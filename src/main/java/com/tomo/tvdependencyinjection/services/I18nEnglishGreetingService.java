package com.tomo.tvdependencyinjection.services;

import com.tomo.tvdependencyinjection.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService
{
    @Override
    public String getGreeting()
    {
        return "Hello World -EN";
    }
}
