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
    public Monster(String name, int level, BadConsequence bc, Prize price){
        setName(name);
        setCombatLevel(level);
        setBadConsequence(bc);
        setPrice(price);
    }
    
    //Setters
    private void setName(String nombre){
        name = nombre;
    }
    
    private void setCombatLevel(int cLevel){
        combatLevel = cLevel;
    }
    
    private void setBadConsequence(BadConsequence bc){
        badConsequence = bc;
    }
    
    private void setPrice(Prize price){
        prize = price;
    }
    
    //Getters
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public String toString(){
        return "name = " + name + " combatLevel = " + Integer.toString(combatLevel) +
                " price = " + prize.toString() + " badConsequence = " + badConsequence.toString();
    }
    
    

    
}
