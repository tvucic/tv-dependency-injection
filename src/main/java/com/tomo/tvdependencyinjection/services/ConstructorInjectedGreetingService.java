package com.tomo.tvdependencyinjection.services;

import org.springframework.stereotype.Service;

//@Service
public class ConstructorInjectedGreetingService implements GreetingService
{
    @Override
    public String getGreeting()
    {
        return "Hello World! - Constructor";
    }
}
