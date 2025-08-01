package com.ctw.workstation.bd.repositories;

import com.ctw.workstation.bd.entities.BookingEntity;
import com.ctw.workstation.bd.entities.RackAssetEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
@Transactional
public class RackAssetRepository implements PanacheRepositoryBase<RackAssetEntity, UUID> {
}
