package ru.adkazankov.hourse.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HourseControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private HourseController hourseController;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(hourseController)
                .build();
    }

    @Test
    public void testHourseController() throws Exception {
        mockMvc.perform(
                get("/rest/count")
                .param("width", "8")
                .param("height", "7")
                .param("start", "B4")
                .param("end", "G8")
        )
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }

}