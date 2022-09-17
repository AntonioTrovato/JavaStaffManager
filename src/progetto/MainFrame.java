package progetto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent.*;
import java.io.ObjectInputStream;

import javax.swing.*;

public class MainFrame extends JFrame 
{
	private JTextArea textArea;
	private Azienda a;
	
	public MainFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,510);
		setLocation(200,200);
		a=getAziendaFromFile();
		textArea=new JTextArea();
		setTitle("Progetto POO");
		setJMenuBar(MenuBar());
		add(MainPanel());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				File file = new File("azienda.dat");
				ObjectOutputStream oos;
				try {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(a);
					oos.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		MainFrame mainFrame = new MainFrame();
		
	}
	
	public JMenuBar MenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		//menuBar.add(File());
		menuBar.add(Assumi());
		menuBar.add(Licenzia());
		menuBar.add(Paga());
		menuBar.add(new JSeparator(SwingConstants.VERTICAL));
		menuBar.add(Aggiungi());
		menuBar.add(Rimuovi());
		menuBar.add(new JSeparator(SwingConstants.VERTICAL));
		menuBar.add(Mostra());
		menuBar.add(Report());
		return menuBar;
	}
	
	public JScrollPane MainPanel()
	{
		textArea.setPreferredSize(new Dimension(600,450));
		JScrollPane scrollPane = new JScrollPane(textArea);
		return scrollPane;
	}
	
	public JMenuItem File()
	{
		JMenuItem file = new JMenuItem("File");
		return file;
	}
	
	public JMenu Assumi()
	{
		JMenu assumiInterni = new JMenu("Assumi");
		assumiInterni.add(AssumiImpiegato());
		assumiInterni.add(AssumiOperaio());
		assumiInterni.add(AssumiDirigente());
		assumiInterni.add(AssumiQuadro());
		return assumiInterni;
	}
	
	public JMenuItem AssumiImpiegato()
	{
		JMenuItem assumiImpiegato = new JMenuItem("Impiegato");
		assumiImpiegato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiImpiegatoFrame ai = new AssumiImpiegatoFrame();;
				JButton assumi = new JButton("Assumi");
				assumi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Impiegato i = new Impiegato(ai.getNome(),ai.getCognome(),ai.getIndirizzo(),ai.getConto(),ai.getMansione());
						a.assumi(i);
						ai.dispose();
					}
				});
				ai.add(ai.AssumiPanel(assumi),BorderLayout.SOUTH);	
			}
		});
		return assumiImpiegato;
	}
	
	public JMenuItem AssumiOperaio()
	{
		JMenuItem assumiOperaio = new JMenuItem("Operaio");
		assumiOperaio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiOperaioFrame ad = new AssumiOperaioFrame();;
				JButton assumi = new JButton("Assumi");
				assumi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Operaio o = new Operaio(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						a.assumi(o);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(assumi),BorderLayout.SOUTH);	
			}
		});

		return assumiOperaio;
	}
	
	public JMenuItem AssumiDirigente()
	{
		JMenuItem assumiDirigente = new JMenuItem("Dirigente");
		assumiDirigente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiDirigenteFrame ad = new AssumiDirigenteFrame();;
				JButton assumi = new JButton("Assumi");
				assumi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Dirigente d = new Dirigente(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						a.assumi(d);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(assumi),BorderLayout.SOUTH);	
			}
		});
		return assumiDirigente;
	}
	
	public JMenuItem AssumiQuadro()
	{
		JMenuItem assumiQuadro = new JMenuItem("Quadro");
		assumiQuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiQuadroFrame ad = new AssumiQuadroFrame();;
				JButton assumi = new JButton("Assumi");
				assumi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Quadro q = new Quadro(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						a.assumi(q);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(assumi),BorderLayout.SOUTH);	
			}
		});
		return assumiQuadro;
	}
	
	public JMenu Paga()
	{
		JMenu pagaInterni = new JMenu("Paga");
		pagaInterni.add(PagaImpiegato());
		pagaInterni.add(PagaOperaio());
		pagaInterni.add(PagaDirigente());
		pagaInterni.add(PagaQuadro());
		return pagaInterni;
	}
	
	public JMenuItem PagaDirigente()
	{
		JMenuItem pagaDirigente = new JMenuItem("Dirigente");
		pagaDirigente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiDirigenteFrame ad = new AssumiDirigenteFrame();
				ad.setTitle("Paga Dirigente");
				JButton paga = new JButton("Paga");
				paga.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Dirigente d = new Dirigente(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						ArrayList<Personale> personale = a.getAmministrativo().getPersonale();
						for(int i=0;i<personale.size();i++)
							if (d.equals(personale.get(i)))
							{
								a.paga(personale.get(i));
							}
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(paga),BorderLayout.SOUTH);	
			}
		});
		return pagaDirigente;
	}
	
	public JMenuItem PagaQuadro()
	{
		JMenuItem pagaQuadro = new JMenuItem("Quadro");
		pagaQuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiQuadroFrame ad = new AssumiQuadroFrame();
				ad.setTitle("Paga Quadro");
				JButton paga = new JButton("Paga");
				paga.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Quadro q = new Quadro(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						ArrayList<Personale> personale = a.getAmministrativo().getPersonale();
						for(int i=0;i<personale.size();i++)
							if (q.equals(personale.get(i)))
							{
								a.paga(personale.get(i));
							}
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(paga),BorderLayout.SOUTH);	
			}
		});
		return pagaQuadro;
	}
	
	public JMenuItem PagaOperaio()
	{
		JMenuItem pagaOperaio = new JMenuItem("Operaio");
		pagaOperaio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiOperaioFrame ad = new AssumiOperaioFrame();
				ad.setTitle("Paga Operaio");
				JButton paga = new JButton("Paga");
				paga.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Operaio p = new Operaio(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						ArrayList<Personale> personale = a.getAmministrativo().getPersonale();
						for(int i=0;i<personale.size();i++)
							if (p.equals(personale.get(i)))
							{
								a.paga(personale.get(i));
							}
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(paga),BorderLayout.SOUTH);	
			}
		});
		return pagaOperaio;
	}
	
	public JMenuItem PagaImpiegato()
	{
		JMenuItem pagaImpiegato = new JMenuItem("Impiegato");
		pagaImpiegato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiImpiegatoFrame ad = new AssumiImpiegatoFrame();
				ad.setTitle("Paga Impiegato");
				JButton paga = new JButton("Paga");
				paga.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Impiegato p = new Impiegato(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto(),ad.getMansione());
						ArrayList<Personale> personale = a.getAmministrativo().getPersonale();
						for(int i=0;i<personale.size();i++)
							if (p.equals(personale.get(i)))
							{
								a.paga(personale.get(i));
							}
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(paga),BorderLayout.SOUTH);	
			}
		});
		return pagaImpiegato;
	}
	
	public JMenu Licenzia()
	{
		JMenu assumiInterni = new JMenu("Licenzia");
		assumiInterni.add(LicenziaImpiegato());
		assumiInterni.add(LicenziaOperaio());
		assumiInterni.add(LicenziaDirigente());
		assumiInterni.add(LicenziaQuadro());
		return assumiInterni;
	}
	
	public JMenuItem LicenziaDirigente()
	{
		JMenuItem licenziaDirigente = new JMenuItem("Dirigente");
		licenziaDirigente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiDirigenteFrame ad = new AssumiDirigenteFrame();
				ad.setTitle("Licenzia Dirigente");
				JButton licenzia = new JButton("Licenzia");
				licenzia.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Dirigente d = new Dirigente(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						a.licenzia(d);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(licenzia),BorderLayout.SOUTH);	
			}
		});
		return licenziaDirigente;
	}
	
	public JMenuItem LicenziaQuadro()
	{
		JMenuItem licenziaQuadro = new JMenuItem("Quadro");
		licenziaQuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiQuadroFrame ad = new AssumiQuadroFrame();
				ad.setTitle("Licenzia Quadro");
				JButton licenzia = new JButton("Licenzia");
				licenzia.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Quadro q = new Quadro(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						a.licenzia(q);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(licenzia),BorderLayout.SOUTH);	
			}
		});
		return licenziaQuadro;
	}
	
	public JMenuItem LicenziaOperaio()
	{
		JMenuItem licenzia = new JMenuItem("Operaio");
		licenzia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiOperaioFrame ad = new AssumiOperaioFrame();
				ad.setTitle("Licenzia Operaio");
				JButton licenzia = new JButton("Licenzia");
				licenzia.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Operaio p = new Operaio(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto());
						a.licenzia(p);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(licenzia),BorderLayout.SOUTH);	
			}
		});
		return licenzia;
	}
	
	public JMenuItem LicenziaImpiegato()
	{
		JMenuItem licenzia = new JMenuItem("Impiegato");
		licenzia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AssumiImpiegatoFrame ad = new AssumiImpiegatoFrame();
				ad.setTitle("Licenzia Impiegato");
				JButton licenzia = new JButton("Licenzia");
				licenzia.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Impiegato p = new Impiegato(ad.getNome(),ad.getCognome(),ad.getIndirizzo(),ad.getConto(),ad.getMansione());
						a.licenzia(p);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(licenzia),BorderLayout.SOUTH);	
			}
		});
		return licenzia;
	}
	
	public JMenu Aggiungi()
	{
		JMenu aggiungiEsterni = new JMenu("Aggiungi");
		aggiungiEsterni.add(AggiungiEnte());
		aggiungiEsterni.add(AggiungiFornitore());
		aggiungiEsterni.add(AggiungiLocale());
		aggiungiEsterni.add(AggiungiCliente());
		aggiungiEsterni.add(AggiungiCantiere());
		return aggiungiEsterni;
	}
	
	public JMenuItem AggiungiEnte()
	{
		JMenuItem aggiungiEnte = new JMenuItem("Ente");
		aggiungiEnte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AggiungiEnteFrame ad = new AggiungiEnteFrame();
				JButton aggiungi = new JButton("Aggiungi");
				aggiungi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Ente ente = new Ente(ad.getNome(),ad.getAttivita());
						a.addEnte(ente);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(aggiungi),BorderLayout.SOUTH);	
			}
		});
		return aggiungiEnte;
	}
	
	public JMenuItem AggiungiFornitore()
	{
		JMenuItem aggiungiFornitore = new JMenuItem("Fornitore");
		aggiungiFornitore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AggiungiFornitoreFrame ad = new AggiungiFornitoreFrame();;
				JButton aggiungi = new JButton("Aggiungi");
				aggiungi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Fornitore f = new Fornitore(ad.getNome(),ad.getIndirizzo(),ad.getProdotto());
						a.addFornitore(f);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(aggiungi),BorderLayout.SOUTH);	
			}
		});
		return aggiungiFornitore;
	}
	
	public JMenuItem AggiungiLocale()
	{
		JMenuItem aggiungiLocale = new JMenuItem("Locale");
		aggiungiLocale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AggiungiLocaleFrame ad = new AggiungiLocaleFrame();;
				JButton aggiungi = new JButton("Aggiungi");
				aggiungi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Locale l = new Locale(ad.getNome(),ad.getAttivita(),ad.getProvincia());
						a.addLocale(l);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(aggiungi),BorderLayout.SOUTH);	
			}
		});
		return aggiungiLocale;
	}
	
	public JMenuItem AggiungiCliente()
	{
		JMenuItem aggiungiCliente = new JMenuItem("Cliente");
		aggiungiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AggiungiClienteFrame ad = new AggiungiClienteFrame();;
				JButton aggiungi = new JButton("Aggiungi");
				aggiungi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Cliente c = new Cliente(ad.getNome(),ad.getCognome(),ad.getIndirizzo());
						a.addCliente(c);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(aggiungi),BorderLayout.SOUTH);	
			}
		});
		return aggiungiCliente;
	}
	
	public JMenuItem AggiungiCantiere()
	{
		JMenuItem aggiungiCliente = new JMenuItem("Cantiere");
		aggiungiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				CantiereFrame ad = new CantiereFrame();;
				JButton aggiungiDirettore = new JButton("Diretto da Direttore");
				aggiungiDirettore.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Cantiere c = new Cantiere(ad.getValore(),ad.getNome(),ad.getDirettore());
						a.addCantiere(c);
						ad.dispose();
					}
				});
				JButton aggiungiQuadro = new JButton("Diretto da Quadro");
				aggiungiDirettore.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Cantiere c = new Cantiere(ad.getValore(),ad.getNome(),ad.getQuadro());
						a.addCantiere(c);
						ad.dispose();
					}
				});
				ad.add(ad.ButtonPanel(aggiungiDirettore,aggiungiQuadro),BorderLayout.SOUTH);	
			}
		});
		return aggiungiCliente;
	}
	
	public JMenu Rimuovi()
	{
		JMenu rimuoviEsterni = new JMenu("Rimuovi");
		rimuoviEsterni.add(RimuoviEnte());
		rimuoviEsterni.add(RimuoviFornitore());
		rimuoviEsterni.add(RimuoviLocale());
		rimuoviEsterni.add(RimuoviCliente());
		return rimuoviEsterni;
	}
	
	public JMenuItem RimuoviEnte()
	{
		JMenuItem rimuoviEnte = new JMenuItem("Ente");
		rimuoviEnte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AggiungiEnteFrame ad = new AggiungiEnteFrame();;
				ad.setTitle("Rimuovi Ente");
				JButton rimuovi = new JButton("Rimuovi");
				rimuovi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Ente ente = new Ente(ad.getNome(),ad.getAttivita());
						a.removeEnte(ente);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(rimuovi),BorderLayout.SOUTH);	
			}
		});
		return rimuoviEnte;
	}
	
	public JMenuItem RimuoviFornitore()
	{
		JMenuItem rimuoviFornitore = new JMenuItem("Rimuovi");
		rimuoviFornitore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AggiungiFornitoreFrame ad = new AggiungiFornitoreFrame();
				ad.setTitle("Rimuovi Fornitore");
				JButton rimuovi = new JButton("Rimuovi");
				rimuovi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Fornitore f = new Fornitore(ad.getNome(),ad.getIndirizzo(),ad.getProdotto());
						a.removeFornitore(f);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(rimuovi),BorderLayout.SOUTH);	
			}
		});
		return rimuoviFornitore;
	}
	
	public JMenuItem RimuoviLocale()
	{
		JMenuItem rimuoviLocale = new JMenuItem("Locale");
		rimuoviLocale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AggiungiLocaleFrame ad = new AggiungiLocaleFrame();
				ad.setTitle("Rimuovi Locale");
				JButton rimuovi = new JButton("Rimuovi");
				rimuovi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Locale l = new Locale(ad.getNome(),ad.getAttivita(),ad.getProvincia());
						a.removeLocale(l);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(rimuovi),BorderLayout.SOUTH);	
			}
		});
		return rimuoviLocale;
	}
	
	public JMenuItem RimuoviCliente()
	{
		JMenuItem rimuoviCliente = new JMenuItem("Cliente");
		rimuoviCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AggiungiClienteFrame ad = new AggiungiClienteFrame();
				ad.setTitle("Rimuovi Cliente");
				JButton rimuovi = new JButton("Rimuovi");
				rimuovi.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e)
					{
						Cliente c = new Cliente(ad.getNome(),ad.getCognome(),ad.getIndirizzo());
						a.removeCliente(c);
						ad.dispose();
					}
				});
				ad.add(ad.AssumiPanel(rimuovi),BorderLayout.SOUTH);	
			}
		});
		return rimuoviCliente;
	}
	
	public JMenu Mostra()
	{
		JMenu mostra = new JMenu("Mostra");
		mostra.add(MostraPersonale());
		mostra.add(MostraEsterni());
		mostra.add(Cantieri());
		return mostra;
	}
	
	public JMenuItem MostraPersonale()
	{
		JMenuItem mostraPersonale = new JMenuItem("Personale");
		mostraPersonale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.showPersonale());
			}
		});
		return mostraPersonale;
	}
	
	public JMenu MostraEsterni()
	{
		JMenu mostraEsterni = new JMenu("Esterni");
		mostraEsterni.add(Enti());
		mostraEsterni.add(Clienti());
		mostraEsterni.add(Fornitori());
		mostraEsterni.add(Locali());
		return mostraEsterni;
	}
	
	public JMenuItem Enti()
	{
		JMenuItem enti = new JMenuItem("Enti");
		enti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.showEnti());
			}
		});
		return enti;
	}
	
	public JMenuItem Clienti()
	{
		JMenuItem clienti = new JMenuItem("Clienti");
		clienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.showClienti());
			}
		});
		return clienti;
	}
	
	public JMenuItem Fornitori()
	{
		JMenuItem fornitori = new JMenuItem("Fornitori");
		fornitori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.showFornitori());
			}
		});
		return fornitori;
	}
	
	public JMenuItem Locali()
	{
		JMenuItem locali = new JMenuItem("Locali");
		locali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.showLocali());
			}
		});
		return locali;
	}
	
	public JMenuItem Cantieri()
	{
		JMenuItem cantieri = new JMenuItem("Cantieri");
		cantieri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.showCantieri());
			}
		});
		return cantieri;
	}

	public JMenu Report()
	{
		JMenu report = new JMenu("Report");
		report.add(ReportPersonale());
		report.add(ReportCantieri());
		report.add(ReportLocali());
		report.add(ReportEnti());
		report.add(ReportFornitori());
		return report;
	}
	
	public JMenu ReportCantieri()
	{
		JMenu cantieri = new JMenu("Cantieri");
		cantieri.add(CantieriIntervalore());
		cantieri.add(CantieriDirigenti());
		cantieri.add(CantieriQuadri());
		return cantieri;
	}
	
	public JMenuItem CantieriDirigenti()
	{
		JMenuItem dirigenti = new JMenuItem("Diretti da Dirigenti");
		dirigenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.reportCantieriDirigenti());
			}
		});
		return dirigenti;
	}
	
	public JMenuItem CantieriQuadri()
	{
		JMenuItem quadri = new JMenuItem("Diretti da Quadri");
		quadri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.reportCantieriQuadri());
			}
		});
		return quadri;
	}
	
	public JMenuItem CantieriIntervalore()
	{
		JMenuItem intervalore = new JMenuItem("Cantieri Compresi tra 2 Valori");
		intervalore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				IntervaloreFrame iframe = new IntervaloreFrame();
				JButton seleziona = new JButton("Seleziona");
				seleziona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						textArea.setText(a.reportCantieriInterValore(iframe.getInferiore(), iframe.getSuperiore()));
						iframe.dispose();
					}
				});
				iframe.add(iframe.ButtonPanel(seleziona),BorderLayout.SOUTH);
			}
		});
		return intervalore;
	}
	
	public JMenu ReportLocali()
	{
		JMenu locali = new JMenu("Locali");
		locali.add(LocaliAttivita());
		locali.add(LocaliProvincia());
		return locali;
	}
	
	public JMenuItem LocaliProvincia()
	{
		JMenuItem provincia = new JMenuItem("Data una Provincia");
		provincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ProvinciaFrame af = new ProvinciaFrame();
				JButton seleziona = new JButton("Seleziona");
				seleziona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						textArea.setText(a.reportLocaliDataProvincia(af.getAttivita()));
						af.dispose();
					}
				});
				af.add(af.ButtonPanel(seleziona),BorderLayout.SOUTH);	
			}
		});
		return provincia;
	}
	
	
	public JMenuItem LocaliAttivita()
	{
		JMenuItem attivita = new JMenuItem("Attivita");
		attivita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AttivitaFrame af = new AttivitaFrame();
				JButton seleziona = new JButton("Seleziona");
				seleziona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						textArea.setText(a.reportLocaliAttivita(af.getAttivita()));
						af.dispose();
					}
				});
				af.add(af.ButtonPanel(seleziona),BorderLayout.SOUTH);	
			}
		});
		return attivita;
	}
	
	public JMenu ReportEnti()
	{
		JMenu enti = new JMenu("Enti");
		enti.add(EntiAttivita());
		return enti;
	}
	
	public JMenuItem EntiAttivita()
	{
		JMenuItem attivita = new JMenuItem("Attivita");
		attivita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AttivitaFrame af = new AttivitaFrame();
				JButton seleziona = new JButton("Seleziona");
				seleziona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						textArea.setText(a.reportEntiAttivita(af.getAttivita()));
						af.dispose();
					}
				});
				af.add(af.ButtonPanel(seleziona),BorderLayout.SOUTH);	
			}
		});
		return attivita;
	}
	
	public JMenu ReportPersonale()
	{
		JMenu personale = new JMenu("Personale");
		personale.add(PersonaleImpegnato());
		personale.add(PersonaleNonImpegnato());
		return personale;
	}
	
	public JMenuItem PersonaleImpegnato()
	{
		JMenuItem impegnato = new JMenuItem("Personale Impegnato");
		impegnato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.reportPersonaleImpegnato());
			}
		});
		return impegnato;
	}
	
	public JMenuItem PersonaleNonImpegnato()
	{
		JMenuItem nonimpegnato = new JMenuItem("Personale Non Impegnato");
		nonimpegnato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(a.reportPersonaleNonImpegnato());
			}
		});
		return nonimpegnato;
	}
	public JMenu ReportFornitori()
	{
		JMenu fornitori = new JMenu("Fornitori");
		fornitori.add(FornitoriProdotto());
		return fornitori;
	}
	
	public JMenuItem FornitoriProdotto()
	{
		JMenuItem provincia = new JMenuItem("Dato un Prodotto");
		provincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ProdottoFrame af = new ProdottoFrame();
				JButton seleziona = new JButton("Seleziona");
				seleziona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						textArea.setText(a.reportFornitoriDatoProdotto(af.getAttivita()));
						af.dispose();
					}
				});
				af.add(af.ButtonPanel(seleziona),BorderLayout.SOUTH);	
			}
		});
		return provincia;
	}
	public Azienda getAziendaFromFile()
	{
		File file = new File("azienda.dat");
		ObjectInputStream ois;
		Azienda b;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			b = (Azienda) ois.readObject();
			ois.close();
			return b;
		}
		catch (ClassNotFoundException e) 
		{
				e.printStackTrace();
				System.out.println("Non trovo la classe");
				return null;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("IO");
			return null;
		}
	}	
}
