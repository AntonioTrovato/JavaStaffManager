package progetto;

import java.io.Serializable;

/**
 * Questa classe implementa il concetto di Personale di un'azienda
 * @author workgroup
 */
public abstract class Personale implements Cloneable,Serializable{
	public Personale(String n, String c, String i, double d) {
		nome = n;
		cognome = c;
		indirizzo = i;
		conto = d;
		assunto = false;
	}
	
	/**
	 * Restituisce il nome di un membro del personale
	 * @return nome del membro
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Restituisce il cognome di un membro del personale
	 * @return cognome membro
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Restituisce l'indirizzo di un membro del personale
	 * @return indirizzo di un membro
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * Questo metodo rende noto il saldo attuale del membro del personale
	 * @return conto attuale membro del personale
	 */
	public double getConto() {
		return conto;
	}
	
	/**
	 * Questo metodo ci indica se il membro del personale � stato assunto
	 * @return true se � stato assunto, false altrimenti
	 */
	public boolean getAssunto() {
		return assunto;
	}
	
	/**
	 * Questo metodo imposta il nome di un membro del personale
	 * @param nome da impostare
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Imposta il cognome di un membro del personale
	 * @param cognome da impostare
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 Questa operazione imposta l' indirizzo di un membro del personale 
	  @param indirizzo da impostare
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	/**
	 * Questa operazione imposta il conto di un membro del personale
	 * @param conto da impostare
	 */
	public void setConto(double conto) {
		this.conto = conto;
	}
	
	/**
	 * Questa operazione imposta lo stato di assunzione di un membro del personale
	 * @param a stato di assunzione da impostare
	 */
	public void setAssunto(boolean a) {
		assunto = a;
	}
	
	/**
	 * Questo metodo incrementa di un certo valore il saldo del conto di un membro del personale
	 * @param amount valore daaggiungere al saldo del membro del personale
	 */
	public void depositaInConto(double amount) {
		conto+=amount;
	}
	
	/**
	 * Tale metodo permette l'azione di pagamento di un membro del personale
	 */
	public abstract void riceviPaga();
	
	/**
	 * Tale metodo restituisce l'elenco di informazioni riguardanti un membro del personale
	 */
	public abstract String toString();
	
	/**
	 * Tale metodo verifica se due membri del personale hanno valori identici per ciascun attributo
	 */
	public abstract boolean equals(Object o);
	
	/**
	 Questa operazione richiama la clone di Object per ricreare degli oggetti identici all'istanza di Personale chiamante
	 @return il clone dell'oggetto chiamante, null altrimenti 
	 */
	public Personale clone() {
		try {
			Personale cloned = (Personale) super.clone();
			return cloned;
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	private String nome;
	private String cognome;
	private String indirizzo;
	public double conto;
	public boolean assunto;
}