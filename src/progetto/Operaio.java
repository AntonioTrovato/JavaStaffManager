package progetto;

import java.io.Serializable;

/**
 * Implementa il concetto di Operaio
 * @author anton
 *
 */
public class Operaio extends Personale implements Serializable{
	/**
	 * Costruttore di un'istanza di Operaio
	 * @param nome nome dell'operaio
	 * @param cognome cognome dell'operaio
	 * @param indirizzo indirizzo dell'operaio
	 * @param conto conto attuale dell'operaio
	 */
	public Operaio(String nome, String cognome, String indirizzo, double conto) {
		super(nome,cognome,indirizzo,conto);
	}
	
	/**
	 * Indica se istanza chiamante � gi� impegnata in un cantiere 
	 * @return true se gi� impegnata, false altrimenti
	 */
	public boolean getLavora() {
		return lavora;
	}
	
	/**
	 * Assegna o toglie un lavoro all'istanza chiamante come operaio in un cantiere
	 * @param lavora true se all'istanza � assegnato un cantiere, false altrimenti
	 */
	public void setLavora(boolean lavora) {
		this.lavora = lavora;
	}
	
	/**
	  Tramite questa operazione viene stipendiato un impiegato
	 */
	public void riceviPaga() {
		depositaInConto(PAGA);
	}
	
	/**
	 Questa operazione crea una stringa con tutti i dati riguardanti un operaio
	 @return stringa di informazioni 
	 */
	public String toString() {
		return getClass().getSimpleName()+": [Nome = "+getNome()+", Cognome = "+getCognome()+", Indirizzo = "+getIndirizzo()+", Conto:"+getConto()+"]";
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
			Operaio op = (Operaio) o;
			return getNome().compareTo(op.getNome())==0&&getCognome().compareTo(op.getCognome())==0&&getIndirizzo().compareTo(op.getIndirizzo())==0;
		}
	}
	
	/**
	 * Clona l'oggetto chiamante
	 * @return un'istanza di Impiegato con valori dei campi identici a quelli dell'oggetto chiamante
	 */
	public Operaio clone() {
		Operaio cloned = (Operaio) super.clone();
		return cloned;
	}
	
	private boolean lavora;
	private final int PAGA = 1000;
}