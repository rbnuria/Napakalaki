/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author nuria
 */
public class ComoseEjecuta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BadConsequence bd = new BadConsequence("Ey", true);
        Prize p = new Prize(3,4);
        Monster monstruo = new Monster("Gadi", 4, bd, p);
        
        System.out.println(monstruo.toString());
    }
    
    
}
