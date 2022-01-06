package com.tomo.tvdependencyinjection.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController
{
    public String sayWorld()
    {
        System.out.println("Hello Word!");
        return "Hy developers!";
    }
}
