package donnees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * la classe CD contient toute l'information associee a un CD.</p>
 * 
 * elle est caracterisee par
 * <ul>
 * <li>le nom de l'artiste du CD
 * <li>le titre du D
 * <li>l'ensemble des pistes du CD
 * </ul>
 * 
 * Cette classe est utilisee par le magasin qui rassemble une liste de CDs.
 * 
 */
public class CD {

	/**
	 * constante pour definir comment afficher une separation entre les elements
	 * dans toString
	 */
	private static final String SEPARATOR = "--------------------------------------\n";

	/**
	 * les attributs du CD
	 */
	private String nomArtiste;
	private String nomCD;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CD cd = (CD) o;
		return Objects.equals(nomArtiste, cd.nomArtiste) && Objects.equals(nomCD, cd.nomCD) && Objects.equals(pistes, cd.pistes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomArtiste, nomCD, pistes);
	}

	/**
	 * les pistes du CD
	 */
	private List<InfoPiste> pistes;

	/**
	 * constructeur simple, cree un CD sans aucune piste
	 * 
	 * @param artiste
	 *            nom de l'artiste qui a fait le C
	 * @param nomCDParam
	 *            titre du CD
	 */
	public CD(String artiste, String nomCDParam) {
		this.nomArtiste = artiste;
		this.nomCD = nomCDParam;

		this.pistes = new ArrayList<InfoPiste>();
	}

	/**
	 * ajoute une piste en fin de CD
	 *
	 * @param infoPiste
	 *            les informations concernant la piste (duree et titre)
	 */
	public void ajouterPiste(InfoPiste infoPiste) {
		pistes.add(infoPiste);
	}

	@Override
	/**
	 * retourne le descriptif d'un CD
	 * <ul>
	 * <li> affiche les informations du CD
	 * <li> puis les informations des pistes du CD
	 * </ul>
	 */
	public String toString() {
		String r = SEPARATOR;
		r += this.nomArtiste + " - " + this.nomCD + " (" + pistes.size()
				+ " pistes)\n";
		// ajoute les pistes
		for (int i = 0; i < this.pistes.size(); i++) {
			InfoPiste piste = pistes.get(i);
			r += "   ." + numeroPiste(i) + ". " + piste + "\n";
		}
		r += SEPARATOR;
		return (r);
	}

	/**
	 * retourne une chaine correspondant au numero de piste (sur deux char) pour
	 * pouvoir afficher les pistes sans decalage
	 *
	 * @param i
	 *            le numero
	 * @return la chaine sous deux caracteres
	 */
	private String numeroPiste(int i) {
		int numPiste = i + 1;
		String resultat = "" + numPiste;
		if (numPiste < 10)
			resultat = "0" + resultat;
		return (resultat);
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public String getNomCD() {
		return nomCD;
	}

	public static CD comparerCDAlbum(CD min, CD actuel) {
		String titre = min.getNomCD();
		CD cd = min;
		if (titre.compareTo(actuel.getNomCD()) > 0) {
			cd = actuel;
		}
		return cd;
	}

	public static CD comparerCDArtiste(CD min, CD actuel) {
		String artiste = min.getNomArtiste();
		CD cd = min;
		if (artiste.compareTo(actuel.getNomArtiste()) > 0) {
			cd = actuel;
		}
		return cd;
	}

	public String toStringTest() {
		return this.nomArtiste + " - " + this.nomCD+"\n";
	}

}
