package com.kxs.hospitalmanagement.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hms/api/medicine")
public class MedicineController {

    @PostMapping("/add")
    public Object addMedicine(){
        return "Medicine Added Successfully";
    }

}
