package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.bd.entities.StatusEnum;

public class RackStatusDTOInput {
    private StatusEnum status;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}