package progetto;

public class CantiereTester {
	public static void main(String[] args) {
		Cantiere c1 = new Cantiere(501000, "Cantiere 1",null);
		Cantiere c2 = new Cantiere(400000, "Cantiere 2",null);
		
		Quadro q1 = new Quadro("Dora", "Morandi", "Via A. Simon 123a",3998);
		Quadro q2 = new Quadro("Francesco", "Quomo", "Via T. Cesari 23",4982);
		Quadro q3 = new Quadro("Aldo", "Morandi", "Via A. Stefano 123a",3672);
		Quadro q4 = new Quadro("Antonio", "Quomo", "Via T. Carceri 23",4672);
		
		q1.setAssunto(true);
		q2.setAssunto(true);
		q3.setAssunto(true);
		q4.setAssunto(true);
		
		Squadra s1 = new Squadra(q1, c1);
		Squadra s2 = new Squadra(q2, c2);
		Squadra s3 = new Squadra(q3, c1);
		Squadra s4 = new Squadra(q4, c2);
		
		Operaio op1 = new Operaio("Alfredo","Testa","Via R. Sfoglia 5",1200);
		Operaio op2 = new Operaio("Gilda","Serra","Via A. Gatti 2",1289);
		Operaio op3 = new Operaio("Alfonso","Torre","Via R. Falange 5",1278);
		Operaio op4 = new Operaio("Giulia","Silvani","Via A. Grotta 2",1100);
		Operaio op5 = new Operaio("Antonio","Testa","Via R. Sfoglia 5",1234);
		Operaio op6 = new Operaio("Giulio","Serra","Via A. Gatti 2",1324);
		Operaio op7 = new Operaio("Alberto","Torre","Via R. Falange 5",1432);
		Operaio op8 = new Operaio("Giuliana","Silvani","Via A. Grotta 2",1129);
		
		op1.setAssunto(true);
		op2.setAssunto(true);
		op3.setAssunto(true);
		op4.setAssunto(true);
		op5.setAssunto(true);
		op6.setAssunto(true);
		op7.setAssunto(true);
		op8.setAssunto(true);
		
		System.out.println("Testiamo la classe Squadra");
		System.out.println("Aggiungiamo alla squadra s1 gli operai op1 ed op2, mentre alla squadra s2 gli operai op3 ed op4");
		s1.addOpeario(op1);
		s1.addOpeario(op2);
		s2.addOpeario(op3);
		s2.addOpeario(op4);
		System.out.println("toString s1: "+s1.toString());
		System.out.println("toString s2: "+s2.toString());
		System.out.println("Testiamo la equals tra s1 ed s2, ci aspettiamo di ottenere false");
		System.out.println(s1.equals(s2));
		System.out.println("Cloniamo s1 in s5 e tramite la equals verifichiamo che s1 ed s5 abbiano lo stesso stato");
		Squadra s5 = (Squadra) s1.clone();
		System.out.println("toString di s5: "+s5.toString());
		System.out.println("s1.equals(s5): "+s1.equals(s5));
		System.out.println("==============================================================================");
		System.out.println("Testiamo la classe Cantiere");
		System.out.println("Proviamo ad assegnare un quadro come direttore di c1, ci aspettiamo il lancio dell'eccezione");
		try {
			Quadro q6 = new Quadro("Debora", "Morandi", "Via A. Simon 123a",3998);
			q6.setAssunto(true);
			c1.setDirettore(q6);
		}catch(ManagerException e) {
			System.out.println("Eccezione lanciata");
		}
		System.out.println("Ora assegniamo a c1 e c2 dei direttori del tipo corretto");
		Quadro q7 = new Quadro("Dora", "Morandi", "Via A. Simon 123a",3998);
		Dirigente d1 = new Dirigente("Paolo", "Sforza", "Via U. Rovere 3",4902);
		q7.setAssunto(true);
		d1.setAssunto(true);
		c1.setDirettore(d1);
		c2.setDirettore(q7);
		System.out.println("Assegnamo al cantiere una squadra che non gli era stata assegnata, ci aspettiamo un'eccezione");
		try {
			c1.add(s2);
		}catch(WrongTeamException e) {
			System.out.println("Eccezione della squadra lanciata");
		}
		System.out.println("Ora assegniamo ad ogni cantiere le squadre che gli spettano");
		s3.addOpeario(op5);
		s3.addOpeario(op6);
		s4.addOpeario(op7);
		s4.addOpeario(op8);
		c1.add(s1);
		c1.add(s3);
		c2.add(s2);
		c2.add(s4);
		System.out.println("Testiamo la toString di entrambi i cantieri");
		System.out.println("toString c1: "+c1.toString());
		System.out.println("toString c2: "+c2.toString());
		System.out.println("Eliminiamo una squadra di c1 e riproviamo la toString, ci aspettiamo una squadra in meno");
		c1.removeSquadra(s3);
		System.out.println("toString c1: "+c1.toString());
		System.out.println("Verifichiamo che op5 ed op6 non lavorino pi�");
		System.out.println("op5 Lavora? "+op5.getLavora()+"\nop6 Lavora? "+op6.getLavora());
		System.out.println("Testiamo la equals fra c1 e c2, ci aspettiamo false come risultato");
		System.out.println("equals: "+c1.equals(c2));
		System.out.println("Testiamo la clone, c3 sar� un clone di c1. Verifichiamo il tutto tramite una equals che ci dar� true");
		Cantiere c3 = (Cantiere) c1.clone();
		System.out.println("toString di c3: "+c3.toString());
		System.out.println("c1.equals(c3): "+c1.equals(c3));
	}
}