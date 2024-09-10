import org.example.Clinic;
import org.example.Patient;
import org.example.VisibleSymptom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {

    @Test
    public void givenAPatient_whenAddingPatientInDoctorsQ_thenPatientAdded()
    {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.COLD);

        clinic.addPatient(patient);

        assertFalse(clinic.isEmpty());
    }

    @Test
    public void givenOnePatientInList_whenMeet_thenPatientIsRemoved()
    {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.COLD);

        clinic.addPatient(patient);
        clinic.meetPatient();

        assertTrue(clinic.docstorsQIsEmpty());
    }


    @Test
    public void givenTwoPatientsInList_whenMeet_thenPatientRemovedInSameOrder()
    {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.COLD);
        Patient patient2 = new Patient("Jean-Marie", 4, VisibleSymptom.COLD);
        clinic.addPatient(patient);
        clinic.addPatient(patient2);

        Patient meetedPatient = clinic.meetPatient();
        Patient meetedPatient2 = clinic.meetPatient();

        assertEquals(patient, meetedPatient);
        assertEquals(patient2, meetedPatient2);
        assertTrue(clinic.docstorsQIsEmpty());
    }


    @Test
    public void givenPatientHasBrokenBone_whenAddingPatient_thenAddToBothDoctorAndRadiologyQ()
    {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.BROKEN_BONE);
        clinic.addPatient(patient);

        assertFalse(clinic.docstorsQIsEmpty());
        assertFalse(clinic.radiologyQIsEmpty());
    }



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
Et il est la première dans la file d'attente de la radiologie
*/