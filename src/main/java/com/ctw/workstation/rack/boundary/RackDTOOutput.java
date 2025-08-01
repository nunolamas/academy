package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.bd.entities.StatusEnum;

import java.sql.Timestamp;
import java.util.UUID;

public record RackDTOOutput(UUID id,
                            String serialNumber,
                            Timestamp createdAt,
                            Timestamp modifiedAt,
                            String defaultLocation,
                            StatusEnum status,
                            UUID teamId) {

}
