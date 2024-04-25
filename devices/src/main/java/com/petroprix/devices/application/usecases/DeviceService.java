package com.petroprix.devices.application.usecases;

import com.petroprix.devices.domain.model.dto.DeviceDTO;
import com.petroprix.devices.domain.model.dto.request.DeviceRequest;

import java.time.LocalDate;
import java.util.List;

public interface DeviceService {

    DeviceDTO createNewDevice(DeviceRequest deviceRequest);
    List<DeviceDTO> findByIdDeviceAndDateRangeAndPeriod(Long id_device, LocalDate startDate, LocalDate endDate, String period);
    List<DeviceDTO> findByDeviceIdAndDateRangeAndPeriodWithHighConsumption(Long id_device, LocalDate startDate, LocalDate endDate, String period);
}
