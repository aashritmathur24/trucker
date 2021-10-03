package com.aashritmathur.controller;

import com.aashritmathur.entity.Reading;
import com.aashritmathur.service.ReadingsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {
    @Autowired
    private ReadingsService readingsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Reading> findAll(){
        return readingsService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Reading Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Reading findOne(@PathVariable("id") String id){
        return readingsService.findOne(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Reading Already Exists"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Reading create(@RequestBody Reading reading) throws JsonProcessingException {
        return readingsService.create(reading);
    }

//    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "OK"),
//            @ApiResponse(code = 400, message = "Reading Already Exists"),
//            @ApiResponse(code = 500, message = "Internal Server Error")
//    })
//    public Reading update(@PathVariable("id") String id, @RequestBody Reading reading){
//        return readingsService.update(id, reading);
//    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") String id){
        readingsService.delete(id);
    }
}
