package com.booksrecords.demo.MVPBookRecords.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(Top3GlobalBooksController.class)
public class Top3GlobalBooksControllerTest {

    @MockBean
    private Top3GlobalBooksController top3GlobalBooksController;

    private final MockMvc mockMvc;

    @Autowired
    public Top3GlobalBooksControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void GetTop3GlobalBooksWhenAPICalled() throws Exception {
        mockMvc.perform(get("/getTop3ReadBooks?country_code=SG").contentType(MediaType.APPLICATION_JSON));
        verify(top3GlobalBooksController).getTop3Books("SG");
    }
}
