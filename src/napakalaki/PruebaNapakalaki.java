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
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Mal rollo
        String texto1 = "Has perdido.";
        String texto2 = "Moriras!!!";
        int niveles = 3;
        int tVisibles = 2;
        int tOcultos = 1;
        boolean muerte = true;
        
        ArrayList<TreasureKind> tesoros_visibles;
        tesoros_visibles = new ArrayList<>();
        tesoros_visibles.add(TreasureKind.ARMOR);
        tesoros_visibles.add(TreasureKind.ONEHAND);
        
        ArrayList<TreasureKind> tesoros_invisibles;
        tesoros_invisibles = new ArrayList<>();
        tesoros_invisibles.add(TreasureKind.BOTHHANDS);
        tesoros_invisibles.add(TreasureKind.ONEHAND);
        
        BadConsequence malRollo1, malRollo2;
        malRollo1 = new BadConsequence(texto1, niveles, tVisibles, tOcultos);
        malRollo2 = new BadConsequence(texto2, niveles, tesoros_visibles, tesoros_invisibles);
          
        //Premio
        int tesorosGanados = 5;
        int nivelesGanados = 1;
        
        Prize premio;
        premio = new Prize(tesorosGanados, nivelesGanados);
        
        //Monstruos
        String nombre = "Ghador";
        int nivelCombate = 10;
        
        Monster monstruo;
        monstruo = new Monster(nombre, nivelCombate, malRollo2, premio);    
     
        System.out.println("Estado del monstruo:" + premio.toString() + "\n");
        System.out.println("Estado del premio:" + monstruo.toString() + "\n");
        System.out.println("Estado del mal rollo:" + malRollo1.toString() + "\n");
                          
    }
    
}
