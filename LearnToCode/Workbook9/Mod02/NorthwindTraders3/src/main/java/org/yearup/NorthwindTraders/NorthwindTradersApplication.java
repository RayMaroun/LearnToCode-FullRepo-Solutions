package org.yearup.NorthwindTraders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.yearup.NorthwindTraders.models.Product;
import org.yearup.NorthwindTraders.services.ProductService;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NorthwindTradersApplication.class, args);
    }

}
