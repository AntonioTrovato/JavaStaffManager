package progetto;

public class EsternoTester {
	public static void main(String[] args) {
		Prodotto p1 = new Prodotto("i2uw2", "Marmo");
		Prodotto p2 = new Prodotto("iu3ey", "Quarzo");
		
		Fornitore f1 = new Fornitore("Fornitore 1", "Via P. Di Maurizio 2", p1);
		Fornitore f2 = new Fornitore("Fornitore 2", "Via A. D\'Angelo 22", p2);
		
		Locale l1 = new Locale("Locale 1", "Bonifica", "Salerno");
		Locale l2 = new Locale("Locale 2", "Pulizia", "Caserta");
		
		Ente e1 = new Ente("Ente 1", "Sicurezza sul lavoro");
		Ente e2 = new Ente("Ente 2", "Controllo geologico");
		
		Cliente c1 = new Cliente("Antonio", "Bianchi", "Via U. D'Italia 43");
		Cliente c2 = new Cliente("Giuseppe", "Alfredi", "Via D. Roberti 15");
		
		System.out.println("Verifichiamo il corretto funzionamento della classe Prodotto");
		System.out.println("toString di p1: "+p1.toString());
		System.out.println("Procediamo con una equals tra p1 e p2, ci attendiamo false");
		System.out.println("p1.equals(p2): "+p1.equals(p2));
		System.out.println("Cloniamo p1 in p3 e verifichiamo che p1 e p3 siano valutati come identici");
		Prodotto p3 = (Prodotto)  p1.clone();
		System.out.println("toString di p3 = " + p3.toString());
		System.out.println("p1.equals(p3): "+ p1.equals(p3));
		System.out.println("=====================================================================================");
		System.out.println("Verifichiamo il corretto funzionamento della classe Fornitore");
		System.out.println("toString di f1: "+f1.toString());
		System.out.println("Procediamo con una equals tra f1 ed f2, ci attendiamo false");
		System.out.println("f1.equals(f2): "+f1.equals(f2));
		System.out.println("Cloniamo f1 in f3 e verifichiamo che f1 e f3 siano valutati come identici");
		Fornitore f3 = (Fornitore)  f1.clone();
		System.out.println("toString di f3 = " + f3.toString());
		System.out.println("f1.equals(f3): "+ f1.equals(f3));
		System.out.println("======================================================================================");
		System.out.println("Verifichiamo il corretto funzionamento della classe Locale");
		System.out.println("toString di l1: "+l1.toString());
		System.out.println("Procediamo con una equals tra l1 e l2, ci attendiamo false");
		System.out.println("l1.equals(l2): "+l1.equals(l2));
		System.out.println("Cloniamo l1 in l3 e verifichiamo che l1 e l3 siano valutati come identici");
		Locale l3 = (Locale)  l1.clone();
		System.out.println("toString di l3 = " + l3.toString());
		System.out.println("l1.equals(l3): "+ l1.equals(l3));
		System.out.println("=====================================================================================");
		System.out.println("Verifichiamo il corretto funzionamento della classe Ente");
		System.out.println("toString di e1: "+e1.toString());
		System.out.println("Procediamo con una equals tra e1 e e2, ci attendiamo false");
		System.out.println("e1.equals(e2): "+e1.equals(e2));
		System.out.println("Cloniamo e1 in e3 e verifichiamo che e1 e e3 siano valutati come identici");
		Ente e3 = (Ente)  e1.clone();
		System.out.println("toString di e3 = " + e3.toString());
		System.out.println("e1.equals(e3): "+ e1.equals(e3));
		System.out.println("=====================================================================================");
		System.out.println("Verifichiamo il corretto funzionamento della classe Cliente");
		System.out.println("toString di c1: "+c1.toString());
		System.out.println("Procediamo con una equals tra c1 e c2, ci attendiamo false");
		System.out.println("c1.equals(c2): "+c1.equals(c2));
		System.out.println("Cloniamo c1 in c3 e verifichiamo che c1 e c3 siano valutati come identici");
		Cliente c3 = (Cliente)  c1.clone();
		System.out.println("toString di c3 = " + c3.toString());
		System.out.println("c1.equals(c3): "+ c1.equals(c3));
		System.out.println("=====================================================================================");
	}
}