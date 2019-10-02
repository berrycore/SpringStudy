package model;

public class Team {

	private Integer team_id;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getTeam_id() {
		return team_id;
	}
}
