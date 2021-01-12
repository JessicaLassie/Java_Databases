/*
 * Copyright (C) Jessica LASSIE from 2020 to present
 * All rights reserved
 */
package fr.jl.generator.utils;

/**
 *
 * @author Jessica LASSIE
 */
public class Utils {
    
    public static String createClassName(String tableName){       
        String className;
        int pos = tableName.indexOf('_');        
        if (pos == -1) {
            className = tableName.substring(0,1).toUpperCase() + tableName.substring(1);
        } else {
            className = tableName.substring(0,1).toUpperCase() + tableName.substring(1,pos).toLowerCase() + tableName.substring(pos+1,pos+2).toUpperCase() + tableName.substring(pos+2).toLowerCase();
        }
        return className;
    }
}
