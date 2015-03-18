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
public class Monster {
    //Atributos visibilidad privada
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
 
    //Constructores
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badConsequence = bc;
    }
   
    //Getters
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return badConsequence;
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public String toString(){
        return "\nname = " + name + "\ncombatLevel = " + Integer.toString(combatLevel) +
                "\nprize : " + prize.toString() + "\nbadConsequence : " + badConsequence.toString();
    }
    
    

    
}
