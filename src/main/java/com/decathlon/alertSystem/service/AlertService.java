package com.decathlon.alertSystem.service;

import com.decathlon.alertSystem.exception.DeveloperNotFoundException;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

public interface AlertService {

    public ResponseEntity<String> alertTeam(Long teamId) throws DeveloperNotFoundException, URISyntaxException;
}
