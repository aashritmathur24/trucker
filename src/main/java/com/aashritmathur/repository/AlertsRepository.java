package com.aashritmathur.repository;

import com.aashritmathur.entity.Alert;
import com.aashritmathur.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertsRepository extends CrudRepository<Alert, String> {
    @Query(
            value = "SELECT v.vin FROM VEHICLES v LEFT JOIN READING r WHERE v.vin = r.vin AND r.engineRpm > v.redLineRpm",
            nativeQuery = true
    )
    List<Vehicle> findVehicleVinEngineRpmGreaterThanRedLineRpm();

    @Query(
            value = "SELECT v.vin FROM VEHICLES v LEFT JOIN READING r WHERE v.vin = r.vin AND r.fuelVolume < (0.01 * v.maxFuelVolume)",
            nativeQuery = true
    )
    List<Vehicle> findVehicleVinFuelVolumeLessThanTenPercentOfMaxFuelVolume();

    @Query(
            value = "SELECT v.vin FROM VEHICLES v LEFT JOIN READING r WHERE v.vin = r.vin AND " +
                    "(r.frontleft NOT IN (32, 33, 34, 35, 36) OR" +
                    "r.frontRight NOT IN (32, 33, 34, 35, 36) OR" +
                    "r.rearLeft NOT IN (32, 33, 34, 35, 36) OR" +
                    "r.rearRight NOT IN (32, 33, 34, 35, 36))",
            nativeQuery = true
    )
    List<Vehicle> findVehicleVinAnyTirePressureOutOfRange();

    @Query(
            value = "SELECT r.vin FROM READING r WHERE r.engineCoolantLow = 'true' OR r.checkEngineLightOn = 'true'",
            nativeQuery = true
    )
    List<String> findVehicleVinEngineCoolantLowOrCheckEngineLightOn();
}
