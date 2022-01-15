package com.tomo.tvdependencyinjection.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean
{
    public SingletonBean()
    {
        System.out.println("Creating Singleton Bean---");
    }

    public String getMyScope()
    {
        return "I'm Singleton Scope!";
    }
}
