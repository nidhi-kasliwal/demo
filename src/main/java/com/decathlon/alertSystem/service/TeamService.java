package com.decathlon.alertSystem.service;

import com.decathlon.alertSystem.entity.Developer;
import com.decathlon.alertSystem.entity.Team;
import com.decathlon.alertSystem.exception.DeveloperNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


public interface TeamService {
    public Team addTeam(Team team) throws DeveloperNotFoundException;

    public void removeTeam(Long teamId);

    public Team updateTeam(Team team);

    public List<Developer> getDevelopers(Long teamId);

    public Team getTeam(Long TeamId);

    public List<Team> getTeams();

    public String getPhoneNumberOfRandomDeveloperFromTeam(Long teamId) throws DeveloperNotFoundException;

}
