package org.example;

import java.util.*;

public class Clinic {

    private List<Patient> doctorsQ = new ArrayList<>();
    private List<Patient> radiologyQ = new ArrayList<>();
    private TriageType doctorTriageType;
    private TriageType radiologyTriageType;

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType)
    {
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
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
        if(this.doctorTriageType == TriageType.FIFO){
            doctorsQ.add(patient);
        }
        if(this.doctorTriageType == TriageType.GRAVITY){
            doctorsQ.addFirst(patient);
        }
    }

    private void addPatientToRadiologyQ(Patient patient)
    {
        if(this.radiologyTriageType == TriageType.FIFO){
            radiologyQ.add(patient);
        }
        if(this.radiologyTriageType == TriageType.GRAVITY){
            radiologyQ.addFirst(patient);
        }

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
