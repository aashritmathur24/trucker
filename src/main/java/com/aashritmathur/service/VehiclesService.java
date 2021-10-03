package com.aashritmathur.service;

import com.aashritmathur.entity.Vehicle;

import java.util.List;

public interface VehiclesService {
    List<Vehicle> findAll();
    Vehicle findOne(String id);
    List<Vehicle> create(List<Vehicle> vehicles);
    Vehicle update(String id, Vehicle vehicle);
    Vehicle delete(String id);
}
