package org.wcci;


public class HospitalPatient {
    private String patientName;
    private int patientHealth;
    private int patientBlood;


    public HospitalPatient(String patientName, int patientHealth, int patientBlood) {
        this.patientName = patientName;
        this.patientHealth = patientHealth;
        this.patientBlood = patientBlood;
    }

    public HospitalPatient() {
        this.patientBlood = 20;
        this.patientHealth = 10;
    }

    public String getPatientName() {
        return String.valueOf(patientName);
    }

    public int getPatientHealth() {
        return patientHealth;
    }

    public int getPatientBlood() {
        return patientBlood;
    }

    @Override
    public String toString() {
        return patientName + ": \n"
                + "     Patient Health: " + patientHealth
                + "\n     Blood Level: " + patientBlood;
    }

    public void tickPatient() {
        decreasePatientHealth();
        increaseBloodLevels();
    }


    private void increaseBloodLevels() {
        patientBlood++;
    }


    private void decreasePatientHealth() {
        patientHealth -= 1;
    }

    public void treatThisPatient(int healingValue) {
        patientHealth += healingValue;
        System.out.println(patientName + " has been healed by " + healingValue + "!");

    }

    public void drawThisPatientsBlood(int amountOfBlood) {
        patientBlood -= amountOfBlood;
        System.out.println(patientName + " has had their blood drawn!");
    }
}
