package com.decathlon.alertSystem.controller;

import com.decathlon.alertSystem.entity.Developer;
import com.decathlon.alertSystem.entity.Team;
import com.decathlon.alertSystem.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TeamController.class)
public class TeamControllerTest {

    @Autowired
    TeamService teamService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addTeamTest() throws Exception {

        List<Developer> list=new ArrayList<>();
        list.add(new Developer(2L,"Nidhi","1234567890",null));
        list.add(new Developer(3L,"Shuchi","1234567891",null));
        Team mockTeam = new Team(1L, "NidhiTeam", list);

        Mockito.when(
                teamService.addTeam(Mockito.any(Team.class))).thenReturn(mockTeam);

        String exampleTeamJson = "{\"teamName\":\"NidhiTeam\",\"developers\":[{\"name\":\"Nidhi\",\"phoneNumbber\":\"1234567890\"}]}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/team")
                .accept(MediaType.APPLICATION_JSON).content(exampleTeamJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }




}
