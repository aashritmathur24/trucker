package com.aashritmathur.service;

import com.aashritmathur.entity.Reading;
import com.aashritmathur.exception.BadRequestException;
import com.aashritmathur.exception.ResourceNotFoundException;
import com.aashritmathur.repository.ReadingsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class ReadingsServiceImpl implements ReadingsService {

    @Autowired
    private ReadingsRepository readingsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return (List<Reading>) readingsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Reading findOne(String id) {
        Optional<Reading> reading = readingsRepository.findById(id);
        if(!reading.isPresent()){
            throw new ResourceNotFoundException("Reading with timestamp = " + id + " does not exist.");
        }
        return reading.get();
    }

    @Override
    @Transactional
    public Reading create(Reading reading) {
        Optional<Reading> existing = readingsRepository.findById(reading.getTimestamp());
        if(existing.isPresent()){
            throw new BadRequestException("Reading with timestamp = " + reading.getTimestamp() + " already exists.");
        }

//        JsonNode readingNode = new ObjectMapper().readTree(String.valueOf(reading));
//
//        Reading reading1 = new Reading();
//        reading1.setVin(readingNode.get("vin").textValue());
//        reading1.setLatitude(Double.parseDouble(readingNode.get("latitude").textValue()));
//        reading1.setLongitude(Double.parseDouble(readingNode.get("longitude").textValue()));
//        reading1.setTimestamp(readingNode.get("timestamp").textValue());
//        reading1.setFuelVolume(Double.parseDouble(readingNode.get("fuelVolume").textValue()));
//        reading1.setSpeed(Integer.parseInt(readingNode.get("speed").textValue()));
//        reading1.setEngineHp(Integer.parseInt(readingNode.get("engineHp").textValue()));
//        reading1.setCheckEngineLightOn(readingNode.get("checkEngineLightOn").textValue());
//        reading1.setEngineCoolantLow(readingNode.get("engineCoolantLow").textValue());
//        reading1.setCruiseControlOn(readingNode.get("cruiseControlOn").textValue());
//        reading1.setEngineRpm(Integer.parseInt(readingNode.get("engineRpm").textValue()));
//
//        reading1.setFrontLeft(Integer.parseInt(readingNode.get("tire").get("frontLeft").textValue()));
//        reading1.setFrontRight(Integer.parseInt(readingNode.get("tire").get("frontRight").textValue()));
//        reading1.setRearLeft(Integer.parseInt(readingNode.get("tire").get("rearLeft").textValue()));
//        reading1.setRearRight(Integer.parseInt(readingNode.get("tire").get("rearRight").textValue()));

//        try {
//            Reading reading1 = new ObjectMapper()
//                    .readerFor(Reading.class)
//                    .readValue(String.valueOf(reading));
//            return readingsRepository.save(reading1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        TypeReference<Reading> typeReference = new TypeReference<Reading>(){};
//        InputStream inputStream = TypeReference.class.getResourceAsStream(String.valueOf(reading));
//        try
//        {
//            Reading newReading = objectMapper.readValue(String.valueOf(reading), typeReference);
//            readingsRepository.save(newReading);
//            System.out.println("Reading saved!");
//        } catch (IOException e){
//            System.out.println("Unable to save reading: " + e.getMessage());
//        }

        return readingsRepository.save(reading);
    }

    @Override
    @Transactional
    public Reading update(String id, Reading reading) {
        Optional<Reading> existing = readingsRepository.findById(id);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Reading with timestamp = " + id + " does not exist.");
        }

        return readingsRepository.save(reading);
    }

    @Override
    @Transactional
    public Reading delete(String id) {
        Optional<Reading> reading = readingsRepository.findById(id);
        if(!reading.isPresent()){
            throw new ResourceNotFoundException("Reading with timestamp = " + id + " does not exist.");
        }

        readingsRepository.delete(reading.get());
        return null;
    }
}
