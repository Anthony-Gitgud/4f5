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


package tut07.pages.partie.vues;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import tut07.Constantes;
import tut07.commandes.jouer_ici.JouerIci;
import tut07.commandes.jouer_ici.JouerIciPourEnvoi;
import tut07.enumerations.Couleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import tut07.pages.partie.composants.ConteneurEntetes;
import tut07.pages.partie.composants.ConteneurGrille;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public abstract class VuePartie implements Vue, Initializable {

    @FXML
    private ConteneurEntetes conteneurEntetes;

    @FXML
    private ConteneurGrille conteneurGrille;

	private Button[][] cases;
    
    //private Button[] entetes;
    
    //private Button[][] cases;

	//private JouerIciPourEnvoi jouerIciPourEnvoi;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurEntetes);
		DoitEtre.nonNul(conteneurGrille);
	} 

    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);

        //creerEntetes(largeur);
        
        //creerColonnes(largeur, hauteur);
        
        conteneurEntetes.creerEntetes(largeur);
        conteneurGrille.creerGrille(largeur, hauteur);
        
    }
    
  //  private void creerEntetes(int largeur) {
  //      J.appel(this);
        
   //     entetes = new Button[largeur];
        
   //     for(int indiceRangee = 0; indiceRangee < largeur; indiceRangee++) {
        	
   //     	Button entete = new Button("|");
        	
   //     	entete.setMinWidth(Constantes.TAILLE_CASE);
    //    	entete.setMaxWidth(Constantes.TAILLE_CASE);
        	
   //     	entetes[indiceRangee] = entete;
        	
    //    	conteneurEntetes.getChildren().add(entete);
    //    }
  //  }

  //  private void creerColonnes(int largeur, int hauteur) {
   //     J.appel(this);
        
    //    cases = new Button[largeur][hauteur];

   //     for(int indiceRangee = 0; indiceRangee < hauteur; indiceRangee++) {
   //     	HBox ligne = creerLigne(indiceRangee, largeur);
        	
    //    	conteneurGrille.getChildren().add(ligne);
   //     }
  //  }

  //  private HBox creerLigne(int indiceRangee, int largeur) {
   //     J.appel(this);
        
  //      HBox ligne = new HBox();
        
   //     for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
        	
    //    	Button _case = new Button();
        	
      //  	_case.setMinWidth(Constantes.TAILLE_CASE);
      //  	_case.setMaxWidth(Constantes.TAILLE_CASE);
        	
      //  	cases[indiceColonne][indiceRangee] = _case;
        	
       // 	ligne.getChildren().add(_case);
     //   }
        
    //    return ligne;
  //  }
    

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		conteneurEntetes.obtenirJouerIciPourEnvoi();
		//jouerIciPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		conteneurEntetes.installerCapteursJouerIci();
		
		//for(int i = 0; i < entetes.length; i++) {
			
		//	final int indiceColonne = i;
			
		//	entetes[i].setOnAction(new EventHandler<ActionEvent>() {
		//		@Override
		//		public void handle(ActionEvent event) {
		//			J.appel(this);
				
					
		//			jouerIciPourEnvoi.setIndiceColonne(indiceColonne);
		//			jouerIciPourEnvoi.envoyerCommande();
				}
		//	});
		//}
	//}
	
	public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);
		
		conteneurGrille.afficherJeton(indiceColonne, indiceRangee, couleur);
	}


	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		conteneurEntetes.verifierCommandesPossibles();
	} 
	
	public void animerEntreeJeton(int indiceColonne, int indiceRangee) {
		J.appel(this);
		
		conteneurGrille.animerEntreeJeton(indiceColonne, indiceRangee);
	}
	
	
	
	//private boolean siIndicesValides(int indiceColonne, int indiceRangee) {
	//	J.appel(this);

	//	boolean siValide = false;
		
	//	if(indiceColonne >= 0 && indiceColonne < cases.length) {
		//	siValide = indiceRangee >= 0 && indiceRangee < cases[indiceColonne].length;
		//}
		
		//return siValide;
	//}

	//*public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		//J.appel(this);
		
		//if(siIndicesValides(indiceColonne, indiceRangee)) {

			//Button _case = cases[indiceColonne][indiceRangee];
			
			//switch(couleur) {
			//	case ORANGE:
			//		_case.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
			//		break;

			//	case VERT:
			//		_case.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
			//		break;
			//}
		//}
	}

//}
