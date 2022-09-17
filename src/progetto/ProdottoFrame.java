package progetto;

import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProdottoFrame extends JFrame {
	
	private JTextField attivitaTextField;
	
	public ProdottoFrame()
	{
		setSize(400,100);
		setLocation(200,200);
		setResizable(false);
		setTitle("Inserisci Prodotto");
		add(MainPanel());
		setVisible(true);
	}
	
	public JPanel MainPanel()
	{
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(InfoPanel(),BorderLayout.NORTH);
		return mainPanel;
	}
	
	public JPanel InfoPanel()
	{
		JPanel infoPanel = new JPanel(new GridBagLayout());
		JLabel attivitaLabel = new JLabel("Inserisci Prodotto");
		attivitaTextField = new JTextField("Prodotto");
		infoPanel.add(attivitaLabel);
		infoPanel.add(attivitaTextField);
		return infoPanel;
	}
	
	public JPanel ButtonPanel(JButton button)
	{
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.add(button);
		return buttonPanel;
	}
	public String getAttivita()
	{
		return attivitaTextField.getText();
	}
}
