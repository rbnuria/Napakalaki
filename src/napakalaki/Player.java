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
    private boolean dead = true; //Podemos ponerlo en constructor
    private String name;
    private int level;
    private final int MAXHIDDENTREASURES = 4;
    
    //Referencias
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    /*
    private void bringToLive(){
        
    }
    
    private void incrementeLevels(int l){
        
    }
    
    private void decrementLevels(int l){
        
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        
    }
    
    private void die(){
        
    }
    
    private void discardNecklaceIfVisible(){
        
    }
    
    private void dieIfNoTreasures(){
        
    }
    
    private boolean canIBuyLevels(int l){
        
    }
    
    
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
        
    }
    
    public int getCombatLevel(){
        return level;
    }
    
    public boolean validState(){
        
    }
    
    public boolean initTreasures(){
        
    }
    
    public boolean isDead(){
        
    }
    
    public boolean hasVisibleTreasures(){
        
    }
    
    public Player(String name){
        
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        
    }
    */

}
