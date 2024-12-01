package org.example.fluffwebserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @RequestMapping("/api/data")
    public String index() {
        return "Ligma";
    }
}
