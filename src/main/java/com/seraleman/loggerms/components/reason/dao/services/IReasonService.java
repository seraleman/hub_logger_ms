package com.seraleman.loggerms.components.reason.dao.services;

import com.seraleman.loggerms.components.reason.Reason;

import org.springframework.http.ResponseEntity;

public interface IReasonService {

    public ResponseEntity<?> list();

    public ResponseEntity<?> show(String id);

    public ResponseEntity<?> create(Reason reason);

    public ResponseEntity<?> update(String id, Reason reason);

    public ResponseEntity<?> delete(String id);
}
