package dev.rubio.controllers;

import dev.rubio.models.Doctor;
import dev.rubio.services.DoctorService;
import io.javalin.http.Context;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DoctorsControllerTest {
    @InjectMocks
    private DoctorController doctorController;
    @Mock
    private DoctorService service;
    @BeforeEach
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandleGetMarriageCounselors(){
        Context context = mock(Context.class);
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Psychiatrist",true,"Test Psychiatrist", "Transgender" ));
        doctors.add(new Doctor("Therapy",true,"Test Therapy", "Male" ));
        doctors.add(new Doctor("Marriage Counseling",true,"First Marriage Counselor", "Female" ));
        doctors.add(new Doctor("Marriage Counseling",true,"Second Marriage Counselor", "Transgender" ));

        when(service.getMarriageCounselors()).thenReturn(doctors);
        doctorController.handleGetMarriageCounselors(context);
        verify(context).json(doctors);
    }


}
