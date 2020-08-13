/*
 * Copyright (C) Jessica LASSIE from 2020 to present
 * All rights reserved
 */
package fr.jl.generator.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jessica LASSIE
 */
public class GeneratorController {
    
    public static Connection getConnection(String server, String port, String database, String login, char[] password) {
        Connection cnx = null;
        try {
            String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
            cnx = DriverManager.getConnection(url, login, new String(password));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cnx;
    }
    
}
