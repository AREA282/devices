package com.petroprix.devices.application.mapper;

import com.petroprix.devices.domain.model.Device;
import com.petroprix.devices.domain.model.dto.DeviceDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-25T16:00:17-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21 (JetBrains s.r.o.)"
)
@Component
public class DeviceDtoMapperImpl implements DeviceDtoMapper {

    @Override
    public DeviceDTO toDto(Device devices) {
        if ( devices == null ) {
            return null;
        }

        DeviceDTO deviceDTO = new DeviceDTO();

        deviceDTO.setDeviceId( devices.getDeviceId() );
        deviceDTO.setId_device( devices.getId_device() );
        deviceDTO.setConsumption_date( devices.getConsumption_date() );
        deviceDTO.setConsumption_value( devices.getConsumption_value() );

        return deviceDTO;
    }
}
