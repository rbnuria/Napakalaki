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
public class BadConsequenceNumbers extends BadConsequence{
    
    //Numero tesoros visibles perdidos
    private int nVisibleTreasures;
    //Numero tesoros ocultos perdidos
    private int nHiddenTreasures;
       
    public BadConsequenceNumbers(String text, int levels, int nVisible, int nHidden){
        super(text,levels,nVisible,nHidden,false,new ArrayList(),new ArrayList());
    }
    
    @Override
    public boolean isEmpty(){
        return (getLevels()==0)&&(getnVisibleTreasures()==0)&&(getnHiddenTreasures()==0);
    }
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        //Creamos el contenido del badConsequence nuevo
       
        int nvisible = this.getnVisibleTreasures();
        int nhidden = this.getnHiddenTreasures();

        if(visible.size() <  nvisible){
            nvisible = visible.size();
        }
        if(hidden.size() < nhidden){
            nhidden = hidden.size();
        }

        //Creamos badConsequence
        BadConsequenceNumbers nuevoBc;
        nuevoBc = new BadConsequenceNumbers(this.getText(), 0, nvisible, nhidden);
        
        return nuevoBc;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){        
        if(getnVisibleTreasures() != 0){
            setnVisibleTreasures(getnVisibleTreasures() - 1 );
        }
    }

    @Override
    public void substractHiddenTreasure(Treasure t){        
        if(getnHiddenTreasures() != 0){
            setnHiddenTreasures(getnHiddenTreasures() - 1 );
        }
    }

    
    @Override
    public String toString(){
       
       
        return super.toString()+ "\n\tTexto = " + this.getText() + 
                "\n\tNiveles =" + ((this.getLevels() != 0) ? Integer.toString(this.getLevels()) : "No quita niveles") + 
                "\n\tNumero tesoros Visibles = " + ((this.getnVisibleTreasures() != 0) ? Integer.toString(this.getnVisibleTreasures()) : "No quia tesoros visibles") +
                "\n\tNumero tesoros ocultos = " +((this.getnHiddenTreasures() != 0) ? Integer.toString(this.getnHiddenTreasures()) : "No quita tesoros ocultos. ")+
                "\n\tMuerte = " + ((this.getDeath() == true) ? " true" : "false" ) +
                "\n\tTesoros Visibles: " + 
                ((!(this.getSpecificVisibleTreasures().isEmpty())) ? ArrayToString(this.getSpecificVisibleTreasures()) : "No quita tesoros visibles") +
                "\n\tTesoros Ocultos: " + 
                ((!(this.getSpecificHiddenTreasures().isEmpty())) ? ArrayToString(this.getSpecificHiddenTreasures()) : "No quita tesoros ocultos");
               
    }
}
