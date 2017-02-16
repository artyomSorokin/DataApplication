package net.sorokin.web;

import net.sorokin.dao.cardao.CarDao;
import net.sorokin.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    private CarDao carDao;

    @Autowired
    public WelcomeController(CarDao carDao) {
        this.carDao = carDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(HttpSession session){
        String message;
        try {
            List<Car> carList = carDao.getAllCar();
            session.setAttribute("carList", carList);
        } catch (SQLException e) {
            message = "Problem with database in action refresh" + e;
            session.setAttribute("message", message);
        }
        return "dataGrid";
    }
}
