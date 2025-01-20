package com.services.product.pricerates;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.product.pricerates.domain.dto.ProductDto;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceRatesProductControllerTest {
    
    @Autowired
	private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private final String BRAND = "1";
    private final String PRODUCTID = "35455";

    private final String RESULTPRICE1 = "35.50";
    private final String RESULTFEE1 = "1";

    private final String RESULTPRICE2 = "25.45";
    private final String RESULTFEE2 = "2";

    private final String RESULTPRICE3 = "35.50";
    private final String RESULTFEE3 = "1";

    private final String RESULTPRICE4 = "30.50";
    private final String RESULTFEE4 = "3";

    private final String RESULTPRICE5 = "38.95";
    private final String RESULTFEE5 = "4";

    private final String ENDPOINT_PRODUCT_PRICERATE = "/product/pricerate?";

    private final String PRODUCT_NOT_FOUND = "No se ha encontrado producto que cumpla con los criterios de la consulta realizada.";


    /*
     * Test 1: peticion a las 10:00 del di­a 14 del producto 35455   para la brand 1 (ZARA)
     */
    @Test
    public void getProductTest1() throws Exception {
        String fechaApp1 = "2020-06-14 10:00:00";
        MvcResult result = this.mockMvc.perform(get(ENDPOINT_PRODUCT_PRICERATE + "applicationDate=" + fechaApp1 + "&brand=" + BRAND + "&id=" + PRODUCTID))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        ProductDto product = objectMapper.readValue(jsonResult, ProductDto.class);

        assertNotNull(product);
        assertEquals(PRODUCTID, String.valueOf(product.getId()));
        assertEquals(RESULTPRICE1, product.getPrice().toString());
        assertEquals(RESULTFEE1, String.valueOf(product.getFee()));
    }

    /*
     * Test 2: peticion a las 16:00 del di­a 14 del producto 35455   para la brand 1 (ZARA)
     */
    @Test
    public void getProductTest2() throws Exception {
        String fechaApp2 = "2020-06-14 16:00:00";
        MvcResult result = this.mockMvc.perform(get(ENDPOINT_PRODUCT_PRICERATE + "applicationDate=" + fechaApp2 + "&brand=" + BRAND + "&id=" + PRODUCTID))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        ProductDto product = objectMapper.readValue(jsonResult, ProductDto.class);

        assertNotNull(product);
        assertEquals(PRODUCTID, String.valueOf(product.getId()));
        assertEquals(RESULTPRICE2, product.getPrice().toString());
        assertEquals(RESULTFEE2, String.valueOf(product.getFee()));
    }

    /**
     * Test 3: peticion a las 21:00 del di­a 14 del producto 35455   para la brand 1 (ZARA)
     */
    @Test
    public void getProductTest3() throws Exception {
        String fechaApp3 = "2020-06-14 21:00:00";
        MvcResult result = this.mockMvc.perform(get(ENDPOINT_PRODUCT_PRICERATE + "applicationDate=" + fechaApp3 + "&brand=" + BRAND + "&id=" + PRODUCTID))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        ProductDto product = objectMapper.readValue(jsonResult, ProductDto.class);

        assertNotNull(product);
        assertEquals(PRODUCTID, String.valueOf(product.getId()));
        assertEquals(RESULTPRICE3, product.getPrice().toString());
        assertEquals(RESULTFEE3, String.valueOf(product.getFee()));
    }

    /**
     * Test 4: peticion a las 10:00 del di­a 15 del producto 35455   para la brand 1 (ZARA)
     */
    @Test
    public void getProductTest4() throws Exception {
        String fechaApp4 = "2020-06-15 10:00:00";
        MvcResult result = this.mockMvc.perform(get(ENDPOINT_PRODUCT_PRICERATE + "applicationDate=" + fechaApp4 + "&brand=" + BRAND + "&id=" + PRODUCTID))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        ProductDto product = objectMapper.readValue(jsonResult, ProductDto.class);

        assertNotNull(product);
        assertEquals(PRODUCTID, String.valueOf(product.getId()));
        assertEquals(RESULTPRICE4, product.getPrice().toString());
        assertEquals(RESULTFEE4, String.valueOf(product.getFee()));
    }

    /**
     * Test 5: peticion a las 21:00 del di­a 16 del producto 35455   para la brand 1 (ZARA)
     */
    @Test
    public void getProductTest5() throws Exception {
        String fechaApp5 = "2020-06-16 21:00:00";
        MvcResult result = this.mockMvc.perform(get(ENDPOINT_PRODUCT_PRICERATE + "applicationDate=" + fechaApp5 + "&brand=" + BRAND + "&id=" + PRODUCTID))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        ProductDto product = objectMapper.readValue(jsonResult, ProductDto.class);

        assertNotNull(product);
        assertEquals(PRODUCTID, String.valueOf(product.getId()));
        assertEquals(RESULTPRICE5, product.getPrice().toString());
        assertEquals(RESULTFEE5, String.valueOf(product.getFee()));
    }

    @Test
    public void getNoProductTest() throws Exception {
        String fechaAppNoPrd = "2020-06-13 00:00:00";
        this.mockMvc.perform(get(ENDPOINT_PRODUCT_PRICERATE + "applicationDate=" + fechaAppNoPrd + "&brand=" + BRAND + "&id=" + PRODUCTID))
                .andExpect(status().isConflict())
                .andExpect(status().reason(containsString(PRODUCT_NOT_FOUND)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getNoProductTest2() throws Exception {
        String fechaAppNoPrd = "2020-06-13 00:00:00";
        this.mockMvc.perform(get(ENDPOINT_PRODUCT_PRICERATE + "applicationDate=" + fechaAppNoPrd + "&brand=" + BRAND + "&id=9999"))
                .andExpect(status().isConflict())
                .andExpect(status().reason(containsString(PRODUCT_NOT_FOUND)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
