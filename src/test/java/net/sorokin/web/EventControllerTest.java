package net.sorokin.web;


import net.sorokin.dao.cardao.CarDao;
import net.sorokin.entity.Car;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EventControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HttpSession httpSession;
    @Mock
    private CarDao carDao;

    @InjectMocks
    private EventController eventController;

    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }

    @Test
    public void actionHandlerNormalRefreshRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=refresh&carId=1")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=refresh&carId=1")).andExpect(forwardedUrl("dataGrid"));
    }

    @Test
    public void actionHandlerBadRefreshRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=refre&carId=1")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=refre&carId=1")).andExpect(forwardedUrl("error"));
    }

    @Test
    public void actionHandlerNormalDeleteRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=delete&carId=1")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=delete&carId=1")).andExpect(forwardedUrl("dataGrid"));
    }

    @Test
    public void actionHandlerBadActionDeleteRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=del&carId=1")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=del&carId=1")).andExpect(forwardedUrl("error"));
    }

    @Test
    public void actionHandlerBadCarIdDeleteRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=delete")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=delete")).andExpect(forwardedUrl("dataGrid"));
    }

    @Test
    public void actionHandlerNullCarIdEditRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=edit")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=edit")).andExpect(forwardedUrl("edit"));
    }

    @Test
    public void actionHandlerOneCarIdEditRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=edit&carId=1")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=edit&carId=1")).andExpect(forwardedUrl("edit"));
    }

    @Test
    public void actionHandlerMoreOneCarIdEditRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=edit&carId=1&carId=2")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=edit&carId=1&carId=2")).andExpect(forwardedUrl("dataGrid"));
    }

    @Test()
    public void actionHandlerBadEditRequestTest() throws Exception {
        mockMvc.perform(get("/event?action=edi&carId=1")).andExpect(status().isOk());
        mockMvc.perform(get("/event?action=edi&carId=1")).andExpect(forwardedUrl("error"));
    }
}
