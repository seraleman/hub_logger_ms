package com.seraleman.loggerms.components.registry.dao.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.seraleman.loggerms.components.registry.Registry;
import com.seraleman.loggerms.components.registry.dao.IRegistryDao;
import com.seraleman.loggerms.services.response.IResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistryServiceImpl implements IRegistryService {

    @Autowired
    private IResponseService response;

    @Autowired
    private IRegistryDao registryDao;

    @Override
    public ResponseEntity<?> list() {

        List<Registry> registries = new ArrayList<>();

        try {
            registries = registryDao.findAll();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (registries.size() == 0) {
            return response.empty();
        }
        return response.list(registries);
    }

    @Override
    public ResponseEntity<?> show(String id) {

        Registry registry = null;

        try {
            registry = registryDao.findById(id.toString()).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (registry == null) {
            return response.notFound(id.toString());
        }
        return response.found(registry);
    }

    @Override
    public ResponseEntity<?> create(Registry registry) {

        // Se obtiene la hora y la fecha en que se guarda el registro,
        // independiente de dónde esté desplegado
        Registry registryNew = null;
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        LocalDateTime localDateTimeBogota = zdt.toLocalDateTime();

        // Se extrae solo la fecha y se guarda como un String para su filtrado
        LocalDate localDateBogota = localDateTimeBogota.toLocalDate();
        String stringlocalDateBogota = localDateBogota.toString();

        registry.setDateTime(localDateTimeBogota);
        registry.setDate(stringlocalDateBogota);

        try {
            registryNew = registryDao.save(registry);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.created(registryNew);
    }

    @Override
    public ResponseEntity<?> update(String id, Registry registry) {

        Registry registryCurrent = null;

        try {
            registryCurrent = registryDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (registryCurrent == null) {
            return response.notFound(id);
        }

        try {
            registryCurrent.setReason(registry.getReason());
            registryCurrent.setUser(registry.getUser());
            registryDao.save(registryCurrent);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.updated(registryCurrent);
    }

    @Override
    public ResponseEntity<?> delete(String id) {

        Registry registry = null;

        try {
            registry = registryDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (registry == null) {
            return response.notFound(id);
        }

        try {
            registryDao.deleteById(id);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.deleted();
    }

    @Override
    public ResponseEntity<?> registriesByUser(String user) {

        List<Registry> registries = new ArrayList<>();

        try {
            registries = registryDao.findByUser(user);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (registries.size() == 0) {
            return response.empty();
        }
        return response.list(registries);
    }

    @Override
    public ResponseEntity<?> registriesByReasonId(String reasonId) {

        List<Registry> registries = new ArrayList<>();

        try {
            registries = registryDao.findByReasonId(reasonId);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (registries.size() == 0) {
            return response.empty();
        }
        return response.list(registries);
    }

    @Override
    public ResponseEntity<?> registriesByDate(String date) {

        List<Registry> registries = new ArrayList<>();

        try {
            registries = registryDao.findByDate(date);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (registries.size() == 0) {
            return response.empty();
        }
        return response.list(registries);
    }

    @Override
    public ResponseEntity<?> registriesByReasonIdAndDate(String reasonId, String date) {

        List<Registry> registries = new ArrayList<>();

        try {
            registries = registryDao.findByReasonIdAndDate(reasonId, date);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (registries.size() == 0) {
            return response.empty();
        }
        return response.list(registries);
    }

}
