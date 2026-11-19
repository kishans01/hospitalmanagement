package com.kxs.hospitalmanagement.controllers;

import com.kxs.hospitalmanagement.dtos.request.MedicineRequest;
import com.kxs.hospitalmanagement.dtos.response.MedicneResponse;
import com.kxs.hospitalmanagement.service.MedicineService;
import com.kxs.hospitalmanagement.utility.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hms/api/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }


    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<MedicneResponse>> addMedicine(@RequestBody MedicineRequest  medicineRequest ){
        ResponseStructure<MedicneResponse> response = new ResponseStructure<>();
        response.setData(medicineService.addMedicine(medicineRequest));
        response.setMessage("Medicine added successfully");
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
