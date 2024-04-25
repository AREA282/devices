package com.petroprix.devices.application.mapper;

import com.petroprix.devices.domain.model.Device;
import com.petroprix.devices.domain.model.dto.request.DeviceRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-25T16:00:17-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21 (JetBrains s.r.o.)"
)
@Component
public class DeviceRequestMapperImpl implements DeviceRequestMapper {

    @Override
    public Device toDomain(DeviceRequest deviceRequest) {
        if ( deviceRequest == null ) {
            return null;
        }

        Device device = new Device();

        device.setDeviceId( deviceRequest.getDeviceId() );
        device.setId_device( deviceRequest.getId_device() );
        device.setConsumption_date( deviceRequest.getConsumption_date() );
        device.setConsumption_value( deviceRequest.getConsumption_value() );

        return device;
    }
}
