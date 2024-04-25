package com.petroprix.devices.infrastructure.adapter.repository;

import com.petroprix.devices.infrastructure.adapter.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

    @Query("SELECT new com.petroprix.devices.infrastructure.adapter.entity.DeviceEntity(d.deviceId, d.id_device, " +
            "CASE WHEN :period = 'daily' THEN d.consumption_date " +
            "WHEN :period = 'weekly' THEN FUNCTION('date_trunc', 'week', d.consumption_date) " +
            "WHEN :period = 'monthly' THEN FUNCTION('date_trunc', 'month', d.consumption_date) " +
            "END AS period_date, " +
            "SUM(d.consumption_value)) " +
            "FROM DeviceEntity d " +
            "WHERE d.id_device = :id_device " +
            "AND d.consumption_date BETWEEN :startDate AND :endDate " +
            "GROUP BY d.deviceId, d.id_device, " +
            "CASE WHEN :period = 'daily' THEN d.consumption_date " +
            "WHEN :period = 'weekly' THEN FUNCTION('date_trunc', 'week', d.consumption_date) " +
            "WHEN :period = 'monthly' THEN FUNCTION('date_trunc', 'month', d.consumption_date) " +
            "END")
    List<DeviceEntity> findByIdDeviceAndDateRangeAndPeriod(
            @Param("id_device") Long id_device,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("period") String period
    );

    @Query("SELECT d FROM DeviceEntity d " +
            "WHERE d.id_device = :id_device " +
            "AND d.consumption_date BETWEEN :startDate AND :endDate " +
            "AND d.consumption_value > (" +
            "    CASE :periodo " +
            "        WHEN 'daily' THEN (" +
            "            SELECT AVG(daily.consumption_value) * 1.15 " +
            "            FROM DeviceEntity daily " +
            "            WHERE daily.id_device = :id_device " +
            "            AND daily.consumption_date = d.consumption_date " +
            "        ) " +
            "        WHEN 'weekly' THEN (" +
            "            SELECT AVG(weekly.consumption_value) * 1.15 " +
            "            FROM DeviceEntity weekly " +
            "            WHERE weekly.id_device = :id_device " +
            "            AND EXTRACT(WEEK FROM weekly.consumption_date) = EXTRACT(WEEK FROM d.consumption_date) " +
            "            AND weekly.consumption_date BETWEEN :startDate AND :endDate " +
            "        ) " +
            "        WHEN 'monthly' THEN (" +
            "            SELECT AVG(monthly.consumption_value) * 1.15 " +
            "            FROM DeviceEntity monthly " +
            "            WHERE monthly.id_device = :id_device " +
            "            AND EXTRACT(MONTH FROM monthly.consumption_date) = EXTRACT(MONTH FROM d.consumption_date) " +
            "            AND monthly.consumption_date BETWEEN :startDate AND :endDate " +
            "        ) " +
            "        ELSE 0 " +
            "    END" +
            ")")
    List<DeviceEntity> findByDeviceIdAndDateRangeAndPeriodWithHighConsumption(
            @Param("id_device") Long id_device,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("periodo") String periodo);

}
