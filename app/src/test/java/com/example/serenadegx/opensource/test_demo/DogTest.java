package com.example.serenadegx.opensource.test_demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DogTest {

    @Mock
    Dog dog;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        dog.setName("Mango");
    }

    @Test
    public void testIsNotNull() {
        assertNotNull(dog);
    }

    @Test
    public void testDogReturn(){
//        when(dog.getName()).thenReturn("Mango");
        //提前打桩
        doReturn("Mango").when(dog).getName();
        System.out.println(dog.getName());
    }

    @Test
    public void testDogVerify(){
        verify(dog, atLeast(2)).getName();
        verify(dog).getBreed();
        verify(dog).getGender();
    }

}