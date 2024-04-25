package com.petroprix.devices.infrastructure.adapter.mapper;

import com.petroprix.devices.domain.model.Device;
import com.petroprix.devices.infrastructure.adapter.entity.DeviceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceDbMapper {

    DeviceEntity toDb(Device devices);

    Device toDomain(DeviceEntity deviceEntity);
}
