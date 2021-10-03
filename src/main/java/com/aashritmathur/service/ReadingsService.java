package com.aashritmathur.service;

import com.aashritmathur.entity.Reading;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ReadingsService {
    List<Reading> findAll();
    Reading findOne(String id);
    Reading create(Reading reading) throws JsonProcessingException;
    Reading update(String id, Reading reading);
    Reading delete(String id);
}
