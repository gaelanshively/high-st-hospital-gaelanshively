package org.wcci;

public abstract class MedicalStaff extends HospitalEmployee {
    //sub class of employees able to perform medical tasks


    public MedicalStaff(String employeeName, double employeeSalary, int employeeIdentification, String employeePosition, int healingValue) {
        super(employeeName, employeeSalary, employeeIdentification, employeePosition, healingValue);

    }

//    public interface drawBlood() {
//
//    }
}
