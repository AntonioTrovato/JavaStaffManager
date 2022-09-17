package progetto;

import java.io.Serializable;

/**
 * Implementa il concetto di Fornitore
 * @author Workgroup
 *
 */
public class Fornitore implements Cloneable,Serializable{
	/**
	 * Costruttore di Forntore
	 * @param n nome del fornitore
	 * @param i indirizzo del fornitore
	 * @param p prodotto fornito
	 */
	public Fornitore(String n, String i, Prodotto p) {
		nome = n;
		indirizzo = i;
		prodotto = p;
	}
	
	/**
	 * Indica il nome del fornitore
	 * @return nome del fornitore
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Indica l'indirizzo del fornitore
	 * @return indirizzo del fornitore
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * Indica il prodotto fornito dal fornitore
	 * @return prodotto fornito
	 */
	public Prodotto getProdotto() {
		return prodotto;
	}
	
	/**
	 * Imposta il nome del fornitore
	 * @param n nome da impostare
	 */
	public void setNome(String n) {
		nome = n;
	}
	
	/**
	 * Imposta l'indirizzo del fornitore
	 * @param i indirizzo da impostare
	 */
	public void setIndirizzo(String i) {
		indirizzo = i;
	}
	
	/**
	 * Imposta un prodotto
	 * @param p prodotto da impostare
	 */
	public void setProdotto(Prodotto p) {
		prodotto = p;
	}
	
	/**
	 * Indica le informazioni riguardanti la classe Fornitore
	 * @return la stringa contenente la lista degli attributi di Fornitori con i rispettivi valori
	 */
	public String toString() {
		return getClass().getSimpleName()+" [nome = "+nome+", indirizzo = "+indirizzo+", prodotto = "+prodotto+"]";
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
			Fornitore f = (Fornitore) o;
			return nome.compareTo(f.getNome()) == 0 && indirizzo.compareTo(f.getIndirizzo()) == 0 && prodotto.equals(f.getProdotto());
		}
	}
	
	/**
	 * Questa operazione richiama la clone di Object per ricreare degli oggetti identici all'istanza di Personale chiamante
	 * @return il clone dell'oggetto chiamante, null altrimenti
	 */
	public Object clone() {
		try {
			Fornitore cloned = (Fornitore) super.clone();
			return cloned;
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	private String nome;
	private String indirizzo;
	private Prodotto prodotto;
}