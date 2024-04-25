package com.petroprix.devices.domain.model.dto;


import java.time.LocalDate;

public class DeviceDTO {

    private Long deviceId;

    private Long id_device;

    private LocalDate consumption_date;

    private double consumption_value;

    public DeviceDTO(){

    }
    public DeviceDTO(Long deviceId, Long id_device, LocalDate consumption_date, double consumption_value) {
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
