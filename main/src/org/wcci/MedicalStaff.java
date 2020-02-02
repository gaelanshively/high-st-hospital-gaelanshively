package org.wcci;

public class MedicalStaff extends HospitalEmployee implements DrawsBlood {
    //sub class of employees able to perform medical tasks
    int bloodDrawAmount = 2;

    public MedicalStaff(String employeeName, double employeeSalary, int employeeIdentification, int employeePosition) {
        super(employeeName, employeeSalary, employeeIdentification, employeePosition);

    }

    public void drawBlood(HospitalPatient patient) {
        patient.drawThisPatientsBlood(bloodDrawAmount);
    }
}