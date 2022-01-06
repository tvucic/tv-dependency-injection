package com.tomo.tvdependencyinjection.controllers;

import com.tomo.tvdependencyinjection.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest
{
    SetterInjectedController controller;

    @BeforeEach
    void setUp()
    {
        // We are kind of acting as the inversion control in the setUp() method
        controller = new SetterInjectedController();
        controller.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    void getGreeting()
    {
        System.out.println(controller.getGreeting());
    }
}