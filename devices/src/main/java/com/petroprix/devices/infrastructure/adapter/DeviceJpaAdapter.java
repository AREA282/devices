package com.petroprix.devices.infrastructure.adapter;

import com.petroprix.devices.domain.model.Device;
import com.petroprix.devices.domain.port.DevicePersistencePort;
import com.petroprix.devices.infrastructure.adapter.entity.DeviceEntity;
import com.petroprix.devices.infrastructure.adapter.exception.DataBaseException;
import com.petroprix.devices.infrastructure.adapter.mapper.DeviceDbMapper;
import com.petroprix.devices.infrastructure.adapter.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DeviceJpaAdapter implements DevicePersistencePort {

    private final DeviceRepository deviceRepository;
    private final DeviceDbMapper deviceDbMapper;

    public DeviceJpaAdapter(DeviceRepository deviceRepository, DeviceDbMapper deviceDbMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceDbMapper = deviceDbMapper;
    }

    @Override
    public Device createNewDevice(Device device)
    {
        try
        {
            DeviceEntity deviceEntityToSave = deviceDbMapper.toDb(device);
            DeviceEntity deviceSaved = deviceRepository.save(deviceEntityToSave);
            return deviceDbMapper.toDomain(deviceSaved);
        }catch(Exception exception)
        {
            throw new DataBaseException("Ha ocurrido un error al intentar guardar el dispositivo en la base de datos");
        }

    }

    @Override
    public List<Device> findByIdDeviceAndDateRangeAndPeriod(Long id_device, LocalDate startDate, LocalDate endDate, String period) {
        try
        {
            return deviceRepository.findByIdDeviceAndDateRangeAndPeriod(id_device, startDate, endDate, period)
                    .stream()
                    .map(deviceDbMapper::toDomain)
                    .toList();
        }catch(Exception exception)
        {
            throw new DataBaseException("Ha ocurrido un error al intentar listar el dispositivo por periodo");
        }
    }

    @Override
    public List<Device> findByDeviceIdAndDateRangeAndPeriodWithHighConsumption(Long id_device, LocalDate startDate, LocalDate endDate, String period) {
        try
        {
            return deviceRepository.findByDeviceIdAndDateRangeAndPeriodWithHighConsumption(id_device, startDate, endDate, period)
                    .stream()
                    .map(deviceDbMapper::toDomain)
                    .toList();
        }catch(Exception exception)
        {
            throw new DataBaseException("Ha ocurrido un error al intentar listar el dispositivo por periodo con consumo mayor a 15%");
        }
    }
}
