package io.gatling.liferay.dto;

import java.util.List;


/**
 * ScenarioDTO regroups all the data needed to to draw
 * a scenario in the builder scenario view.
 */
public class ScenarioDTO {
	
	/**
	 * The scenario's name
	 */
	private String name;
	
	/**
	 * The scenario's id
	 */
	private long id;
	
	/**
	 * The list of data used to draw process boxes in the scenario
	 */
	private List<ProcessDTO> processes;

	
	
	
	public ScenarioDTO() {}
	
	public ScenarioDTO(String name, long l, List<ProcessDTO> processes) {
		this.name = name;
		this.id = l;
		this.processes = processes;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ProcessDTO> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessDTO> processes) {
		this.processes = processes;
	}
	
	@Override
	public String toString() {
		return "ScenarioDTO [name=" + name + ", id=" + id + ", processes="
				+ processes + "]";
	}
}
