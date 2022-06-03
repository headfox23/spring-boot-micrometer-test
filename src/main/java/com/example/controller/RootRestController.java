package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(RootRestController.URL)
public class RootRestController {

    private static final String NAME = "api";
    public static final String URL = "/" + NAME;

    /**
     * Returns relevant infos of this instance of the app
     */
    @GetMapping(value = "test", produces = "application/json")
    public String getTest() {
        return "WORKS MAN";
    }
}
