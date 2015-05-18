/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author nuria
 */
public class CardDealer {    
    private static final CardDealer INSTANCE = new CardDealer();

    //Referencias
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    
    
    private CardDealer(){}
    
    private void initTreasureCardDeck(){
       
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));        
        unusedTreasures.add(new Treasure("Botas de investigacion", 600, 3, 4, TreasureKind.SHOE));        
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));        
        unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));   
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));   
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));   
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));   
        unusedTreasures.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.HELMET));   
        unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));   
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de tres cañones", 700, 4, 6, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.NECKLACE));
        unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycon", 300, 3, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicón", 100, 1, 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a dos manos", 400, 3, 6, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicón", 200, 2, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 200, 0, 1, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));    
    }
    
    private void initMonsterCardDeck(){
        BadConsequence badConsequence;
        Prize prize;
        
        //3 Byakhees de bonanza
        badConsequence = new BadConsequenceSpecific("Pierdes tu armadura visible y otra oculta",
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        //Chibithulhu
        badConsequence = new BadConsequenceSpecific("Embobados con el lindo primigenio te descartas de tu casco visible",
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        //El sopor de Dunwich
        badConsequence = new BadConsequenceSpecific("El primordial bostezo contagioso. Pierdes el calzado visible",
                0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
                
        //Angeles de la noche ibicenca
        badConsequence = new BadConsequenceSpecific("Te atrapan para llevarte de fiesta y te dejan caer en mitad"
                + "del vuelo. Descarta 1 mano visible y 1 mano oculta.",0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));  
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca.",14, badConsequence, prize));
        
        //El gorrón en el umbral
        badConsequence = new BadConsequenceNumbers("Pierdes todos tus tesoros visibles.", 0, 5, 0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        //H.P. Munchcraft
        badConsequence = new BadConsequenceSpecific("Pierdes la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        //Bichgooth
        badConsequence = new BadConsequenceSpecific("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));  
                
        //El rey de la Rosa
        badConsequence = new BadConsequenceNumbers("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de la rosa", 13, badConsequence, prize));
        
        //La que redacta en las tinieblas
        badConsequence = new BadConsequenceNumbers("Toses los pulmones y pierdes dos niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        //Los hondos
        badConsequence = new BadConsequenceDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente.Estas muerto.", true);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Semillas Cthulhu
        badConsequence = new BadConsequenceNumbers("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        //Dameargo
        badConsequence = new BadConsequenceSpecific("Te intentas escaquear.Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));  
        
        //Pollipólipo volante
        badConsequence = new BadConsequenceNumbers("Da mucho asquito.Pierdes tres niveles.", 3, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipolito volante", 3, badConsequence, prize));
        
        //YskhtihyssgGoth
        badConsequence = new BadConsequenceDeath("No le hace gracia que pronuncien mal su nombre.Estás muerto.", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("YskhtihyssgGoth", 12, badConsequence, prize));
        
        //Familia feliz
        badConsequence = new BadConsequenceDeath("La familia te atrapa.Estás muerto.", true);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("YskhtihyssgGoth", 1, badConsequence, prize));
        
        //Roboggoth
        badConsequence = new BadConsequenceSpecific("La quinta directiva primaria te obliga a perder"
                + "2 niveles y un tesoro y 2 manos visibles.", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        //El espía
        badConsequence = new BadConsequenceSpecific("Te asusta en la noche. Pierdes un casco visible.", 0 ,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espía.", 5, badConsequence, prize));
        
        //El Lenguas
        badConsequence = new BadConsequenceNumbers("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas.", 20, badConsequence, prize));
        
        //Bicéfalo
        badConsequence = new BadConsequenceSpecific("Te faltan manos para tanta cabeza.", 3,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        //MONSTRUOS CON SECTARIOS
        badConsequence = new BadConsequenceSpecific("Pierdes 1 mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize  = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        badConsequence = new BadConsequenceNumbers("Pierdes tus tesoros visibles. Ja ja ja",0, 5, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence, prize, +2));
        
        badConsequence = new BadConsequenceDeath("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, +4));
        
        badConsequence = new BadConsequenceNumbers("Pierdes tus tesoros visibles. Ja ja ja",2 , 0, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, badConsequence, prize, -2));
        
        badConsequence = new BadConsequenceSpecific("Pierdes 1 mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)));
        prize  = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, +5));
        
        badConsequence = new BadConsequenceNumbers("Pierdes dos niveles.",2 , 0, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        badConsequence = new BadConsequenceNumbers("Pintalabios negro. Pierdes dos niveles.",2 , 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, +3));
                
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    public static CardDealer getInstance(){
        return INSTANCE;
    }
    
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
            ArrayList<Treasure> aux=  unusedTreasures;
            unusedTreasures=usedTreasures;
            usedTreasures=aux;
            shuffleTreasures();
        }
        Treasure t=unusedTreasures.get(0);
        
        unusedTreasures.remove(0);
        return t;
    }
    
    public Monster nextMonster(){
        //Igual que para las cartas
         if(unusedMonsters.isEmpty()){
            ArrayList<Monster> aux=  unusedMonsters;
            unusedMonsters=usedMonsters;
            usedMonsters=aux;
            shuffleMonsters();
        }
         
        Monster t=unusedMonsters.get(0); 
        unusedMonsters.remove(0);
        return t;
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){              
        initTreasureCardDeck();
        shuffleTreasures();
        initMonsterCardDeck();
        shuffleMonsters();
        initCultistCardDeck();
        shuffleCultists();
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",2));
        unusedCultists.add(new Cultist("Sectario",1));
        unusedCultists.add(new Cultist("Sectario",1));
    }
    
    public Cultist nextCultist(){
        Cultist cultist = unusedCultists.get(0);
        unusedCultists.remove(0);
        return cultist;
    }

}
