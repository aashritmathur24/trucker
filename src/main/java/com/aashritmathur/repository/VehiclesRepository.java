package com.aashritmathur.repository;

import com.aashritmathur.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends CrudRepository<Vehicle, String> {
}
