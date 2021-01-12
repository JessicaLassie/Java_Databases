/*
 * Copyright (C) Jessica LASSIE from 2020 to present
 * All rights reserved
 */
package fr.jl.generator.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jessica LASSIE
 */
public class ConnectionController {
    
    public static Connection getConnection(String server, String port, String database, String login, char[] password) throws SQLException {
        String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
        Connection cnx = DriverManager.getConnection(url, login, new String(password));
        return cnx;
    }
    
    public static Connection disconnect(Connection cnx) throws SQLException {
        cnx.close();
        cnx = null;
        return cnx;
    }
    
}
