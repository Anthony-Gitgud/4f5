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


package tut07.pages.parametres;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import tut07.commandes.choisir_difficulte.ChoisirDifficulte;
import tut07.commandes.choisir_difficulte.ChoisirDifficultePourEnvoi;
import tut07.commandes.choisir_modeJeu.ChoisirModeJeu;
import tut07.commandes.choisir_modeJeu.ChoisirModeJeuPourEnvoi;
import tut07.enumerations.Difficulte;
import tut07.enumerations.ModeJeu;
import tut07.commandes.choisir_qui_commence.ChoisirQuiCommence;
import tut07.commandes.choisir_qui_commence.ChoisirQuiCommencePourEnvoi;
import tut07.commandes.choisir_taille_grille.ChoisirTailleGrillePourEnvoi;
import tut07.commandes.choisir_taille_grille.ChoisirTailleGrille;
import tut07.commandes.fermer_parametres.FermerParametres;
import tut07.commandes.fermer_parametres.FermerParametresPourEnvoi;
import tut07.enumerations.Couleur;
import tut07.enumerations.TailleGrille;
import tut07.pages.partie.composants.CaseAjustable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class VueParametres implements Vue, Initializable {
	
	private FermerParametresPourEnvoi fermerParametres;
	private ChoisirQuiCommencePourEnvoi choisirQuiCommence;
	private ChoisirTailleGrillePourEnvoi choisirTailleGrille;
	private ChoisirDifficultePourEnvoi choisirDifficulte;
	private ChoisirModeJeuPourEnvoi choisirModeJeu;

	@FXML 
	private CaseAjustable caseVert, caseOrange;
	
	@FXML
	private CheckBox checkVert, checkOrange;
	
	@FXML
	private Button boutonOk;
	
	@FXML
	private ComboBox<String> choixModeJeu;
	
	@FXML
	private ComboBox<String> choixDifficulte;

	@FXML
	private ComboBox<String> choixTaille;
	
	//ModeJeu
	private Map<String, ModeJeu> modeJeuSelonNom = new HashMap<>();
	private Map<ModeJeu, String> nomSelonModeJeu = new HashMap<>();
		
		//Difficulte
	private Map<String, Difficulte> difficulteSelonNom = new HashMap<>();
	private Map<Difficulte, String> nomSelonDifficulte = new HashMap<>();
	
	private Map<String, TailleGrille> tailleSelonNom = new HashMap<>();
	private Map<TailleGrille, String> nomSelonTaille = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(caseVert);
		DoitEtre.nonNul(caseOrange);
		DoitEtre.nonNul(checkVert);
		DoitEtre.nonNul(checkOrange);
		DoitEtre.nonNul(boutonOk);
		DoitEtre.nonNul(choixDifficulte);
		DoitEtre.nonNul(choixModeJeu);
		DoitEtre.nonNul(choixTaille);

		caseVert.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		caseOrange.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		
		initialiserChoixTaille(resources);
		initialiserChoixModeJeu(resources);
		initialiserChoixDifficulte(resources);
		//caseVert.afficherJeton(Couleur.VERT);
		//caseOrange.afficherJeton(Couleur.ORANGE);
	}
	
	public void animerCaseVert(){
		caseVert.afficherJeton(Couleur.VERT);
	}
	
	private void initialiserChoixTaille(ResourceBundle resources) {
		J.appel(this);

		for(TailleGrille tailleGrille : TailleGrille.values()) {
			
			String nomTaille = tailleGrille.name();
			
			choixTaille.getItems().add(nomTaille);
			
			tailleSelonNom.put(nomTaille, tailleGrille);
			nomSelonTaille.put(tailleGrille, nomTaille);
		}

		choixTaille.getSelectionModel().clearAndSelect(0);
	}
	
	private void initialiserChoixDifficulte(ResourceBundle resources) {
		J.appel(this);

		for(Difficulte difficulte : Difficulte.values()) {
			
			String nomDifficulte = difficulte.name();
			
			choixDifficulte.getItems().add(nomDifficulte);
			
			difficulteSelonNom.put(nomDifficulte, difficulte);
			nomSelonDifficulte.put(difficulte, nomDifficulte);
		}

		choixTaille.getSelectionModel().clearAndSelect(0);
	}
		

	private void initialiserChoixModeJeu(ResourceBundle resources) {
		J.appel(this);

		for(ModeJeu modeJeu : ModeJeu.values()) {
			
			String nomModeJeu = modeJeu.name();
			
			choixModeJeu.getItems().add(nomModeJeu);
			
			modeJeuSelonNom.put(nomModeJeu, modeJeu);
			nomSelonModeJeu.put(modeJeu, nomModeJeu);
		}

		choixModeJeu.getSelectionModel().clearAndSelect(0);
	}
	

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		fermerParametres = FabriqueCommande.obtenirCommandePourEnvoi(FermerParametres.class);
		choisirQuiCommence = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirQuiCommence.class);
		choisirTailleGrille = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirTailleGrille.class);
		choisirDifficulte = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirDifficulte.class);
		choisirModeJeu = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirModeJeu.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		checkVert.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				choisirQuiCommence.setCouleur(Couleur.VERT);
				choisirQuiCommence.envoyerCommande();
			}
		});
		
		checkOrange.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setCouleur(Couleur.ORANGE);
				choisirQuiCommence.envoyerCommande();
			}
		});

		boutonOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				fermerParametres.envoyerCommande();
			}
		});

		choixTaille.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				String nomTailleChoisie = choixTaille.getSelectionModel().getSelectedItem();
				
				TailleGrille tailleChoisie = tailleSelonNom.get(nomTailleChoisie);
				
				choisirTailleGrille.setTailleGrille(tailleChoisie);
				choisirTailleGrille.envoyerCommande();
			}
		});
		
		choixDifficulte.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				String nomDifficulteChoisie = choixDifficulte.getSelectionModel().getSelectedItem();
				
				Difficulte difficulteChoisie = difficulteSelonNom.get(nomDifficulteChoisie);
				
				choisirDifficulte.setDifficulte(difficulteChoisie);
				choisirDifficulte.envoyerCommande();
			}
		});
		
		
		choixModeJeu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				String nomModeJeuChoisi = choixModeJeu.getSelectionModel().getSelectedItem();
				
				ModeJeu modeJeuChoisi = modeJeuSelonNom.get(nomModeJeuChoisi);
				
				choisirModeJeu.setModeJeu(modeJeuChoisi);
				choisirModeJeu.envoyerCommande();
			}
		});
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherQuiCommence(Couleur couleur) {
		J.appel(this);
		
		DoitEtre.nonNul(couleur);

		switch(couleur) {
		
		case VERT:
			checkVert.setSelected(true);
			checkOrange.setSelected(false);
			break;

		case ORANGE:
			checkVert.setSelected(false);
			checkOrange.setSelected(true);
			break;
		
		}
	}

	public void afficherTailleGrille(TailleGrille tailleGrille) {
		J.appel(this);
		
		String nomTaille = nomSelonTaille.get(tailleGrille);
		
		int indiceTaille = choixTaille.getItems().indexOf(nomTaille);
		
		if(indiceTaille != -1) {
			choixTaille.getSelectionModel().clearAndSelect(indiceTaille);
		}
	}
	
	public void afficherDifficulte(Difficulte difficulte) {
		J.appel(this);
		
		String nomDifficulte = nomSelonDifficulte.get(difficulte);
		
		int indiceDifficulte = choixDifficulte.getItems().indexOf(nomDifficulte);
		
		if(indiceDifficulte != -1) {
			choixDifficulte.getSelectionModel().clearAndSelect(indiceDifficulte);
		}
	}
		
		public void afficherModeJeu(ModeJeu modeJeu) {
			J.appel(this);
			
			String nomModeJeu = nomSelonModeJeu.get(modeJeu);
			
			int indiceModeJeu = choixModeJeu.getItems().indexOf(nomModeJeu);
			
			if(indiceModeJeu != -1) {
				choixModeJeu.getSelectionModel().clearAndSelect(indiceModeJeu);
			}
		}

}
