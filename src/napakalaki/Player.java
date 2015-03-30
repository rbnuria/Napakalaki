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
public class Player {
    //Datos miembros especificados
    private boolean dead;
    private String name;
    private int level;
    private final int MAXHIDDENTREASURES = 4;
    
    //Referencias
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.dead = true;
        this.name = name;
        
        //Valores por defecto
        level = 1;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
    }
    
    
    private void bringToLive(){
        this.dead = false;
    }
    
    private void incrementeLevels(int l){//los niveles no pueden ser mayores que 10
        this.level += l;
        
        if(level > 10){
            level = 10;
        }
    }
    
    private void decrementLevels(int l){
        this.level -= l;
        
        if(level < 1){
            level = 1;
        }
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b; 
    }
    
    private void die(){
        
    }
    
    private void discardNecklaceIfVisible(){
        
    }
    
    private void dieIfNoTreasures(){
        if(this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()){
            dead = true;
            level = 1;
        }
    }
    
    private boolean canIBuyLevels(int l){
        if(level + l < 10){
            return true;
        }else
            return false;
        
    }
    
    /*
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        
    }
    
    public void applyPrize(Prize p){
        
    }
    
    public CombatResult combat(Monster m){
        
    }
    
    public void applyBadConsequence(BadConsequence bad){
        
    }
    
    public boolean makeTreasureVisible(Treasure t){
        
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        
    }
    
    public void discardVisibleTReasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        
    }*/
    
    public int getCombatLevel(){//hay dos bucles for para recorrer lo mismo, lo puedes hacer solo en uno
        int combatLevel = level;
        boolean collar = false; 
        for(Treasure it : visibleTreasures){
            if(it.getType() == TreasureKind.NECKLACE)
               collar = true;
        }
        
        for(Treasure it : visibleTreasures){
            if(collar){
                combatLevel += it.getMaxBonus();
            }else
                combatLevel += it.getMinBonus();
        }
        
        return combatLevel;     
    }
    
    public boolean validState(){
        if(this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() <= 4)
            return true;
        else
            return false;
    }
    
    /*
    public boolean initTreasures(){
        
    }
    
    
    public boolean isDead(){
        return dead;
    }
    
    public boolean hasVisibleTreasures(){
        return !(this.visibleTreasures.isEmpty());
    }    
    

    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    */

}
