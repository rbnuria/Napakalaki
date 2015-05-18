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
public class BadConsequenceSpecific extends BadConsequence{
    
    public BadConsequenceSpecific(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(text,levels,0,0,false,tVisible,tHidden);
    }
    
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
