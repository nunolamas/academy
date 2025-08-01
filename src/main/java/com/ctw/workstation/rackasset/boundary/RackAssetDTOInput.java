package com.ctw.workstation.rackasset.boundary;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class RackAssetDTOInput {

    private String assetTag;
    private UUID rackId;

    public RackAssetDTOInput() {
    }
    public RackAssetDTOInput(String assetTag, UUID rackId) {
        this.assetTag = assetTag;
        this.rackId = rackId;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    @Override
    public String toString() {
        return "RackAssetDTOInput{" +
                ", assetTag='" + assetTag + '\'' +
                ", rackId=" + rackId +
                '}';
    }
}