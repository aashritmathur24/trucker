package com.aashritmathur.controller;

import com.aashritmathur.entity.Vehicle;
import com.aashritmathur.service.VehiclesService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Vehicle> findAll(){
        return vehiclesService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Vehicle Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Vehicle findOne(@PathVariable("id") String id){
        return vehiclesService.findOne(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Vehicle Already Exists"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Vehicle> create(@RequestBody List<Vehicle> vehicles){
        return vehiclesService.create(vehicles);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Vehicle Already Exists"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Vehicle update(@PathVariable("id") String id, @RequestBody Vehicle vehicle){
        return vehiclesService.update(id, vehicle);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") String id){
        vehiclesService.delete(id);
    }
}
