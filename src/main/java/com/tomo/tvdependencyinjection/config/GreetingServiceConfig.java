package com.tomo.tvdependencyinjection.config;

import com.tomo.tvdependencyinjection.datasource.FakeDataSource;
import com.tomo.tvdependencyinjection.datasource.ProdConfiguration;
import com.tomo.tvdependencyinjection.repositories.EnglishGreetingRepository;
import com.tomo.tvdependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.tomo.tvdependencyinjection.services.*;
import net.tomo.tvdependencyinjection.PetService;
import net.tomo.tvdependencyinjection.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class GreetingServiceConfig
{
    @Bean("fakeDataSourceValue")
    FakeDataSource fakeDataSource(@Value("${app.username}") String username,
                                  @Value("${app.password}") String password,
                                  @Value("${app.jdbcurl}") String jdbcurl)
    {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

    @Bean("fakeDataSourceProd")
    FakeDataSource fakeDataSourceProd(ProdConfiguration prodConfiguration){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(prodConfiguration.getUsername());
        fakeDataSource.setPassword(prodConfiguration.getPassword());
        fakeDataSource.setJdbcurl(prodConfiguration.getJdbcurl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory()
    {
        return new PetServiceFactory();
    }

    @Profile({"dog","default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory)
    {
        return petServiceFactory.getPetService("dog");
    }
    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory)
    {
        return petServiceFactory.getPetService("cat");
    }
    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService()
    {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository()
    {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository)
    {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService()
    {
        return new PrimaryGreetingService();
    }
    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService() {
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
