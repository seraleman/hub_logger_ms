package com.seraleman.loggerms.components.registry.dao.services;

import com.seraleman.loggerms.components.registry.Registry;

import org.springframework.http.ResponseEntity;

public interface IRegistryService {

    public ResponseEntity<?> list();

    public ResponseEntity<?> show(String id);

    public ResponseEntity<?> create(Registry registry);

    public ResponseEntity<?> update(String id, Registry registry);

    public ResponseEntity<?> delete(String id);

    public ResponseEntity<?> registriesByUser(String user);

    public ResponseEntity<?> registriesByReasonId(String reasonId);

    public ResponseEntity<?> registriesByDate(String date);

    public ResponseEntity<?> registriesByReasonIdAndDate(String reasonId, String date);

}
