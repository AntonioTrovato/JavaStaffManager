package progetto;

import java.io.Serializable;

/**
 * Classe che rappresenta il concetto di Ente
 * @author workgroup
 *
 */
public class Ente implements Cloneable, Serializable{
	/**
	 * Costruttore della classe
	 * @param n nome dell'ente 
	 * @param a attivit� svolta dall'ente
	 */
	public Ente(String n, String a) {
		nome = n;
		attivita = a;
	}
	
	/**
	 * Restituisce il nome dell'ente
	 * @return nome dell'ente
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Riporta l'attivit� pubblica fornita dall'ente
	 * @return attivit� offerta
	 */
	public String getAttivita() {
		return attivita;
	}
	
	/**
	 * Imposta il nome dell'ente
	 * @param nome da usare
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Imposta l'attivit� dell'ente
	 * @param p attivit� dell'ente
	 */
	public void setAttivita(String p) {
		attivita = p;
	}
	
	/**
	 * Indica le informazioni riguardanti la classe Ente
	 * @return la stringa contenente la lista degli attributi di Ente con i rispettivi valori
	 */
	public String toString() {
		return getClass().getSimpleName()+" [nome = "+nome+", attivit� offerta = "+attivita+"]";
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
			Ente e = (Ente) o;
			return nome.compareTo(e.getNome()) == 0 && attivita.compareTo(e.getAttivita()) == 0;
		}
	}
	
	/**
	 * Questa operazione richiama la clone di Object per ricreare degli oggetti identici all'istanza di Ente chiamante
	 * @return il clone dell'oggetto chiamante, null altrimenti
	 */
	public Object clone() {
		try {
			Ente cloned = (Ente) super.clone();
			return cloned;
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	private String nome;
	private String attivita;
}