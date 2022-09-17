package progetto;

import java.io.Serializable;

/**
  Questa classe implementa il concetto di Dirigente
  @author workgroup
 
 */
public class Dirigente extends Personale implements Serializable{
	/**
	  Costruttore Dirigente
	  @param nome nome dirigente
	  @param cognome cognome dirigente
	  @param indirizzo indirizzo dirigente
	  @param conto saldo attuale del dirigente
	 */
	public Dirigente(String nome, String cognome, String indirizzo, double conto) {
		super(nome,cognome,indirizzo,conto);
	}
	
	/**
	 Questa indica se il Dirigente � stato assegnato ad un cantiere come direttore  
	  @return false se non � un direttore o true se lo �
	 */
	public boolean getDirettore() {
		return direttore;
	}
	
	/**
	 Questa operazione ci permette di aggiornare lo status di direttore di un cantiere 
	  @param d true se l'oggetto chiamante va assegnato come direttore di un cantiere, false nel caso opposto
	 */
	public void setDirettore(boolean d) {
		direttore = d;
	}
	
	/**
	 Questa operazione assegna una paga al dirigente, se egli lavora come direttore ha diritto al 15% in pi�
	 del suo stipendio di base
	 */
	public void riceviPaga() {
		if(direttore)
			depositaInConto(PAGA + ((15*PAGA)/100));
		else
			depositaInConto(PAGA);
	}
	
	/**
	  Restituisce tutte le informazioni riguardanti il dirigente sottoforma di stringa
	 @return informazioni del dirigente 
	 */
	public String toString() {
		return getClass().getSimpleName()+": [Nome = "+getNome()+", Cognome = "+getCognome()+", Indirizzo = "+getIndirizzo()+", Conto ="+getConto()+"]";
	}

	/**
	 * Verifica che l'oggetto chiamante e quello passato per parametro abbiano gli stessi valori per tutti i campi
	 * @param o oggetto da paragonare a quello chiamante
	 * @return true se i due oggetti hanno gli stessi valori per tutti i campi, false altrimenti
	 */
	public boolean equals(Object o) {
		if(o == null)
			return false;
		else if(o.getClass() != getClass())
			return false;
		else {
			Dirigente d = (Dirigente) o;
			return getNome().compareTo(d.getNome())==0&&getCognome().compareTo(d.getCognome())==0&&getIndirizzo().compareTo(d.getIndirizzo())==0;
		}
	}
	
	/**
	 * Clona l'oggetto chiamante
	 * @return un'istanza di Impiegato con valori dei campi identici a quelli dell'oggetto chiamante
	 */
	public Dirigente clone() {
		Dirigente cloned = (Dirigente) super.clone();
		return cloned;
	}
	
	private boolean direttore;
	private final double PAGA = 2000.0;
}