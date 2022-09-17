package progetto;

import java.io.Serializable;

/**
 * Implementa il concetto di Cliente
 * @author workgroup
 *
 */
public class Cliente implements Cloneable,Serializable{
	/**
	 * Costruttore di  Cliente
	 * @param n nome del cliente
	 * @param i indirizzo cliente
	 * @param c cognome del cliente
	 */
	public Cliente(String n, String i, String c) {
		nome = n;
		indirizzo = c;
		cognome = i;
	}
	
	/**
	 * Riporta il nome del cliente
	 * @return nome del cliente
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Riporta l'indirizzo del cliente
	 * @return indirizzo del cliente
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * Riporta il cognome del responsabile del cliente
	 * @return cognome del cliente
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Imposta il nome del cliente
	 * @param n nome
	 */
	public void setNome(String n) {
		nome = n;
	}
	
	/**
	 * Assegna un indirizzo al cliente
	 * @param i indirizzo da assegnare
	 */
	public void setIndirizzo(String i) {
		indirizzo = i;
	}
	
	/**
	 * Imposta il cognome del cliente
	 * @param c cognome
	 */
	public void setCognome(String c) {
		cognome = c;
	}
	
	/**
	 * Indica le informazioni riguardanti la classe Cliente
	 * @return la stringa contenente la lista degli attributi di Cliente con i rispettivi valori
	 */
	public String toString() {
		return getClass().getSimpleName()+" [nome = "+nome+", cognome = "+cognome+", indirizzo = "+indirizzo+"]";
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
			Cliente c = (Cliente) o;
			return nome.compareTo(c.getNome()) == 0 && indirizzo.compareTo(c.getIndirizzo()) == 0 && cognome.compareTo(c.getCognome()) == 0;
		}
	}
	
	/**
	 * Questa operazione richiama la clone di Object per ricreare degli oggetti identici all'istanza di Ente chiamante
	 * @return il clone dell'oggetto chiamante, null altrimenti
	 */
	public Object clone() {
		try {
			Cliente cloned = (Cliente) super.clone();
			return cloned;
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	private String nome;
	private String indirizzo;
	private String cognome;
}