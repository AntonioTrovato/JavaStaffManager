package progetto;

import java.io.Serializable;

/**
 * Questa classe implementa il concetto di Quadro
 * @author workgroup
 */
public class Quadro extends Personale implements Serializable {
	/**
	 * Costruttore di un'istanza di Quadro
	 * @param nome nome del quadro
	 * @param cognome cognome del quadro
	 * @param indirizzo indirizzo del quadro
	 * @param conto conto attuale del quadro
	 */
	public Quadro(String nome, String cognome, String indirizzo, double conto) {
		super(nome,cognome,indirizzo,conto);
	}
	
	/**
	 * Indica se l'istanza chiamante � caposquadra
	 * @return true se � caposquadra, false altrimenti
	 */
	public boolean getCapoSquadra() {
		return capoSquadra;
	}
	
	/**
	 * Indica se l'stanza chiamante � direttore di un cantiere
	 * @return tue in caso affermativo, false altrimenti
	 */
	public boolean getDirettore() {
		return direttore;
	}
	
	/**
	 * Aggiorna lo stato di caposquadra di un quadro
	 * @param capoSquadra vale true se all'istanza chiamante � assegnato il compito di caposquadra, false nel caso opposto
	 */
	public void setCapoSquadra(boolean capoSquadra) {
		this.capoSquadra = capoSquadra;
	}
	
	/**
	 * Aggiorna lo stato di direttore di cantiere di un quadro
	 * @param d vale true se all'istanza chiamante � assegnato il compito di direttore di cantiere, false nel caso opposto
	 */
	public void setDirettore(boolean d) {
		direttore = d;
	}
	
	/**
	 * Tale metodo permette la ricezione da parte dell'istanza chiamante del suo stipendio
	 */
	public void riceviPaga() {
		if(capoSquadra)
			depositaInConto(PAGA + ((5*PAGA)/100)); //se lavora come caposquadra gli viene dato il 5% in pi�
		else if(direttore)
			depositaInConto(PAGA + ((5*PAGA)/100)); //se lavora come direttore gli viene dato il 10% in pi�
		else
			depositaInConto(PAGA);
	}
	
	/**
	 Questa operazione crea una stringa con tutti i dati riguardanti un quadro
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
			Quadro q = (Quadro) o;
			return getNome().compareTo(q.getNome())==0&&getCognome().compareTo(q.getCognome())==0&&getIndirizzo().compareTo(q.getIndirizzo())==0;
		}
	}
	
	/**
	 * Clona l'oggetto chiamante
	 * @return un'istanza di Impiegato con valori dei campi identici a quelli dell'oggetto chiamante
	 */
	public Quadro clone() {
		Quadro cloned = (Quadro) super.clone();
		return cloned;
	}
	
	private boolean capoSquadra;
	private boolean direttore;
	private final double PAGA = 1800.0;
}
