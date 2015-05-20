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
    //Creacion de objetos
        //TESOROS
        Treasure shoe = new Treasure("Zapatos", 600, 3, 4, TreasureKind.SHOE);
        Treasure onehand = new Treasure("Una mano", 600, 3, 4, TreasureKind.ONEHAND);
        Treasure twohands = new Treasure("Dos manos", 600, 3, 4, TreasureKind.BOTHHANDS);
        Treasure helmet = new Treasure("Casco", 600, 3, 4, TreasureKind.HELMET);
        Treasure armor = new Treasure("Armadura", 600, 3, 4, TreasureKind.ARMOR);
        Treasure necklace = new Treasure("Collar", 600, 3, 4, TreasureKind.NECKLACE);
        
        //BADCONSEQUECES
        BadConsequence bcLists;
        BadConsequence bcNumbers;
        BadConsequence bcDeath;
        
        bcLists = new BadConsequenceSpecific("Mal rollo listas", 3,new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.SHOE)), 
                        new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR,TreasureKind.BOTHHANDS)));
        
        bcNumbers = new BadConsequenceNumbers("Mal rollo numero", 2, 1,6);
        
        bcDeath = new BadConsequenceDeath("Mal rollo muerte",true);
        
        //Premio y monstruo
        Prize prize = new Prize(3,2);
        Monster monster = new Monster("Nomber monstruo", 1 , bcLists, prize, 6);
        
        //Creacion jugadores
        Player player = new Player("Nuria");
        Cultist cultist = new Cultist("Sectario",3);
        CultistPlayer cultistplayer = new CultistPlayer(player, cultist);
        
        
        
        //LLAMADA A METODOS
        
        //BAD CONSEQUENCEE!!!
        
        //bcLists.substractVisibleTreasure(shoe);
        //bcLists.substractHiddenTreasure(onehand);
        
        //bcNumbers.substractVisibleTreasure(shoe);
        //bcNumbers.substractHiddenTreasure(onehand);t
        
        ArrayList<Treasure> v = new ArrayList();
        v.add(onehand);
        v.add(onehand);
        v.add(onehand);
        v.add(onehand);
        v.add(onehand);
        v.add(twohands);
        v.add(necklace);
        
        ArrayList<Treasure> h = new ArrayList();
        h.add(onehand);
        h.add(helmet);
        h.add(armor);
        
     
        BadConsequence adjust = bcLists.adjustToFitTreasureLists(v,h);
        BadConsequence adjust1 = bcNumbers.adjustToFitTreasureLists(v,h);
        
        //Creamos badConsequence vacios y llamamos al adjust
        BadConsequence bcEmptyN = new BadConsequenceNumbers("n",0,0,0);
        BadConsequence bcEmptyL = new BadConsequenceSpecific("n",0,new ArrayList(),new ArrayList());
        
        BadConsequence adjust2 = bcEmptyN.adjustToFitTreasureLists(v, h);
        BadConsequence adjust3 = bcEmptyL.adjustToFitTreasureLists(v, h);
        
        System.out.println(adjust.toString());
        System.out.println(adjust1.toString());
        System.out.println(adjust2.toString());
        System.out.println(adjust3.toString());
        
        
        //PLAYER
        
        player.setSpecificVisibleTreasures(v);
        player.setSpecificHiddenTreasures(h);
        
        
        int level1 = player.getCombatLevel();
        int level2 = cultistplayer.getCombatLevel();
        
        for(int i = 0; i < 10; i++){
            if(player.shouldConvert()){
                System.out.println("True");
            }else{
               System.out.println("False"); 
            }
        }
            
        for(int j = 0; j < 10; j++){
            if(cultistplayer.shouldConvert()){
                System.out.println("True");
            }else{
               System.out.println("False"); 
            }
        }
        
        double money = player.computeGoldCoinsValue(v);
        double money2 = cultistplayer.computeGoldCoinsValue(v);
        
        //Se ajusta y despues se aplica
        player.applyBadConsequence(bcNumbers);
        
        player.makeTreasureVisible(armor);
        
        player.validState();
        
        //player.setPendingBadConsequence();
        
        player.applyPrize(prize);
        
        player.discardVisibleTreasure(onehand);
        player.discardHiddenTreasure(onehand);
        
        System.out.println("Tesoros invisibles");
        for(Treasure t : player.getHiddenTreasures()){
            System.out.println(t.toString());
        }
        System.out.println("Tesoros visibles");
        for(Treasure t : player.getVisibleTreasures()){
            System.out.println(t.toString());
        }
        
        System.out.println(player.getOponentLevel(monster));
        System.out.println(cultistplayer.getOponentLevel(monster));
        
        
        
        
        
        
        
        
        

        
        
        
        
        
    
    

}
}
    
    

