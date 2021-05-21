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


package tut03.pages.partie.modeles;
import tut03.enumerations.Couleur;
import tut03.enumerations.Difficulte;
import tut03.enumerations.ModeJeu;
import ntro.debogage.J;

public class Jeton implements JetonLectureSeule {
	
	private Couleur couleur;
	private transient int indiceColonne;
	private transient int indiceRangee;
	private Difficulte difficulte;
	private ModeJeu modeJeu;
	
	@Override
	public Difficulte getDifficulte() {
		J.appel(this);

		return difficulte;
	}
	
	@Override
	public ModeJeu getModeJeu() {
		J.appel(this);

		return modeJeu;
	}

	@Override
	public Couleur getCouleur() {
		J.appel(this);

		return couleur;
	}

	@Override
	public int getIndiceRangee() {
		J.appel(this);

		return indiceRangee;
	}

	@Override
	public int getIndiceColonne() {
		J.appel(this);

		return indiceColonne;
	}
	
	public void setIndiceColonne(int indiceColonne) {
		J.appel(this);
		
		this.indiceColonne = indiceColonne;
	}
	
	public void setIndiceRangee(int indiceRangee) {
		J.appel(this);
		
		this.indiceRangee = indiceRangee;
	}

	public void setModeJeu (ModeJeu modeJeu) {
		J.appel(this);
		
		this.modeJeu = modeJeu;
	}
	
	public void setDifficulte(Difficulte difficulte) {
		J.appel(this);
		
		this.difficulte = difficulte;
	}
	
	public void setCouleur(Couleur couleur) {
		J.appel(this);
		
		this.couleur = couleur;
	}
}
