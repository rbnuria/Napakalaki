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
     
    public BadConsequence(String text,int levels,int nVisibleTreasures,int nHiddenTreasures,boolean death,ArrayList<TreasureKind> specificHiddenTreasures,ArrayList<TreasureKind> specificVisibleTreasures){
        this.text=text;
        this.levels=levels;
        this.nHiddenTreasures=nHiddenTreasures;
        this.nVisibleTreasures=nVisibleTreasures;
        this.death=death;
        this.specificHiddenTreasures=specificHiddenTreasures;
        this.specificVisibleTreasures=specificVisibleTreasures;
    }
    public boolean isEmpty(){
        return (levels==0)&&(nVisibleTreasures==0)&&(nHiddenTreasures==0)&&(specificVisibleTreasures.isEmpty())
                &&(specificHiddenTreasures.isEmpty());                    
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
        Boolean encontrado = false;
        
        for(int i=0; i< specificVisibleTreasures.size() && !encontrado;i++){
            if(specificVisibleTreasures.get(i)==tipo){
                specificVisibleTreasures.remove(i);
                encontrado = true;
            }
        }
        
        if(!encontrado && nVisibleTreasures != 0){
            nVisibleTreasures--;
        }
        
    }
    
    public void substractHiddenTreasure(Treasure t){
        Boolean encontrado = false;
        TreasureKind tipo=t.getType();
        for(int i=0; i< specificHiddenTreasures.size() && !encontrado;i++){
            if(specificHiddenTreasures.get(i)==tipo){
                specificHiddenTreasures.remove(i);
                encontrado = true;
            }
        }
        
        if(!encontrado && nHiddenTreasures != 0){
            nHiddenTreasures--;
        }
    }
    
    
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

