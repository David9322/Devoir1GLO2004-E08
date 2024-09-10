package org.example;
import org.example.VisibleSymptom;

public class Patient {

    private String name;
    private int gravity;
    private VisibleSymptom symptom;

    public Patient(String name, int gravity, VisibleSymptom symptom) {
        this.name = name;
        this.gravity = gravity;
        this.symptom = symptom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public VisibleSymptom getSymptom() {
        return symptom;
    }

    public void setSymptom(VisibleSymptom symptom) {
        this.symptom = symptom;
    }
}


