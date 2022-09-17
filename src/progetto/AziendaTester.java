package progetto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AziendaTester {
	public static void main(String[] args) {
		RepartoAmministrativo am = new RepartoAmministrativo();
		RepartoOperativo op = new RepartoOperativo();
		
		Azienda a = new Azienda(am,op);
		
		Quadro q1 = new Quadro("Dora", "Morandi", "Via A. Simon 123a",3998);
		Quadro q2 = new Quadro("Francesco", "Quomo", "Via T. Cesari 23",4982);
		Quadro q3 = new Quadro("Aldo", "Morandi", "Via A. Stefano 123a",3672);
		Quadro q4 = new Quadro("Antonio", "Quomo", "Via T. Carceri 23",4672);
		Quadro q5 = new Quadro("Alberto", "Quomo", "Via T. Carceri 23",4672);
		
		Dirigente d1 = new Dirigente("Paolo", "Sforza", "Via U. Rovere 3",4902);
		Dirigente d2 = new Dirigente("Domenico", "Bini", "Via S. D'Acquisto 32",5902);
		
		Impiegato i1 = new Impiegato("Antonio", "Pascarella", "Via E. Chiesa 1", 3567, "Poste");
		Impiegato i2 = new Impiegato("Alberto", "Trifola", "Via G. Sabatini 65", 3789, "Web Site");
		
		Operaio op1 = new Operaio("Alfredo","Testa","Via R. Sfoglia 5",1200);
		Operaio op2 = new Operaio("Gilda","Serra","Via A. Gatti 2",1289);
		Operaio op3 = new Operaio("Alfonso","Torre","Via R. Falange 5",1278);
		Operaio op4 = new Operaio("Giulia","Silvani","Via A. Grotta 2",1100);
		Operaio op5 = new Operaio("Antonio","Testa","Via R. Sfoglia 5",1234);
		Operaio op6 = new Operaio("Giulio","Serra","Via A. Gatti 2",1324);
		Operaio op7 = new Operaio("Alberto","Torre","Via R. Falange 5",1432);
		Operaio op8 = new Operaio("Giuliana","Silvani","Via A. Grotta 2",1129);
		
		Prodotto p1 = new Prodotto("i2uw2", "Marmo");
		Prodotto p2 = new Prodotto("iu3ey", "Quarzo");
		
		Fornitore f1 = new Fornitore("Fornitore 1", "Via P. Di Maurizio 2", p1);
		Fornitore f2 = new Fornitore("Fornitore 2", "Via A. D\'Angelo 22", p2);
		
		Locale l1 = new Locale("Locale 1", "Bonifica", "Salerno");
		Locale l2 = new Locale("Locale 2", "Pulizia", "Caserta");
		
		Ente e1 = new Ente("Ente 1", "Sicurezza sul lavoro");
		Ente e2 = new Ente("Ente 2", "Controllo geologico");
		
		Cliente cl1 = new Cliente("Antonio", "Bianchi", "Via U. D'Italia 43");
		Cliente cl2 = new Cliente("Giuseppe", "Alfredi", "Via D. Roberti 15");
		
		a.assumi(q1);
		a.assumi(q2);
		a.assumi(q3);
		a.assumi(q4);
		a.assumi(q5);
		a.assumi(d1);
		a.assumi(d2);
		a.assumi(i1);
		a.assumi(i2);
		a.assumi(op1);
		a.assumi(op2);
		a.assumi(op3);
		a.assumi(op4);
		a.assumi(op5);
		a.assumi(op6);
		a.assumi(op7);
		a.assumi(op8);
		a.addFornitore(f1);
		a.addFornitore(f2);
		a.addLocale(l1);
		a.addLocale(l2);
		a.addCliente(cl1);
		a.addCliente(cl2);
		a.addEnte(e1);
		a.addEnte(e2);
		
		Cantiere c1 = new Cantiere(501000, "Cantiere 1",d1);
		Cantiere c2 = new Cantiere(40, "Cantiere 2",q5);
		
		Squadra s1 = new Squadra(q1, c1);
		Squadra s2 = new Squadra(q2, c2);
		Squadra s3 = new Squadra(q3, c1);
		Squadra s4 = new Squadra(q4, c2);

		s1.addOpeario(op1);
		s1.addOpeario(op2);
		s2.addOpeario(op3);
		s2.addOpeario(op4);
		s3.addOpeario(op5);
		s3.addOpeario(op6);
		s4.addOpeario(op7);
		s4.addOpeario(op8);
		
		c1.add(s1);
		c2.add(s2);
		c1.add(s3);
		c2.add(s4);
		
		op.addCantiere(c1);
		op.addCantiere(c2);
		
		/*a.licenzia(d1);
		a.licenzia(d2);
		a.licenzia(op6);*/
		//a.licenzia(q5);
		//a.licenzia(q2);
		
		System.out.println("Testiamo la classe Azienda");
		System.out.println("Verifichiamo che sia stato tutto effettivamente aggiunto");
		System.out.println("Fornitori:");
		System.out.println(a.showFornitori());
		System.out.println("Enti:");
		System.out.println(a.showEnti());
		System.out.println("Locali:");
		System.out.println(a.showLocali());
		System.out.println("Clienti:");
		System.out.println(a.showClienti());
		System.out.println("Personale:");
		System.out.println(a.showPersonale());
		System.out.println("Cantieri:");
		System.out.println(a.showCantieri());
		System.out.println("Verifichiamo il corretto funzionamento dello stipendiaggio");
		System.out.println("Saldo di op1 attuale: "+op1.getConto());
		a.paga(op1);
		System.out.println("Dopo il pagamento (deve essere aumentato di 1000): "+op1.getConto());
		System.out.println("Verifichiamo il corretto funzionamento delle funzioni di report");
		System.out.println("Cantieri gestiti da dirigenti"+a.reportCantieriDirigenti());
		System.out.println("Cantieri con valore tra quelli dati"+a.reportCantieriInterValore(500000, 690000));
		System.out.println("Cantieri gestiti da quadri"+a.reportCantieriQuadri());
		System.out.println("Enti che effettuano controlli geologico"+a.reportEntiAttivita("Controllo geologico"));
		System.out.println("Fornitori che forniscono marmo"+a.reportFornitoriDatoProdotto("Marmo"));
		System.out.println("Enti locali che effettuano pulizie"+a.reportLocaliAttivita("Pulizia"));
		System.out.println("Enti nella provincia di Caserta"+a.reportLocaliDataProvincia("Caserta"));
		System.out.println("Parte del personale impegnato in qualche attivit�"+a.reportPersonaleImpegnato());
		System.out.println("Parte del personale non impegnato in qualche attivit�"+a.reportPersonaleNonImpegnato());
		File file = new File("azienda.dat");
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(a);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectInputStream ois;
		System.out.println("TEST FILE");
		Azienda b;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			b = (Azienda) ois.readObject();
			System.out.println(b.showEnti());
			ois.close();
		} catch (IOException e) {
			b=null;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			b=null;
			e.printStackTrace();
		}
		
		
	}
}