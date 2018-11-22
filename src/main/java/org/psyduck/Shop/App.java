package org.psyduck.Shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages={"org.psyduck.Shop.controller"})
public class App
{
    public static void main( final String[] args )
    {
        SpringApplication.run(App.class);
    }
}
