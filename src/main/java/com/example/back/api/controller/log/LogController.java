package com.example.back.api.controller.log;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/log")
public class LogController {

    private final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/get")
    public void getLog() {
       logger.trace("log trace");
       logger.debug("log debug");
       logger.info("log info");
       logger.warn("log warn");
       logger.error("log error");
    }
}
