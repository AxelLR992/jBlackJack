package jblackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Axel Emiliano León Rico
 */
public class Deck extends ArrayList{
    Random random = new Random();

    public Deck() {
       for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                if (i < 10 && i > 0){
                    Card card = new Card(i+1, j, String.valueOf(i+1));
                    add(card);
                } else {
                    switch (i) {
                        case 0:
                            {
                                Card card = new Card(i+1, j, "A");
                                add(card);
                                break;
                            }
                        case 10:
                            {
                                Card card = new Card(10, j, "J");
                                add(card);
                                break;
                            }
                        case 11:
                            {
                                Card card = new Card(10, j, "Q");
                                add(card);
                                break;
                            }
                        default:
                            {
                                Card card = new Card(10, j, "K");
                                add(card);
                                break;
                            }
                    }
                }
                
            }
        } 
    }
    
    public void intercambiar(int pos1, int pos2){
        Card carta1, carta2, aux;
        carta1 = (Card) get(pos1);
        carta2 = (Card) get(pos2);
        aux = carta2;
        carta2 = carta1;
        carta1 = aux;
        set(pos1, carta1);
        set(pos2, carta2);
    }
    
    public void shuffle(){
        for (int i = 0; i < 100; i++) {
            int carta1 = random.nextInt(51);
            int carta2 = random.nextInt(51);
            intercambiar(carta1, carta2);            
        }
    }
    
}
