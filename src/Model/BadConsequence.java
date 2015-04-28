/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author nuria
 */
public class BadConsequence {
    //Atributos de visibilidad privada
    
    //Texto que dice un mal rollo
    private String text;
    //Numero de niveles perdidos
    private int levels;
    //Numero tesoros visibles perdidos
    private int nVisibleTreasures;
    //Numero tesoros ocultos perdidos
    private int nHiddenTreasures;
    //Muerte o no
    private boolean death;   
    //Tesoros especificos ocultos que pierdes
    private ArrayList<TreasureKind> specificHiddenTreasures;
    //Tesoros especificos visibles que pierdes
    private ArrayList<TreasureKind> specificVisibleTreasures;
     

    //Constructores
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        
        //Valores por defecto
        death = false;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        
        //Valores por defecto
        levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }

    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
        //Valores por defecto
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        death = false;
    }
    
    
    public boolean isEmpty(){
        return (levels==0)&&(nVisibleTreasures==0)&&(nHiddenTreasures==0)&&(specificVisibleTreasures.isEmpty())
                &&(specificHiddenTreasures.isEmpty());                    
    }
    
    public boolean kills(){
        return death;
    }
    
    //Getters
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }

    public boolean getDeath(){
        return death;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    
    public void substractVisibleTreasure(Treasure t){
        TreasureKind tipo=t.getType();
        Boolean encontrado = false;
        
        for(int i=0; i< specificVisibleTreasures.size() && !encontrado;i++){
            if(specificVisibleTreasures.get(i)==tipo){
                specificVisibleTreasures.remove(i);
                encontrado = true;
            }
        }
        
        if(!encontrado && nVisibleTreasures != 0){
            nVisibleTreasures--;
        }
        
    }
    
    public void substractHiddenTreasure(Treasure t){
        Boolean encontrado = false;
        TreasureKind tipo=t.getType();
        for(int i=0; i< specificHiddenTreasures.size() && !encontrado;i++){
            if(specificHiddenTreasures.get(i)==tipo){
                specificHiddenTreasures.remove(i);
                encontrado = true;
            }
        }
        
        if(!encontrado && nHiddenTreasures != 0){
            nHiddenTreasures--;
        }
    }
    
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        //Creamos el contenido del badConsequence nuevo
        ArrayList <TreasureKind> tVisible = new ArrayList();
        ArrayList <TreasureKind> tHidden = new ArrayList();
        int nvisible = this.nVisibleTreasures;
        int nhidden = this.nHiddenTreasures;
        BadConsequence nuevoBc;
        
        ArrayList<Treasure> copiavisible = new ArrayList(visible);
        ArrayList<Treasure> copiahidden = new ArrayList(hidden);
        
        
        //Si no pasamos listas especificas si no numero de tesoros, cogemos el máximo de tesoros posibles
        //Esto es, el mínimo entre todos los tesoros que tenemos y los que quiere aplicar el mal rollo actual
        if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
            if(visible.size() <  this.nVisibleTreasures){
                nvisible = visible.size();
            }
            if(hidden.size() < this.nHiddenTreasures){
                nhidden = hidden.size();
            }
            
            //Creamos badConsequence
            nuevoBc = new BadConsequence(this.text, 0, nvisible, nhidden);
            
        //Por el contrario, si lo que tenemos son listas especificas de tesoros, rellenamos los vectores correspondientes
        //a las listas de tesoros visibles y ocultos del nuevo badConsequence con los tesoros que contengamos
        }else{
            for(TreasureKind treasure : specificVisibleTreasures){
                for(Treasure t : copiavisible){
                    if(t.getType() == treasure){
                        tVisible.add(treasure);
                        copiavisible.remove(t);
                    }
                }
                
            }
            
            for(TreasureKind treasure : specificHiddenTreasures){
                for(Treasure t : copiahidden){
                    if(t.getType() == treasure){
                        tHidden.add(treasure);
                        copiahidden.remove(t);
                    }
                }
            }  
            
            nuevoBc = new BadConsequence(this.text, 0, tVisible, tHidden);
        }
        
        return nuevoBc;

    }
    
    
    
    public String ArrayToString(ArrayList<TreasureKind> t){
        String auxiliar = "";
        for(TreasureKind it : t){
            auxiliar=auxiliar+it.toString()+" ";
        }
        
        return auxiliar;
    }
    

    public String toString(){
        
        return "\n\tTexto = " + text + 
                "\n\tNiveles =" + ((levels != 0) ? Integer.toString(levels) : "No quita niveles") + 
                "\n\tNumero tesoros Visibles = " + ((nVisibleTreasures != 0) ? Integer.toString(nVisibleTreasures) : "No quia tesoros visibles") +
                "\n\tNumero tesoros ocultos = " +((nHiddenTreasures != 0) ? Integer.toString(nHiddenTreasures) : "No quita tesoros ocultos. ")+
                "\n\tMuerte = " + ((death == true) ? " true" : "false" ) +
                "\n\tTesoros Visibles: " + 
                ((!(specificVisibleTreasures.isEmpty())) ? ArrayToString(this.specificVisibleTreasures) : "No quita tesoros visibles") +
                "\n\tTesoros Ocultos: " + 
                ((!(specificHiddenTreasures.isEmpty())) ? ArrayToString(this.specificHiddenTreasures) : "No quita tesoros ocultos");
                
    }
}

