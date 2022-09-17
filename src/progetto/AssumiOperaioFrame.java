package progetto;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AssumiOperaioFrame extends JFrame 
{
	
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField indirizzoTextField;
	private JTextField contoTextField;
	
	
	public AssumiOperaioFrame()
	{
		setSize(400,200);
		setLocation(200,200);
		setResizable(false);
		setTitle("AssumiOperaio");
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
		infoPanel.add(CognomePanel());
		infoPanel.add(IndirizzoPanel());
		infoPanel.add(ContoPanel());
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
	
	public JPanel CognomePanel()
	{
		JPanel cognomePanel = new JPanel(new GridLayout(1,2));
		JLabel cognomeLabel = new JLabel("Inserisci Cognome:");
		cognomeTextField = new JTextField("Cognome");
		cognomePanel.add(cognomeLabel);
		cognomePanel.add(cognomeTextField);
		return cognomePanel;
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
	
	public JPanel ContoPanel()
	{
		JPanel contoPanel = new JPanel(new GridLayout(1,2));
		JLabel contoLabel = new JLabel("Inserisci Conto:");
		contoTextField = new JTextField("Conto");
		contoPanel.add(contoLabel);
		contoPanel.add(contoTextField);
		return contoPanel;
	}
	
	public String getNome()
	{
		return nomeTextField.getText();
	}
	
	public String getCognome()
	{
		return cognomeTextField.getText();
	}
	
	public String getIndirizzo()
	{
		return indirizzoTextField.getText();
	}
	
	public double getConto()
	{
		return Double.parseDouble(contoTextField.getText());
	}
	
}
