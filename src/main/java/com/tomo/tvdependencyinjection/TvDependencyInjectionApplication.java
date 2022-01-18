package com.tomo.tvdependencyinjection;

import com.tomo.tvdependencyinjection.config.ProdConstructorConfig;
import com.tomo.tvdependencyinjection.controllers.*;
import com.tomo.tvdependencyinjection.datasource.FakeDataSource;
import com.tomo.tvdependencyinjection.config.ProdConfiguration;
import com.tomo.tvdependencyinjection.services.PrototypeBean;
import com.tomo.tvdependencyinjection.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"com.tomo.tvdependencyinjection", "net.tomo.tvdependencyinjection."})
@SpringBootApplication
public class TvDependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TvDependencyInjectionApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("--------------PRIMARY Bean");
		System.out.println(myController.sayHello());

		System.out.println("--------------Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------------Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController)ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------------Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("-------------- SCOPES ----------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());

		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("-------------- From Value annotation ----------");

		FakeDataSource fakeDataSourceValue = ctx.getBean("fakeDataSourceValue", FakeDataSource.class);
		System.out.println(fakeDataSourceValue.getUsername());
		System.out.println(fakeDataSourceValue.getPassword());
		System.out.println(fakeDataSourceValue.getJdbcurl());

		System.out.println("-------------- Properties Binding Prod ----------");

		FakeDataSource fakeDataSourceProd = ctx.getBean("fakeDataSourceProd", FakeDataSource.class);
		System.out.println(fakeDataSourceProd.getUsername());
		System.out.println(fakeDataSourceProd.getPassword());
		System.out.println(fakeDataSourceProd.getJdbcurl());

		System.out.println("-------------- From Property class  ----------");

		ProdConfiguration prodConfiguration =  ctx.getBean(ProdConfiguration.class);
		System.out.println(prodConfiguration.getUsername());
		System.out.println(prodConfiguration.getPassword());
		System.out.println(prodConfiguration.getJdbcurl());

		System.out.println("-------------- Constructor Binding  ----------");

		ProdConstructorConfig prodConstructorConfig =  ctx.getBean(ProdConstructorConfig.class);
		System.out.println(prodConstructorConfig.getUsername());
		System.out.println(prodConstructorConfig.getPassword());
		System.out.println(prodConstructorConfig.getJdbcurl());

		System.out.println("-------------- FakeDataSource arg constructor Binding  ----------");

		FakeDataSource fakeDataSourceConstBinding =  ctx.getBean("fakeDataSourceConstBinding" ,FakeDataSource.class);

		System.out.println(fakeDataSourceConstBinding.getUsername());
		System.out.println(fakeDataSourceConstBinding.getPassword());
		System.out.println(fakeDataSourceConstBinding.getJdbcurl());
	}

}
