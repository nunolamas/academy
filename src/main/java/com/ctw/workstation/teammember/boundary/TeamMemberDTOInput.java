package com.ctw.workstation.teammember.boundary;

public class TeamMemberDTOInput {

    private String teamId;
    private String name;
    private String ctwId;

    public TeamMemberDTOInput(String teamId, String name, String ctwId) {
        this.teamId = teamId;
        this.name = name;
        this.ctwId = ctwId;
    }

    public TeamMemberDTOInput() {
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCtwId() {
        return ctwId;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    @Override
    public String toString() {
        return "TeamMemberDTOInput{" +
                "teamId='" + teamId + '\'' +
                ", name='" + name + '\'' +
                ", ctwId='" + ctwId + '\'' +
                '}';
    }
}
