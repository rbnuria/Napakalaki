/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
        
        //Mal rollo
        String texto1 = "Has perdido.";
        String texto2 = "Moriras!!!";
        int niveles = 3;
        int tVisibles = 2;
        int tOcultos = 3;
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
     
        System.out.println("Estado del premio:" + premio.toString() + "\n");
        System.out.println("Estado del monstruo:" + monstruo.toString() + "\n");
        System.out.println("Estado del mal rollo:" + malRollo1.toString() + "\n");
        
        
        /************  CREACIÓN DE LOS MONSTRUOS ***************/
        ArrayList<Monster> monstruos = new ArrayList();
        
        BadConsequence badConsequence;
        Prize prize;
        
        //3 Byakhees de bonanza
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        //Chibithulhu
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        //El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",
                0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
                
        //Angeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad"
                + "del vuelo. Descarta 1 mano visible y 1 mano oculta.",0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));  
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca.",14, badConsequence, prize));
        
        //El gorrón en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles.", 0, 5, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        //H.P. Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        //Bichgooth
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));  
                
        //El rey de la Rosa
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(4,2);
        monstruos.add(new Monster("El rey de la rosa", 13, badConsequence, prize));
        
        //La que redacta en las tinieblas
        badConsequence = new BadConsequence("Toses los pulmones y pierdes dos niveles.", 2, 0,0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        //Los hondos
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente.Estas muerto.", true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        //Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear.Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));  
        
        //Pollipólipo volante
        badConsequence = new BadConsequence("Da mucho asquito.Pierdes tres niveles.", 3,0,0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Pollipolito volante", 3, badConsequence, prize));
        
        //YskhtihyssgGoth
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre.Estás muerto.", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("YskhtihyssgGoth", 12, badConsequence, prize));
        
        //Familia feliz
        badConsequence = new BadConsequence("La familia te atrapa.Estás muerto.", true);
        prize = new Prize(4,1);
        monstruos.add(new Monster("YskhtihyssgGoth", 1, badConsequence, prize));
        
        //Roboggoth
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder"
                + "2 niveles y un tesoro y 2 manos visibles.", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        //El espía
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0 ,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espía.", 5, badConsequence, prize));
        
        //El Lenguas
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("El Lenguas.", 20, badConsequence, prize));
        
        //Bicéfalo
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza.", 3,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
    
    
    /************ MOSTRAMOS LOS MONSTRUOS CON LAS SIGUIENTES CARACTERISTICAS ***********/
    
    //Nivel de combate superior a 10
    System.out.println("Los monstruos con un nivel de combate mayor a 10 son: \n");
    for(Monster it : monstruos){
        if(it.getCombatLevel() > 10){
            it.toString();
        }
    }
    
    //Monstruos cuyo malRollo implica solo perdida de niveles
    System.out.println("Los monstruos con un nivel de combate mayor a 10 son: \n");
    for(Monster it : monstruos){
        if(it.getBadConsequence().getLevels() != 0 && it.getBadConsequence().getnHiddenTreasures() == 0 &&
                it.getBadConsequence().getnVisibleTreasures() == 0){
            it.toString();
        }
    }
    
    //Monstruos con un buenRollo que implica ganancia de niveles superior a 1
    System.out.println("Monstruos con un buenRollo que implica ganancia de niveles superior a 1 son: \n");
    for(Monster it : monstruos){
        if(it.getPrize().getLevels() > 1){
           it.toString();
        }
    }
   
    //Monstruos cuyo malRollo implique la perdida de algun ONEHAND (visible u oculta):
    System.out.println("Monstruos cuyo malRollo implique la perdida de algun ONEHAND (visible u oculta) son :\n");
    for(Monster it : monstruos){
        if(it.getBadConsequence().getSpecificHiddenTreasures())
    }
    
   
    
    
    
    
    
}
    

