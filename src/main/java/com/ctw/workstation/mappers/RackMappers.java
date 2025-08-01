package com.ctw.workstation.mappers;

import com.ctw.workstation.bd.entities.*;
import com.ctw.workstation.booking.boundary.BookingDTOInput;
import com.ctw.workstation.booking.boundary.BookingDTOOutput;
import com.ctw.workstation.rack.boundary.RackDTOInput;
import com.ctw.workstation.rack.boundary.RackDTOOutput;
import com.ctw.workstation.rackasset.boundary.RackAssetDTOInput;
import com.ctw.workstation.rackasset.boundary.RackAssetDTOOutput;
import com.ctw.workstation.team.boundary.TeamDTOInput;
import com.ctw.workstation.team.boundary.TeamDTOOutput;
import com.ctw.workstation.teammember.boundary.TeamMemberDTOInput;
import com.ctw.workstation.teammember.boundary.TeamMemberDTOOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "jakarta")
public interface RackMappers {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "serialNumber", source = "serialNumber")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "defaultLocation", source = "defaultLocation")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "teamId", source = "teamId")
    @Mapping(target = "team", ignore = true)
    RackEntity toRackEntity(RackDTOInput rack);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "serialNumber", source = "serialNumber")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "modifiedAt", source = "modifiedAt")
    @Mapping(target = "defaultLocation", source = "defaultLocation")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "teamId", source = "teamId")
    List<RackDTOOutput> toRackDTOList(List<RackEntity> rack);

    RackDTOOutput toRackDTO(RackEntity rack);


}
