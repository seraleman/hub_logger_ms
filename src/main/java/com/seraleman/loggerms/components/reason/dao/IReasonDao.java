package com.seraleman.loggerms.components.reason.dao;

import com.seraleman.loggerms.components.reason.Reason;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IReasonDao extends MongoRepository<Reason, String> {

}
