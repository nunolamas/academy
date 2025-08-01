package com.ctw.workstation.mappers;

import com.ctw.workstation.bd.entities.TeamMemberEntity;
import com.ctw.workstation.teammember.boundary.TeamMemberDTOInput;
import com.ctw.workstation.teammember.boundary.TeamMemberDTOOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "jakarta")
public interface TeamMemberMappers {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teamId", source = "teamId")
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "ctwId", source = "ctwId")
    TeamMemberEntity toTeamMemberEntity(TeamMemberDTOInput teamMember);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "teamId", source = "teamId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "modifiedAt", source = "modifiedAt")
    @Mapping(target = "ctwId", source = "ctwId")
    List<TeamMemberDTOOutput> toTeamMemberDTOList(List<TeamMemberEntity> teamMember);

    TeamMemberDTOOutput toTeamMemberDTO(TeamMemberEntity teamMember);

}
