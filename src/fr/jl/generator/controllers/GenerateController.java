/*
 * Copyright (C) Jessica LASSIE from 2020 to present
 * All rights reserved
 */
package fr.jl.generator.controllers;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Jessica LASSIE
 */
public class GenerateController {
    
    public static void generate(String tableName) throws IOException {
        File fichier = new File("C:/Users/Jessica/Downloads/" + tableName + ".java");
        if (fichier.createNewFile()) {
          System.out.println("Le fichier a été créé");
        } else {
          System.out.println("Erreur, Impossible de créer ce fichier");
        }
    }
    
}
