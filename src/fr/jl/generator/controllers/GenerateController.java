/*
 * Copyright (C) Jessica LASSIE from 2020 to present
 * All rights reserved
 */
package fr.jl.generator.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Jessica LASSIE
 */
public class GenerateController {
    
    public static void generate(String tableName, List<String> columnsList) throws IOException {
        String content = "/*\n" +
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
        "public class " + tableName.substring(0,1).toUpperCase() + tableName.substring(1).toLowerCase() + " {\n" +
        "}"
        ;
        
        File file = new File("C:/Users/Jessica/Downloads/" + tableName.substring(0,1).toUpperCase() + tableName.substring(1).toLowerCase() + ".java");
        file.createNewFile();
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
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
