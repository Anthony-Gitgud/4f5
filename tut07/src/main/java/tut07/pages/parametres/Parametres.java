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

import tut07.enumerations.Couleur;
import tut07.enumerations.TailleGrille;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;
import tut07.enumerations.Difficulte;
import tut07.enumerations.ModeJeu;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {
	
	private Couleur quiCommence;
	private TailleGrille tailleGrille;
	private Difficulte difficulte;
	private ModeJeu modeJeu;

	@Override
	public void apresCreation() {
		J.appel(this);

		quiCommence = Couleur.ORANGE;
		tailleGrille = TailleGrille.MOYENNE;
		modeJeu = ModeJeu.SOLO;
		difficulte = Difficulte.MOYENNE;
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);
		
		DoitEtre.nonNul(quiCommence);
		DoitEtre.nonNul(tailleGrille);
		DoitEtre.nonNul(modeJeu);
		DoitEtre.nonNul(difficulte);
	}

	@Override
	public Couleur getQuiCommence() {
		J.appel(this);

		return quiCommence;
	}

	public void choisirQuiCommence(Couleur joueurQuiCommence) {
		J.appel(this);
		
		this.quiCommence = joueurQuiCommence;
	}
	
	public void choisirModeJeu(ModeJeu modeJeu) {
		J.appel(this);
		
		this.modeJeu = modeJeu;
	}
	public void choisirDifficulte(Difficulte difficulte) {
		J.appel(this);
		
		this.difficulte = difficulte;
	}

	public void choisirTailleGrille(TailleGrille tailleGrille) {
		J.appel(this);
		
		this.tailleGrille = tailleGrille;
	}
	
	@Override
	public Difficulte getDifficulte() {
		return difficulte;
	}
	@Override
	public ModeJeu getModeJeu() {
		return modeJeu;
	}

	@Override
	public TailleGrille getTailleGrille() {
		return tailleGrille;
	}
}
