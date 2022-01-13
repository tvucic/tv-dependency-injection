package com.tomo.tvdependencyinjection.services;

import com.tomo.tvdependencyinjection.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES", "default"})
@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService
{
    @Override
    public String getGreeting()
    {
        return "Hola Mundo - ES";
    }
}
