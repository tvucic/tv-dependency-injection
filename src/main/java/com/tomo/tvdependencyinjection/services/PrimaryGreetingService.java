package com.tomo.tvdependencyinjection.services;


//@Primary // Qualifier will take precedence over Primary
//@Service
public class PrimaryGreetingService implements GreetingService
{
    @Override
    public String getGreeting()
    {
        return "Hello World - PRIMARY Bean";
    }
}
