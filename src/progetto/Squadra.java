package progetto;

import java.io.Serializable;
import java.util.ArrayList;

/**
  Quest classe implementa il concetto di Squadra 
  @author workgroup
 
 */
public class Squadra implements Cloneable,Serializable{
	
	/**
	 Costruttore Squadra
	  @param responsabile Quadro a capo della squadra
	  @param c cantiere a cui � assegnata la squadra
	 */
	public Squadra(Quadro responsabile, Cantiere c) {
		if(responsabile.getCapoSquadra() == false && responsabile.getAssunto() == true) {
			this.responsabile = responsabile;
			this.responsabile.setCapoSquadra(true);
		}else {
			System.out.println(responsabile.toString());
			throw new BusyWorkerException("Quadro gi� impegnato");
		}
		operai = new ArrayList<Operaio>();
		cantiere = c;
	}
	
	/**
	 Restituisce il Quadro a capo della squadra 
	  @return responsabile della squadra
	 */
	public Quadro getResponsabile() {
		return responsabile;
	}
	
	/**
	 Restituisce il cantiere in cui lavora la squadra 
	  @return cantiere cantiere assegnato alla squadra
	 */
	public Cantiere getCantiere() {
		return cantiere;
	}
	
	/**
	 * Restituisce la lista di operai impiegati nella squadra chiamante
	 * @return operai operai della squadra chiamante
	 */
	public ArrayList<Operaio> getOperai() {
		return operai;
	}
	
	/**
	 * Imposta un caposquadra
	 * @param q caposquadra da impostare
	 */
	public void setResponsabile(Quadro q) {
		responsabile.setCapoSquadra(false);//caposquadra attuale
		if(q.getAssunto())
			responsabile = q;
		else
			throw new FakeMemberException("Membro non assunto");
	}
	
	/**
	 * Imposta il cantiere nel quale � impiegata la squadra chiamante
	 * @param c cantiere da impostare
	 */
	public void setCantiere(Cantiere c) {
		cantiere = c;
	}
	
	/**
	 * Imposta la lista di operai impiegati nella squadra chiamante
	 * @param operai2 operai impiegati nella squadra chiamante
	 */
	public void setOperai(ArrayList<Operaio> operai2) {
		operai = operai2;
	}
	
	/**
	 Questa operazione crea un elenco di operai che fanno parte della squadra in forma di stringa
	  @return operai nella squadra
	 */
	public String toStringOperai() {
		String str = "";
		for(Operaio op: operai)
			str = str + op.toString() + "\n";
		return str;
	}
	
	/**
	 * Restituisce un operaio appartenente alla lista
	 * @param c cantiere cercato
	 * @return il cantiere cercato, null in caso di sua assenza
	 */
	public Operaio getOperaio(Operaio c) {
		int i;
		
		for(i=0;i<operai.size();i++)
			if(operai.get(i).equals(c))
				return operai.get(i);
		
		return null;
	}
	
	/**
 	  Questa operazione aggiunge un operaio alla squadra assicurandosi per� che non stia gi� lavorando ad un altro cantiere
	  @param op operaio da aggiungere
 	  @throws BusyWorkerException lanciata nel caso in cui l'operaio sia gi� impegnato in un altro cantiere
	 */
	public void addOpeario(Operaio op) throws BusyWorkerException{
		if(op.getLavora()==false && op.getAssunto() == true) {
			operai.add(op);
			op.setLavora(true);
		}else if(op.getLavora())
			throw new BusyWorkerException("Operaio gi� impegnato");
		else if(!op.getAssunto())
			throw new FakeMemberException("Operaio non assunto dall'azienda");
	}
	
	/**
	 Questa operazione rimuove un operaio da una squadra 
	  @param op operaio da rimuovere
	 */
	public void removeOperaio(Operaio op) {
		operai.remove(op);
		op.setLavora(false);
	}
	
	/**
	 Questa operazione cancella tutti gli operai ed il responsabile da una squadra 
	 */
	public void removeSquadra() {
		int i;
		for(i=operai.size()-1;i>=0;i--) {
			Operaio o = operai.get(i);
			removeOperaio(o);
		}
		responsabile.setCapoSquadra(false);
		responsabile = null;
	}
	
	/**
	 Questa operazione crea una copia della lista di operai all' interno di una squadra 
	  @param list lista da clonare
	  @return lista clone di quella passata come parametro
	 */
	public ArrayList<Operaio> cloneList(ArrayList<Operaio> list) {
	    ArrayList<Operaio> clone = new ArrayList<Operaio>(list.size());
	    for (Operaio item : list) 
	    	clone.add((Operaio)item.clone());
	    return clone;
	}
	
	/**
	 Questa operazione crea una stringa con tutti i dati riguardanti un impiegato
	 @return stringa di informazioni 
	 */
	public String toString() {
		return getClass().getSimpleName()+": [Responsabile = "+responsabile.toString()+", Operai:\n"+toStringOperai()+"]";
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
			Squadra sq = (Squadra) o;
			return responsabile.equals(sq.getResponsabile())&&toStringOperai().compareTo(sq.toStringOperai())==0;
		}
	}
	
	/**
	 * Clona l'oggetto chiamante
	 * @return un'istanza di Impiegato con valori dei campi identici a quelli dell'oggetto chiamante
	 */
	public Object clone() {
		try {
			Squadra cloned = (Squadra) super.clone();
			cloned.responsabile = (Quadro) responsabile.clone();
			cloned.operai = cloneList(operai);
			return cloned;
		}catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	private Cantiere cantiere;
	private Quadro responsabile;
	private ArrayList<Operaio> operai;
}