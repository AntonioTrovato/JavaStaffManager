package progetto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Questa classe implementa il concetto di Reparto Amministrativo
 * @author workgroup
 */
public class RepartoAmministrativo implements Serializable{
	/**
	 * Costruttore della classe. Inizializza una liste di fornitori, enti, locali, clienti e personale
	 */
	public RepartoAmministrativo() {
		fornitori = new ArrayList<Fornitore>();
		enti = new ArrayList<Ente>();
		locali = new ArrayList<Locale>();
		clienti = new ArrayList<Cliente>();
		personale = new ArrayList<Personale>();
	}
	
	/**
	 * Restituisce la lista di fornitori
	 * @return lista di fornitori
	 */
	public ArrayList<Fornitore> getFornitori() {
		return fornitori;
	}
	
	/**
	 * Restituisce la lista degli enti
	 * @return lista degli enti
	 */
	public ArrayList<Ente> getEnte() {
		return enti;
	}
	
	/**
	 * Restituisce la lista dei locali
	 * @return lista dei locali
	 */
	public ArrayList<Locale> getLocali() {
		return locali;
	}
	
	/**
	 * Restituisce la lista dei clienti
	 * @return lista dei clienti
	 */
	public ArrayList<Cliente> getClienti() {
		return clienti;
	}
	
	/**
	 * Restituisce la lista dei componenti del personale
	 * @return lista dei compinenti del personale
	 */
	public ArrayList<Personale> getPersonale() {
		return personale;
	}
	
	/**
	 * Imposta i fornitori
	 * @param list lista di fornitori
	 */
	public void setFornitori(ArrayList<Fornitore> list) {
		fornitori = list;
	}
	
	/**
	 * Imposta gli enti
	 * @param list lista di enti
	 */
	public void setEnti(ArrayList<Ente> list) {
		enti = list;
	}
	
	/**
	 * Imposta i locali
	 * @param list lista di locali
	 */
	public void setLocali(ArrayList<Locale> list) {
		locali = list;
	}
	
	/**
	 * Imposta i clienti
	 * @param list lista di clienti
	 */
	public void setClienti(ArrayList<Cliente> list) {
		clienti = list;
	}
	
	/**
	 * Imposta la lista del personale
	 * @param list lista del personale
	 */
	public void setPersonale(ArrayList<Personale> list) {
		personale = list;
	}
	
	/**
	 * Aggiungi un fornitore
	 * @param f fornitore da aggiungere
	 */
	public void addFornitore(Fornitore f) {
		fornitori.add(f);
	}
	
	/**
	 * Aggiungi un ente
	 * @param e ente da aggiungere
	 */
	public void addEnte(Ente e) {
		enti.add(e);
	}
	
	/**
	 * Aggiungi un locale
	 * @param l locale da aggiungere
	 */
	public void addLocale(Locale l) {
		locali.add(l);
	}
	
	/**
	 * Aggiungi un cliente
	 * @param c cliente da aggiungere
	 */
	public void addCliente(Cliente c) {
		clienti.add(c);
	}
	
	/**
	 * Aggiungi un membro del personale
	 * @param p membro del personale da aggiungere
	 */
	public void assumi(Personale p) {
		personale.add(p);
		p.setAssunto(true);
	}
	
	/**
	 * Effettua la rimozione di un fornitore
	 * @param f fornitore da rimuovere
	 */
	public void removeFornitore(Fornitore f) {
		fornitori.remove(f);
	}
	
	/**
	 * Effettua la rimozione di un ente
	 * @param f ente da rimuovere
	 */
	public void removeEnte(Ente f) {
		enti.remove(f);
	}
	
	/**
	 * Effettua la rimozione di un locale
	 * @param f locale da rimuovere
	 */
	public void removeLocale(Locale f) {
		locali.remove(f);
	}
	
	/**
	 * Effettua la rimozione di un cliente
	 * @param f cliente da rimuovere
	 */
	public void removeCliente(Cliente f) {
		clienti.remove(f);
	}
	
	/**
	 * Effettua la rimozione di un membro del personale, sollevandolo dai compiti che gli erano eventualmente stati assegnati
	 * @param f membro del personale da rimuovere
	 * @param c la lista di cantieri dell'azienda
	 * @return il sostituto del membro licenziato, null nel caso non fosse necessario un sostituto
	 */
	public Personale licenzia(Personale f, ArrayList<Cantiere> c) {
		Scanner in = new Scanner(System.in);
		String n,co,i;
		double conto;
		ArrayList<Squadra> squadre = new ArrayList<Squadra>();
		if(f.getClass().getSimpleName().compareTo("Operaio")==0) {
			Operaio o = (Operaio) f;
			if(o.getLavora()) {
				for(Cantiere cantiere: c) {
					squadre = cantiere.getSquadre();
					for(Squadra sq: squadre) {
						sq.removeOperaio(o);
					}
				}
			}
			f.setAssunto(false);
			personale.remove(f);
			return null;
		}else if(f.getClass().getSimpleName().compareTo("Impiegato")==0) {
			f.setAssunto(false);
			personale.remove(f);
			return null;
		}else if(f.getClass().getSimpleName().compareTo("Dirigente")==0) {
			Dirigente d = (Dirigente) f;
			Dirigente d1 = null;
			if(d.getDirettore()) {
				System.out.println("Vai");
				n=in.next();
				co=in.next();
				i=in.next();
				conto=in.nextDouble();
				d1 = new Dirigente(n,co,i,conto);
				d1.setAssunto(true);
				for(Cantiere cantiere: c) {
					if(cantiere.getDirettore().equals(d)) {
						cantiere.setDirettore(d1);
						d.setAssunto(false);
						personale.remove(f);
						break;
					}
				}
			}else {
				f.setAssunto(false);
				personale.remove(f);
			}
			return d1;
		}else if(f.getClass().getSimpleName().compareTo("Quadro")==0) {
			Quadro d = (Quadro) f;
			Quadro d1;
			if(d.getDirettore()) {
				System.out.println("Vai");
				n=in.next();
				co=in.next();
				i=in.next();
				conto=in.nextDouble();
				d1 = new Quadro(n,co,i,conto);
				d1.setAssunto(true);
				for(Cantiere cantiere: c) {
					if(cantiere.getDirettore().equals(d)) {
						cantiere.setDirettore(d1);
						d.setAssunto(false);
						personale.remove(f);
						break;
					}
				}
				return d1;
			}else if(d.getCapoSquadra()) {
				System.out.println("Vai");
				n=in.next();
				co=in.next();
				i=in.next();
				conto=in.nextDouble();
				d1 = new Quadro(n,co,i,conto);
				d1.setAssunto(true);
				for(Cantiere cantiere: c) {
					squadre = cantiere.getSquadre();
					for(Squadra sq: squadre) {
						if(sq.getResponsabile().equals(d)) {
							d.setAssunto(false);
							sq.setResponsabile(d1);
							personale.remove(f);
							break;
						}
					}
				}
				return d1;
			}else {
				f.setAssunto(false);
				personale.remove(f);
				return null;
			}
		}
		return null;
	}
	
	/**
	 * Effettua il versamento dello stipendio ad un certo membro del personale
	 * @param p membro del personale
	 */
	public void paga(Personale p) {
		int i;
		
		for(i=0;i<personale.size();i++)
			if(p.equals(personale.get(i)))
				p.riceviPaga();
	}
	
	/**
	 * Mostra la lista dei fornitori
	 * @return lista fornitori
	 */
	public String showFornitori() {
		String s = "[ ";
		for(Fornitore f: fornitori)
			s+=f.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Mostra la lista degli enti
	 * @return lista enti
	 */
	public String showEnti() {
		String s = "[ ";
		for(Ente e: enti)
			s+=e.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Mostra la lista dei locali
	 * @return lista locali
	 */
	public String showLocali() {
		String s = "[ ";
		for(Locale l: locali)
			s+=l.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Mostra la lista dei clienti
	 * @return lista clienti
	 */
	public String showClienti() {
		String s = "[ ";
		for(Cliente c: clienti)
			s+=c.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Mostra la lista dei membri del personale
	 * @return lista membri del personale
	 */
	public String showPersonale() {
		String s = "[ ";
		for(Personale p: personale)
			s+=p.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Genera una stringa contenente tutti i fornitori che forniscono un certo prodotto
	 * @param nomeProdotto nome del prodotto di cui vogliamo i fornitori 
	 * @return s stringa contente i fornitori trovati
	 */
	public String reportFornitoriDatoProdotto(String nomeProdotto) {
		String s = "[ ";
		for(Fornitore f: fornitori)
			if(f.getProdotto().getNome().compareTo(nomeProdotto)==0)
				s+=f.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Restituisce una stringa indicante i membri del personale impegnati in almeno un'attivit� aziendale
	 * @return lista dei membri
	 */
	public String reportPersonaleImpegnato() {
		String s = "[ ";
		for(Personale p: personale) {
			if(p.getClass().getSimpleName().compareTo("Impiegato")==0)
				s+=p.toString()+"\n";
			else if(p.getClass().getSimpleName().compareTo("Operaio")==0) {
				Operaio o = (Operaio) p;
				if(o.getLavora())
					s+=o.toString()+"\n";
			}else if(p.getClass().getSimpleName().compareTo("Dirigente")==0) {
				Dirigente o = (Dirigente) p;
				if(o.getDirettore())
					s+=o.toString()+"\n";
			}else if(p.getClass().getSimpleName().compareTo("Quadro")==0) {
				Quadro o = (Quadro) p;
				if(o.getCapoSquadra() || o.getDirettore())
					s+=o.toString()+"\n";
			}
		}
		return s+"]";
	}
	
	/**
	 * Restituisce una stringa indicante i membri del personale impegnati in nessuna attivit� aziendale
	 * @return lista dei membri
	 */
	public String reportPersonaleNonImpegnato() {
		String s = "[ ";
		for(Personale p: personale) {
			if(p.getClass().getSimpleName().compareTo("Impiegato")==0)
				continue;
			else if(p.getClass().getSimpleName().compareTo("Operaio")==0) {
				Operaio o = (Operaio) p;
				if(!o.getLavora())
					s+=o.toString()+"\n";
			}else if(p.getClass().getSimpleName().compareTo("Dirigente")==0) {
				Dirigente o = (Dirigente) p;
				if(!o.getDirettore())
					s+=o.toString()+"\n";
			}else if(p.getClass().getSimpleName().compareTo("Quadro")==0) {
				Quadro o = (Quadro) p;
				if(!o.getCapoSquadra() && !o.getDirettore())
					s+=o.toString()+"\n";
			}
		}
		return s+"]";
	}
	
	/**
	 * Restituisce la lista di tutti gli enti che svolgono una certa attivit�
	 * @param a attivit� desiderata
	 * @return lista enti che svolgono l'attivit� desiderata
	 */
	public String reportEntiAttivita(String a) {
		String s = "[ ";
		for(Ente e: enti)
			if(e.getAttivita().compareTo(a)==0)
				s+=e.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Restituisce la lista di tutti i locali attivi in una certa provincia
	 * @param p provincia desiderata
	 * @return lista locali attivi in una certa provincia
	 */
	public String reportLocaliDataProvincia(String p) {
		String s = "[ ";
		for(Locale l: locali)
			if(l.getProvincia().compareTo(p)==0)
				s+=l.toString()+"\n";
		return s+"]";
	}
	
	/**
	 * Restituisce la lista di tutti i locali che svolgono una certa attivit�
	 * @param a attivit� desiderata
	 * @return lista locali che svolgono l'attivit� desiderata
	 */
	public String reportLocaliAttivita(String a) {
		String s = "[ ";
		for(Locale l: locali)
			if(l.getAttivita().compareTo(a)==0)
				s+=l.toString()+"\n";
		return s+"]";
	}
	
	public ArrayList<Fornitore> fornitori;
	public ArrayList<Ente> enti;
	public ArrayList<Locale> locali;
	public ArrayList<Cliente> clienti;
	public ArrayList<Personale> personale;
}