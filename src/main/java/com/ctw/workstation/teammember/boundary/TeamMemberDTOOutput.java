package com.ctw.workstation.teammember.boundary;

import java.sql.Timestamp;
import java.util.UUID;

public record TeamMemberDTOOutput(UUID id,
                                  UUID teamId,
                                  String name,
                                  Timestamp createdAt,
                                  Timestamp modifiedAt,
                                  String ctwId) {

}
