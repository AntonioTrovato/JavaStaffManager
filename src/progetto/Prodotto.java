package progetto;

import java.io.Serializable;

/**
 * Implementazione del concetto di Prodotto
 * @author workspace
 *
 */
public class Prodotto implements Cloneable,Serializable{
	/**
	 * Costruttore di un'istanza di tipo Prodotto
	 * @param c codice prodotto
	 * @param n nome prodotto
	 */
	public Prodotto(String c, String n) {
		cod = c;
		nome = n;
	}
	
	/**
	 * Riporta il codice del prodotto
	 * @return codice prodotto
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * Riporta il nome del prodotto
	 * @return nome prodotto
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Imposta il codice di un prodotto
	 * @param c codice da impostare
	 */
	public void setCod(String c) {
		cod = c;
	}
	
	/**
	 * Imposta il nome di un prodotto
	 * @param n nome da impostare
	 */
	public void setNome(String n) {
		nome = n;
	}
	
	/**
	 Questa operazione crea una stringa con tutti i dati riguardanti un impiegato
	 @return stringa di informazioni 
	 */
	public String toString() {
		return getClass().getSimpleName()+" [codice = "+cod+", nome del prodotto = "+nome+"]";
	}
	
	/**
	 * Verifica che l'oggetto chiamante e quello passato per parametro abbiano gli stessi valori per tutti i campi
	 * @param o oggetto da paragonare a quello chiamante
	 * @return true se i due oggetti hanno gli stessi valori per tutti i campi, false altrimenti
	 */
	public boolean equals(Object o) {
		if(o == null)
			return false;
		else if(getClass() != o.getClass())
			return false;
		else {
			Prodotto p = (Prodotto) o;
			return cod.compareTo(p.getCod())==0&&nome.compareTo(p.getNome())==0;
		}
	}
	
	/**
	 * Clona l'oggetto chiamante
	 * @return un'istanza di Impiegato con valori dei campi identici a quelli dell'oggetto chiamante
	 */
	public Object clone() {
		try {
			Prodotto cloned = (Prodotto) super.clone();
			return cloned;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}
	
	private String cod;
	private String nome;
}