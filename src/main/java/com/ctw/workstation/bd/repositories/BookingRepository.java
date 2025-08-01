package com.ctw.workstation.bd.repositories;

import com.ctw.workstation.bd.entities.BookingEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
@Transactional
public class BookingRepository implements PanacheRepositoryBase<BookingEntity, UUID> {
    public void deleteAllByRackId(UUID rackId) {
        delete("rackId", rackId);
    }
}
