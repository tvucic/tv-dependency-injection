package com.tomo.tvdependencyinjection.services;


//@Profile({"ES", "default"})
//@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService
{
    @Override
    public String getGreeting()
    {
        return "Hola Mundo - ES";
    }
}
