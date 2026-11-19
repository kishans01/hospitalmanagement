package com.kxs.hospitalmanagement.dtos.request;

public record MedicineRequest(
        String medicineName,
        String category,
        Integer minStock,
        String description

) {
}
