package jblackjack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Axel Emiliano León Rico
 */
public class JBlackJack {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String r;
        boolean gameOver = false;
        System.out.println("¡Bienvenido a jBlackJack!");
        System.out.println("El mejor BlackJack para Java que ha existido en Tabasco (El estado, no la salsa).");
        
        do{
            System.out.println("¿Iniciar nueva partida? (s/n)");
            r = scanner.nextLine();
            if ("s".equals(r) || "S".equals(r) || "si".equals(r) || "SI".equals(r) || "sI".equals(r) || "Si".equals(r)) {
                //Turno del jugador
                //Crear la baraja
                Deck baraja = new Deck();
                baraja.shuffle();
                //Declaramos la respuesta y la suma de las cartas del jugador.
                String gr;
                int suma = 0, contador = 0;
                //Obtener las cartas
                do {
                    Card carta = (Card) baraja.get(contador);
                    baraja.remove(contador);
                    System.out.println("Tu carta es: " + carta.getRepresentacion());
                    suma += carta.getValor();
                    System.out.println("¿Quieres otra carta? (s/n)");
                    gr = scanner.nextLine();
                    contador++;
                } while (gr.equals("s"));
                System.out.println("La suma de tus cartas es " + suma);
                gameOver = false;
                if (suma > 21) {
                    System.out.println("¡Haz perdido!");
                    gameOver = true;
                }
                
                //Turno de la computadora
                if (!gameOver) {
                    System.out.println("Turno de la computadora.");
                    int sumaComputadora = 0;
                    do{
                        Card carta = (Card) baraja.get(contador);
                        baraja.remove(contador);
                        sumaComputadora += carta.getValor();
                        System.out.println("Computadora obtiene la carta: " + carta.getRepresentacion());
                        if (sumaComputadora < 18) {
                            gr = "s";
                        } else {
                            gr = "n";
                        }
                        contador++;
                    } while(gr.equals("s"));
                    System.out.println("Las cartas de la computadora suman " + sumaComputadora);
                    
                    if (sumaComputadora > 21) {
                        System.out.println("La computadora ha perdido. \n¡Eres el ganador! =D");
                    } else {
                        if (sumaComputadora > suma) {
                            System.out.println("La computadora te ha vencido. \n¡Haz perdido!");
                        } else if (sumaComputadora < suma){
                            System.out.println("Sumas más que la computadora. \n¡Eres el ganador! =D");
                        } else {
                            System.out.println("¡Empate!");
                        }
                    }
                }
                
                
            } else if ("n".equals(r) || "no".equals(r) || "N".equals(r) || "No".equals(r) || "NO".equals(r) || "nO".equals(r)){
                System.out.println("¡Muchas gracias por jugar, señor!");
                r = "n";
            } else {
                System.out.println("Lo siento, no entendí lo que dijiste.");
            } 
        } while (!r.equals("n"));
        System.exit(0);
    }
    
}
