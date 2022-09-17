package progetto;

import java.io.Serializable;
import java.util.ArrayList;
/**
	Questa classe implementa il concetto di cantiere 
  @author Workgroup
 
 */
public class Cantiere implements Cloneable,Serializable{
	/**
	  Costruttore cantiere
	  @param valore valore del cantiere
	  @param nome nome del cantiere
	  @param p membro del personale che diventer� direttore del cantiere
	  @throws FakeMemberException nel caso in cui il membro del personale non sia stato effettivamente assunto
	  @throws ManagerException nel caso in cui il direttore del cantiere non sia del tipo adeguato
	 */
	public Cantiere(double valore, String nome, Personale p) throws FakeMemberException, ManagerException{
		this.valore = valore;
		nomeCantiere = nome;
		squadre = new ArrayList<Squadra>();
		if(valore>500000) {
			if(p.getClass().getSimpleName().compareTo("Dirigente")==0 && p.getAssunto() == true) {
				direttore = p;
				Dirigente d = (Dirigente) p;
				d.setDirettore(true);
			}else if(!p.getAssunto())
				throw new FakeMemberException("Membro non assunto dall'azienda");
			else
				throw new ManagerException("Il manager deve essere un dirigente");
		}else {
			if(p.getClass().getSimpleName().compareTo("Quadro")==0 && p.getAssunto() == true) {
				direttore = p;
				Quadro q = (Quadro) p;
				q.setDirettore(true);
			}else if(!p.getAssunto())
				throw new FakeMemberException("Membro non assunto dall'azienda");
			else
				throw new ManagerException("Il manager deve essere un quadro");
		}
	}
	
	/**
	  Restituisce il nome del cantiere
	  @return nome nome cantiere
	 */
	public String getNomeCantiere() {
		return nomeCantiere;
	}
	
	/**
	  Restituisce il direttore assegnato al cantiere
	  @return direttore direttore cantiere
	 */
	public Personale getDirettore() {
		return direttore;
	}
	
	/**
	  Restituisce il valore del cantiere
	  @return valore valore cantiere
	 */
	public double getValore() {
		return valore;
	}
	
	/**
	 * Imposta le squadre che sono impegniate nel cantiere chiamante
	 * @return squadre lla lista delle squadre impegniate
	 */
	public ArrayList<Squadra> getSquadre() {
		return squadre;
	}
	
	/**
	 * Imposta il nome del cantiere
	 * @param n nome cantiere
	 */
	public void setNomeCantiere(String n) {
		nomeCantiere = n;
	}
	
	/**
	 * Questa operazione imposta il direttore del cantiere
	 * @param p Pu� essere un Dirigente o un Quadro soltanto
	 * @throws FakeMemberException nel caso in cui il membro del personale non sia stato effettivamente assunto
	 * @throws ManagerException nel caso in cui il direttore del cantiere non sia del tipo adeguato
	 */
	public void setDirettore(Personale p) throws ManagerException, FakeMemberException{
		if(valore>500000) {
			if(direttore!=null) {
				Dirigente d = (Dirigente) p;//il direttore attuale
				d.setDirettore(false);
			}
			if(p.getClass().getSimpleName().compareTo("Dirigente")==0 && p.getAssunto() == true) {
				direttore = p;
				Dirigente d = (Dirigente) p;
				d.setDirettore(true);
			}else if(!p.getAssunto())
				throw new FakeMemberException("Membro non assunto dall'azienda");
			else
				throw new ManagerException("Il manager deve essere un dirigente");
		}else {
			if(direttore!=null) {
				Quadro d = (Quadro) p;//il direttore attuale
				d.setDirettore(false);
			}
			if(p.getClass().getSimpleName().compareTo("Quadro")==0 && p.getAssunto() == true) {
				direttore = p;
				Quadro q = (Quadro) p;
				q.setDirettore(true);
			}else if(!p.getAssunto())
				throw new FakeMemberException("Membro non assunto dall'azienda");
			else
				throw new ManagerException("Il manager deve essere un quadro");
		}
	}
	
	/**
	 * Imposta il valore del cantiere
	 * @param v valore del cantiere
	 */
	public void setValore(double v) {
		valore = v;
	}
	
	/**
	 * Imposta le squadre che lavorano nel cantiere chiamante
	 * @param sq squadre che lavorano nel cantiere chiamante
	 */
	public void setSquadre(ArrayList<Squadra> sq) {
		squadre = sq;
	}
	
	/**
	 * Restituisce una squadra appartenente alla lista
	 * @param c squadra cercata
	 * @return la squadra cercata, null in caso di sua assenza
	 */
	public Squadra getSquadra(Squadra c) {
		int i;
		
		for(i=0;i<squadre.size();i++)
			if(squadre.get(i).equals(c))
				return squadre.get(i);
		
		return null;
	}
	
	/**
	  Questa operazione aggiunge una squadra al cantiere assicurandosi che tale squadra sia destinata a tale cantiere 
	  @param s Squadra da aggiungere
	  @throws WrongTeamException nel caso in cui la squadra passata come parametro non sia realmente destinata a questo cantiere
	 */
	public void add(Squadra s) throws WrongTeamException{
		if(s.getCantiere().getNomeCantiere().compareTo(nomeCantiere) == 0)
			squadre.add(s);
		else
			throw new WrongTeamException("Questa squadra non � destinata a questo cantiere");
	}
	
	/**
	  Questa operazione rimuove una determinata squadra da un cantiere
	  @param s Squadra da rimuovere
	 */
	public void removeSquadra(Squadra s) {
		int i = 0;
		for(i=0;i<squadre.size();i++) {
			Squadra sq = squadre.get(i);
			if(sq.equals(s)) {
				sq.removeSquadra();
				squadre.remove(i);
			}
		}
	}
	
	/**
	  Questa operazione restituisce in formato di stringa tutte le squadre che lavorano ad un cantiere
	  @return Un elenco di squadre
	 */
	public String toStringSquadre() {
		String str = "";
		for(Squadra sq: squadre)
			str = str + sq.toString() + "\n";
		return str;
	}
	
	/**
	 Clona la squadra passata come parametro  
	  @param a squadra da copiare
	  @return clone della squadra passata come parametro
	 */
	public ArrayList<Squadra> cloneList(ArrayList<Squadra> a) {
		ArrayList<Squadra> cloned = new ArrayList<Squadra>();
		for(Squadra sq: a) {
			Squadra el =  (Squadra) sq.clone();
			cloned.add(el);
		}
		return cloned;
	}
	
	/**
	 Questa operazione crea una stringa con tutti i dati riguardanti un impiegato
	 @return stringa di informazioni 
	 */
	public String toString() {
		return getClass().getSimpleName()+": [Nome Cantiere = "+nomeCantiere+", valore = "+valore+", direttore = "+direttore+", squadre:\n"+toStringSquadre()+"]";
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
			Cantiere c = (Cantiere) o;
			return nomeCantiere.compareTo(c.getNomeCantiere())==0&&toStringSquadre().compareTo(c.toStringSquadre())==0&&direttore.equals(c.getDirettore())&&Double.compare(valore, c.getValore())==0;
		}
	}
	
	/**
	 * Clona l'oggetto chiamante
	 * @return un'istanza di Impiegato con valori dei campi identici a quelli dell'oggetto chiamante
	 */
	public Object clone() {
		try {
			Cantiere cloned = (Cantiere) super.clone();
			if(valore > 500000)
				cloned.direttore = (Dirigente) direttore.clone();
			else
				cloned.direttore = (Quadro) direttore.clone();
			cloned.squadre = cloneList(squadre);
			return cloned;
		}catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	
	private String nomeCantiere;
	private ArrayList<Squadra> squadre;
	private Personale direttore;
	private double valore;
}