package progetto;

import java.io.Serializable;

/**
 * Implemetazione del concetto di Azienda
 * @author workgroup
 *
 */
public class Azienda implements Serializable{
	/**
	 * Costruttore della classe
	 * @param a il reparto amministrativo dell'azienda
	 * @param o il reparto operativo dell'azienda
	 */
	public Azienda(RepartoAmministrativo a, RepartoOperativo o) {
		amministrativo = a;
		operativo =  o;
	}
	
	/**
	 * Riporta il reparto amministrativo dell'azienda
	 * @return reparto amministrativo dell'azienda
	 */
	public RepartoAmministrativo getAmministrativo() {
		return amministrativo;
	}
	
	/**
	 * Riporta il reparto operativo dell'azienda
	 * @return reparto operativo dell'azienda
	 */
	public RepartoOperativo getOperativo() {
		return operativo;
	}
	
	/**
	 * Imposta il reparto amministrativo dell'azienda
	 * @param a reparto amministrativo da impostare
	 */
	public void setAmministrativo(RepartoAmministrativo a) {
		amministrativo = a;
	}
	
	/**
	 * Imposta il reparto operativo dell'azienda
	 * @param a reparto operativo da impostare
	 */
	public void setOperativo(RepartoOperativo a) {
		operativo = a;
	}
	
	/**
	 * Aggiungi un fornitore
	 * @param f fornitore da aggiungere
	 */
	public void addFornitore(Fornitore f) {
		amministrativo.addFornitore(f);
	}
	
	/**
	 * Aggiungi un ente
	 * @param e ente da aggiungere
	 */
	public void addEnte(Ente e) {
		amministrativo.addEnte(e);
	}
	
	/**
	 * Aggiungi un locale
	 * @param l locale da aggiungere
	 */
	public void addLocale(Locale l) {
		amministrativo.addLocale(l);
	}
	
	/**
	 * Aggiungi un cliente
	 * @param c cliente da aggiungere
	 */
	public void addCliente(Cliente c) {
		amministrativo.addCliente(c);
	}
	
	/**
	 * Aggiungi un membro del personale
	 * @param p membro del personale da aggiungere
	 */
	public void assumi(Personale p) {
		amministrativo.assumi(p);
	}
	
	/**
	 * Effettua la rimozione di un fornitore
	 * @param f fornitore da rimuovere
	 */
	public void removeFornitore(Fornitore f) {
		amministrativo.removeFornitore(f);
	}
	
	/**
	 * Effettua la rimozione di un ente
	 * @param f ente da rimuovere
	 */
	public void removeEnte(Ente f) {
		amministrativo.removeEnte(f);
	}
	
	/**
	 * Effettua la rimozione di un locale
	 * @param f locale da rimuovere
	 */
	public void removeLocale(Locale f) {
		amministrativo.removeLocale(f);
	}
	
	/**
	 * Effettua la rimozione di un cliente
	 * @param f cliente da rimuovere
	 */
	public void removeCliente(Cliente f) {
		amministrativo.removeCliente(f);
	}
	
	/**
	 * Effettua la rimozione di un membro del personale
	 * @param f membro del personale da rimuovere
	 */
	public void licenzia(Personale f) {
		Personale p = amministrativo.licenzia(f,operativo.getCantieri());
		if(p!=null)
			assumi(p);
	}
	
	/**
	 * Effettua il versamento dello stipendio ad un certo membro del personale
	 * @param p membro del personale
	 */
	public void paga(Personale p) {
		amministrativo.paga(p);
	}
	
	/**
	 * Mostra la lista dei fornitori
	 * @return lista fornitori
	 */
	public String showFornitori() {
		return amministrativo.showFornitori();
	}
	
	/**
	 * Mostra la lista degli enti
	 * @return lista enti
	 */
	public String showEnti() {
		return amministrativo.showEnti();
	}
	
	/**
	 * Mostra la lista dei locali
	 * @return lista locali
	 */
	public String showLocali() {
		return amministrativo.showLocali();
	}
	
	/**
	 * Mostra la lista dei clienti
	 * @return lista clienti
	 */
	public String showClienti() {
		return amministrativo.showClienti();
	}
	
	/**
	 * Mostra la lista dei membri del personale
	 * @return lista membri del personale
	 */
	public String showPersonale() {
		return amministrativo.showPersonale();
	}
	
	/**
	 * Genera una stringa contenente tutti i fornitori che forniscono un certo prodotto
	 * @param nomeProdotto nome del prodotto di cui vogliamo i fornitori 
	 * @return s stringa contente i fornitori trovati
	 */
	public String reportFornitoriDatoProdotto(String nomeProdotto) {
		return amministrativo.reportFornitoriDatoProdotto(nomeProdotto);
	}
	
	/**
	 * Restituisce una stringa indicante i membri del personale impegnati in almeno un'attivit� aziendale
	 * @return lista dei membri
	 */
	public String reportPersonaleImpegnato() {
		return amministrativo.reportPersonaleImpegnato();
	}
	
	/**
	 * Restituisce una stringa indicante i membri del personale impegnati in nessuna attivit� aziendale
	 * @return lista dei membri
	 */
	public String reportPersonaleNonImpegnato() {
		return amministrativo.reportPersonaleNonImpegnato();
	}
	
	/**
	 * Restituisce la lista di tutti gli enti che svolgono una certa attivit�
	 * @param a attivit� desiderata
	 * @return lista enti che svolgono l'attivit� desiderata
	 */
	public String reportEntiAttivita(String a) {
		return amministrativo.reportEntiAttivita(a);
	}
	
	/**
	 * Restituisce la lista di tutti i locali attivi in una certa provincia
	 * @param p provincia desiderata
	 * @return lista locali attivi in una certa provincia
	 */
	public String reportLocaliDataProvincia(String p) {
		return amministrativo.reportLocaliDataProvincia(p);
	}
	
	/**
	 * Restituisce la lista di tutti i locali che svolgono una certa attivit�
	 * @param a attivit� desiderata
	 * @return lista locali che svolgono l'attivit� desiderata
	 */
	public String reportLocaliAttivita(String a) {
		return amministrativo.reportLocaliAttivita(a);
	}
	
	/**
	 * Restituisce un cantiere appartenente alla lista
	 * @param c cantiere cercato
	 * @return il cantiere cercato, null in caso di sua assenza
	 */
	public Cantiere getCantiere(Cantiere c) {
		return operativo.getCantiere(c);
	}
	
	/**
	 * Permette l'aggiunta di un cantiere alla lista
	 * @param c cantiere da aggiungere
	 */
	public void addCantiere(Cantiere c) {
		operativo.addCantiere(c);
	}
	
	/**
	 * Effettua la rimozione di un cantiere
	 * @param c cantiere da rimuovere
	 */
	public void removeCantiere(Cantiere c) {
		operativo.removeCantiere(c);
	}
	
	/**
	 * Elenca tutti i cantieri in gestione
	 * @return lista dei cantieri
	 */
	public String showCantieri() {
		return operativo.showCantieri();
	}
	
	/**
	 * Restituisce la lista dei cantieri il cui valore � compreso tra altri 2
	 * @param x estremo inferiore/superiore
	 * @param y estremo inferiore/superiore
	 * @return lista dei cantieri che rispettano la richiesta
	 */
	public String reportCantieriInterValore(double x, double y) {
		return operativo.reportCantieriInterValore(x, y);
	}
	
	/**
	 * Restituisce la lista dei cantieri che hanno per direttore un dirigente
	 * @return lista dei cantieri che hanno per direttore un dirigente
	 */
	public String reportCantieriDirigenti() {
		return operativo.reportCantieriDirigenti();
	}
	
	/**
	 * Restituisce la lista dei cantieri che hanno per direttore un quadro
	 * @return lista dei cantieri che hanno per direttore un quadro
	 */
	public String reportCantieriQuadri() {
		return operativo.reportCantieriQuadri();
	}
	
	private RepartoAmministrativo amministrativo;
	private RepartoOperativo operativo;
}