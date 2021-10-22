package com.kbe.LC2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Songs {
    @GetMapping("/LC/songs/id")
    public String index() {
        return "bar";
    }
}
