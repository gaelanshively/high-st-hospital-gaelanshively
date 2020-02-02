package org.wcci;

public class Doctor extends MedicalStaff
        //implements MedicalStaff.drawBlood
{
    public Doctor(String employeeName, double employeeSalary, int employeeIdentification, String employeePosition, int healingValue) {
        super(employeeName, employeeSalary, employeeIdentification, employeePosition, healingValue);
        super.healingValue = 5;
    }
}
