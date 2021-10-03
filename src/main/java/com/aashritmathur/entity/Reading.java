package com.aashritmathur.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

//@JsonIgnoreProperties("tire")

@Entity
public class Reading {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String vin;
    private double latitude;
    private double longitude;
    private String timestamp;
    private double fuelVolume;
    private int speed;
    private int engineHp;
    private String checkEngineLightOn;
    private String engineCoolantLow;
    private String cruiseControlOn;
    private int engineRpm;

//    private int frontLeft;
//    private int frontRight;
//    private int rearLeft;
//    private int rearRight;
    @JsonUnwrapped
    private Tire tire;

    private static class Tire{
        private int frontLeft;
        private int frontRight;
        private int rearLeft;
        private int rearRight;

        public int getFrontLeft() {
            return frontLeft;
        }

        public void setFrontLeft(int frontLeft) {
            this.frontLeft = frontLeft;
        }

        public int getFrontRight() {
            return frontRight;
        }

        public void setFrontRight(int frontRight) {
            this.frontRight = frontRight;
        }

        public int getRearLeft() {
            return rearLeft;
        }

        public void setRearLeft(int rearLeft) {
            this.rearLeft = rearLeft;
        }

        public int getRearRight() {
            return rearRight;
        }

        public void setRearRight(int rearRight) {
            this.rearRight = rearRight;
        }

        @Override
        public String toString() {
            return "Tire{" +
                    "frontLeft=" + frontLeft +
                    ", frontRight=" + frontRight +
                    ", rearLeft=" + rearLeft +
                    ", rearRight=" + rearRight +
                    '}';
        }
    }

//    @SuppressWarnings("unchecked")
//    @JsonProperty("tire")
//    private void unpackNested(Map<String,Object> tire) {
//        this.frontLeft = (int) tire.get("frontLeft");
//        this.frontRight = (int) tire.get("frontRight");
//        this.rearLeft = (int) tire.get("rearLeft");
//        this.rearRight = (int) tire.get("rearRight");
//    }

    public Reading(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public String getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(String checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public String getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(String engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public String getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(String cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

//    public int getFrontLeft() {
//        return frontLeft;
//    }
//
//    public void setFrontLeft(int frontLeft) {
//        this.frontLeft = frontLeft;
//    }
//
//    public int getFrontRight() {
//        return frontRight;
//    }
//
//    public void setFrontRight(int frontRight) {
//        this.frontRight = frontRight;
//    }
//
//    public int getRearLeft() {
//        return rearLeft;
//    }
//
//    public void setRearLeft(int rearLeft) {
//        this.rearLeft = rearLeft;
//    }
//
//    public int getRearRight() {
//        return rearRight;
//    }
//
//    public void setRearRight(int rearRight) {
//        this.rearRight = rearRight;
//    }


    @Override
    public String toString() {
        return "Reading{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp='" + timestamp + '\'' +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn='" + checkEngineLightOn + '\'' +
                ", engineCoolantLow='" + engineCoolantLow + '\'' +
                ", cruiseControlOn='" + cruiseControlOn + '\'' +
                ", engineRpm=" + engineRpm +
                ", tire=" + tire +
                '}';
    }
}
