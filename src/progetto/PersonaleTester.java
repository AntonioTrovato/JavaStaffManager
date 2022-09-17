package progetto;

public class PersonaleTester {
	public static void main(String[] args) {
		Operaio op1 = new Operaio("Alfredo","Testa","Via R. Sfoglia 5",1200);
		Operaio op2 = new Operaio("Gilda","Serra","Via A. Gatti 2",1289);
		
		Dirigente d1 = new Dirigente("Paolo", "Sforza", "Via U. Rovere 3",4902);
		Dirigente d2 = new Dirigente("Domenico", "Bini", "Via S. D'Acquisto 32",5902);
		
		Impiegato i1 = new Impiegato("Antonio", "Pascarella", "Via E. Chiesa 1", 3567, "Poste");
		Impiegato i2 = new Impiegato("Alberto", "Trifola", "Via G. Sabatini 65", 3789, "Web Site");
		
		Quadro q1 = new Quadro("Dora", "Morandi", "Via A. Simon 123a",3998);
		Quadro q2 = new Quadro("Francesco", "Quomo", "Via T. Cesari 23",4982);
		
		System.out.println("Verifichiamo il corretto funzionamento della classe Operaio");
		System.out.println("Impostiamo il campo lavora a false e verifichiamo che l'informazione venga salvata");
		op1.setLavora(false);
		System.out.println("lavora = "+op1.getLavora());
		System.out.println("Verifichiamo il funzionamento dell'operazione di pagamento");
		System.out.println("Saldo prima del pagamento: "+op1.getConto());
		op1.riceviPaga();
		System.out.println("Saldo dopo il ricevimento dello stipendio: "+op1.getConto());
		System.out.println("Verifichiamo il funzionamento delle funzione toString, equals e clone");
		System.out.println("toString: "+op1.toString());
		System.out.println("Proviamo la equals fra op1 ed op2, ci aspettiamo come risultato false");
		System.out.println("Risultato: "+op1.equals(op2));
		System.out.println("Cloniamo op1 in op3 e verifichiamo che la funzione equals ci restituisca true tra op1 ed op3");
		Operaio op3 = (Operaio) op1.clone();
		System.out.println("toString op3: "+op3.toString());
		System.out.println("Risultato op1.equals(op3): "+op1.equals(op3));
		System.out.println("=========================================================================");
		System.out.println("Verifichiamo il corretto funzionamento della classe Dirigente");
		System.out.println("Impostiamo il campo direttore a false e verifichiamo che l'informazione venga salvata");
		d1.setDirettore(false);
		System.out.println("lavora = "+d1.getDirettore());
		System.out.println("Verifichiamo il funzionamento dell'operazione di pagamento");
		System.out.println("Saldo prima del pagamento: "+d1.getConto());
		d1.riceviPaga();
		System.out.println("Saldo dopo il ricevimento dello stipendio: "+d1.getConto());
		System.out.println("Verifichiamo il funzionamento delle funzione toString, equals e clone");
		System.out.println("toString: "+d1.toString());
		System.out.println("Proviamo la equals fra d1 ed d2, ci aspettiamo come risultato false");
		System.out.println("Risultato: "+d1.equals(d2));
		System.out.println("Cloniamo d1 in d3 e verifichiamo che la funzione equals ci restituisca true tra d1 ed d3");
		Dirigente d3 = (Dirigente) d1.clone();
		System.out.println("toString op3: "+d3.toString());
		System.out.println("Risultato d1.equals(d3): "+d1.equals(d3));
		System.out.println("==========================================================================");
		System.out.println("Verifichiamo il corretto funzionamento della classe Impiegato");
		System.out.println("Verifichiamo il funzionamento dell'operazione di pagamento");
		System.out.println("Saldo prima del pagamento: "+i1.getConto());
		i1.riceviPaga();
		System.out.println("Saldo dopo il ricevimento dello stipendio: "+i1.getConto());
		System.out.println("Verifichiamo il funzionamento delle funzione toString, equals e clone");
		System.out.println("toString: "+i1.toString());
		System.out.println("Proviamo la equals fra i1 ed i2, ci aspettiamo come risultato false");
		System.out.println("Risultato: "+i1.equals(i2));
		System.out.println("Cloniamo i1 in i3 e verifichiamo che la funzione equals ci restituisca true tra i1 ed i3");
		Impiegato i3 = (Impiegato) i1.clone();
		System.out.println("toString i3: "+i3.toString());
		System.out.println("Risultato i1.equals(i3): "+i1.equals(i3));
		System.out.println("==========================================================================");
		System.out.println("Verifichiamo il corretto funzionamento della classe Quadro");
		System.out.println("Impostiamo il campo capoSquadra e direttore a false e verifichiamo che l'informazione venga salvata");
		q1.setDirettore(false);
		q1.setCapoSquadra(false);
		System.out.println("lavora = "+q1.getDirettore());
		System.out.println("Capo Squadra = "+q1.getCapoSquadra());
		System.out.println("Verifichiamo il funzionamento dell'operazione di pagamento");
		System.out.println("Saldo prima del pagamento: "+q1.getConto());
		q1.riceviPaga();
		System.out.println("Saldo dopo il ricevimento dello stipendio: "+q1.getConto());
		System.out.println("Verifichiamo il funzionamento delle funzione toString, equals e clone");
		System.out.println("toString: "+q1.toString());
		System.out.println("Proviamo la equals fra q1 ed q1, ci aspettiamo come risultato false");
		System.out.println("Risultato: "+q1.equals(q2));
		System.out.println("Cloniamo q1 in q3 e verifichiamo che la funzione equals ci restituisca true tra q1 ed q3");
		Quadro q3 = (Quadro) q1.clone();
		System.out.println("toString q3: "+q3.toString());
		System.out.println("Risultato q1.equals(q3): "+q1.equals(q3));
	}
}