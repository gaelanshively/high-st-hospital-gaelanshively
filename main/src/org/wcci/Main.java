package org.wcci;

import java.util.Scanner;

public class Main {

    static Scanner scannerInput = new Scanner(System.in);
    static Hospital hospital = new Hospital();

    public static void main(String[] args) {


        createInitialDoctors();
        createInitialPatients();
        printGreeting();
        printMainMenu();


    }

    private static void printMainMenu() {
        hospital.showAllPatients();
        userTakesATurn();
    }

    private static HospitalPatient pickAPatient() {
        String userPickPatient;
        hospital.showAllPatients();
        System.out.println("Which patient would you like to help?");
        userPickPatient = scannerInput.nextLine();
        HospitalPatient chosenPatient = hospital.getMapOfPatients().get(userPickPatient);

        return chosenPatient;
    }

    private static void createInitialDoctors() {
        hospital.addEmployeeToHospitalMap(new Doctor("Doctor Ripley", 235000.00, 10005601, 1));
        hospital.addEmployeeToHospitalMap(new Nurse("Nurse Vasquez", 145000.00, 42655100, 2));
        hospital.addEmployeeToHospitalMap((new FacilityStaff("Receptionist Bishop", 45000.00, 34135698, 3)));
        hospital.addEmployeeToHospitalMap((new FacilityStaff("Janitor Burke", 30000.00, 28185697, 4)));


    }

    private static void createInitialPatients() {
        hospital.addPatientToHospitalMap(new HospitalPatient("Jeff", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Britta", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Abed", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Annie", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Troy", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Elroy", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Frankie", 20, 10));
    }

//    private static void treatPatient(staffMember) {
//        String userPickPatient;
//                for (HospitalPatient patient : hospital.getMapOfPatients().values()) {
//            System.out.println(patient);
//        }
//
//        System.out.println("Which patient would you like to treat?");
//        userPickPatient = scannerInput.nextLine();
//        HospitalPatient chosenPatient = hospital.getMapOfPatients().get(userPickPatient);
//        chosenPatient.treatThisPatient(staffmember.healingValue);
//    }

    private static void printGreeting() {
        System.out.println("Welcome to the High St. Hospital!");
        System.out.println("You have just been hired as the new Hospital Administrator!");
        System.out.println("Let's get to work!");
    }

    private static void killDeadPatients() {
        for (HospitalPatient patient : hospital.getMapOfPatients().values()) {
            if (patient.getPatientHealth() <= 0) {
                System.out.println(patient.getPatientName() + " has died.");
                System.out.println("You should have taken better care of them!");
                hospital.getMapOfPatients().remove(patient.getPatientName());
            } else if (patient.getPatientBlood() <= 0) {
                System.out.println(patient.getPatientName() + " has died.");
                System.out.println("You took way too much blood from them!");
                hospital.getMapOfPatients().remove(patient.getPatientName());
            } else if (patient.getPatientHealth() >= 50) {
                System.out.println(patient.getPatientName() + " is healthy!  They have been sent home.");
                hospital.getMapOfPatients().remove(patient.getPatientName());
            }

        }
        printMainMenu();
    }


    private static void userTakesATurn() {
        String userCommand;
        HospitalPatient pickedPatient;
        Doctor chosenDoctor = (Doctor) hospital.getMapOfEmployees().get("Doctor Ripley");
        Nurse chosenNurse = (Nurse) hospital.getMapOfEmployees().get("Nurse Vasquez");
        FacilityStaff receptionist = (FacilityStaff) hospital.getMapOfEmployees().get("Receptionist Bishop");
        FacilityStaff janitor = (FacilityStaff) hospital.getMapOfEmployees().get("Janitor Burke");
        System.out.println("What would Doctor Ripley like to do? \n"
                + "1. Treat a patient \n"
                + "2. Draw blood");
        userCommand = scannerInput.nextLine();
        switch (userCommand) {
            case "1":
                pickedPatient = pickAPatient();
                chosenDoctor.treatAPatient(pickedPatient);
                break;
            case "2":
                pickedPatient = pickAPatient();
                chosenDoctor.drawBlood(pickedPatient);
                break;
            default:
                System.out.println("That is not a valid option.");
        }
        System.out.println("What would Nurse Vasquez like to do? \n"
                + "1. Treat a patient \n"
                + "2. Draw blood");
        userCommand = scannerInput.nextLine();
        switch (userCommand) {
            case "1":
                pickedPatient = pickAPatient();
                chosenNurse.treatAPatientWithNurse(pickedPatient);
                break;
            case "2":
                pickedPatient = pickAPatient();
                chosenNurse.drawBlood(pickedPatient);
                break;
            default:
                System.out.println("That is not a valid option.");
        }
        System.out.println("What would Receptionist Bishop like to do? \n"
                + "1. Answer phones \n"
                + "2. Assist patients");
        userCommand = scannerInput.nextLine();
        switch (userCommand) {
            case "1":
                receptionist.employeeIsDoing = receptionist.getEmployeeName() + " is answering the phones!";
                System.out.println(receptionist.getEmployeeName() + " is answering the phones!");
                break;
            case "2":
                receptionist.employeeIsDoing = receptionist.getEmployeeName() + " is assisting patients!";
                System.out.println(receptionist.getEmployeeName() + " is assisting patients!");
                break;
            default:
                System.out.println("That is not a valid option.");
        }
        System.out.println("What would Janitor Burke like to do? \n"
                + "1. Clean toilets \n"
                + "2. Take a smoke break");
        userCommand = scannerInput.nextLine();
        switch (userCommand) {
            case "1":
                janitor.employeeIsDoing = janitor.getEmployeeName() + " is cleaning the toilets!";
                System.out.println(janitor.employeeIsDoing);
                break;
            case "2":
                janitor.employeeIsDoing = janitor.getEmployeeName() + " is taking a smoke break.";
                System.out.println(janitor.employeeIsDoing);
                break;
            default:
                System.out.println("That is not a valid option.");
        }
        hospital.tickAllPatients();
        killDeadPatients();
        printMainMenu();
    }
}


