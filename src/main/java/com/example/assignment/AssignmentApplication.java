package com.example.assignment;

import com.example.assignment.Myframework.Container;
import com.example.assignment.Myframework.DependecyInjector;
import com.example.assignment.Myframework.MyDepenedecyInjector;
import com.example.assignment.Optional.TestClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) {
        DependecyInjector dependecyInjector = new MyDepenedecyInjector();
        Container container = new Container(dependecyInjector);


        UserSerivice userSerivice = new UserSerivice();
        container.injectDependecies(userSerivice);
        if(userSerivice.getUserRepository() != null) System.out.println(userSerivice.getUserRepository());


        // opitional

        TestClass testClass = new TestClass();
        container.injectDependecies(testClass);

        if(testClass.getDependecy1() != null) System.out.println(testClass.getDependecy1());
    }

}
