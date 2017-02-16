package net.sorokin.dao.cardao;


import net.sorokin.entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {

    /**add new car to database*/
    void addCarToDb(Car car) throws SQLException;
    /**update car in database*/
    void updateCar(Car car) throws SQLException;
    /**take car by id from database*/
    Car getCarById(int id) throws SQLException;
    /**return all car from database*/
    List<Car> getAllCar() throws SQLException;
    /**delete car in database*/
    void deleteCar(List<Car> carList) throws SQLException;
}
