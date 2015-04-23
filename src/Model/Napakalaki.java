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
public class Napakalaki {
    //Datos miembro
    private static final Napakalaki instance = new Napakalaki();
    private int currentPlayerIndex = -1;
    
    //Referencias
    Player currentPlayer;
    ArrayList<Player> players = new ArrayList();
    Monster currentMonster;

    
    private Napakalaki(){}
    
    private void initPlayers(ArrayList<String> names){
        /*for(String name : names){
            players.add(new Player(name));     
        }*/
        
        for(int i = 0; i < names.size(); i++){
            players.add(new Player(names.get(i)));
        }
    }
    
    
    private Player nextPlayer(){
        int maxIndex = players.size() - 1;
        if(currentPlayerIndex == -1){
            currentPlayerIndex = (int) (Math.random() * maxIndex);
        }else{
            if(currentPlayerIndex ==  maxIndex){
                currentPlayerIndex = 0;
            }else{
                currentPlayerIndex = currentPlayerIndex + 1;
            }
        }
        
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
    }
    
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    
    public CombatResult combat(){
        CombatResult resultado = currentPlayer.combat(currentMonster);
        CardDealer.getInstance().giveMonsterBack(currentMonster);
        
        return resultado;   
        
        //Aqui miguel hace cosas raras
    }
    
   
    public void discardVisibleTreasures(Treasure treasure){
            currentPlayer.discardVisibleTreasure(treasure); 
    }
    
    
    public void discardHiddenTreasures(Treasure treasure){
            currentPlayer.discardHiddenTreasure(treasure); 
    }
    
    
    //Antes era boolean
    public void makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)){
            currentPlayer.makeTreasureVisible(t);
        }  
    }
    
    
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        return currentPlayer.buyLevels(visible,hidden);
    }
    
    public void initGame(ArrayList<String> players){
        CardDealer.getInstance().initCards();  
        initPlayers(players);   
        nextTurn();
        
    }
   
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
   
    public boolean canMakeTreasureVisible(Treasure t){
        return currentPlayer.canMakeTreasureVisible(t);
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return currentPlayer.getVisibleTreasures();
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return currentPlayer.getHiddenTreasures();
    }
    
    
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        boolean dead;
        
        if(stateOK == true){
            currentMonster = CardDealer.getInstance().nextMonster();
            currentPlayer = nextPlayer();
            dead = currentPlayer.isDead();
            
            if(dead == true){
                currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    
    public boolean nextTurnAllowed(){
        boolean allowed;
        
        if(currentPlayerIndex == -1)
        {
            allowed=true;
        }else
        {
            allowed = currentPlayer.validState();
        }
        
        return allowed;
    }
    
   
    
    public boolean endOfGame(CombatResult result){
        return (combat() == CombatResult.WINANDWINGAME);
    }
}
