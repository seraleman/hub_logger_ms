package com.seraleman.loggerms.components.reason.dao.services;

import java.util.ArrayList;
import java.util.List;

import com.seraleman.loggerms.components.reason.Reason;
import com.seraleman.loggerms.components.reason.dao.IReasonDao;
import com.seraleman.loggerms.services.response.IResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReasonServiceImpl implements IReasonService {

    @Autowired
    private IResponseService response;

    @Autowired
    private IReasonDao reasonDao;

    @Override
    public ResponseEntity<?> list() {

        List<Reason> reasons = new ArrayList<>();

        try {
            reasons = reasonDao.findAll();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (reasons.size() == 0) {
            return response.empty();
        }
        return response.list(reasons);
    }

    @Override
    public ResponseEntity<?> show(String id) {

        Reason reason = null;

        try {
            reason = reasonDao.findById(id.toString()).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (reason == null) {
            return response.notFound(id.toString());
        }
        return response.found(reason);
    }

    @Override
    public ResponseEntity<?> create(Reason reason) {

        Reason reasonNew = null;

        try {
            reasonNew = reasonDao.save(reason);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.created(reasonNew);
    }

    @Override
    public ResponseEntity<?> update(String id, Reason reason) {

        Reason reasonCurrent = null;

        try {
            reasonCurrent = reasonDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (reasonCurrent == null) {
            return response.notFound(id);
        }

        try {
            reasonCurrent.setName(reason.getName());
            reasonCurrent.setDescription(reason.getDescription());
            reasonDao.save(reasonCurrent);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.updated(reasonCurrent);
    }

    @Override
    public ResponseEntity<?> delete(String id) {

        Reason reason = null;

        try {
            reason = reasonDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (reason == null) {
            return response.notFound(id);
        }

        try {
            reasonDao.deleteById(id);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.deleted();
    }
}
