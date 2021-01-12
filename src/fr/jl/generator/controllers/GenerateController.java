/*
 * Copyright (C) Jessica LASSIE from 2020 to present
 * All rights reserved
 */
package fr.jl.generator.controllers;

import fr.jl.generator.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jessica LASSIE
 */
public class GenerateController {
    
    public static String generateClass(String tableName, Connection cnx) throws IOException {
        
        String className = Utils.createClassName(tableName);
        
        Map<String, String> typesMap = new HashMap<>();
        typesMap.put("ARRAY", "Array");
        typesMap.put("BIGINT", "long");
        typesMap.put("BINARY", "byte[]");
        typesMap.put("BIT", "boolean");
        typesMap.put("BLOB", "Blob");
        typesMap.put("CHAR", "String");
        typesMap.put("CLOB", "Clob");
        typesMap.put("DATE", "Date");
        typesMap.put("DECIMAL", "BigDecimal");
        typesMap.put("DINSTINCT", "typeDeBase");
        typesMap.put("DOUBLE", "double");
        typesMap.put("FLOAT", "double");
        typesMap.put("INTEGER", "int");
        typesMap.put("INT", "int");
        typesMap.put("JAVA_OBJECT", "type");
        typesMap.put("LONGVARBINARY", "byte[]");
        typesMap.put("LONGVARCHAR", "String");
        typesMap.put("NUMERIC", "BigDecimal");
        typesMap.put("OTHER", "Object");
        typesMap.put("REAL", "float");
        typesMap.put("REF", "Ref");
        typesMap.put("SMALLINT", "short");
        typesMap.put("STRUCT", "type");
        typesMap.put("TIME", "Time");
        typesMap.put("TIMESTAMP", "Timestamp");
        typesMap.put("TINYINT", "byte");
        typesMap.put("VARBINARY", "byte[]");
        typesMap.put("VARCHAR", "String");
      
        Map<String, String> attributesMap = new HashMap<>();
        try {
            Statement stmt = cnx.createStatement();
            ResultSet res = stmt.executeQuery("Select * from " + tableName);
            ResultSetMetaData rsMetaData = res.getMetaData();  
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                String columnName = rsMetaData.getColumnName(i);
                for (Map.Entry mapentry : typesMap.entrySet()) {
                    if (mapentry.getKey().toString().equals(rsMetaData.getColumnTypeName(i))) {
                        attributesMap.put(columnName, mapentry.getValue().toString());
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        String properties = "";
        String getters = "";
        
        for (Map.Entry mapentry : attributesMap.entrySet()) {   
            String attribute;
            int posAttribute = mapentry.getKey().toString().indexOf('_');        
            if (posAttribute == -1) {
                attribute = mapentry.getKey().toString();
            } else {
                attribute = mapentry.getKey().toString().substring(0,posAttribute).toLowerCase() + mapentry.getKey().toString().substring(posAttribute+1,posAttribute+2).toUpperCase() + mapentry.getKey().toString().substring(posAttribute+2).toLowerCase();
            }
            String getterAttribute = attribute.substring(0,1).toUpperCase() + attribute.substring(1);
            properties += "private " + mapentry.getValue().toString() + " " + attribute + ";\n";
            getters += "public " + mapentry.getValue().toString() + " get" + getterAttribute + "() {\n" + "\t" + "return " + attribute + ";\n}\n\n";
        }
      
        String generatedClass = "/*\n" +
        " * Copyright (C) Jessica LASSIE from 2020 to present\n" +
        " * All rights reserved\n" +
        " */\n" +
        "\n" +
        "package fr.jl\n" +
        "\n" +
        "/**\n" +
        " *\n" +
        " * @author Jessica LASSIE\n" +
        " */\n" +
        "\n" +
        "public class " + className + " {\n" +
        "\n" +
        properties +
        "\n" +
        "public " + className + "() {\n" +
        "}\n" +
        "\n" +
        getters +
        "}"
        ;
        
        return generatedClass;
    }  
}
