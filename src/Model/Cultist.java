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
public class Cultist implements Card{
    private String name;
    private int gainedLevels;
    
    Cultist(String nombre, int levels){
        this.name = nombre;
        this.gainedLevels = levels;
        
    }
    
    public int getBasicValue(){
        return gainedLevels;
    }
    
    public int getSpecialValue(){
        return (gainedLevels * CultistPlayer.getTotalCultistPlayers());
    }
}
