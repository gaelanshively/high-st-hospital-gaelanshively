package org.wcci;

import java.util.HashMap;

public class Hospital {

    private HashMap<String, HospitalEmployee> mapOfEmployees = new HashMap<>();

    public HashMap<String, HospitalEmployee> getMapOfEmployees() {
        return mapOfEmployees;
    }

    private HashMap<String, HospitalPatient> mapOfPatients = new HashMap<>();

    public HashMap<String, HospitalPatient> getMapOfPatients() {
        return mapOfPatients;
    }

    public void addEmployeeToHospitalMap(HospitalEmployee employee) {
        getMapOfEmployees().put(employee.getEmployeeName(), employee);
    }

    public void addPatientToHospitalMap(HospitalPatient patient) {
        getMapOfPatients().put(patient.getPatientName(), patient);
    }

    public void showDutyRoster() {
        System.out.println("Here is every employee available:");
        for (HospitalEmployee employee : getMapOfEmployees().values()) {
            System.out.println(employee);
        }
    }

    public void showAllPatients() {
        System.out.println("Here is every patient in your care:");
        for (HospitalPatient patient : getMapOfPatients().values()) {
            System.out.println(patient);
        }
    }


}

