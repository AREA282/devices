package com.petroprix.devices.infrastructure.rest.controller;

import com.petroprix.devices.application.usecases.DeviceService;
import com.petroprix.devices.domain.model.dto.CustomResponseDTO;
import com.petroprix.devices.domain.model.dto.DeviceDTO;
import com.petroprix.devices.domain.model.dto.request.DeviceRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService deviceService;
    public DeviceController(DeviceService deviceService) {this.deviceService = deviceService;}

    @PostMapping()
    public ResponseEntity<Object> createNewDevice(@Validated @RequestBody DeviceRequest deviceRequest)
    {
        DeviceDTO savedDevice = deviceService.createNewDevice(deviceRequest);
        CustomResponseDTO res = new CustomResponseDTO("El dispositivo ha sido creado exitosamente!", HttpStatus.OK);
        res.setResponseObject(savedDevice);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/period/{id_device}")
    public ResponseEntity<Object> getDeviceConsumption(
            @Validated
            @RequestParam Long id_device,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam String period
            )
    {
        List<DeviceDTO> devices = deviceService.findByIdDeviceAndDateRangeAndPeriod(id_device, startDate, endDate, period);
        CustomResponseDTO res = new CustomResponseDTO("Los dispositivos han sido consultados satisfactoriamentr!", HttpStatus.OK);
        res.setResponseObject(devices);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/consumption")
    public ResponseEntity<Object> findDevicesWhitConsumptionAboveThreshold(
            @Validated
            @RequestParam Long id_device,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam String period
            )
    {
        List<DeviceDTO> devices = deviceService.findByDeviceIdAndDateRangeAndPeriodWithHighConsumption(id_device, startDate, endDate, period);
        CustomResponseDTO res = new CustomResponseDTO("Los dispositivos por encima del 15% de consumo han sido consultados satisfactoriamente!", HttpStatus.OK);
        res.setResponseObject(devices);
        return ResponseEntity.ok(res);
    }

}
