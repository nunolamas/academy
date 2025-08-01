package com.ctw.workstation.bd.repositories;

import com.ctw.workstation.bd.entities.BookingEntity;
import com.ctw.workstation.bd.entities.RackEntity;
import com.ctw.workstation.bd.entities.StatusEnum;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
@Transactional
public class RackRepository implements PanacheRepositoryBase<RackEntity, UUID> {
    public boolean updateStatus(UUID rackId, StatusEnum newStatus) {
        return update("status = ?1 where id = ?2", newStatus, rackId) == 1;
    }
}
