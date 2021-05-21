// Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of tutoriels4f5
//
// tutoriels4f5 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// tutoriels4f5 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>


package tut07.pages.partie.composants;

import ntro.debogage.J;
import tut07.enumerations.Couleur;
import tut07.pages.partie.composants.ConteneurLigne;
import javafx.beans.NamedArg;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ConteneurGrille extends VBox {
    
    private Color couleurVert;
    private Color couleurOrange;
    
    public ConteneurGrille(@NamedArg("couleurVert") String couleurVert, 
    		               @NamedArg("couleurOrange") String couleurOrange) {
        super();
        J.appel(this);

        if(couleurVert != null && !couleurVert.isEmpty()) {
            this.couleurVert = Color.valueOf(couleurVert);
        }
        
        if(couleurOrange != null && !couleurOrange.isEmpty()) {
            this.couleurOrange = Color.valueOf(couleurOrange);
        }
    }

    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);
        
        this.getStyleClass().add("conteneurGrille");
        
        VBox.setVgrow(this, Priority.ALWAYS);
        
       // int hauteurPixels = hauteur * Constantes.TAILLE_CASE;
        //int largeurPixels = largeur * Constantes.TAILLE_CASE;
        
      // this.setMinHeight(hauteurPixels);
      //  this.setMaxHeight(hauteurPixels);

      //  this.setMinWidth(largeurPixels);
       // this.setMaxWidth(largeurPixels);
        
        for(int i = 0; i < hauteur; i++) {

            this.getChildren().add(new ConteneurLigne(largeur, couleurVert, couleurOrange));
        }
    }

    public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
        J.appel(this);
        
        if(siIndiceRangeeValide(indiceRangee)) {
            
            ConteneurLigne conteneurLigne = getConteneurLigne(indiceRangee);
            conteneurLigne.afficherJeton(indiceColonne, couleur);
        }
    }
    
    private boolean siIndiceRangeeValide(int indiceRangee) {
        J.appel(this);

        return indiceRangee >= 0 && indiceRangee < this.getChildren().size();
    }
    
    private ConteneurLigne getConteneurLigne(int indiceRangee) {
        J.appel(this);

        return (ConteneurLigne) this.getChildren().get(indiceRangee);
    }
    
    public void animerEntreeJeton(int indiceColonne, int indiceRangee) {
        J.appel(this);

        if(siIndiceRangeeValide(indiceRangee)) {
            
            ConteneurLigne ligne = getConteneurLigne(indiceRangee);
            ligne.animerEntreeJeton(indiceColonne);
        }
    }
}
