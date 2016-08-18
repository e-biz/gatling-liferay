package com.excilys.liferay.gatling.model.AST;

import java.util.ArrayList;
import java.util.List;

public class ScenarioAST {
	
	private String scenarioName;
	private long users;
	private long rampUp;
	private List<ProcessAST> processes;

	public ScenarioAST(String scenarioName, long users, long rampUp, List<ProcessAST> processList) {
		this.scenarioName = scenarioName;
		this.users = users;
		this.rampUp = rampUp;
		this.processes = processList;
	}

	public ScenarioAST(String scenarioName, long users, long rampUp) {
		this(scenarioName, users, rampUp, new ArrayList<ProcessAST>());
	}
	
	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public long getUsers() {
		return users;
	}

	public void setUsers(long users) {
		this.users = users;
	}

	public long getRampUp() {
		return rampUp;
	}

	public void setRamUp(long rampup) {
		this.rampUp = rampup;
	}

	public List<ProcessAST> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessAST> processes) {
		this.processes = processes;
	}

}