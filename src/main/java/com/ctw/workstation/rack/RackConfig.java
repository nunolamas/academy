package com.ctw.workstation.rack;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "rack")
public interface RackConfig {

    @WithName("serialNumber")
    String serialNumber();

    @WithName("status")
    String status();

    @WithName("teamId")
    int teamId();
}
