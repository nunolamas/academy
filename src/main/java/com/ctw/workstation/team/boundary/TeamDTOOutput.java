package com.ctw.workstation.team.boundary;

import com.ctw.workstation.bd.entities.StatusEnum;

import java.sql.Timestamp;
import java.util.UUID;

public record TeamDTOOutput(UUID id,
                            String name,
                            Timestamp createdAt,
                            Timestamp modifiedAt,
                            String defaultLocation,
                            String product) {

}
