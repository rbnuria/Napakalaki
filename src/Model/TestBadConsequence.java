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
public class TestBadConsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BadConsequence bc = new BadConsequence("Ey", true);
        Prize p = new Prize(3,4);
        Monster monstruo = new Monster("Gadi", 4, bc, p);
        
        System.out.println(monstruo.toString());
        
        ArrayList<BadConsequence> malRollitos = new ArrayList();
        
        BadConsequence bc2 = new BadConsequence("Yuhu", -1,-1,-1);
        BadConsequence bc3 = new BadConsequence("Piruli", -1,new  ArrayList(),new ArrayList());
        BadConsequence bc4 = new BadConsequence("Yihaaa", false);
        
        malRollitos.add(bc);
        malRollitos.add(bc2);
        malRollitos.add(bc3);
        malRollitos.add(bc4);
        
        System.out.println("\nMal rollitos que estan vacios");
        for(BadConsequence b : malRollitos){
            if(b.isEmpty()){
                System.out.println(b.toString());
            }
        }
        
        System.out.println("\nMal rollitos que te matan");
                for(BadConsequence b : malRollitos){
            if(b.kills()){
                System.out.println(b.toString());
            }
        }
                
        
        
        
    }
    
    
}
