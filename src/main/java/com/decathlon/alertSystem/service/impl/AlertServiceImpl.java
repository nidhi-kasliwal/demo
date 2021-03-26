package com.decathlon.alertSystem.service.impl;

import com.decathlon.alertSystem.exception.DeveloperNotFoundException;
import com.decathlon.alertSystem.service.AlertService;
import com.decathlon.alertSystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    TeamService teamService;

    @Override
    public ResponseEntity<String> alertTeam(Long teamId) throws DeveloperNotFoundException, URISyntaxException {
        String phoneNumber = teamService.getPhoneNumberOfRandomDeveloperFromTeam(teamId);
        if(phoneNumber==null)
        {
            return null;
        }
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> map = new HashMap<>();
        map.put("phoneNumber", phoneNumber);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity,
                String.class);
        return result;
    }
}
