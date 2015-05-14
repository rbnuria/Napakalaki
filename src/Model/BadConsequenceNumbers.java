/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nuria
 */
public class BadConsequenceNumbers extends BadConsequence{
       
    public BadConsequenceNumbers(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        
        //Valores por defecto
        death = false;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
}
