package com.kxs.hospitalmanagement.mappers;

import com.kxs.hospitalmanagement.dtos.request.MedicineRequest;
import com.kxs.hospitalmanagement.dtos.response.MedicneResponse;
import com.kxs.hospitalmanagement.entities.Medicine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicineMapper {

    Medicine toEntity(MedicineRequest medicineRequest);
    MedicneResponse toResponse(Medicine medicine);
}
