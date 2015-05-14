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
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
        //Valores por defecto
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        death = false;
    }
    
}
