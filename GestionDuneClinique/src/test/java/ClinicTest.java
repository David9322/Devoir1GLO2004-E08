import org.example.Clinic;
import org.example.Patient;
import org.example.TriageType;
import org.example.VisibleSymptom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {

    @Test
    public void givenAPatient_whenAddingPatientInDoctorsQ_thenPatientAdded()
    {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.COLD);

        clinic.addPatient(patient);

        assertFalse(clinic.isEmpty());
    }

    @Test
    public void givenOnePatientInList_whenMeet_thenPatientIsRemoved()
    {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.COLD);

        clinic.addPatient(patient);
        clinic.doctorMeetPatient();

        assertTrue(clinic.doctorsQIsEmpty());
    }

    @Test
    public void givenTwoPatientsInList_whenMeet_thenPatientRemovedInSameOrder()
    {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.COLD);
        Patient patient2 = new Patient("Jean-Marie", 4, VisibleSymptom.COLD);
        clinic.addPatient(patient);
        clinic.addPatient(patient2);

        Patient meetedPatient = clinic.doctorMeetPatient();
        Patient meetedPatient2 = clinic.doctorMeetPatient();

        assertEquals(patient, meetedPatient);
        assertEquals(patient2, meetedPatient2);
        assertTrue(clinic.doctorsQIsEmpty());
    }

    @Test
    public void givenRadiologyQueueNotEmpty_whenradiologyMeetPatient_thenFisrtPatientFromRadiologyQueueRemoved()
    {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.BROKEN_BONE);
        Patient patient2 = new Patient("Jean-Marie", 4, VisibleSymptom.BROKEN_BONE);
        clinic.addPatient(patient);
        clinic.addPatient(patient2);

        Patient meetedPatient = clinic.radiologyMeetPatient();
        Patient meetedPatient2 = clinic.radiologyMeetPatient();

        assertEquals(patient, meetedPatient);
        assertEquals(patient2, meetedPatient2);
        assertTrue(clinic.radiologyQIsEmpty());
    }


    @Test
    public void givenPatientHasBrokenBone_whenAddingPatient_thenAddToBothDoctorAndRadiologyQ()
    {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.BROKEN_BONE);
        clinic.addPatient(patient);

        assertFalse(clinic.doctorsQIsEmpty());
        assertFalse(clinic.radiologyQIsEmpty());
    }

    @Test
    public void givenPatientHasHighGravityAndAlgoIsGravity_whenAddingPatient_thenPatientFirstInQueue()
    {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.BROKEN_BONE);
        Patient patient2 = new Patient("BOB", 7, VisibleSymptom.COLD);
        clinic.addPatient(patient);
        clinic.addPatient(patient2);

        Patient meetedPatient = clinic.doctorMeetPatient();
        Patient meetedPatient2 = clinic.doctorMeetPatient();

        assertEquals(patient2, meetedPatient);
        assertEquals(patient, meetedPatient2);
        assertTrue(clinic.doctorsQIsEmpty());
    }

    @Test
    public void givenTwoPatientsInDoctorAndRadiologyQueue_whenNewPatientHasBrokenBoneSeverity7_thenPatientIsFirstInQueue()
    {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);
        Patient patient = new Patient("Jean-Guy", 4, VisibleSymptom.BROKEN_BONE);
        Patient patient2 = new Patient("BOB", 7, VisibleSymptom.BROKEN_BONE);
        clinic.addPatient(patient);
        clinic.addPatient(patient2);

        Patient meetedPatientDoctor = clinic.doctorMeetPatient();
        Patient meetedpatientRadiology = clinic.radiologyMeetPatient();

        assertEquals(patient2, meetedPatientDoctor);
        assertEquals(patient2, meetedpatientRadiology);
    }
}

