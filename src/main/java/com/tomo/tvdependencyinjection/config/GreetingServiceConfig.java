package com.tomo.tvdependencyinjection.config;

import com.tomo.tvdependencyinjection.services.ConstructorInjectedGreetingService;
import com.tomo.tvdependencyinjection.services.PropertyInjectedGreetingService;
import com.tomo.tvdependencyinjection.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig
{
    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService()
    {
        return new ConstructorInjectedGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService()
    {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService()
    {
        return new SetterInjectedGreetingService();
    }
}
