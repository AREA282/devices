package com.petroprix.devices.application.service;

import com.petroprix.devices.application.mapper.DeviceDtoMapper;
import com.petroprix.devices.application.mapper.DeviceRequestMapper;
import com.petroprix.devices.application.usecases.DeviceService;
import com.petroprix.devices.domain.model.Device;
import com.petroprix.devices.domain.model.dto.DeviceDTO;
import com.petroprix.devices.domain.model.dto.request.DeviceRequest;
import com.petroprix.devices.domain.port.DevicePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeviceManagementService implements DeviceService {

    private final DevicePersistencePort devicePersistencePort;
    private final DeviceDtoMapper deviceDtoMapper;
    private final DeviceRequestMapper deviceRequestMapper;
    @Autowired
    public DeviceManagementService(DevicePersistencePort devicePersistencePort, DeviceDtoMapper deviceDtoMapper, DeviceRequestMapper deviceRequestMapper) {
        this.devicePersistencePort = devicePersistencePort;
        this.deviceDtoMapper = deviceDtoMapper;
        this.deviceRequestMapper = deviceRequestMapper;
    }


    @Override
    public DeviceDTO createNewDevice(DeviceRequest deviceRequest) {
        Device deviceToCreate= deviceRequestMapper.toDomain(deviceRequest);
        Device deviceCreated = devicePersistencePort.createNewDevice(deviceToCreate);
        return deviceDtoMapper.toDto(deviceCreated);
    }

    @Override
    public List<DeviceDTO> findByIdDeviceAndDateRangeAndPeriod(Long id_device, LocalDate startDate, LocalDate endDate, String period) {
        List<Device> device = devicePersistencePort.findByIdDeviceAndDateRangeAndPeriod(id_device, startDate, endDate, period);
        return device
                .stream()
                .map(deviceDtoMapper::toDto)
                .toList();
    }

    @Override
    public List<DeviceDTO> findByDeviceIdAndDateRangeAndPeriodWithHighConsumption(Long id_device, LocalDate startDate, LocalDate endDate, String period) {
       List<Device> devices = devicePersistencePort.findByDeviceIdAndDateRangeAndPeriodWithHighConsumption(id_device, startDate, endDate, period);
       return devices
               .stream()
               .map(deviceDtoMapper::toDto)
               .toList();
    }


}
