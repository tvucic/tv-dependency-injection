package com.tomo.tvdependencyinjection.controllers;

import com.tomo.tvdependencyinjection.services.GreetingService;

public class SetterInjectedController
{
    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }
    public String getGreeting()
    {
        return greetingService.getGreeting();
    }
}
