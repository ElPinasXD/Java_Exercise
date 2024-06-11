package com.ejercicio_4;

import java.util.*; // Random, List, Arrays.asList,  Set,  HashSet, Arrays.fill, Scanner "sena", "programacion", "diarrea", "gonorrea", "cancer"

public class Main_4{

        private static final int MAX_INTENTOS = 5;
        private static final List<String> PALABRAS = Arrays.asList("sena", "programacion", "diarrea", "gonorrea", "cancer");
    
        private String palabrasSecreta;
        private char [] palabraAdivinar;
        private int intentosRestantes;
        private Set <Character> letrasAdivinadas;
    
        public Main_4 () {
            Random random = new Random();
            this.palabrasSecreta = PALABRAS.get(random.nextInt(PALABRAS.size()));
            this.palabraAdivinar = new char[palabrasSecreta.length()];
            Arrays.fill(this.palabraAdivinar, '_');
            this.intentosRestantes = MAX_INTENTOS;
            this.letrasAdivinadas = new HashSet<>();
        }
    
        public void Juego () {
            Scanner scanner = new Scanner(System.in);
    
            while (intentosRestantes > 0 && !palabraAdivinar_2()) {
                System.out.println("Palabra: " + new String(palabraAdivinar));
                System.out.println("Intentos restantes: " + intentosRestantes);
                System.out.println("Letras adivinadas: " + letrasAdivinadas);
                System.out.print("Ingrese una letra: ");
                String input = scanner.nextLine().toLowerCase();
    
                if (input.length() != 1) {
                    System.out.println("Ingrese una sola letra");
                    continue;
                }
    
                char adivinar = input.charAt(0);
    
                if (letrasAdivinadas.contains(adivinar)) {
                    System.out.println("Ya pusiste esa letra");
                    continue;
                }
    
                letrasAdivinadas.add(adivinar);
    
                if (palabrasSecreta.indexOf(adivinar) >= 0) {
                    for (int i = 0; i < palabrasSecreta.length(); i++) {
                        if (palabrasSecreta.charAt(i) == adivinar) {
                            palabraAdivinar[i] = adivinar;
                        }
                    }
                } else {
                    intentosRestantes--;
                    System.out.println("Esa letra no está en la palabra");
                }
            }
    
            if (palabraAdivinar_2()) {
                System.out.println("Bravo. Has adivinado la palabra");
            } else {
                System.out.println("Perdio" +  "\n" +  "La palabra era: " + palabrasSecreta);
            }
    
            scanner.close();
        }
    
        private boolean palabraAdivinar_2() {
            for (char c : palabraAdivinar) {
                if (c == '_') {
                    return false;
                }
            }
            return true;
        }
    
        public static void main(String[] args) {
            Main_4 game = new Main_4();
            game.Juego();
        }
}
