package com.booksrecords.demo.MVPBookRecords.Controller;

import com.booksrecords.demo.MVPBookRecords.DTO.RandomCountry.Country;
import com.booksrecords.demo.MVPBookRecords.DTO.RandomCountry.RandomCountryDTO;
import com.booksrecords.demo.MVPBookRecords.Service.GetRandomCountryService;
import com.booksrecords.demo.MVPBookRecords.Util.CountryData;
import com.booksrecords.demo.MVPBookRecords.Util.CountryDataUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetRandomCountryController.class)
public class GetRandomCountryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetRandomCountryService getRandomCountryService;


    @Test
    public void GetRandomCountryWhenAPICalled() throws Exception {
        try {
            RandomCountryDTO randomCountryDTO = new RandomCountryDTO();
            Country country = new Country();
            country.setFull_name("Singapore");
            country.setCountry_code("702");
            randomCountryDTO.setCountry(country);


            given(getRandomCountryService.getRandomCountry()).willReturn(randomCountryDTO);

            mockMvc.perform(get("/getRandomCountry")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.country.full_name", is(randomCountryDTO.getCountry().getFull_name())))
                    .andExpect(jsonPath("$.country.country_code", is(randomCountryDTO.getCountry().getCountry_code())));
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
