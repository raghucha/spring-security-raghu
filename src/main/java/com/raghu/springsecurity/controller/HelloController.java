package com.raghu.springsecurity.controller;

/*
@author raghu created on 10/9/2020 
inside the package -com.raghu.springsecurity.log
*/


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(Principal principal){
    return "<h1>hello raghu</h1>"+ principal.getName();
    }
}
