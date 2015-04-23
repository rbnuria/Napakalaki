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
    
    public Player(String nombre){
        this.dead = true;
        this.name = nombre;
        
        //Valores por defecto
        level = 1;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
    }
    
    public String getName(){
        return this.name;
    }
    
    private void bringToLive(){
        this.dead = false;
    }
    
    private void incrementLevels(int l){//los niveles no pueden ser mayores que 10
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
        for(Treasure t : visibleTreasures){
            CardDealer.getInstance().giveTreasureBack(t);
        }
        
        visibleTreasures.clear();
        
        for(Treasure t : hiddenTreasures){
            CardDealer.getInstance().giveTreasureBack(t);
        }
        
        hiddenTreasures.clear();
        
        
    }
    
    private void discardNecklaceIfVisible(){
        for(int i=0;i<visibleTreasures.size();i++){
            if(visibleTreasures.get(i).getType()==TreasureKind.NECKLACE){
                CardDealer dealer=CardDealer.getInstance();
                dealer.giveTreasureBack(visibleTreasures.get(i));
                visibleTreasures.remove(visibleTreasures.get(i));
            }
        }
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
    
    
    protected float computeGoldCoinsValue(ArrayList<Treasure> t){
        float value=0;
        for(int i=0;i<t.size();i++){
            value=value+t.get(i).getGoldCoins();
        }
        
        
        return value/1000;
    }
    
    public void applyPrize(Prize p){
        int nLevels = p.getLevels();
        incrementLevels(nLevels);
        
        int nPrize = p.getTreasures();
        
        Treasure treasure;
        if(nPrize > 0 ){
            CardDealer carddealer = CardDealer.getInstance();
            for(int i = 0; i < nPrize; i++){
                treasure = carddealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    
    public CombatResult combat(Monster m){
        int mylevel = getCombatLevel();
        int levelmonster = m.getCombatLevel();
        Prize prize;
        CombatResult combatResult;
        
        if(mylevel > levelmonster){
            prize = m.getPrize();
            applyPrize(prize);
            
            if(level > 10){
                combatResult = CombatResult.WINANDWINGAME;
            }else{
                combatResult = CombatResult.WIN;
            }
            
        }else{
            int escape = Dice.getInstance().nextNumber();
            
            if(escape < 5){
                BadConsequence bad = m.getBadConsequence();
                boolean amIDead = bad.kills();
                
                if(amIDead == true){
                    die();
                    combatResult = CombatResult.LOSEANDDIE;
                }else{
                    applyBadConsequence(bad);
                    combatResult = CombatResult.LOSE;
                }
            }else{
                combatResult = CombatResult.LOSEANDESCAPE;
            }
        }
        
        discardNecklaceIfVisible();
        
        return combatResult;
        
    }
    
    
    public void applyBadConsequence(BadConsequence bad){
        int nLevels = bad.getLevels();
        decrementLevels(nLevels);
        
        BadConsequence pendingBad = bad.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures);
        
        setPendingBadConsequence(pendingBad);
    }
    
    //Antes era boolea
    public void makeTreasureVisible(Treasure t){
        visibleTreasures.add(t);
        discardHiddenTreasure(t);
    }
    
    
    public boolean canMakeTreasureVisible(Treasure t){
        boolean valido=true;
        int nOneHand=0;
        for(int i=0;i<visibleTreasures.size() && valido;++i){
            if((visibleTreasures.get(i).getType()==t.getType())) {
               if(!(t.getType()==TreasureKind.ONEHAND && nOneHand<2))
                    valido=false;
               else
                   if(t.getType()==TreasureKind.ONEHAND)
                       nOneHand++;
               
            }else{
                if((t.getType()==TreasureKind.ONEHAND && visibleTreasures.get(i).getType()==TreasureKind.BOTHHANDS)||(t.getType()==TreasureKind.BOTHHANDS && visibleTreasures.get(i).getType()==TreasureKind.ONEHAND))
                    valido=false;
                }
        } 
        return valido;
    }
    
    public void discardVisibleTreasure(Treasure treasure){
        visibleTreasures.remove(treasure);
        
        //Ajustamos el pendingBadConsequence
        if( (pendingBadConsequence!=null) && (!pendingBadConsequence.isEmpty()) ){
            pendingBadConsequence.substractVisibleTreasure(treasure);
        }
        
        CardDealer.getInstance().giveTreasureBack(treasure);
        
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure treasure){
        hiddenTreasures.remove(treasure);
        
        //Ajustamos el pendingBadConsequence
        if( (pendingBadConsequence!=null) && (!pendingBadConsequence.isEmpty()) ){
            pendingBadConsequence.substractHiddenTreasure(treasure);
        }
        
        CardDealer.getInstance().giveTreasureBack(treasure);
        
        dieIfNoTreasures();
    }
    
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        float levels = computeGoldCoinsValue(visible);
        levels += computeGoldCoinsValue(hidden);
        
        boolean canI = canIBuyLevels((int)levels);
        
        if(canI == true){
            incrementLevels((int)levels);
            
            for(Treasure vis : visible){
                discardVisibleTreasure(vis);
            }
            
            for(Treasure hid : hidden){
                discardHiddenTreasure(hid);
            }
        }
        
        return canI;
    }
    
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
        if(this.pendingBadConsequence!= null &&this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() <= MAXHIDDENTREASURES)
            return true;
        else
            return false;
    }
    
    
    public void initTreasures(){
        bringToLive();
        int number = Dice.getInstance().nextNumber();
        
        if(number == 1){
            Treasure treasure = CardDealer.getInstance().nextTreasure();
            hiddenTreasures.add(treasure);
        }else{
            if(number == 6){
                for(int i=0; i < 3; i++){
                    Treasure treasure = CardDealer.getInstance().nextTreasure();
                    hiddenTreasures.add(treasure);
                }
            }else{
                for(int i = 0; i < 2; i++){
                   Treasure treasure = CardDealer.getInstance().nextTreasure();
                   hiddenTreasures.add(treasure); 
                }
            }            
        }    
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
    

}
