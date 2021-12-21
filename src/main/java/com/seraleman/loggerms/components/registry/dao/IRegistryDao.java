package com.seraleman.loggerms.components.registry.dao;

import java.util.List;

import com.seraleman.loggerms.components.registry.Registry;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRegistryDao extends MongoRepository<Registry, String> {

    // Consulta para filtrar los registros por usuario
    List<Registry> findByUser(String user);

    // Consulta para filtrar los registros por id de la razón
    List<Registry> findByReasonId(String reasonId);

    // Consulta pra filtrar por fecha de visita
    List<Registry> findByDate(String date);

    // Consulta para filtrar los registros por id de la razón y fecha de visita
    List<Registry> findByReasonIdAndDate(String reasonId, String date);

}
