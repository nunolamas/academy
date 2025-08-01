package com.ctw.workstation.mappers;

import com.ctw.workstation.bd.entities.BookingEntity;
import com.ctw.workstation.bd.entities.RackEntity;
import com.ctw.workstation.booking.boundary.BookingDTOInput;
import com.ctw.workstation.booking.boundary.BookingDTOOutput;
import com.ctw.workstation.rack.boundary.RackDTOInput;
import com.ctw.workstation.rack.boundary.RackDTOOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "jakarta")
public interface BookingMappers {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "bookFrom", source = "bookFrom")
    @Mapping(target = "bookTo", source = "bookTo")
    @Mapping(target = "requesterId", source = "requesterId")
    @Mapping(target = "requester", ignore = true)
    @Mapping(target = "rackId", source = "rackId")
    @Mapping(target = "rack", ignore = true)
    BookingEntity toBookingEntity(BookingDTOInput booking);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "modifiedAt", source = "modifiedAt")
    @Mapping(target = "bookFrom", source = "bookFrom")
    @Mapping(target = "book_to", source = "bookTo")
    @Mapping(target = "requesterId", source = "requesterId")
    @Mapping(target = "rackId", source = "rackId")
    List<BookingDTOOutput> toBookingDTOList(List<BookingEntity> booking);

    BookingDTOOutput toBookingDTO(BookingEntity booking);

}
