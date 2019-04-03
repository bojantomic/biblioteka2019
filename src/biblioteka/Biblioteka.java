package biblioteka;

import java.util.LinkedList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterface;

public class Biblioteka implements BibliotekaInterface {
	
	private List<Knjiga> knjige = new LinkedList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga k) {
		if (k == null)
			throw new RuntimeException("Knjiga ne sme biti null");
		
		knjige.add(k);
	}

	@Override
	public void obrisiKnjigu(Knjiga k) {
		if (k == null)
			throw new RuntimeException("Knjiga ne sme biti null");

		knjige.remove(k);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		if (autor == null && isbn == null && naslov == null && izdavac == null)
			throw new RuntimeException("Morate uneti bar jedan kriterijum");
		
		LinkedList<Knjiga> rezultati = new LinkedList<Knjiga>();
		
		for (Knjiga knjiga: knjige)
			if (knjiga.getNaslov().contains(naslov))
				rezultati.add(knjiga);
		
		return rezultati;
	}

}