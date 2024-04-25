# Prueba Técnica - Java Spring Boot

## Descripción del Proyecto

Este proyecto tiene como objetivo desarrollar un sistema para la fábrica ACME que permita controlar el consumo energético de los dispositivos de operación mediante sensores y PLCs que ya pueden consumir servicios REST. El sistema debe ser capaz de recibir los consumos de los dispositivos cada minuto, almacenarlos para análisis posterior, y ofrecer informes de consumo diario, semanal y mensual por dispositivo.

## Historias de Usuario

### 1. Registro de Consumos

**Como** Sistema de Adquisición  
**Quiero** un servicio REST para registrar los consumos de los dispositivos  
**Para** almacenar la información para su posterior análisis.

#### Criterios de Aceptación:
- El servicio REST debe recibir un POST con los datos de `id_device`, `consumption_date` y `consumption_value`.
- En caso de éxito, se debe recibir el mensaje de estado HTTP 200.
- En caso de error interno, se debe recibir un mensaje de error HTTP 500.
- En caso de error de parámetros, se debe recibir un mensaje de error HTTP 404.
- En caso de no recibir el valor de consumo, se debe recibir un mensaje de error HTTP 400.

### 2. Informe de Consumos

**Como** Sistema de Reportes  
**Quiero** un servicio para obtener información de consumos diario, semanal y mensual por dispositivos  
**Para** tener datos precisos sobre el consumo energético de los dispositivos.

#### Criterios de Aceptación:
- El servicio REST debe recibir un GET con `id_device`, `startDate`, `endDate` y `period` (`daily`, `weekly`, o `monthly`).
- El sistema debe retornar una lista de `id_device`, `consumption_date` y `consumption_value` para el rango de fecha solicitado.
- En caso de éxito, se debe recibir el mensaje de estado HTTP 200.
- En caso de error interno, se debe recibir un mensaje de error HTTP 500.
- En caso de no recibir `id_device`, se debe generar un mensaje de error HTTP 404.
- En caso de no recibir los valores de rango de fecha o si son incorrectos, se debe recibir un mensaje de error HTTP 400.

### 3. Informe de Picos de Consumo

**Como** Sistema de Reportes  
**Quiero** un servicio para obtener información de picos de consumo diario, semanal y mensual por dispositivos  
**Para** identificar períodos de alto consumo energético.

#### Criterios de Aceptación:
- El servicio REST debe recibir un GET con `id_device`, `startDate`, `endDate` y `period` (`daily`, `weekly`, o `monthly`).
- El sistema debe retornar una lista de `id_device`, `consumption_date` y `consumption_value` para el rango de fecha donde el consumo fue superior al 15% de la media.
- En caso de éxito, se debe recibir el mensaje de estado HTTP 200.
- En caso de error interno, se debe recibir un mensaje de error HTTP 500.
- En caso de no recibir `id_device`, se debe generar un mensaje de error HTTP 404.
- En caso de no recibir los valores de rango de fecha o si son incorrectos, se debe recibir un mensaje de error HTTP 400.
