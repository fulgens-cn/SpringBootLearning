package com.example.springbootlogging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public Map<String, Object> logTest() {

        logger.error("error log...");
        logger.warn("warn log...");
        logger.info("info log...");
        logger.debug("debug log...");
        logger.trace("trace log...");

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("returnCode", "SUCCESS");
        returnMap.put("returnMsg", "This is for log test...");
        return returnMap;

    }

}
