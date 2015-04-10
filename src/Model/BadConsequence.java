/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author nuria
 */
public class BadConsequence {
    //Atributos de visibilidad privada
    
    //Texto que dice un mal rollo
    private String text;
    //Numero de niveles perdidos
    private int levels;
    //Numero tesoros visibles perdidos
    private int nVisibleTreasures;
    //Numero tesoros ocultos perdidos
    private int nHiddenTreasures;
    //Muerte o no
    private boolean death;   
    //Tesoros especificos ocultos que pierdes
    private ArrayList<TreasureKind> specificHiddenTreasures;
    //Tesoros especificos visibles que pierdes
    private ArrayList<TreasureKind> specificVisibleTreasures;
     

    //Constructores
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        
        //Valores por defecto
        death = false;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        
        //Valores por defecto
        levels = -1;
        nVisibleTreasures = -1;
        nHiddenTreasures = -1;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
    /* Yo no creo que esto se pueda hacer ni esté bien
    public BadConsequence(){
        this.text = "";
        this.death = false;        
        //Valores por defecto
        levels = -1;
        nVisibleTreasures = -1;
        nHiddenTreasures = -1;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }*/
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
        //Valores por defecto
        nVisibleTreasures = -1;
        nHiddenTreasures = -1;
        death = false;
    }
    
    
    public boolean isEmpty(){
        return (levels==-1)&&(nVisibleTreasures==-1)&&(nHiddenTreasures==-1)&&(specificVisibleTreasures.isEmpty())
                &&(specificHiddenTreasures.isEmpty() && death == false);                    
    }
    
    public boolean kills(){
        return death;
    }
    
    //Getters
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }

    public boolean getDeath(){
        return death;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    
    public void substractVisibleTreasure(Treasure t){
        TreasureKind tipo=t.getType();
        for(int i=0; i< specificVisibleTreasures.size();i++){
            if(specificVisibleTreasures.get(i)==tipo){
                specificVisibleTreasures.remove(i);
            }
        }
        //AQUI Y EN EL METODO DE ABAJO, SI NO HA ENCONTRADO NADA, MIGUEL HACE QUE TE DESCARTES DE UNO CUALQUIERA, YO NO LO HE PUESTO PORQUE EN LA PRACTICA DE PRIMERAS NO PONE NADA DE ESO, PERO HABRIA QUE MIRARLO
        
    }
    
    public void substractHiddenTreasure(Treasure t){
        TreasureKind tipo=t.getType();
        for(int i=0; i< specificHiddenTreasures.size();i++){
            if(specificHiddenTreasures.get(i)==tipo){
                specificHiddenTreasures.remove(i);
            }
        }
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
    }
    
    
    
    public String ArrayToString(ArrayList<TreasureKind> t){
        String auxiliar = "";
        for(TreasureKind it : t){
            auxiliar=auxiliar+it.toString()+" ";
        }
        
        return auxiliar;
    }
    

    public String toString(){
        
        return "\nTexto = " + text + 
                "\nNiveles =" + ((levels != -1) ? Integer.toString(levels) : "No quita niveles") + 
                "\nNumero tesoros Visibles = " + ((nVisibleTreasures != -1) ? Integer.toString(nVisibleTreasures) : "No quia tesoros visibles") +
                "\nNumero tesoros ocultos = " +((nHiddenTreasures != -1) ? Integer.toString(nHiddenTreasures) : "No quita tesoros ocultos. ")+
                "\nMuerte = " + ((death == true) ? " true" : "false" ) +
                "\nTesoros Visibles: " + 
                ((!(specificVisibleTreasures.isEmpty())) ? ArrayToString(this.specificVisibleTreasures) : "No quita tesoros visibles") +
                "\nTesoros Ocultos: " + 
                ((!(specificHiddenTreasures.isEmpty())) ? ArrayToString(this.specificHiddenTreasures) : "No quita tesoros ocultos");
                
    }
    
    
    
}

