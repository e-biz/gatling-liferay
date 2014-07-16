package com.excilys.liferay.gatling;

import com.excilys.liferay.gatling.validator.RequestValidator;
import com.excilys.liferay.gatling.validator.ScenarioValidator;
import com.excilys.liferay.gatling.validator.SimulationValidator;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.sample.model.Request;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.model.Simulation;
import com.liferay.sample.service.RequestLocalServiceUtil;
import com.liferay.sample.service.ScenarioLocalServiceUtil;
import com.liferay.sample.service.SimulationLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class GatlingPortlet
 */
public class GatlingPortlet extends MVCPortlet {


	private static Log log = LogFactoryUtil.getLog(GatlingPortlet.class);


	protected String jspListSimulation, jspEditSimulation, jspEditScenario;


	/**
	 * récupérer les noms de toutes les pages
	 */
	@Override
	public void init() throws PortletException {
		jspListSimulation = getInitParameter("list-simulation-jsp");
		jspEditSimulation = getInitParameter("edit-simulation-jsp");
		jspEditScenario = getInitParameter("edit-scenario-jsp");
		super.init();
	}

	/*
	 * ==== Simulation ====
	 */
	/**
	 * Adds a new Simulation to the database.
	 * 
	 */
	public void addSimulation(ActionRequest request, ActionResponse response)
			throws Exception {
		long primaryKey = CounterLocalServiceUtil.increment(Simulation.class.getName());	
		Simulation simulation = SimulationLocalServiceUtil.createSimulation(primaryKey);
		simulation.setName(ParamUtil.getString(request, "simulationName"));
		List<String> errors = new ArrayList<String>();
		if(SimulationValidator.validateSimulation(simulation, errors)) {

			SimulationLocalServiceUtil.addSimulation(simulation);
		}
		else {
			for(String error : errors) {
				SessionErrors.add(request, error);
			}
		}
		sendRedirect(request, response);
	}

	public void removeSimulation(ActionRequest request, ActionResponse response)
			throws Exception {
		long simulationId = ParamUtil.getLong(request, "simulationId");
		log.info("remove Simulation with id : "+ simulationId);
		// Etape 1
		// -> Suppression des tables
		SimulationLocalServiceUtil.removeSimulationCascade(simulationId);
		// Etape 2 
		// -> récupération des simulations
		List<Simulation> list = new ArrayList<Simulation>();
		try {
			list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		request.setAttribute("listSimulation", list);
		response.setRenderParameter("jspPage", jspListSimulation); 
		sendRedirect(request, response);
	}	

	/*
	 * ==== Scenario ====
	 */
	/**
	 * Add a new Scenario to the database
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		//create scenario
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(primaryKey);
		scenario.setName(ParamUtil.getString(request, "scenarioName"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulationId"));
		scenario.setGroup_id(ParamUtil.getLong(request, "sites"));
		// Saving ...
		List<String> errors = new ArrayList<String>();
		if(ScenarioValidator.validateScenario(scenario, errors)) {
			scenario = ScenarioLocalServiceUtil.addScenario(scenario);
		}
		else {
			for(String error : errors) {
				SessionErrors.add(request, error);
			}
		}
		// Récupération de la simulation
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(ParamUtil.getLong(request, "simulationId"));
		request.setAttribute("simulation", simulation);
		// Récupération des scénarios de la simulation
		List<Scenario> liScenarios = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
		request.setAttribute("listScenario", liScenarios);
		// List of Sites
		List<Group> liGroups = getListOfSites();
		request.setAttribute("listGroup", liGroups);

		response.setRenderParameter("jspPage", jspEditSimulation); 
		sendRedirect(request, response);
	}


	/**
	 * edit scenario
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws Exception
	 */
	public void editScenario(ActionRequest request, ActionResponse response) {

		Long idScenario = ParamUtil.getLong(request, "scenarioId");
		Map<String, String[]> parameters = request.getParameterMap();
		Map<String, Request> lstRequestToEdit =new HashMap<String, Request>();
		try {
			for(Request r :RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(request, "scenarioId",0))){
				lstRequestToEdit.put(r.getUrl().trim(),  r);
			}

		} catch (SystemException e) {
			e.printStackTrace();
		}

		if(idScenario !=null){

			long groupId =ParamUtil.getLong(request, "groupId");

			List<Layout> listLayouts;
			try {
				listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
				for (String key : parameters.keySet()){

					if((StringUtil.merge(parameters.get(key)).equals("true")) && (!key.contains("Checkbox")) ){
						int requestNumber = Integer.parseInt(key);
						int weight  =  Integer.parseInt(StringUtil.merge(parameters.get("rate")).split(",")[requestNumber]);
						String url = listLayouts.get(requestNumber).getFriendlyURL();
						if((lstRequestToEdit.containsKey(url.trim())) && (lstRequestToEdit.get(url).getRate() != weight)){
							Request updatedRequest = lstRequestToEdit.get(url);
							updatedRequest.setRate(weight);
							// Saving ...
							List<String> errors = new ArrayList<String>();
							if(RequestValidator.validateRequest(updatedRequest, errors)) {
								RequestLocalServiceUtil.updateRequest(updatedRequest);
								log.info("request updated succefully");
							}
							else {
								for(String error : errors) {
									SessionErrors.add(request, error);
								}
							}

						}
						else if(! lstRequestToEdit.containsKey(url.trim())){					
							addRequest(url, weight, idScenario);
							log.info("request created and added succefully ");
						}				
					}
					else if((StringUtil.merge(parameters.get(key)).equals("false")) && (!key.contains("Checkbox")) ){
						int requestNumber = Integer.parseInt(key);
						String url = listLayouts.get(requestNumber).getFriendlyURL();
						if(lstRequestToEdit.containsKey(url.trim())){
							Request RequestToDelete = lstRequestToEdit.get(url);
							RequestLocalServiceUtil.deleteRequest(RequestToDelete);
							log.info("request deleted succefully ");

						}
					}
				}
				// Récupération de la simulation
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(idScenario);
				Simulation simulation = SimulationLocalServiceUtil.getSimulation(scenario.getSimulation_id());
				request.setAttribute("simulation", simulation);
				// Récupération des scénarios de la simulation
				List<Scenario> liScenarios = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
				request.setAttribute("listScenario", liScenarios);
				// List of Sites
				List<Group> liGroups = getListOfSites();
				request.setAttribute("listGroup", liGroups);
				response.setRenderParameter("jspPage", "/html/gatling/editSimulation.jsp");
			} catch (SystemException e) {
				log.info("pbm with layout : "+e.getMessage());
			} catch (PortalException e) {
				log.info("pbm appel aux method localServiceUtil : "+e.getMessage());
			} catch (Exception e) {
				log.info("pbm with addRequestMethod : "+e.getMessage());
			} 
		}
	}

	public void removeScenario(ActionRequest request, ActionResponse response)
			throws Exception {
		long scenarioId = ParamUtil.getLong(request, "scenarioId");
		//Pour le retour
		long simulationId = ParamUtil.getLong(request, "simulationId");
		log.info("remove Scenario with id : "+ scenarioId);
		// Etape 1
		// -> Suppression des tables
		ScenarioLocalServiceUtil.removeByIdCascade(scenarioId);
		// Etape 2 
		// -> récupération des scénarios
		Simulation simulation = SimulationLocalServiceUtil.getSimulation(simulationId);
		request.setAttribute("simulation", simulation);
		// Récupération des scénarios de la simulation
		List<Scenario> liScenarios = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
		request.setAttribute("listScenario", liScenarios);
		// List of Sites
		List<Group> liGroups = getListOfSites();
		request.setAttribute("listGroup", liGroups);
		response.setRenderParameter("jspPage", "/html/gatling/editSimulation.jsp"); 
	}

	/*
	 * ==== Request ====
	 */

	/**
	 * Add a new Request to the database
	 * 
	 */


	public void addRequest(String url, int rate, long idScenario)
			throws Exception {

		log.info("addRequest contrôleur");
		//create request
		long primaryKey = CounterLocalServiceUtil.increment(Request.class.getName());
		Request newRequest = RequestLocalServiceUtil.createRequest(primaryKey);
		newRequest.setUrl(url);
		newRequest.setRate(rate);
		newRequest.setScenario_id(idScenario);
		// Saving ...
		List<String> errors = new ArrayList<String>();
		if(RequestValidator.validateRequest(newRequest, errors)) {
			newRequest = RequestLocalServiceUtil.addRequest(newRequest);
		}
	}
	/**
	 * ici en fonction de la page demandée, on effectue différentes actions pour envoyer <br/>
	 * les informations nécessaire à la construction de la page
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		/* récupération de la value page */
		/* récupération du chemin de la prochaine jsp ou par défaut jspListSimulation */
		String page = ParamUtil.get(renderRequest, "page", jspListSimulation); 


		if(page.equals(jspListSimulation)) {
			/*
			 * Page d'acceuil, liste des simulations
			 */
			List<Simulation> list = new ArrayList<Simulation>();
			try {
				list = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("listSimulation", list);
		} else if(page.equals(jspEditSimulation)) {
			/*
			 * Edition d'une simulation, liste des scénarios
			 */
			Long id = (Long) ParamUtil.getLong(renderRequest, "simulationId");

			Simulation simulation;
			try {
				simulation = SimulationLocalServiceUtil.getSimulation(id);
				renderRequest.setAttribute("simulation", simulation);
				// List of Scénarios
				List<Scenario> ls = ScenarioLocalServiceUtil.findBySimulationId(simulation.getSimulation_id());
				renderRequest.setAttribute("listScenario", ls);	
			} catch (PortalException | SystemException e1) {
				e1.printStackTrace();
			}

			// List of Sites
			List<Group> liGroups = getListOfSites();
			renderRequest.setAttribute("listGroup", liGroups);
		}
		else if(page.equals(jspEditScenario)){
			/*
			 * Edition d'un scénario -> liste des requêtes
			 */
			try {
				Scenario scenario = ScenarioLocalServiceUtil.getScenario(ParamUtil.getLong(renderRequest, "scenarioId"));
				long groupId = scenario.getGroup_id();

				List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);

				renderRequest.setAttribute("scenario", scenario);
				renderRequest.setAttribute("listLayout", listLayouts);	

				Map<String, Integer> ls =new HashMap<String, Integer>();
				try {
					for(Request r :RequestLocalServiceUtil.findByScenarioId(ParamUtil.get(renderRequest, "scenarioId",0))){
						ls.put(r.getUrl(), r.getRate());
					}

				} catch (SystemException e) {
					e.printStackTrace();
				}

				renderRequest.setAttribute("listrequest", ls);

			} catch (SystemException e) {
				e.printStackTrace();
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}

		/* on redirige sur la jsp de page */
		include(page, renderRequest, renderResponse);	
	}

	/**
	 * Récupère la liste des sites du portail
	 * @return list des sites
	 */
	private List<Group> getListOfSites()  {
		/*recupere la liste des sites*/			
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Group.class)
				.add(PropertyFactoryUtil.forName("type").eq(1)) //1 -> site
				.add(PropertyFactoryUtil.forName("site").eq(true))
				.add(PropertyFactoryUtil.forName("active").eq(true));

		List<Group> listGroups = new ArrayList<Group>();
		try {
			listGroups = (List<Group>) GroupLocalServiceUtil.dynamicQuery(dq);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return listGroups;

	}

}