package net.sorokin.dao.cardao;


import net.sorokin.dao.util.HibernateUtil;
import net.sorokin.entity.Car;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao{

    @Override
    public void addCarToDb(Car car) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Error in method addDataEntity" + e);
        }
    }

    @Override
    public void updateCar(Car car) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Error in method updateDataEntity" + e);
        }
    }

    @Override
    public Car getCarById(int id) throws SQLException {
        Car car = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            car = (Car) session.get(Car.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Error in method getDataEntityById" + e);
        }
        return car;
    }

    @Override
    public List<Car> getAllCar() throws SQLException {
        List<Car> carList = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaQuery<Car> cq = session.getCriteriaBuilder().createQuery(Car.class);
            cq.from(Car.class);
            carList = session.createQuery(cq).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Error in method getAllDataEntity" + e);
        }
        return carList;
    }

    @Override
    public void deleteCar(List<Car> carList) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            for(Car car : carList) {
                session.delete(car);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("Error in method deleteDataEntity" + e);
        }
    }
}
