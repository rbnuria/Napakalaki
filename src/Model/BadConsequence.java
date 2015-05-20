/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author nuria
 */
public abstract class BadConsequence {
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
     
    public BadConsequence(String text,int levels,int nVisibleTreasures,int nHiddenTreasures,boolean death,ArrayList<TreasureKind> specificVisibleTreasures,ArrayList<TreasureKind> specificHiddenTreasures){
        this.text=text;
        this.levels=levels;
        this.nHiddenTreasures=nHiddenTreasures;
        this.nVisibleTreasures=nVisibleTreasures;
        this.death=death;
        this.specificHiddenTreasures=specificHiddenTreasures;
        this.specificVisibleTreasures=specificVisibleTreasures;
    }
    public abstract boolean isEmpty();
    
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
    
    //Metodos auxilaires para cambiar el numero de 
    protected void setnHiddenTreasures(int n){
        nHiddenTreasures = n;
    }
    
    protected void setnVisibleTreasures(int n){
        nVisibleTreasures = n;
    }
    
    
    //Metodos abstractos
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden);
    
    
    public String ArrayToString(ArrayList<TreasureKind> t){
        String auxiliar = "";
        for(TreasureKind it : t){
            auxiliar=auxiliar+it.toString()+" ";
        }
        
        return auxiliar;
    }
    

    public String toString(){
        return "\nEsto es un mal rollo con el siguiente contenido:\n";
        
    }
}

