package com.ctw.workstation.booking.boundary;

import java.sql.Timestamp;
import java.util.UUID;

public class BookingDTOInput {

    private UUID requesterId;
    private UUID rackId;
    private Timestamp bookFrom;
    private Timestamp bookTo;

    public BookingDTOInput() {
    }

    public BookingDTOInput(UUID rackId, UUID requesterId, Timestamp bookFrom, Timestamp bookTo) {
        this.requesterId = requesterId;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.rackId = rackId;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public Timestamp getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(Timestamp bookFrom) {
        this.bookFrom = bookFrom;
    }

    public Timestamp getBookTo() {
        return bookTo;
    }

    public void setBookTo(Timestamp bookTo) {
        this.bookTo = bookTo;
    }

    public UUID getRackId() {
        return rackId;
    }
    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                ", requesterId=" + requesterId +
                ", rackId=" + rackId +
                ", bookFrom=" + bookFrom +
                ", bookTo=" + bookTo +
                '}';
    }
}
