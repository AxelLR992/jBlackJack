package jblackjack;

import java.util.Random;

/**
 *
 * @author Axel Emiliano León Rico
 */
public class Card {
    
    int valor, palo;
    String representacion;

    public Card(int valor, int palo, String representacion) {
        this.valor = valor;
        this.palo = palo;
        this.representacion = representacion;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }
    
    public String getRepresentacion(){
        return representacion;
    }
    
    public void setRepresentacion(String representacion){
        this.representacion = representacion;
    }
    
    
}
