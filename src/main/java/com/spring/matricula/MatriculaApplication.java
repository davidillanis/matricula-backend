package com.spring.matricula;

import com.spring.matricula.service.implementation.AddDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatriculaApplication implements CommandLineRunner {
    //@Autowired
    //private AddDataServiceImpl addDataService;

    public static void main(String[] args){
        SpringApplication.run(MatriculaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //addDataService.addData();
    }
}
