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
public class Treasure implements Card{
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    public Treasure(String n, int g, int min, int max, TreasureKind t){
        this.name = n;
        this.goldCoins = g;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = t;
    }
    
    public String getName(){
        return name;
    }
    
    public int getGoldCoins(){
        return goldCoins;
    }
    
    public int getMinBonus(){
        return minBonus;
    }
    
    public int getMaxBonus(){
        return maxBonus;
    }
    
    public TreasureKind getType(){
        return type;
    }
    
    public String toString(){
        String nombre = name;
        String num_monedas = Integer.toString(goldCoins);
        String maxiBonus = Integer.toString(maxBonus);
        String miniBonus = Integer.toString(minBonus);
        String tipo = type.toString();
        
        return  "Nombre: " + name + "\n\tValor en monedas de oro : " + num_monedas + 
                "\n\tNiveles que suma sin collar : " + miniBonus + "\n\tNiveles que suma con collar : " + maxiBonus +
                "\n\tTipo de tesoro : " + tipo + "\n";
        
        
    }
    
    public int getBasicValue(){
        return getMinBonus();
    }
    
    public int getSpecialValue(){
        return getMaxBonus();
    }
    
    
}
