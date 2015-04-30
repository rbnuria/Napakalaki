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
public class Monster implements Card{
    //Atributos visibilidad privada
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer;
 
    //Constructores
    public Monster(String name, int level, BadConsequence bc, Prize prize, int change){
        this(name, level, bc, prize);
        this.levelChangeAgainstCultistPlayer = change;
    }
    
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
        return "\nNombre = " + name + "\nNivel de combate = " + Integer.toString(combatLevel) +
                "\nBuen rollo : " + prize.toString() + "\nMal rollo : " + badConsequence.toString();
    }
    
    public int getBasicValue(){
        return getCombatLevel();
    }
    
    public int getSpecialValue(){
        return getCombatLevel() + levelChangeAgainstCultistPlayer;
    }
 

    
}
