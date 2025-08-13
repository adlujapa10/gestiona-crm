/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionacrm;

import java.sql.*;

/**
 *
 * @author Lucia
 */
public class crud {

    public void insertarDato(int id, String nombre, String apellido, String cedula, String telefono, String email, int edad, String sexo, String rol) {
        String query = "insert into persona (id_persona, nombre, apellido, cedula, telefono, email, edad, sexo, rol) values (?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = dbConnection.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setString(4, cedula);
            preparedStatement.setString(5, telefono);
            preparedStatement.setString(6, email);
            preparedStatement.setInt(7, edad);
            preparedStatement.setString(8, sexo);
            preparedStatement.setString(9, rol);

            preparedStatement.executeUpdate();
            System.out.println("Dato insertado con exito");
        } catch (SQLException exception) {
            System.out.println("Error al insertar dato");
            exception.printStackTrace();
        }

    }

    public void leerDatos() {
        String query = "select *from persona";
        try {
            Connection connection = dbConnection.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_persona");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String cedula = resultSet.getString("cedula");
                String telefono = resultSet.getString("telefono");
                String email = resultSet.getString("email");
                int edad = resultSet.getInt("edad");
                String sexo = resultSet.getString("sexo");
                String rol = resultSet.getString("rol");
                System.out.println("ID: " + id + "Nombre: " + nombre + "Apellido: " + apellido + "Cedula: " + cedula + "Telefono: " + telefono + "Email: " + email + "edad: " + edad + "Sexo: " + sexo + "Rol: " + rol);
            }

        } catch (SQLException exception) {
            System.out.println("Error al leer dato");
            exception.printStackTrace();
        }

    }

    public void actualizarDato(int id, String nombre, String apellido, String cedula, String telefono, String email, int edad, String sexo, String rol) {
        String query = "update persona set nombre=?, apellido=?, cedula=?, telefono=?, email=?, edad=?, sexo=?, rol=? where id_persona=?";
        try {
            Connection connection = dbConnection.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(9, id);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, cedula);
            preparedStatement.setString(4, telefono);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, edad);
            preparedStatement.setString(7, sexo);
            preparedStatement.setString(8, rol);

            preparedStatement.executeUpdate();
            System.out.println("Dato acutalizado con exito");

        } catch (SQLException exception) {
            System.out.println("Error al acutalizar dato");
            exception.printStackTrace();
        }
    }

    public void eliminarDato(int id) {
        String query = "delete from persona where id_persona=?";
        try {
            Connection connection = dbConnection.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            System.out.println("Dato eliminado con exito");

        } catch (SQLException exception) {
            System.out.println("Error al eliminar dato");
            exception.printStackTrace();
        }
    }

}
