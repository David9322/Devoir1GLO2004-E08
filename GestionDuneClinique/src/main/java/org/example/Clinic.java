package org.example;

import java.util.*;

public class Clinic {

    private List<Patient> doctorsQ = new ArrayList<>();
    private List<Patient> radiologyQ = new ArrayList<>();
    private TriageType triageType;

    public Clinic(TriageType triageType)
    {
        this.triageType = triageType;
    }

    public Patient doctorMeetPatient()
    {
        return doctorsQ.removeFirst();
    }
    public Patient radiologyMeetPatient()
    {
        return radiologyQ.removeFirst();
    }

    public boolean doctorsQIsEmpty()
    {
        return doctorsQ.isEmpty();
    }

    public boolean radiologyQIsEmpty()
    {
        return radiologyQ.isEmpty();
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {}

    private void addPatientToDoctorsQ(Patient patient)
    {
        if(this.triageType == TriageType.FIFO){
            doctorsQ.add(patient);
        }
        if(this.triageType == TriageType.GRAVITY){
            doctorsQ.addFirst(patient);
        }
    }

    private void addPatientToRadiologyQ(Patient patient)
    {
        radiologyQ.add(patient);
    }

    public void addPatient(Patient patient)
    {
        this.addPatientToDoctorsQ(patient);
        if (patient.getSymptom().equals(VisibleSymptom.BROKEN_BONE) || patient.getSymptom().equals(VisibleSymptom.SPRAIN)) {
            this.addPatientToRadiologyQ(patient);
        }
    }

    public boolean isEmpty()
    {
        return doctorsQ.isEmpty();
    }
}
