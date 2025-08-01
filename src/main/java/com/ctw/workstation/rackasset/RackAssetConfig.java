package com.ctw.workstation.rackasset;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "rack")
public interface RackAssetConfig {

    @WithName("serialNumber")
    String serialNumber();

    @WithName("status")
    String status();

    @WithName("teamId")
    int teamId();
}
