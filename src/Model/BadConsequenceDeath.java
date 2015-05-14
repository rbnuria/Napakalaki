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
    
    public BadConsequenceDeath(String text, boolean death){
        this.text = text;
        this.death = death;
        
        //Valores por defecto
        levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
}
