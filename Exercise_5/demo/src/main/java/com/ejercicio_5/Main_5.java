package com.ejercicio_5;

import java.io.*;
import java.util.*;

public class Main_5{
        public static void main(String[] args) {
            File file = new File("C:\\Users\\Aprendiz\\Desktop\\2902082\\Exercise_5\\demo\\src\\main\\java\\com\\ejercicio_5\\XD.txt");

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
    
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
    
                String text = content.toString();
                System.out.println("Contenido del archivo:");
                System.out.println(text);
    
                
                String[] words = text.split("\\s+");
                int totalWords = words.length;
                int totalSentences = text.split("[.!?]").length;
    
                Map<String, Integer> wordFrequency = new HashMap<>();
                int totalWordLength = 0;
    
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); 
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                        totalWordLength += word.length();
                    }
                }
    
                
                System.out.println("\nEstadísticas:");
                System.out.println("Número total de palabras: " + totalWords);
                System.out.println("Número total de oraciones: " + totalSentences);
    
                String mostFrequentWord = Collections.max(wordFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();
                int maxFrequency = wordFrequency.get(mostFrequentWord);
                System.out.println("Palabra más frecuente: " + mostFrequentWord + " (aparece " + maxFrequency + " veces)");
    
                double averageWordLength = (double) totalWordLength / totalWords;
                System.out.printf("Longitud promedio de las palabras: %.2f%n", averageWordLength);
    
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error: Archivo no encontrado.");
            } catch (IOException e) {
                System.out.println("Error al leer el archivo.");
            }
        }
}
    
