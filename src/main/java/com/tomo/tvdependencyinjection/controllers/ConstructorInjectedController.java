package com.tomo.tvdependencyinjection.controllers;

import com.tomo.tvdependencyinjection.services.GreetingService;

public class ConstructorInjectedController
{
    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }

    public String getGreeting()
    {
        return greetingService.getGreeting();
    }
}
