package com.petroprix.devices.domain.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


public class DeviceRequest {

    private Long deviceId;

    @NotNull(message = "El id del dispositivo no puede ser null")
    private Long id_device;

    @NotNull(message = "La fecha no puede ser null")
    private LocalDate consumption_date;

    @NotNull(message = "El valor de consumo no puede ser null")
    @Min(value = 1, message = "El valor de consumo no puede ser cero")
    private double consumption_value;

    public DeviceRequest(){

    }

    public DeviceRequest(Long deviceId, Long id_device, LocalDate consumption_date, double consumption_value) {
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
