package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.bd.entities.StatusEnum;

import java.sql.Timestamp;
import java.util.UUID;

public record BookingDTOOutput(UUID id,
                               Timestamp createdAt,
                               Timestamp modifiedAt,
                               Timestamp bookFrom,
                               Timestamp bookTo,
                               UUID requesterId,
                               UUID rackId) {

}
