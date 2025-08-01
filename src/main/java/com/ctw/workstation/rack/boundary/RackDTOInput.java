package com.ctw.workstation.rack.boundary;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class RackDTOInput {

    @NotBlank(message="SerialNumber may not be blank")
    private String serialNumber;
    private String defaultLocation;
    private String status;
    private UUID teamId;

    public RackDTOInput(String serialNumber, String defaultLocation, String status, UUID teamId) {
        this.serialNumber = serialNumber;
        this.defaultLocation = defaultLocation;
        this.status = status;
        this.teamId = teamId;
    }

    public RackDTOInput() {}

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "RackDTOInput{" +
                "serialNumber='" + serialNumber + '\'' +
                ", defaultLocation='" + defaultLocation + '\'' +
                ", status='" + status + '\'' +
                ", teamId=" + teamId +
                '}';
    }
}
