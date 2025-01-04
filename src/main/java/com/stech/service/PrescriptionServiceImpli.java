package com.stech.service;

import com.stech.model.Prescription;
import com.stech.repository.PrescriptionRepository;

import java.util.List;
import java.util.Optional;

public class PrescriptionServiceImpli implements PrescriptionService{

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpli(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepo.findAll();
    }

    @Override
    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepo.findById(id);
    }


}
