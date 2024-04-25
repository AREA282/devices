package com.petroprix.devices.domain.port;

import com.petroprix.devices.domain.model.Device;

import java.time.LocalDate;
import java.util.List;

public interface DevicePersistencePort {

    Device createNewDevice(Device device);
    List<Device> findByIdDeviceAndDateRangeAndPeriod(Long id_device, LocalDate startDate, LocalDate endDate, String period);
    List<Device> findByDeviceIdAndDateRangeAndPeriodWithHighConsumption(Long id_device, LocalDate startDate, LocalDate endDate, String period);

}
