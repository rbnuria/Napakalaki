/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author nuria
 */
public class Prize {
    private int treasures;
    private int levels;
    
    //Constructor 
    public Prize(int treasures, int levels){
        this.treasures = treasures;
        this.levels = levels;
    }
    
    //Getters (¿Son publicos?)
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevels(){
        return levels;
    }
    

    public String toString(){
        return "\nTreasures =" + Integer.toString(treasures) + "\nlevels =" +
                Integer.toString(levels);
    }
    
        
}

