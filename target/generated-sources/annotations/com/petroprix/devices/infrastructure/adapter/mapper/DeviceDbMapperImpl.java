package com.petroprix.devices.infrastructure.adapter.mapper;

import com.petroprix.devices.domain.model.Device;
import com.petroprix.devices.infrastructure.adapter.entity.DeviceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-25T16:00:17-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21 (JetBrains s.r.o.)"
)
@Component
public class DeviceDbMapperImpl implements DeviceDbMapper {

    @Override
    public DeviceEntity toDb(Device devices) {
        if ( devices == null ) {
            return null;
        }

        DeviceEntity deviceEntity = new DeviceEntity();

        deviceEntity.setDeviceId( devices.getDeviceId() );
        deviceEntity.setId_device( devices.getId_device() );
        deviceEntity.setConsumption_date( devices.getConsumption_date() );
        deviceEntity.setConsumption_value( devices.getConsumption_value() );

        return deviceEntity;
    }

    @Override
    public Device toDomain(DeviceEntity deviceEntity) {
        if ( deviceEntity == null ) {
            return null;
        }

        Device device = new Device();

        device.setDeviceId( deviceEntity.getDeviceId() );
        device.setId_device( deviceEntity.getId_device() );
        device.setConsumption_date( deviceEntity.getConsumption_date() );
        device.setConsumption_value( deviceEntity.getConsumption_value() );

        return device;
    }
}
