package org.wcci;

public abstract class HospitalEmployee {
    protected int healingValue;
    private String employeeName;
    private double employeeSalary;
    private int employeeIdentification;
    private String employeePosition;

    public HospitalEmployee(String employeeName, double employeeSalary, int employeeIdentification, String employeePosition, int healingValue) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeIdentification = employeeIdentification;
        this.employeePosition = employeePosition;
        this.healingValue = healingValue;

    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    @Override
    public String toString() {
        return employeeName + ": \n"
                + "     Employee Position: " + employeePosition
                + "\n     Employee ID: " + employeeIdentification
                + "\n     Salary: " + employeeSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeIDNumber() {
        return employeeIdentification;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }
}
