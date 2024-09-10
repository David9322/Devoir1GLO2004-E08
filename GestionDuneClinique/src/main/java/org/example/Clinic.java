package org.example;

import java.util.*;

public class Clinic {

    private List<Patient> doctorsQ = new ArrayList<>();
    private List<Patient> radiologyQ = new ArrayList<>();

    public Patient meetPatient()
    {
        return doctorsQ.removeFirst();
    }

    public boolean docstorsQIsEmpty()
    {
        return doctorsQ.isEmpty();
    }
    public boolean radiologyQIsEmpty()
    {
        return radiologyQ.isEmpty();
    }

    public Clinic(/* ... */) {
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        // TODO
    }

    private void addPatientToDoctorsQ(Patient patient)
    {
        doctorsQ.add(patient);
    }
    private void addPatientToRadiologyQ(Patient patient)
    {
        radiologyQ.add(patient);
    }
    public void addPatient(Patient patient)
    {
        addPatientToDoctorsQ(patient);
        if(patient.getSymptom().equals(VisibleSymptom.BROKEN_BONE) || patient.getSymptom().equals(VisibleSymptom.SPRAIN)){
            addPatientToRadiologyQ(patient);
        }
    }



    public boolean isEmpty()
    {
        return doctorsQ.isEmpty();
    }


    // D'autres méthodes peuvent être nécessaires
}

/*
Scénario 1: Celui où un patient se présente à la clinique avec une migraine
Lorsqu'un patient se présente avec MIGRAINE (peu importe la gravité)
Alors il est le premier dans la file d'attente du médecin
Et il n'est pas dans la file d'attente de la radiologie

Scénario 2: Celui où 2 patients se présentent à la clinique
Étant donné qu'il y a un patient dans la file d'attente du médecin
Lorsqu'un patient se présente avec FLU (peu importe la gravité)
Alors il est le deuxième dans la file d'attente du médecin
Et il n'est pas dans la file d'attente de la radiologie

Scénario 3: Celui où un patient se présente à la clinique avec une entorse
Lorsqu'un patient se présente avec SPRAIN (peu importe la gravité)
Alors il est le premier dans la file d'attente du médecin
Et il est la première dans la file d'attente de la radiologie*/
