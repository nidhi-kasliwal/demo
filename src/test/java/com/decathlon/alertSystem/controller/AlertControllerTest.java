package com.decathlon.alertSystem.controller;

import com.decathlon.alertSystem.service.AlertService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AlertController.class)
public class AlertControllerTest {

    @Autowired
    AlertService alertService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void alertTeamTest() throws Exception {

      String mockMessage="alert sent";
        ResponseEntity<String> mockResponse = new ResponseEntity<String>("mockMessage", HttpStatus.OK);

        Mockito.when(
                alertService.alertTeam(Mockito.any(Long.class))).thenReturn(mockResponse);

        String exampleTeamJson = "{\"teamName\":\"NidhiTeam\",\"developers\":[{\"name\":\"Nidhi\",\"phoneNumbber\":\"1234567890\"}]}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/1/alert")
                .accept(MediaType.APPLICATION_JSON).content(exampleTeamJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

}
