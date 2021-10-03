package com.aashritmathur.service;

import com.aashritmathur.entity.Alert;
import com.aashritmathur.entity.Vehicle;
import com.aashritmathur.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    private AlertsRepository alertsRepository;


    @Override
    public void create() {
        List<Vehicle> vehicles1 = alertsRepository.findVehicleVinEngineRpmGreaterThanRedLineRpm();

        for (Vehicle vehicle: vehicles1
             ) {
            Alert alert = new Alert();
            alert.setVin(vehicle.getVin());
            alert.setPriority("HIGH");
            alert.setDescription("Red-line RPM greater than Engine RPM");

            alertsRepository.save(alert);
        }

        List<Vehicle> vehicles2 = alertsRepository.findVehicleVinFuelVolumeLessThanTenPercentOfMaxFuelVolume();

        for (Vehicle vehicle: vehicles2
        ) {
            Alert alert = new Alert();
            alert.setVin(vehicle.getVin());
            alert.setPriority("MEDIUM");
            alert.setDescription("Fuel Volume less than 10% of Max Fuel Volume");

            alertsRepository.save(alert);
        }

        List<Vehicle> vehicles3 = alertsRepository.findVehicleVinAnyTirePressureOutOfRange();

        for (Vehicle vehicle: vehicles3
        ) {
            Alert alert = new Alert();
            alert.setVin(vehicle.getVin());
            alert.setPriority("LOW");
            alert.setDescription("Tire Pressure less than 32psi or greater than 36psi");

            alertsRepository.save(alert);
        }

        List<Vehicle> vehicles4 = alertsRepository.findVehicleVinAnyTirePressureOutOfRange();

        for (Vehicle vehicle: vehicles4
        ) {
            Alert alert = new Alert();
            alert.setVin(vehicle.getVin());
            alert.setPriority("LOW");
            alert.setDescription("Check Engine Health and Coolant Level");

            alertsRepository.save(alert);
        }
    }
}
