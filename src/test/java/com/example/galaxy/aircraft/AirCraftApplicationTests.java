package com.example.galaxy.aircraft;

import com.example.galaxy.aircraft.api.AirCraftForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AirCraftApplicationTests {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper json;

    private final static String AIRCRAFT_API_URL = "/api/aircraft";


    private static final String AIRCRAFT_NAME = "Death Star";
    private static final String AIRCRAFT_BEST = "Star of Winds";

	@Test
	void contextLoads() throws Exception {
        mock.perform(get(AIRCRAFT_API_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("hi").value("hello www"));
    }

    @Test
    void create() throws Exception {
        mock.perform(post(AIRCRAFT_API_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.writeValueAsString(new AirCraftForm(AIRCRAFT_NAME))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(AIRCRAFT_NAME))
                .andExpect(jsonPath("id").value(1))
        ;

        mock.perform(post(AIRCRAFT_API_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.writeValueAsString(new AirCraftForm(AIRCRAFT_BEST))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(AIRCRAFT_BEST))
                .andExpect(jsonPath("id").value(2))
        ;

        mock.perform(get("/api/aircraft/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(AIRCRAFT_NAME))
                .andExpect(jsonPath("id").value(1))
        ;
    }


}
