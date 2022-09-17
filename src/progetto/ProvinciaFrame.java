package progetto;

import java.awt.*;
import javax.swing.*;

public class ProvinciaFrame extends JFrame {
	
	private JTextField attivitaTextField;
	
	public ProvinciaFrame()
	{
		setSize(400,100);
		setLocation(200,200);
		setResizable(false);
		setTitle("Inserisci Provincia");
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
		JLabel attivitaLabel = new JLabel("Inserisci Provincia");
		attivitaTextField = new JTextField("Provincia");
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
