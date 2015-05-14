/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author nuria
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    ArrayList<Integer> nuri=new ArrayList();
    nuri.add(5);
    nuri.add(2);
    nuri.add(5);
    nuri.add(7);
    nuri.add(8);
    nuri.add(9);
    nuri.add(54);
    nuri.add(27);
    nuri.add(54);
    nuri.add(26);
    nuri.add(54);
    nuri.add(264);
    nuri.add(523);
    nuri.add(28);
    nuri.add(554);
    nuri.add(23);
    
    for (Integer t : nuri){
       System.out.println(t.toString());
    }
    
    ArrayList<Integer> david=new ArrayList();

    
    for (Integer t : nuri){
       david.add(t);
       nuri.remove(t);
    }
    

    
    for (Integer t : david){
       System.out.println(t.toString());
    }
    
    

}
}
    
    

