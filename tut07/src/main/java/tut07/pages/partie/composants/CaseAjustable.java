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
import ntro.javafx.composants.CanvasAjustable;
import tut07.enumerations.Couleur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.NamedArg;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CaseAjustable extends CanvasAjustable {
    
    private final double TAILLE_POURCENTAGE = 0.6;
    
    private Color couleurVert;
    private Color couleurOrange;
    
    private Timeline animationSortieJeton;
    private Timeline animationEntreeJeton;

    public CaseAjustable(@NamedArg("couleurVert") Color couleurVert, 
    		             @NamedArg("couleurOrange") Color couleurOrange) {
        super();
        J.appel(this);
        
        HBox.setHgrow(this, Priority.ALWAYS);
        VBox.setVgrow(this, Priority.ALWAYS);
        
        this.couleurVert = couleurVert;
        this.couleurOrange = couleurOrange;
        
        creerAnimationEntreeJeton();
        creerAnimationSortieJeton();
        initialiserPinceau();
        dessinerCase();
    }

    public void afficherJeton(Couleur couleur) {
        J.appel(this);
        
        switch(couleur) {
        
            case VERT:
                pinceau.setFill(couleurVert);
                dessinerCase();
            break;

            case ORANGE:
                pinceau.setFill(couleurOrange);
                dessinerCase();
            break;
        }
    }

    @Override
    protected void reagirLargeurInitiale(double largeurInitiale) {
        J.appel(this);
        
        viderDessin();
        dessinerCase();
    }

    @Override
    protected void reagirHauteurInitiale(double hauteurInitiale) {
        J.appel(this);

        viderDessin();
        dessinerCase();
    }

    @Override
    protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
        J.appel(this);

        viderDessin();
        dessinerCase();
    }

    @Override
    protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
        J.appel(this);

        viderDessin();
        dessinerCase();
    }

    private void initialiserPinceau() {
        J.appel(this);

        pinceau.setFill(Color.WHITE);
        pinceau.setStroke(Color.BLACK);
        pinceau.setLineWidth(0.01*getWidth());
    }
    
    private void viderDessin() {
        J.appel(this);

        pinceau.clearRect(0, 0, getWidth(), getHeight());
    }
    
    private void dessinerCase() {
        J.appel(this);
        
        dessinerCase(TAILLE_POURCENTAGE);
    }

    private class Case {
        public double caseHautGaucheX;
        public double caseHautGaucheY;
        public double tailleCase;
    }
    
    private void dessinerCase(double taillePourcentage) {
        J.appel(this);
        
        Case laCase = calculerCase(taillePourcentage);
        
        dessinerFond(laCase);
        dessinerContour(laCase);
    }
    
    private void dessinerFond(Case laCase) {
        J.appel(this);

        pinceau.fillRect(laCase.caseHautGaucheX,
				 laCase.caseHautGaucheY,
				 laCase.tailleCase,
				 laCase.tailleCase);
    }

    private void dessinerContour(Case laCase) {
        J.appel(this);
        
        pinceau.strokeRect(laCase.caseHautGaucheX,
				   laCase.caseHautGaucheY,
				   laCase.tailleCase,
				   laCase.tailleCase);
             
    }

    private Case calculerCase(double taillePourcentage) {
        J.appel(this);
        
        Case laCase = new Case();

        double largeurDessin = getWidth();
        double hauteurDessin = getHeight();
        
        laCase.tailleCase = largeurDessin * taillePourcentage;

        if(hauteurDessin < largeurDessin) {
            laCase.tailleCase = hauteurDessin * taillePourcentage;
        }
        
        laCase.caseHautGaucheX = (largeurDessin - laCase.tailleCase) / 2;
        laCase.caseHautGaucheY = (hauteurDessin - laCase.tailleCase) / 2;
        
        return laCase;
        
    }
    
    public void animerEntreeJeton() {
        J.appel(this);
        
        animationEntreeJeton.playFromStart();
    }

    public void animerSortieJeton() {
        J.appel(this);
        
        animationSortieJeton.playFromStart();
    }

    private void creerAnimationEntreeJeton() {
        J.appel(this);
        
        animationEntreeJeton = new Timeline();

        animationEntreeJeton.getKeyFrames().add(
                new KeyFrame(Duration.ZERO,
                             new KeyValue(this.translateYProperty(), -100),
                             new KeyValue(this.opacityProperty(), 0)));

        animationEntreeJeton.getKeyFrames().add(
                new KeyFrame(new Duration(100),
                             new KeyValue(this.translateYProperty(), 0),
                             new KeyValue(this.opacityProperty(), 1))); 
    }

	private void creerAnimationSortieJeton() {
        J.appel(this);
        
        animationSortieJeton = new Timeline();
        
        animationSortieJeton.getKeyFrames().add(
                new KeyFrame(Duration.ZERO,
                             new KeyValue(this.translateYProperty(), 0),
                             new KeyValue(this.opacityProperty(), 1)));

        animationSortieJeton.getKeyFrames().add(
                new KeyFrame(new Duration(100),
                             new KeyValue(this.translateYProperty(), 200),
                             new KeyValue(this.opacityProperty(), 0))); 
    }
}
