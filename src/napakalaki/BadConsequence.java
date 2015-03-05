/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
        setText(text);
        setLevels(levels);
        setnVisibleTreasures(nVisible);
        setnHiddenTreasures(nHidden);
        
    
    }
    
    public BadConsequence(String text, boolean death){
        setText(text);
        setDeath(death);
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        setText(text);
        setLevels(levels);
        setSpecificHiddenTreasure(tHidden);
        setSpecificVisibleTreasure(tVisible);
    }
    
    //Setters
    private void setText(String text1){
        text = text1;
    }
    
    private void setLevels(int levels1){
        levels = levels1;
    }
    
    private void setnVisibleTreasures(int nVisible){
        nVisibleTreasures = nVisible;
    }
    
    private void setnHiddenTreasures(int nHidden){
        nHiddenTreasures = nHidden;
    }
    
    private void setDeath(boolean death1){
        death = death1;
    }
    
    private void setSpecificHiddenTreasure(ArrayList<TreasureKind> tHidden){
        specificHiddenTreasures = tHidden;
    }
    
    private void setSpecificVisibleTreasure(ArrayList<TreasureKind> tVisible){
        specificVisibleTreasures = tVisible;
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
    
    public String toString(){

        return "text =" + text + " levels =" + Integer.toString(levels) + 
                " nVisibleTreasures = " + Integer.toString(nVisibleTreasures) +
                " nHiddenTreasures = " + Integer.toString(nHiddenTreasures)+
                " death = " + ((death == true) ? " true" : "false");
                
    }
    
}

