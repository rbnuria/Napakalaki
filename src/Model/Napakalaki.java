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
    ArrayList<Player> players;
    Monster currentMonster;
   
    
    private Napakalaki(){}
    
    private void initPlayers(ArrayList<String> names){
        for(String name : names){
            players.add(new Player(name));
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
        //Esta mal
        return CombatResult.WIN;
    }
    
    /*
    public void discardVisibleTreasures(Treasure t){
        
    }
    
    public void discardHiddenTreasures(Treasure t){
        
    }
    
    public boolean makeTreasureVisible(Treasure t){
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        
    }
    
    public void initGame(ArrayList<String> players){
        
    }
    */
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    /*
    public boolean canMakeTreasureVisible(Treasure t){
        
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return currentPlayer.getVisibleTreasures();
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return currentPlayer.getHiddenTreasures();
    }
    
    public boolean nextTurn(){
        
    }
    
    */
    public boolean nextTurnAllowed(){
        return currentPlayer.validState();
    }
    
   
    
    public boolean endOfGame(CombatResult result){
        return (combat() == CombatResult.WINANDWINGAME);
    }
}
