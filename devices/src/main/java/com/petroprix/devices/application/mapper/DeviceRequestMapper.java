package com.petroprix.devices.application.mapper;

import com.petroprix.devices.domain.model.Device;
import com.petroprix.devices.domain.model.dto.request.DeviceRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceRequestMapper {

    Device toDomain(DeviceRequest deviceRequest);
}
