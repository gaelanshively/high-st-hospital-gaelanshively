package org.wcci;

public class Doctor extends MedicalStaff
        //implements MedicalStaff.drawBlood

{
    public Doctor(String employeeName, double employeeSalary, int employeeIdentification, int employeePosition) {
        super(employeeName, employeeSalary, employeeIdentification, employeePosition);
        super.bloodDrawAmount = 2;


    }

    public void treatAPatient(HospitalPatient patient) {
        patient.treatThisPatient(5);
    }
}
