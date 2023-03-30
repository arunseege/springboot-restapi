package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){

        return "hello-world";

    }
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){

        return new HelloWorldBean("hello-world-bean-msg");

    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBeanpath(@PathVariable String name){


        return new HelloWorldBean(String.format("hello world %s",name));

    }



}
