package net.sorokin.dao.cardao;


import net.sorokin.entity.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarDaoImplTest {


    private CarDao carDao;
    private Car car;

    @Before
    public void setUp() throws ParseException {
        carDao = new CarDaoImpl();
        car = new Car();
        car.setManufacturer("Ferrari");
        car.setModel("Laferrari");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-25");
        car.setDate(date);
        car.setPrice(new BigDecimal(20000000));
    }

    @Test
    public void getAllCarNormalTest() throws SQLException {
        List<Car> cars = carDao.getAllCar();
        Assert.assertNotNull(cars);
        Assert.assertEquals(cars.get(0).getClass(), Car.class);
    }

    @Test
    public void addCarToDbNormalTest() throws SQLException {
        carDao.addCarToDb(car);
        List<Car> cars = carDao.getAllCar();
        Assert.assertNotNull(car);
        Assert.assertEquals(car.getId(), cars.get(cars.size()-1).getId());
        Assert.assertEquals(car.getManufacturer(), cars.get(cars.size()-1).getManufacturer());
    }

    @Test(expected = SQLException.class )
    public void addCarToDbNullTest() throws SQLException {
        carDao.addCarToDb(null);
    }

    @Test
    public void getCarByIdNormalTest() throws SQLException {
        List<Car> cars = carDao.getAllCar();
        Car carById = carDao.getCarById(cars.get(cars.size()-1).getId());
        Assert.assertNotNull(carById);
        Assert.assertEquals(car.getManufacturer(), carById.getManufacturer());
    }

    @Test()
    public void getCarByIdEmptyTest() throws SQLException {
        Car carById = carDao.getCarById(122);
        Assert.assertNull(carById);
    }

    @Test
    public void updateCarNormalTest() throws SQLException {
        List<Car> cars = carDao.getAllCar();
        Car carById = carDao.getCarById(cars.get(cars.size()-1).getId());
        carById.setManufacturer("Dodge");
        carDao.updateCar(carById);
        Car updateCar = carDao.getCarById(cars.get(cars.size()-1).getId());
        Assert.assertEquals(carById.getManufacturer(), updateCar.getManufacturer());
    }

    @Test(expected = SQLException.class)
    public void updateCarNullTest() throws SQLException {
        carDao.updateCar(null);
    }

    @Test(expected = SQLException.class)
    public void deleteCarNullTest() throws SQLException {
        carDao.deleteCar(null);
    }

    @Test
    public void deleteCarEmptyListTest() throws SQLException {
        List<Car> carList = new ArrayList<>();
        List<Car> cars = carDao.getAllCar();
        Car carById = carDao.getCarById(cars.get(cars.size()-1).getId());
        carDao.deleteCar(carList);
        List<Car> allCar = carDao.getAllCar();
        Assert.assertEquals(carById.getId(), allCar.get(allCar.size()-1).getId());
    }

    @Test
    public void deleteCarNormalTest() throws SQLException {
        List<Car> carList = new ArrayList<>();
        List<Car> cars = carDao.getAllCar();
        Car carById = carDao.getCarById(cars.get(cars.size()-1).getId());
        carList.add(carById);
        carDao.deleteCar(carList);
        List<Car> allCar = carDao.getAllCar();
        Assert.assertNotEquals(carById.getId(), allCar.get(allCar.size()-1).getId());
    }

}
