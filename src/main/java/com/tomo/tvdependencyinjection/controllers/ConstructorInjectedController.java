package com.tomo.tvdependencyinjection.controllers;

import com.tomo.tvdependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController
{
    private final GreetingService greetingService;

//    @Autowired  // optional
    public ConstructorInjectedController(@Qualifier("constructorInjectedGreetingService") GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }

    public String getGreeting()
    {
        return greetingService.getGreeting();
    }
}
