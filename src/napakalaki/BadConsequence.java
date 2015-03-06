/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
    private ArrayList<TreasureKind> specificHiddenTreasures;
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
    
    public String ArrayToString(ArrayList<TreasureKind> t){
        String auxiliar = "";
        for(TreasureKind it : t){
            auxiliar=auxiliar+it.toString()+" ";
        }
        
        return auxiliar;
    }
    
    public String toString(){
        
        return "\ntext = " + text + 
                "\nlevels =" + ((levels != -1) ? Integer.toString(levels) : "No quita niveles") + 
                "\nnVisibleTreasures = " + ((nVisibleTreasures != -1) ? Integer.toString(nVisibleTreasures) : "No quia tesoros visibles") +
                "\nnHiddenTreasures = " +((nHiddenTreasures != -1) ? Integer.toString(nHiddenTreasures) : "No quita tesoros ocultos. ")+
                "\ndeath = " + ((death == true) ? " true" : "false" ) +
                "\nTesoros Visibles: " + 
                ((!(specificVisibleTreasures.isEmpty())) ? ArrayToString(this.specificVisibleTreasures) : "No quita tesoros visibles") +
                "\nTesoros Ocultos: " + 
                ((!(specificHiddenTreasures.isEmpty())) ? ArrayToString(this.specificHiddenTreasures) : "No quita tesoros ocultos");
                
    }
    
}

