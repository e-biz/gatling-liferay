package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.model.AST.MapperAST;
import com.excilys.liferay.gatling.model.AST.ScenarioAST;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;

import java.util.List;

public class DefaultMustachScript {

	private String simulationName;
	private List<ScenarioAST> mustacheScenarios;
	private String loginPageURL;
	private String logoutPageURL;
	
	
	public DefaultMustachScript(Simulation simulation, List<ScenarioAST> scenarios, String portalURL) throws Exception {
		this.simulationName = GatlingUtil.createSimulationVariable(simulation.getName());
		mustacheScenarios = scenarios;
		this.loginPageURL = new StringBuilder(portalURL).append("/home").toString();
		this.logoutPageURL = portalURL;
	}

	/* Getters and Setters */
	
	public String getSimulationName() {
		return simulationName;
	}

	public void setSimulationName(String simulationName) {
		this.simulationName = simulationName;
	}
	
	public String getLoginPageURL() {
		return loginPageURL;
	}

	public void setLoginPageURL(String loginPageURL) {
		this.loginPageURL = loginPageURL;
	}

	public String getLogoutPageURL() {
		return logoutPageURL;
	}

	public void setLogoutPageURL(String logoutPageURL) {
		this.logoutPageURL = logoutPageURL;
	}

	public List<ScenarioAST> getMustacheScenarios() {
		return mustacheScenarios;
	}

	public void setMustacheScenarios(List<ScenarioAST> scenario) {
		this.mustacheScenarios = scenario;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Simulation name: ");
		sb.append(this.simulationName);
		sb.append("Scenarios: \n[");
		for(ScenarioAST scenarioAST : mustacheScenarios) {
			sb.append(scenarioAST.toString());
			sb.append(",\t");
		}
		sb.append("\n]");
		sb.append("LoginPage: ");
		sb.append(this.loginPageURL);
		sb.append("LogoutPage: ");
		sb.append(this.logoutPageURL);
		return sb.toString();
	}
	

}
