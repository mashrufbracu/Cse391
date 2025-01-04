package com.stech.model;

import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@EntityScan
@AsynchronouslyFormattable
public class Prescription {

    public Prescription(){

    }
    public Prescription(LocalDate prescriptionDate, String patientName, int patientAge, String patientGender ){

        this.prescriptionDate = prescriptionDate;
        this.patientName = patientName;
        this.patientAge = patientAge;
        //this.patientGender = patientGender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Prescription date is required.")
    @PastOrPresent(message = "Prescription date must be in past or today.")
    @Column(name = "prescription_date", nullable = false)
    private LocalDate prescriptionDate;

    @NotNull(message = "Patient name is required.")
    @Column(name = "patient_name", length = 120, nullable = false)
    private String patientName;

    @NotNull(message = "Patient age is required.")
    @Min(value = 0, message = "Patient age must be at least zero")
    @Max(value = 150, message = "Maximum age for a patient is 150")
    @Column(name = "patient_age", nullable = false)
    private int patientAge;

    @NotNull(message = "Patient gender is required.")
    @Enumerated(EnumType.STRING)
    @Column(name = "patient_gender", length = 10, nullable = false)
    private Gender patientGender;

    @Column(columnDefinition = "TEXT", length = 1000)
    private String diagnosis;

    @Column(columnDefinition = "TEXT", length = 1000)
    private String medicines;

    @Temporal(TemporalType.DATE)
    @FutureOrPresent(message = "Next visit date must be in the future.")
    @Column(name = "next_visit_date")
    private LocalDate nextVisitDate;

    @Override
    public String toString() {
        return "Prescription [id=" + id + ", prescriptionDate=" + prescriptionDate + ", patientName=" + patientName
                + ", patientAge=" + patientAge + ", patientGender=" + patientGender + ", diagnosis=" + diagnosis
                + ", medicines=" + medicines + ", nextVisitDate=" + nextVisitDate + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public Gender getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Gender patientGender) {
        this.patientGender = patientGender;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public LocalDate getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(LocalDate nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

}
