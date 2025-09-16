/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.*;
/**
 *
 * @author Rober
 */
public class conexaoBanco {
    private static final String URL = "jdbc:mysql://localhost:3306/banco_digital";
    private static final String USER = "root";
    private static final String PASS = "aluno";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
