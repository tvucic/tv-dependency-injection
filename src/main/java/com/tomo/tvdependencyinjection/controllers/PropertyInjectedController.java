package com.tomo.tvdependencyinjection.controllers;

import com.tomo.tvdependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController
{
    @Qualifier("propertyInjectedGreetingService")
    @Autowired
    public GreetingService greetingService; // Field is public!! Property Injection.

    public String getGreeting()
    {
        return greetingService.getGreeting();
    }
}
