package org.wcci;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

public class test {
    private HospitalEmployee employeeInstance;
    private Hospital hospitalInstance = new Hospital();
    private MedicalStaff medicalStaffInstance;
    private HospitalPatient patientInstance;


    @BeforeEach
    void setUp() {
        employeeInstance = new FacilityStaff("Name", 450.00, 80085, 0);
        hospitalInstance.addEmployeeToHospitalMap(employeeInstance);
        medicalStaffInstance = new Doctor("Carlos", 900.00, 8008135, 5);
        hospitalInstance.addEmployeeToHospitalMap(medicalStaffInstance);
        patientInstance = new HospitalPatient("Frankfurt", 1, 25);
        hospitalInstance.addPatientToHospitalMap(patientInstance);

    }

    @org.junit.jupiter.api.Test
    public void shouldHaveEmployeeNames() {
        HashMap<String, HospitalEmployee> employeeHashMap = hospitalInstance.getMapOfEmployees();


        Assertions.assertEquals("Name", employeeInstance.getEmployeeName());


    }

    @org.junit.jupiter.api.Test
    public void shouldHaveEmployeeSalary() {
        HashMap<String, HospitalEmployee> employeeHashMap = hospitalInstance.getMapOfEmployees();

        Assertions.assertEquals(450.00, employeeInstance.getEmployeeSalary());


    }

    @org.junit.jupiter.api.Test
    public void shouldHaveEmployeeID() {
        HashMap<String, HospitalEmployee> employeeHashMap = hospitalInstance.getMapOfEmployees();
        Assertions.assertEquals(80085, employeeInstance.getEmployeeIDNumber());
    }

    @org.junit.jupiter.api.Test
    public void employeeShouldHaveJobTitles() {
        HashMap<String, HospitalEmployee> employeeHashMap = hospitalInstance.getMapOfEmployees();


        Assertions.assertEquals("Unemployed", employeeInstance.getEmployeePosition());
        System.out.println("Job title: " + employeeInstance.getEmployeePosition());

    }

    @org.junit.jupiter.api.Test
    public void medStaffShouldHaveNames() {
        HashMap<String, HospitalEmployee> employeeHashMap = hospitalInstance.getMapOfEmployees();

        Assertions.assertEquals("Carlos", medicalStaffInstance.getEmployeeName());
        System.out.println(medicalStaffInstance.getEmployeeName());
        System.out.println(employeeInstance.getEmployeeName());
    }

    @org.junit.jupiter.api.Test
    public void patientsShouldHaveNames() {
        HashMap<String, HospitalPatient> patientHashMap = hospitalInstance.getMapOfPatients();

        Assertions.assertEquals("Frankfurt", patientInstance.getPatientName());
    }

    @org.junit.jupiter.api.Test
    public void askingForDutyRosterShouldShowStaff() {
        hospitalInstance.showDutyRoster();
    }

    @org.junit.jupiter.api.Test
    public void askingForPatientListShouldShowAllPatients() {
        hospitalInstance.showAllPatients();
    }

    @org.junit.jupiter.api.Test
    public void getPatientBloodShouldGetMeSomeBlood() {
        Assertions.assertEquals(25, patientInstance.getPatientBlood());
    }
}


