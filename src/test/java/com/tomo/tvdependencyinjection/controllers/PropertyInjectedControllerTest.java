package com.tomo.tvdependencyinjection.controllers;

import com.tomo.tvdependencyinjection.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest
{

    PropertyInjectedController controller;

    @BeforeEach
    void setUp()
    {
        // We are kind of acting as the inversion control in the setUp() method
        controller = new PropertyInjectedController();
        controller.greetingService = new ConstructorInjectedGreetingService();
    }

    @Test
    public void testGetGreeting()
    {
        System.out.println(controller.getGreeting());
    }

}