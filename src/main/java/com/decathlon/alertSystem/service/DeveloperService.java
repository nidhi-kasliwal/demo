package com.decathlon.alertSystem.service;

import com.decathlon.alertSystem.entity.Developer;
import com.decathlon.alertSystem.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeveloperService {
    public Developer addDeveloper(Developer developer);
    public void removeDeveloper(Long developerId);
    public Developer updateDeveloper(Developer developer);
    public Team getTeam(Long developerId);
    public Developer getDeveloper(Long developerId);
    public List<Developer> getDevelopers();
    public Developer getDeveloperByPhoneNumber(String phoneNumber);

}
