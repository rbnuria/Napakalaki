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
public class CultistPlayer extends Player{
    private static int totalCultistPlayers = 0;
    Cultist myCultistCard;

    
    public CultistPlayer(Player jugador, Cultist c){  
        this(jugador);
        totalCultistPlayers++;
        myCultistCard = c;
        
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    @Override 
    protected boolean shouldConvert(){
        return false;   
    }
    
    @Override
    public int getCombatLevel(){
        return (super.getCombatLevel() + myCultistCard.getSpecialValue());    
    }
    
    @Override
    protected int getOponentLevel(Monster monster){
        return monster.getSpecialValue();
    }
      
    @Override
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        float value=0;
        for(int i=0;i<t.size();i++){
            value=value+t.get(i).getGoldCoins();
        }  
        return (value*2);
    }
            
            
          
    
    
}
