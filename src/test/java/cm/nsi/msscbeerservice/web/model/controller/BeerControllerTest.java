package cm.nsi.msscbeerservice.web.model.controller;

import cm.nsi.msscbeerservice.bootstrap.BeerLoader;
import cm.nsi.msscbeerservice.services.BeerService;
import cm.nsi.msscbeerservice.web.model.BeerDto;
import cm.nsi.msscbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ravnely
 * @project mssc-beer-service
 * @Created 12/02/2022, 01:36:39, sam.
 **/
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getById(any())).willReturn(getValidBeer());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeer();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(getValidBeer());

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        given(beerService.updateBeer(any(), any())).willReturn(getValidBeer());

        BeerDto beerDto = getValidBeer();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson)).andExpect(status().isNoContent());
    }

    BeerDto getValidBeer() {
        return BeerDto.builder()
                .beerName("Kadji beer")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(BeerLoader.BEER_2_UPC)
                .price(new BigDecimal("12.95"))
                .build();
    }
}