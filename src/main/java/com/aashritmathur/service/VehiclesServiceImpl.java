package com.aashritmathur.service;

import com.aashritmathur.entity.Vehicle;
import com.aashritmathur.exception.BadRequestException;
import com.aashritmathur.exception.ResourceNotFoundException;
import com.aashritmathur.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehiclesServiceImpl implements VehiclesService {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return (List<Vehicle>) vehiclesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle findOne(String id) {
        Optional<Vehicle> vehicle = vehiclesRepository.findById(id);
        if(!vehicle.isPresent()){
            throw new ResourceNotFoundException("Vehicle with vin = " + id + " does not exist.");
        }

        return vehicle.get();
    }

    @Override
    @Transactional
    public List<Vehicle> create(List<Vehicle> vehicles) {
        return (List<Vehicle>) vehiclesRepository.saveAll(vehicles);
    }

    @Override
    @Transactional
    public Vehicle update(String id, Vehicle vehicle) {
        Optional<Vehicle> existing = vehiclesRepository.findById(id);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle with vin = " + id + " does not exist.");
        }

        return vehiclesRepository.save(vehicle);
    }

    @Override
    @Transactional
    public Vehicle delete(String id) {
        Optional<Vehicle> vehicle = vehiclesRepository.findById(id);
        if(!vehicle.isPresent()){
            throw new ResourceNotFoundException("Vehicle with vin = " + id + " does not exist.");
        }

        vehiclesRepository.delete(vehicle.get());
        return null;
    }
}
