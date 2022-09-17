package progetto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Implementa il concetto di Reparto Operativo
 * @author workgroup
 *
 */
public class RepartoOperativo implements Serializable {
	/**
	 * Costruttore della classe Reparto Operativo
	 */
	public RepartoOperativo() {
		cantieri = new ArrayList<Cantiere>();
	}
	
	/**
	 * Riporta una lista di cantieri
	 * @return lista di cantieri
	 */
	public ArrayList<Cantiere> getCantieri() {
		return cantieri;
	}
	
	/**
	 * Imposta una lista di cantieri
	 * @param c lista cantieri da impostare
	 */
	public void setCantieri(ArrayList<Cantiere> c) {
		cantieri = c;
	}
	
	/**
	 * Restituisce un cantiere appartenente alla lista
	 * @param c cantiere cercato
	 * @return il cantiere cercato, null in caso di sua assenza
	 */
	public Cantiere getCantiere(Cantiere c) {
		int i;
		
		for(i=0;i<cantieri.size();i++)
			if(cantieri.get(i).equals(c))
				return cantieri.get(i);
		
		return null;
	}
	
	/**
	 * Permette l'aggiunta di un cantiere alla lista
	 * @param c cantiere da aggiungere
	 */
	public void addCantiere(Cantiere c) {
		cantieri.add(c);
	}
	
	/**
	 * Effettua la rimozione di un cantiere
	 * @param c cantiere da rimuovere
	 */
	public void removeCantiere(Cantiere c) {
		int i = 0;
		for(i=0;i<cantieri.size();i++) {
			Cantiere ca = cantieri.get(i);
			if(ca.equals(c)) {
				if(ca.getValore()>500000) {
					Dirigente d = (Dirigente) ca.getDirettore();
					d.setDirettore(false);
				}else {
					Quadro q = (Quadro) ca.getDirettore();
					q.setDirettore(false);
				}
				cantieri.remove(i);
			}
		}
	}
	
	/**
	 * Elenca tutti i cantieri in gestione
	 * @return lista dei cantieri
	 */
	public String showCantieri() {
		String s = "[ ";
		for(Cantiere c: cantieri)
			s+=c.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Restituisce la lista dei cantieri il cui valore � compreso tra altri 2
	 * @param x estremo inferiore/superiore
	 * @param y estremo inferiore/superiore
	 * @return lista dei cantieri che rispettano la richiesta
	 */
	public String reportCantieriInterValore(double x, double y) {
		String s = "[ ";
		if(Double.compare(x, y) <= 0) {
			for(Cantiere c: cantieri)
				if(Double.compare(x, c.getValore()) <= 0 && Double.compare(y, c.getValore()) >= 0)
					s+=c.toString()+"\n";
		}else {
			for(Cantiere c: cantieri)
			if(Double.compare(x, c.getValore()) >= 0 && Double.compare(y, c.getValore()) >= 0)
				s+=c.toString()+"\n";
		}
		return s+"]";
	}
	
	/**
	 * Restituisce la lista dei cantieri che hanno per direttore un dirigente
	 * @return lista dei cantieri che hanno per direttore un dirigente
	 */
	public String reportCantieriDirigenti() {
		String s = "[ ";
		for(Cantiere c: cantieri)
			if(c.getValore() > 500000)
				s+=c.toString()+"\n";
		return s;
	}
	
	/**
	 * Restituisce la lista dei cantieri che hanno per direttore un quadro
	 * @return lista dei cantieri che hanno per direttore un quadro
	 */
	public String reportCantieriQuadri() {
		String s = "[ ";
		for(Cantiere c: cantieri)
			if(c.getValore() <= 500000)
				s+=c.toString()+"\n";
		return s;
	}
	
	private ArrayList<Cantiere> cantieri;
}