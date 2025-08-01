package com.ctw.workstation.mappers;

import com.ctw.workstation.bd.entities.TeamEntity;
import com.ctw.workstation.team.boundary.TeamDTOInput;
import com.ctw.workstation.team.boundary.TeamDTOOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "jakarta")
public interface TeamMappers {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "defaultLocation", source = "defaultLocation")
    @Mapping(target = "product", source = "product")
    TeamEntity toTeamEntity(TeamDTOInput team);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "modifiedAt", source = "modifiedAt")
    @Mapping(target = "defaultLocation", source = "defaultLocation")
    @Mapping(target = "product", source = "product")
    List<TeamDTOOutput> toTeamDTOList(List<TeamEntity> team);

    TeamDTOOutput toTeamDTO(TeamEntity team);

}
