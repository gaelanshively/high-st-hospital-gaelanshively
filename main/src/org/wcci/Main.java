package org.wcci;

import java.util.Scanner;

public class Main {

    static Scanner scannerInput = new Scanner(System.in);
    static Hospital hospital = new Hospital();

    public static void main(String[] args) {

        String userCommand;
        createInitialDoctors();
        printGreeting();
        printMainMenu();
        userCommand = scannerInput.nextLine();
        while (true) {


            switch (userCommand) {
                case "1":
                    //treat patient
                    treatPatient();
                    break;
                case "2":
                    //draw blood

                    break;
                case "3":
                    //pay employees?
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("I'm sorry, that is not a valid option.");
            }
            killDeadPatients();
        }


    }

    private static void createInitialDoctors() {
        hospital.addEmployeeToHospitalMap(new Doctor("Ellen Ripley", 235000.00, 10005601, "Chief of Medicine", 7));
        hospital.addEmployeeToHospitalMap(new Doctor("Dwayne Hicks", 135000.00, 21384100, "Radiologist", 5));
        hospital.addEmployeeToHospitalMap(new Doctor("Jenette Vasquez", 145000.00, 42655100, "Chief of Surgery", 6));
        hospital.addEmployeeToHospitalMap((new FacilityStaff("Lance Bishop", 45000.00, 34135698, "Receptionist", 0)));
        hospital.addEmployeeToHospitalMap((new FacilityStaff("Carter Burke", 30000.00, 28185697, "Janitor", 0)));

    }

    private static void createInitialPatients() {
        hospital.addPatientToHospitalMap(new HospitalPatient("Jeff", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Britta", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Abed", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Annie", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Troy", 20, 10));
        hospital.addPatientToHospitalMap(new HospitalPatient("Elroy", 20, 10));
    }

    private static void treatPatient() {
        String userPickPatient;
        int totalHealingValue = 0;
        for (HospitalEmployee employee : hospital.getMapOfEmployees().values()) {
            totalHealingValue += employee.healingValue;
        }

        for (HospitalPatient patient : hospital.getMapOfPatients().values()) {
            System.out.println(patient.getPatientName());
        }

        System.out.println("Which patient would you like to treat?");
        userPickPatient = scannerInput.nextLine();
        HospitalPatient chosenPatient = hospital.getMapOfPatients().get(userPickPatient);
        chosenPatient.treatThisPatient(totalHealingValue);
    }

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
            }
        }
    }


    private static void printMainMenu() {
        System.out.println("Select an option: \n" +
                "1: Treat Patients \n" +
                "2: Draw blood \n" +
                "3: Pay employees \n" +
                "4: Quit");

    }
}

