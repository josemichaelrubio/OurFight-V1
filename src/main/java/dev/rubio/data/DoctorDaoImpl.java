package dev.rubio.data;

import dev.rubio.models.Doctor;
import dev.rubio.util.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    private Logger logger = LoggerFactory.getLogger(DoctorDaoImpl.class);

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from doctor");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                String gender = resultSet.getString("gender");
                boolean available = resultSet.getBoolean("available");
                boolean volunteer = resultSet.getBoolean("volunteer");
                Doctor doctor = new Doctor( id, name, specialty , gender, available, volunteer);
                doctors.add(doctor);
            }
            logger.info("selecting all Doctors from database -" + doctors.size() + "doctors retrieved");
        } catch (SQLException e) {
            logger.error(e.getClass() + " " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public List<Doctor> getDoctorsBySpecialty(){
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select specialty, available, name, gender from doctor where specialty = 'Therapy'");

            while (resultSet.next()) {
                String specialty = resultSet.getString("specialty");
                boolean available = resultSet.getBoolean("available");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Doctor doctor = new Doctor(specialty, available, name, gender);
                doctors.add(doctor);
            }
            logger.info(doctors.size() + " retrieved from database");
        } catch (SQLException e) {
            logger.error(e.getClass() + " " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public List<Doctor> getPsychiatrists(){
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select specialty, available, name, gender from doctor where specialty = 'Psychiatry'");

            while (resultSet.next()) {
                String specialty = resultSet.getString("specialty");
                boolean available = resultSet.getBoolean("available");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Doctor doctor = new Doctor(specialty, available, name, gender);
                doctors.add(doctor);
            }
            logger.info(doctors.size() + " retrieved from database");
        } catch (SQLException e) {
            logger.error(e.getClass() + " " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public List<Doctor> getChildPsychologists(){
        List<Doctor> doctors = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select specialty, available, name, gender from doctor where specialty = 'Child Psychology'");

            while (resultSet.next()) {
                String specialty = resultSet.getString("specialty");
                boolean available = resultSet.getBoolean("available");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Doctor doctor = new Doctor(specialty, available, name, gender);
                doctors.add(doctor);
            }
            logger.info(doctors.size() + " retrieved from database");
        } catch (SQLException e) {
            logger.error(e.getClass() + " " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public List<Doctor> getMarriageCounselors() {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select specialty, available, name, gender from doctor where specialty = 'Marriage Counseling'");
            while (resultSet.next()) {
                String specialty = resultSet.getString("specialty");
                boolean available = resultSet.getBoolean("available");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Doctor doctor = new Doctor(specialty, available, name, gender);
                doctors.add(doctor);
            }
            logger.info(doctors.size() + " retrieved from database");
        } catch (SQLException e) {
            logger.error(e.getClass() + " " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public Doctor addNewDoctor(Doctor doctor){
        try(Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into doctor( name, specialty, gender, available, volunteer) values (?,?,?,?,?)")){
//            preparedStatement.setInt(1,doctor.getId());
            preparedStatement.setString(1,doctor.getName());
            preparedStatement.setString(2,doctor.getSpecialty());
            preparedStatement.setString(3, doctor.getGender());
            preparedStatement.setBoolean(4, doctor.isAvailable());
            preparedStatement.setBoolean(5,doctor.isVolunteer());
            preparedStatement.executeUpdate();
            logger.info("successfully added new Doctor to the db");
        } catch (SQLException e){
            logException(e);
        }
        return doctor;
    }

    @Override
    public void deleteDoctor(int id){
        try(Connection connection = ConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from doctor where id = ?")){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            logger.info("deleted item with id: {}", id);
        } catch (SQLException e){
            logException(e);
        }
    }
    /* Attempt to delete doctor by ID and Name

//    @Override
//    public void deleteOldDoctor(int id, String name){
//        try(Connection connection = ConnectionUtil.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("delete from doctor where id=? and name=?")){
//            preparedStatement.setInt(1,id);
//            preparedStatement.setString(2, name);
//            preparedStatement.executeUpdate();
//            logger.info(name +" with the" + id +"is deleted from the db");
//        } catch( SQLException e){
//            logException(e);
//        }catch (IllegalArgumentException a){
//            logger.info("Wrong id");
//        }
//    }

     */

    private void logException(SQLException e) {
        logger.error("{} - {}" , e.getClass(), e.getMessage());
    }

    }



