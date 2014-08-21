/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.util;

import com.excilys.liferay.gatling.model.Request;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;

/**
 * DisplayLayout is used in editScenario.jsp to display both layout and request
 * 
 * use of {@link IdDisplayItem} as field for identity
 *
 */
public class DisplayItem {
	
	public enum RequestState {
		OLD_REQUEST, DEFAULT, NEW_REQUEST;
	}
	// displayLayoutId
	private IdDisplayItem displayLayoutId;

	// field for comparaison
	private RequestState state;

	// field for space
	private int numberOfSpace;
	
	// field of Request table
	private long requestId;
	private long scenarioId;
	private String name;
	private String url;
	private double weight;
	private long parentLayoutId;
	private boolean privateLayout;
	private boolean portlet = false;
	
	// Common initialization
	{
		state = RequestState.DEFAULT;
	}
	
	/**
	 * create DisplayLayout from a liferay Layout
	 * @param layout
	 */
	public DisplayItem(PortletPreferences portletPreferences) {
		
		parentLayoutId = portletPreferences.getPlid();
		name = PortletLocalServiceUtil.getPortletById(portletPreferences.getPortletId()).getDisplayName();
		setPortlet(Boolean.TRUE);
		try {
			url = LayoutLocalServiceUtil.getLayout(portletPreferences.getPlid()).getFriendlyURL() /* + url portlet*/;
		} catch (PortalException | SystemException e) {
			new RuntimeException("fuck you DB! give me my portlet url");
		}
	}
	
	/**
	 * create DisplayLayout from a liferay Layout
	 * @param layout
	 */
	public DisplayItem(Layout layout) {
		
		displayLayoutId = new IdDisplayItem(layout.isPrivateLayout(), layout.getLayoutId());
		parentLayoutId = layout.getParentLayoutId();
		name = layout.getName(LocaleUtil.getDefault());
		url = layout.getFriendlyURL();
		setPrivateLayout(layout.isPrivateLayout());
	}
	
	/**
	 * create DisplayLayout from a scenario request
	 * @param request
	 */
	public DisplayItem(Request request){
		displayLayoutId = new IdDisplayItem(request.isPrivatePage(), request.getLayoutId());
		requestId = request.getRequest_id();
		parentLayoutId = request.getParentLayoutId();
		name = request.getName();
		url = request.getUrl();
		weight = request.getWeight();
		setPrivateLayout(request.isPrivatePage());
	}

	public boolean isUsed() {
		return (weight > 0);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayLayoutId == null) ? 0 : displayLayoutId.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisplayItem other = (DisplayItem) obj;
		if (displayLayoutId == null) {
			if (other.displayLayoutId != null)
				return false;
		} else if (!displayLayoutId.equals(other.displayLayoutId))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}


	/*
	 * Getters and Setters
	 */
	
	public IdDisplayItem getDisplayLayoutId() {
		return displayLayoutId;
	}

	public void setDisplayLayoutId(IdDisplayItem displayLayoutId) {
		this.displayLayoutId = displayLayoutId;
	}
	
	public RequestState getState() {
		return state;
	}
	public void setState(RequestState state) {
		this.state = state;
	}
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public long getScenarioId() {
		return scenarioId;
	}
	public void setScenarioId(long scenarioId) {
		this.scenarioId = scenarioId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getNumberOfSpace() {
		return numberOfSpace;
	}
	public void setNumberOfSpace(int numberOfSpace) {
		this.numberOfSpace = numberOfSpace;
	}

	public long getParentLayoutId() {
		return parentLayoutId;
	}

	public void setParentLayoutId(long parentLayoutId) {
		this.parentLayoutId = parentLayoutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrivateLayout() {
		return privateLayout;
	}

	public void setPrivateLayout(boolean privateLayout) {
		this.privateLayout = privateLayout;
	}

	public boolean isPortlet() {
		return portlet;
	}

	public void setPortlet(boolean portlet) {
		this.portlet = portlet;
	}
}
	