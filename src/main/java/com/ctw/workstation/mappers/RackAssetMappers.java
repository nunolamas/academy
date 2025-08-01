package com.ctw.workstation.mappers;

import com.ctw.workstation.bd.entities.RackAssetEntity;
import com.ctw.workstation.rackasset.boundary.RackAssetDTOInput;
import com.ctw.workstation.rackasset.boundary.RackAssetDTOOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "jakarta")
public interface RackAssetMappers {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assetTag", source = "assetTag")
    @Mapping(target = "rackId", source = "rackId")
    @Mapping(target = "rack", ignore = true)
    RackAssetEntity toRackAssetEntity(RackAssetDTOInput rackAsset);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "assetTag", source = "assetTag")
    @Mapping(target = "rackId", source = "rackId")
    List<RackAssetDTOOutput> toRackAssetDTOList(List<RackAssetEntity> rack);

    RackAssetDTOOutput toRackAssetDTO(RackAssetEntity rack);

}
