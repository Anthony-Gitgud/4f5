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

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import tut05.commandes.choisir_difficulte.ChoisirDifficulteRecue;
import tut05.commandes.choisir_difficulte.ChoisirDifficulte;
import tut05.commandes.choisir_modeJeu.ChoisirModeJeu;
import tut05.commandes.choisir_modeJeu.ChoisirModeJeuRecu;
import tut05.commandes.choisir_qui_commence.ChoisirQuiCommence;
import tut05.commandes.choisir_qui_commence.ChoisirQuiCommenceRecue;
import tut05.commandes.choisir_taille_grille.ChoisirTailleGrille;
import tut05.commandes.choisir_taille_grille.ChoisirTailleGrilleRecue;
import tut05.enumerations.Couleur;
import tut05.enumerations.Difficulte;
import tut05.enumerations.ModeJeu;
import tut05.enumerations.TailleGrille;

public class   ControleurParametres 
       extends ControleurModeleVue<ParametresLectureSeule, 
                                   Parametres,
                                   VueParametres,
                                   AfficheurParametres> {
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirQuiCommence.class, new RecepteurCommandeMVC<ChoisirQuiCommenceRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirQuiCommenceRecue commande) {
				J.appel(this);
				
				Couleur quiCommence = commande.getCouleur();

				DoitEtre.nonNul(quiCommence);

				getModele().choisirQuiCommence(quiCommence);
			}
		});
		//MODEJEU
		installerRecepteurCommande(ChoisirModeJeu.class, new RecepteurCommandeMVC<ChoisirModeJeuRecu>() {
			@Override
			public void executerCommandeMVC(ChoisirModeJeuRecu commande) {
				J.appel(this);
				
				ModeJeu modeJeu = commande.getModeJeu();

				DoitEtre.nonNul(modeJeu);

				getModele().choisirModeJeu(modeJeu);
			}
		});
		//DIFFICULTE
		installerRecepteurCommande(ChoisirDifficulte.class, new RecepteurCommandeMVC<ChoisirDifficulteRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirDifficulteRecue commande) {
				J.appel(this);
				
				Difficulte difficulte = commande.getDifficulte();

				DoitEtre.nonNul(difficulte);

				getModele().choisirDifficulte(difficulte);
			}
		});
		
		installerRecepteurCommande(ChoisirTailleGrille.class, new RecepteurCommandeMVC<ChoisirTailleGrilleRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirTailleGrilleRecue commande) {
				J.appel(this);
				
				TailleGrille tailleGrille = commande.getTailleGrille();
				
				DoitEtre.nonNul(tailleGrille);
				
				getModele().choisirTailleGrille(tailleGrille);
			}
		});
	}


	@Override
	protected void demarrer() {
		J.appel(this);
	} 

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}
}
