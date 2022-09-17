package progetto;

import java.awt.*;
import javax.swing.*;

public class CantiereFrame extends JFrame {
	
	private JTextField nomeCantiereTextField;
	private JTextField valoreTextField;
	private JTextField nomeDirettoreTextField;
	private JTextField cognomeDirettoreTextField;
	private JTextField contoDirettoreTextField;
	private JTextField indirizzoDirettoreTextField;
	
	public CantiereFrame()
	{
		setSize(800,200);
		setLocation(200,200);
		setResizable(false);
		setTitle("Inserisci Cantiere");
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
		JPanel infoPanel = new JPanel(new GridLayout(3,4));
		JLabel valoreLabel = new JLabel("Inserisci Valore");
		valoreTextField = new JTextField("0");
		JLabel nomeCantiereLabel = new JLabel("Inserisci Nome Cantiere");
		nomeCantiereTextField = new JTextField("Nome Cantiere");
		JLabel nomeDirettore = new JLabel("Inserisci Nome Direttore");
		nomeDirettoreTextField = new JTextField("Nome Direttore");
		JLabel cognomeDirettore = new JLabel("Inserisci Cognome Direttore");
		cognomeDirettoreTextField = new JTextField("Cognome Direttore");
		JLabel indirizzoDirettore = new JLabel("Inserisci Indirizzo Direttore");
		indirizzoDirettoreTextField = new JTextField("Indirizzo Direttore");
		JLabel contoDirettore = new JLabel("Inserisci Conto Direttore");
		contoDirettoreTextField = new JTextField("Conto Direttore");
		infoPanel.add(valoreLabel);
		infoPanel.add(valoreTextField);
		infoPanel.add(nomeCantiereLabel);
		infoPanel.add(nomeCantiereTextField);
		infoPanel.add(nomeDirettore);
		infoPanel.add(nomeDirettoreTextField);
		infoPanel.add(cognomeDirettore);
		infoPanel.add(cognomeDirettoreTextField);
		infoPanel.add(indirizzoDirettore);
		infoPanel.add(indirizzoDirettoreTextField);
		infoPanel.add(contoDirettore);
		infoPanel.add(contoDirettoreTextField);
		return infoPanel;
	}
	
	public JPanel ButtonPanel(JButton button,JButton button2)
	{
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.add(button);
		buttonPanel.add(button2);
		return buttonPanel;
	}
	
	public String getNome()
	{
		return nomeCantiereTextField.getText();
	}
	
	public double getValore()
	{
		return Double.parseDouble(valoreTextField.getText());
	}
	
	public Dirigente getDirettore()
	{
		return new Dirigente(nomeDirettoreTextField.getText(),cognomeDirettoreTextField.getText(),indirizzoDirettoreTextField.getText(),Double.parseDouble(contoDirettoreTextField.getText()));	
	}
	
	public Quadro getQuadro()
	{
		return new Quadro(nomeDirettoreTextField.getText(),cognomeDirettoreTextField.getText(),indirizzoDirettoreTextField.getText(),Double.parseDouble(contoDirettoreTextField.getText()));
			
	}
}


