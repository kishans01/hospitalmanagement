package com.kxs.hospitalmanagement.service;

import com.kxs.hospitalmanagement.dtos.request.MedicineRequest;
import com.kxs.hospitalmanagement.dtos.response.MedicneResponse;
import com.kxs.hospitalmanagement.entities.Medicine;
import com.kxs.hospitalmanagement.exceptionHandler.GenericException;
import com.kxs.hospitalmanagement.mappers.MedicineMapper;
import com.kxs.hospitalmanagement.repository.MedicineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;
    private final MedicineMapper medicineMapper;

    public MedicineService(MedicineRepository medicineRepository, MedicineMapper medicineMapper) {
        this.medicineRepository = medicineRepository;
        this.medicineMapper = medicineMapper;
    }


    public MedicneResponse addMedicine(MedicineRequest medicineRequest) {
        Optional<Medicine> duplicateNameMedicne =medicineRepository.findByMedicineName(medicineRequest.medicineName());
        if(duplicateNameMedicne.isPresent()) {
            throw new GenericException("Medicine with medicine name : " + medicineRequest.medicineName() + " already exists");
        }
       return medicineMapper.toResponse(medicineRepository.save(medicineMapper.toEntity(medicineRequest)));
    }
}
