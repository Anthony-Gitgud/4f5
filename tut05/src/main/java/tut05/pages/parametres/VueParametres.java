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


package tut05.pages.parametres;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import tut05.commandes.choisir_difficulte.ChoisirDifficulte;
import tut05.commandes.choisir_difficulte.ChoisirDifficultePourEnvoi;
import tut05.commandes.choisir_modeJeu.ChoisirModeJeu;
import tut05.commandes.choisir_modeJeu.ChoisirModeJeuPourEnvoi;
import tut05.commandes.choisir_qui_commence.ChoisirQuiCommence;
import tut05.commandes.choisir_qui_commence.ChoisirQuiCommencePourEnvoi;
import tut05.commandes.choisir_taille_grille.ChoisirTailleGrillePourEnvoi;
import tut05.commandes.choisir_taille_grille.ChoisirTailleGrille;
import tut05.enumerations.Couleur;
import tut05.enumerations.Difficulte;
import tut05.enumerations.ModeJeu;
import tut05.enumerations.TailleGrille;
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
	
	private ChoisirQuiCommencePourEnvoi choisirQuiCommence;
	private ChoisirTailleGrillePourEnvoi choisirTailleGrille;
	private ChoisirDifficultePourEnvoi choisirDifficulte;
	private ChoisirModeJeuPourEnvoi choisirModeJeu;

	@FXML 
	private Button caseRouge, caseJaune;
	
	@FXML
	private CheckBox checkRouge, checkJaune;

	@FXML
	private ComboBox<String> choixTaille;
	
	@FXML
	private ComboBox<String> choixModeJeu;
	
	@FXML
	private ComboBox<String> choixDifficulte;
	
	private Map<String, TailleGrille> tailleSelonNom = new HashMap<>();
	private Map<TailleGrille, String> nomSelonTaille = new HashMap<>();
	
	//ModeJeu
	private Map<String, ModeJeu> modeJeuSelonNom = new HashMap<>();
	private Map<ModeJeu, String> nomSelonModeJeu = new HashMap<>();
	
	//Difficulte
	private Map<String, Difficulte> difficulteSelonNom = new HashMap<>();
	private Map<Difficulte, String> nomSelonDifficulte = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(caseRouge);
		DoitEtre.nonNul(caseJaune);
		DoitEtre.nonNul(checkRouge);
		DoitEtre.nonNul(checkJaune);
		DoitEtre.nonNul(choixTaille);
		DoitEtre.nonNul(choixDifficulte);
		DoitEtre.nonNul(choixModeJeu);

		caseRouge.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		caseJaune.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		
		initialiserChoixTaille(resources);
		initialiserChoixModeJeu(resources);
		initialiserChoixDifficulte(resources);

		
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

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		choisirQuiCommence = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirQuiCommence.class);
		choisirTailleGrille = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirTailleGrille.class);
		choisirDifficulte = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirDifficulte.class);
		choisirModeJeu = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirModeJeu.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		checkRouge.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				choisirQuiCommence.setCouleur(Couleur.ROUGE);
				choisirQuiCommence.envoyerCommande();
			}
		});
		
		checkJaune.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setCouleur(Couleur.JAUNE);
				choisirQuiCommence.envoyerCommande();
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
		
		case ROUGE:
			checkRouge.setSelected(true);
			checkJaune.setSelected(false);
			break;

		case JAUNE:
			checkRouge.setSelected(false);
			checkJaune.setSelected(true);
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

