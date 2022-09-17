package progetto;

import java.io.Serializable;

/**
 Questa classe implementa il concetto di Impiegato
  @author workgroup
*/
public class Impiegato extends Personale implements Serializable{
	/**
	 * Costruttore della classe Impiegato
	 * @param nome nome impiegato
	 * @param cognome cognome impiegato
	 * @param indirizzo indirizzo impiegato
	 * @param conto saldo attuale dell'impiegato
	 * @param mansione mansione impiegato
	 */
	public Impiegato(String nome, String cognome, String indirizzo, double conto, String mansione) {
		super(nome,cognome,indirizzo,conto);
		this.mansione = mansione;
	}
	
	/**
	  Restituisce la mansione assegnata ad un impiegato
	  @return mansione svolta
	 */
	public String getMansione() {
		return mansione;
	}
	
	/**
	 Assegna una mansione ad un impiegato 
	  @param mansione da svolgere
	 */
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	
	/**
	  Tramite questa operazione viene stipendiato un impiegato
	 */
	public void riceviPaga() {
		depositaInConto(PAGA);
	}
	
	/**
	 Questa operazione crea una stringa con tutti i dati riguardanti un impiegato
	 @return stringa di informazioni 
	 */
	public String toString() {
		return getClass().getSimpleName()+": [Nome = "+getNome()+", Cognome = "+getCognome()+", Indirizzo = "+getIndirizzo()+", Conto:"+getConto()+", Mansione = "+mansione+"]";
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
			Impiegato i = (Impiegato) o;
			return getNome().compareTo(i.getNome())==0&&getCognome().compareTo(i.getCognome())==0&&getIndirizzo().compareTo(i.getIndirizzo())==0&&mansione.compareTo(i.getMansione())==0;
		}
	}
	
	/**
	 * Clona l'oggetto chiamante
	 * @return un'istanza di Impiegato con valori dei campi identici a quelli dell'oggetto chiamante
	 */
	public Impiegato clone() {
		Impiegato cloned = (Impiegato) super.clone();
		return cloned;
	}

	private String mansione;
	private final double PAGA = 1200;
}