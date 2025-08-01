package com.ctw.workstation.services;

import com.ctw.workstation.bd.entities.RackEntity;
import com.ctw.workstation.bd.repositories.RackRepository;
import com.ctw.workstation.mappers.RackMappers;
import com.ctw.workstation.rack.boundary.RackDTOInput;
import com.ctw.workstation.rack.boundary.RackDTOOutput;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestScoped
public class RackService {

    @Inject
    Logger log;

    @Inject
    RackRepository rackRepository;

    @Inject
    RackMappers mapper;

    public RackDTOOutput saveRack(RackDTOInput rack){
        RackEntity rackEntity = mapper.toRackEntity(rack);
        rackRepository.persist(rackEntity);
        return mapper.toRackDTO(rackEntity);
    }

    public List<RackDTOOutput> getAllRacks(){
        return rackRepository.findAll().stream().map(mapper::toRackDTO).toList();
    }

    public RackDTOOutput getSingleRack(UUID id) {

        try {
            RackDTOOutput rack = mapper.toRackDTO(rackRepository.findById(id));
            if (rack != null) {
                return rack;
            } else {
                throw new SQLException("There is no Rack for the id " + id);

            }
        } catch (SQLException e) {
            log.warn(e);
            throw new RuntimeException(e);
        }
    }

    public Response deleteRack(UUID id) {
        try {
            return Response.ok(rackRepository.deleteById(id)).build();
        } catch (Exception e){
            log.warn(e);
            throw new RuntimeException(e);
        }
    }
}
