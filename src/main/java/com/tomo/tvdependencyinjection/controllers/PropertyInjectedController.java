package com.tomo.tvdependencyinjection.controllers;

import com.tomo.tvdependencyinjection.services.GreetingService;

public class PropertyInjectedController
{
    public GreetingService greetingService; // Field is public!! Property Injection.

    public String getGreeting()
    {
        return greetingService.getGreeting();
    }
}
