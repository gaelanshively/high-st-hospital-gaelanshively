package org.wcci;

public class Nurse extends MedicalStaff {

    public Nurse(String employeeName, double employeeSalary, int employeeIdentification, int employeePosition) {
        super(employeeName, employeeSalary, employeeIdentification, employeePosition);
        super.bloodDrawAmount = 3;
    }

    public static void treatAPatientWithNurse(HospitalPatient patient) {
        patient.treatThisPatient(2);
    }
}