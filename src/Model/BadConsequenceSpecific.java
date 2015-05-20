
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Model;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;

/**
 *
 * @author nuria
 */
public class BadConsequenceSpecific extends BadConsequence {

    
    public BadConsequenceSpecific(String text, int levels, ArrayList<TreasureKind> tVisible,
                                  ArrayList<TreasureKind> tHidden) {
        super(text, levels, 0, 0, false, tVisible, tHidden);
    }

    @Override
    public boolean isEmpty() {
        return (getSpecificVisibleTreasures().isEmpty()) && (getSpecificHiddenTreasures().isEmpty());
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {

        BadConsequence nuevoBc = new BadConsequenceSpecific(this.getText(), this.getLevels(), this.getSpecificVisibleTreasures(), this.getSpecificHiddenTreasures());
        ArrayList<TreasureKind> tVisible = this.getSpecificVisibleTreasures();
        ArrayList<TreasureKind> tHidden = this.getSpecificHiddenTreasures();
        ArrayList<TreasureKind> vTypes = new ArrayList();
        ArrayList<TreasureKind> hTypes = new ArrayList();
                
        for(Treasure treasure: hidden){
            hTypes.add(treasure.getType());
        }

        for(int i=0; i<nuevoBc.getSpecificHiddenTreasures().size(); i++){
            boolean encontrado = false;
            for(int j=0; j<hTypes.size() && !encontrado; j++){
                if(nuevoBc.getSpecificHiddenTreasures().get(i) == hTypes.get(j)){
                    hTypes.remove(hTypes.get(j));
                        encontrado = true;
                }
            }
            if(!encontrado){
                nuevoBc.getSpecificHiddenTreasures().remove(nuevoBc.getSpecificHiddenTreasures().get(i));
                i--;
            }
        }               
            
        for(Treasure treasure: visible){
            vTypes.add(treasure.getType());
        }

        for(int i=0; i<nuevoBc.getSpecificVisibleTreasures().size(); i++){
            boolean encontrado = false;
            for(int j=0; j<vTypes.size() && !encontrado; j++){
                if(nuevoBc.getSpecificVisibleTreasures().get(i) == vTypes.get(j)){
                    vTypes.remove(vTypes.get(j));
                        encontrado = true;
                }
            }
            if(!encontrado){
                nuevoBc.getSpecificVisibleTreasures().remove(nuevoBc.getSpecificVisibleTreasures().get(i));
                i--;
            }
        }
        return nuevoBc;
    }
    

    @Override
    public void substractVisibleTreasure(Treasure t) {
        TreasureKind tipo = t.getType();
        Boolean encontrado = false;

        ArrayList<TreasureKind> visibles = getSpecificVisibleTreasures();
               
        for (int i = 0; (i < visibles.size()) &&!encontrado; i++) {
            if (visibles.get(i) == tipo) {
                visibles.remove(i);
                encontrado = true;
            }
        }

    }

    @Override 
    public void substractHiddenTreasure(Treasure t) {
        Boolean encontrado = false;
        TreasureKind tipo = t.getType();
        ArrayList<TreasureKind> hidden = getSpecificHiddenTreasures();

        for (int i = 0; (i < hidden.size()) &&!encontrado; i++) {
            if (hidden.get(i) == tipo) {
                hidden.remove(i);
                encontrado = true;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tTexto = " + this.getText() + "\n\tNiveles =" + ((this.getLevels() != 0)
                ? Integer.toString(this.getLevels())
                : "No quita niveles") + "\n\tNumero tesoros Visibles = " + ((this.getnVisibleTreasures() != 0)
                ? Integer.toString(this.getnVisibleTreasures())
                : "No quia tesoros visibles") + "\n\tNumero tesoros ocultos = " + ((this.getnHiddenTreasures() != 0)
                ? Integer.toString(this.getnHiddenTreasures())
                : "No quita tesoros ocultos. ") + "\n\tMuerte = " + ((this.getDeath() == true)
                ? " true"
                : "false") + "\n\tTesoros Visibles: " + ((!(this.getSpecificVisibleTreasures().isEmpty()))
                ? ArrayToString(this.getSpecificVisibleTreasures())
                : "No quita tesoros visibles") + "\n\tTesoros Ocultos: "
                + ((!(this.getSpecificHiddenTreasures().isEmpty()))
                   ? ArrayToString(this.getSpecificHiddenTreasures())
                   : "No quita tesoros ocultos");
    }
}


