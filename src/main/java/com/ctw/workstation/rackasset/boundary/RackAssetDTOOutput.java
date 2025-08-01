package com.ctw.workstation.rackasset.boundary;

import java.sql.Timestamp;
import java.util.UUID;

public record RackAssetDTOOutput(UUID id,
                                 String assetTag,
                                 UUID rackId) {

}
