
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

        // Creamos el contenido del badConsequence nuevo
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        ArrayList<Treasure> copiavisible = new ArrayList(visible);
        ArrayList<Treasure> copiahidden  = new ArrayList(hidden);
        
        for (TreasureKind treasure : this.getSpecificVisibleTreasures()) {
            for (Treasure t : copiavisible) {
                if (t.getType() == treasure) {
                    tVisible.add(treasure);
                }
            }
        }

        for (TreasureKind treasure : this.getSpecificHiddenTreasures()) {
            for (Treasure t : copiahidden) {
                if (t.getType() == treasure) {
                    tHidden.add(treasure);
                }
            }
        }

        BadConsequenceSpecific nuevoBc;

        nuevoBc = new BadConsequenceSpecific(this.getText(), 0, tVisible, tHidden);

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


