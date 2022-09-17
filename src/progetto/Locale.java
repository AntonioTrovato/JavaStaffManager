package progetto;

import java.io.Serializable;

/**
 * Implementa il concetto di Locale
 * @author workgroup
 *
 */
public class Locale extends Ente implements Serializable{
	/**
	 * Costruttore del locale
	 * @param n nome ente
	 * @param a attivit� svolta
	 * @param r provincia di competenza
	 */
	public Locale(String n, String a, String r) {
		super(n,a);
		provincia = r;
	}
	
	/**
	 * Restituisce la provincia di competenza del locale
	 * @return provincia di competenza
	 */
	public String getProvincia() {
		return provincia;
	}
	
	/**
	 * Imposta la provincia di competenza del locale
	 * @param n provincia di competenza da assegnare
	 */
	public void setProvincia(String n) {
		provincia = n;
	}
	
	/**
	 Questa operazione crea una stringa con tutti i dati riguardanti un impiegato
	 @return stringa di informazioni 
	 */
	public String toString() {
		return getClass().getSimpleName()+" [nome = "+getNome()+", attivit� = "+getAttivita()+", provincia = "+getProvincia()+"]";
	}
	
	/**
	 * Verifica che l'oggetto chiamante e quello passato per parametro abbiano gli stessi valori per tutti i campi
	 * @param o oggetto da paragonare a quello chiamante
	 * @return true se i due oggetti sono uguali, false altrimenti
	 */
	public boolean equals(Object o) {
		if(o == null)
			return false;
		else if(getClass() != o.getClass())
			return false;
		else {
			Locale l = (Locale) o;
			return provincia.compareTo(l.getProvincia()) == 0;
		}
	}
	
	/**
	 * Clona l'oggetto chiamante
	 * @return un'istanza di Impiegato con valori identici a quelli dell'oggetto chiamante
	 */
	public Object clone() {
		Locale cloned = (Locale) super.clone();
		return cloned;
	}
	
	private String provincia;
}