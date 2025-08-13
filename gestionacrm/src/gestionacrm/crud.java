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
            Connection con = dbConnection.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, cedula);
            ps.setString(5, telefono);
            ps.setString(6, email);
            ps.setInt(7, edad);
            ps.setString(8, sexo);
            ps.setString(9, rol);

            ps.executeUpdate();
            System.out.println("Dato insertado con exito");
        } catch (SQLException ex) {
            System.out.println("Error al insertar dato");
            ex.printStackTrace();
        }

    }

    public void leerDatos() {
        String query = "select *from persona";
        try {
            Connection con = dbConnection.conectar();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String cedula = rs.getString("cedula");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                String sexo = rs.getString("sexo");
                String rol = rs.getString("rol");
                System.out.println("ID: " + id + "Nombre: " + nombre + "Apellido: " + apellido + "Cedula: " + cedula + "Telefono: " + telefono + "Email: " + email + "edad: " + edad + "Sexo: " + sexo + "Rol: " + rol);
            }

        } catch (SQLException ex) {
            System.out.println("Error al leer dato");
            ex.printStackTrace();
        }

    }

    public void actualizarDato(int id, String nombre, String apellido, String cedula, String telefono, String email, int edad, String sexo, String rol) {
        String query = "update persona set nombre=?, apellido=?, cedula=?, telefono=?, email=?, edad=?, sexo=?, rol=? where id_persona=?";
        try {
            Connection con = dbConnection.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(9, id);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, cedula);
            ps.setString(4, telefono);
            ps.setString(5, email);
            ps.setInt(6, edad);
            ps.setString(7, sexo);
            ps.setString(8, rol);

            ps.executeUpdate();
            System.out.println("Dato acutalizado con exito");

        } catch (SQLException ex) {
            System.out.println("Error al acutalizar dato");
            ex.printStackTrace();
        }
    }

    public void eliminarDato(int id) {
        String query = "delete from persona where id_persona=?";
        try {
            Connection con = dbConnection.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Dato eliminado con exito");

        } catch (SQLException ex) {
            System.out.println("Error al eliminar dato");
            ex.printStackTrace();
        }
    }

}
