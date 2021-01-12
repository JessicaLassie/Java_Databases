/*
 * Copyright (C) Jessica LASSIE from 2020 to present
 * All rights reserved
 */
package fr.jl.generator.controllers;

import fr.jl.generator.utils.Utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jessica LASSIE
 */
public class FileController {
    
    public static void createFile(String contentFile, String tableName) throws IOException {
        
        String className = Utils.createClassName(tableName);
               
        File file = new File("C:/Users/Jessica/Downloads/" + className + ".java");
        file.createNewFile();
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contentFile);
        bw.close();
   
        /*
        if (fichier.createNewFile()) {
          System.out.println("Le fichier a été créé");
        } else {
          System.out.println("Erreur, Impossible de créer ce fichier");
        }       
        */
        
    }
}
