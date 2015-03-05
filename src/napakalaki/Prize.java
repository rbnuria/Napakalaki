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
        treasures = 0;
        levels = 0;
    }
    
    //Getters (¿Son publicos?)
    public int getTreasures(){
        return treasures;
    }
    
    public int getLevels(){
        return levels;
    }
    

    public String toString(){
        return "Treasures =" + Integer.toString(treasures) + " levels =" +
                Integer.toString(levels);
    }
    
        
}

