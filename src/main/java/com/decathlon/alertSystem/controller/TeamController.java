package com.decathlon.alertSystem.controller;

import com.decathlon.alertSystem.entity.Team;
import com.decathlon.alertSystem.exception.DeveloperNotFoundException;
import com.decathlon.alertSystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;
    @PostMapping("/team")
    public Long addTeam(@Valid @RequestBody Team team) throws DeveloperNotFoundException {
        Team addedTeam = teamService.addTeam(team);
        return addedTeam.getTeamId();
    }

    @GetMapping("/team/{teamId}")
    public Team getTeam(@PathVariable Long teamId)
    {
        return teamService.getTeam(teamId);
    }

    @GetMapping("/teams")
    public List<Team> getTeams()
    {
        return teamService.getTeams();
    }


}
