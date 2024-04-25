package com.petroprix.devices.application.mapper;

import com.petroprix.devices.domain.model.Device;
import com.petroprix.devices.domain.model.dto.DeviceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceDtoMapper {

    DeviceDTO toDto(Device devices);
}
