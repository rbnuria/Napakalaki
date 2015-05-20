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
public class BadConsequenceDeath extends BadConsequence {
    
    //Muerte o no
    private boolean death;  
    
    public BadConsequenceDeath(String text, boolean death){
        super(text,0,0,0,death,new ArrayList(),new ArrayList());     
        
        //Valores por defect
    }
    
    @Override
    public boolean isEmpty(){
        return true;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return this;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){}
    
    @Override
    public void substractHiddenTreasure(Treasure t){}
    
    
    @Override
     public String toString(){
       
       
        return super.toString()+ "\n\tTexto = " + this.getText() + 
                "\n\tNiveles =" + ((this.getLevels() != 0) ? Integer.toString(this.getLevels()) : "No quita niveles") + 
                "\n\tNumero tesoros Visibles = " + ((this.getnVisibleTreasures() != 0) ? Integer.toString(this.getnVisibleTreasures()) : "No quia tesoros visibles") +
                "\n\tNumero tesoros ocultos = " +((this.getnHiddenTreasures() != 0) ? Integer.toString(this.getnHiddenTreasures()) : "No quita tesoros ocultos. ")+
                "\n\tMuerte = " + ((this.getDeath() == true) ? " true" : "false" ) +
                "\n\tTesoros Visibles: " + 
                ((!(this.getSpecificVisibleTreasures().isEmpty())) ? ArrayToString(this.getSpecificVisibleTreasures()) : "No quita tesoros visibles") +
                "\n\tTesoros Ocultos: " + 
                ((!(this.getSpecificHiddenTreasures().isEmpty())) ? ArrayToString(this.getSpecificHiddenTreasures()) : "No quita tesoros ocultos");
               
    }
    
    
    
}
