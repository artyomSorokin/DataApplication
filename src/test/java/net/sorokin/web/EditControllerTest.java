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
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EditControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HttpSession httpSession;
    @Mock
    private CarDao carDao;

    @InjectMocks
    private EditController editController;
    private List<Car> carList;
    private Car car1;

    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(editController).build();
        carList = new ArrayList<>();
        car1 = new Car();
        car1.setManufacturer("Ferrari");
        car1.setModel("Laferrari");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-25");
        car1.setDate(date);
        car1.setPrice(new BigDecimal(20000000));
        carList.add(car1);
    }

    @Test
    public void actionHandlerNormalEditSaveRequestTest() throws Exception {
        when(carDao.getCarById(29)).thenReturn(car1);
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Laferrari&date=2016-05-23&price=20000000&action=save")).andExpect(status().isOk());
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Laferrari&date=2016-05-23&price=20000000&action=save")).andExpect(forwardedUrl("dataGrid"));
    }

    @Test
    public void actionHandlerBadEditSaveRequestTest() throws Exception {
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Laferrari&date=2016-05-23&price=20000000&action=sav")).andExpect(status().isOk());
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Laferrari&date=2016-05-23&price=20000000&action=sav")).andExpect(forwardedUrl("error"));
    }

    @Test
    public void actionHandlerBadEditSaveNotManufacturerRequestTest() throws Exception {
        mockMvc.perform(get("/edit?id=29&model=Laferrari&date=2016-05-23&price=20000000&action=save")).andExpect(status().is4xxClientError());
    }

    @Test()
    public void actionHandlerBadEditSaveNullManufacturerRequestTest() throws Exception {
        mockMvc.perform(get("/edit?id=29&manufacturer=&model=Laferrari&date=2016-05-23&price=20000000&action=save")).andExpect(status().isOk());
    }

    @Test
    public void actionHandlerNormalEditAddRequestTest() throws Exception {
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Viper&date=2016-05-25&price=200002&action=add")).andExpect(status().isOk());
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Viper&date=2016-05-25&price=200002&action=add")).andExpect(forwardedUrl("dataGrid"));
    }

    @Test
    public void actionHandlerBadEditAddRequestTest() throws Exception {
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Viper&date=2016-05-25&price=200002&action=ad")).andExpect(status().isOk());
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Viper&date=2016-05-25&price=200002&action=ad")).andExpect(forwardedUrl("error"));
    }

    @Test
    public void actionHandlerNormalEditCnacelRequestTest() throws Exception {
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Viper&date=2016-05-25&price=200002&action=cancel")).andExpect(status().isOk());
        mockMvc.perform(get("/edit?id=29&manufacturer=Dodge&model=Viper&date=2016-05-25&price=200002&action=cancel")).andExpect(forwardedUrl("dataGrid"));
    }
}
