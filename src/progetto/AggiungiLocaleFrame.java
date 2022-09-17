package progetto;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AggiungiLocaleFrame extends JFrame 
{
	
	private JTextField nomeTextField;
	private JTextField attivitaTextField;
	private JTextField provinciaTextField;
	
	
	public AggiungiLocaleFrame()
	{
		setSize(400,200);
		setLocation(200,200);
		setResizable(false);
		setTitle("Aggiungi Locale");
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
		JPanel infoPanel = new JPanel(new GridLayout(3,1));
		infoPanel.add(NomePanel());
		infoPanel.add(AttivitaPanel());
		infoPanel.add(ProvinciaPanel());
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
	
	public JPanel AttivitaPanel()
	{
		JPanel attivitaPanel = new JPanel(new GridLayout(1,2));
		JLabel attivitaLabel = new JLabel("Inserisci Attivita:");
		attivitaTextField = new JTextField("Attivita");
		attivitaPanel.add(attivitaLabel);
		attivitaPanel.add(attivitaTextField);
		return attivitaPanel;
	}
	
	public JPanel ProvinciaPanel()
	{
		JPanel provinciaPanel = new JPanel(new GridLayout(1,2));
		JLabel provinciaLabel = new JLabel("Inserisci Provincia:");
		provinciaTextField = new JTextField("Provincia");
		provinciaPanel.add(provinciaLabel);
		provinciaPanel.add(provinciaTextField);
		return provinciaPanel;
	}
	
	public String getNome()
	{
		return nomeTextField.getText();
	}
	
	public String getAttivita()
	{
		return attivitaTextField.getText();
	}
	
	public String getProvincia()
	{
		return provinciaTextField.getText();
	}

}
