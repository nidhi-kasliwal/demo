package com.decathlon.alertSystem.controller;

import com.decathlon.alertSystem.exception.DeveloperNotFoundException;
import com.decathlon.alertSystem.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class AlertController {
    @Autowired
    AlertService alertService;

    @PostMapping("/{teamId}/alert")
    public ResponseEntity<String> alertTeam(@PathVariable Long teamId) throws DeveloperNotFoundException, URISyntaxException {
        return alertService.alertTeam(teamId);
    }
}
