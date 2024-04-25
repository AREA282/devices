package com.petroprix.devices.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "devices")
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deviceId")
    private Long deviceId;

    @Column(name = "id_device")
    private Long id_device;

    @Column(name = "consumption_date")
    private LocalDate consumption_date;

    @Column(name = "consumption_value")
    private double consumption_value;

    public DeviceEntity(){

    }
    public DeviceEntity(Long deviceId, Long id_device, LocalDate consumption_date, double consumption_value) {
        this.deviceId = deviceId;
        this.id_device = id_device;
        this.consumption_date = consumption_date;
        this.consumption_value = consumption_value;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getId_device() {
        return id_device;
    }

    public void setId_device(Long id_device) {
        this.id_device = id_device;
    }

    public LocalDate getConsumption_date() {
        return consumption_date;
    }

    public void setConsumption_date(LocalDate consumption_date) {
        this.consumption_date = consumption_date;
    }

    public double getConsumption_value() {
        return consumption_value;
    }

    public void setConsumption_value(double consumption_value) {
        this.consumption_value = consumption_value;
    }
}
