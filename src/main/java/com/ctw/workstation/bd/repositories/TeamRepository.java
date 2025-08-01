package com.ctw.workstation.bd.repositories;

import com.ctw.workstation.bd.entities.RackEntity;
import com.ctw.workstation.bd.entities.TeamEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
@Transactional
public class TeamRepository implements PanacheRepositoryBase<TeamEntity, UUID> {
}
