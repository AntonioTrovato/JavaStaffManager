package progetto;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AggiungiFornitoreFrame extends JFrame 
{
	
	private JTextField nomeTextField;
	private JTextField codiceProdottoTextField;
	private JTextField descrizioneProdottoTextField;
	private JTextField indirizzoTextField;
	
	
	public AggiungiFornitoreFrame()
	{
		setSize(400,200);
		setLocation(200,200);
		setResizable(false);
		setTitle("Aggiungi Cliente");
		add(MainPanel());
		setVisible(true);
	}
	
	public JPanel MainPanel()
	{
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(InfoPanel(),BorderLayout.NORTH);
		return mainPanel;
	}
	
	public JPanel AssumiPanel(JButton button)
	{
		JPanel assumiPanel = new JPanel(new GridBagLayout());
		assumiPanel.add(button);
		return assumiPanel;
	}
	public JPanel InfoPanel()
	{
		JPanel infoPanel = new JPanel(new GridLayout(4,1));
		infoPanel.add(NomePanel());
		infoPanel.add(CodiceProdottoPanel());
		infoPanel.add(DescrizioneProdottoPanel());
		infoPanel.add(IndirizzoPanel());
		return infoPanel;
	}
	
	public JPanel NomePanel()
	{
		JPanel nomePanel = new JPanel(new GridLayout(1,2));
		JLabel nomeLabel = new JLabel("Inserisci Nome:");
		nomeTextField = new JTextField("Nome");
		nomePanel.add(nomeLabel);
		nomePanel.add(nomeTextField);
		return nomePanel;
	}
	
	public JPanel CodiceProdottoPanel()
	{
		JPanel prodottoPanel = new JPanel(new GridLayout(1,2));
		JLabel prodottoLabel = new JLabel("Inserisci Codice Prodotto:");
		codiceProdottoTextField = new JTextField("Codice");
		prodottoPanel.add(prodottoLabel);
		prodottoPanel.add(codiceProdottoTextField);
		return prodottoPanel;
	}
	
	public JPanel DescrizioneProdottoPanel()
	{
		JPanel prodottoPanel = new JPanel(new GridLayout(1,2));
		JLabel prodottoLabel = new JLabel("Inserisci Descrizione Prodotto:");
		descrizioneProdottoTextField = new JTextField("Prodotto");
		prodottoPanel.add(prodottoLabel);
		prodottoPanel.add(descrizioneProdottoTextField);
		return prodottoPanel;
	}
	
	public JPanel IndirizzoPanel()
	{
		JPanel indirizzoPanel = new JPanel(new GridLayout(1,2));
		JLabel indirizzoLabel = new JLabel("Inserisci Indirizzo:");
		indirizzoTextField = new JTextField("Indirizzo");
		indirizzoPanel.add(indirizzoLabel);
		indirizzoPanel.add(indirizzoTextField);
		return indirizzoPanel;
	}
	
	public String getNome()
	{
		return nomeTextField.getText();
	}
	
	public Prodotto getProdotto()
	{
		return new Prodotto(codiceProdottoTextField.getText(),descrizioneProdottoTextField.getText());
	}
	
	public String getIndirizzo()
	{
		return indirizzoTextField.getText();
	}	
}
