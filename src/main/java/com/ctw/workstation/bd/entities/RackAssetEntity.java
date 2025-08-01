package com.ctw.workstation.bd.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "t_rack_asset")
public class RackAssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @SequenceGenerator(name = "rackAssetIdGenerator", sequenceName = "SEQ_RACK_ASSET_ID")
    private UUID id;

    @Column(name = "asset_tag", length = 10, nullable = false)
    private String assetTag;

    @Column(name = "rack_id", nullable = false)
    private UUID rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    private RackEntity rack;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public RackEntity getRack() {
        return rack;
    }

    public void setRack(RackEntity rack) {
        this.rack = rack;
    }
}
