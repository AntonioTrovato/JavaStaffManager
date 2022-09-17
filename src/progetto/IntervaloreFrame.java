package progetto;

import java.awt.*;
import javax.swing.*;

public class IntervaloreFrame extends JFrame {
	
	private JTextField inferioreTextField;
	private JTextField superioreTextField;
	
	public IntervaloreFrame()
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
		JPanel infoPanel = new JPanel(new GridLayout(2,2));
		JLabel inferioreLabel = new JLabel("Inserisci Estremo Inferiore");
		inferioreTextField = new JTextField("0");
		JLabel superioreLabel = new JLabel("Inserisci Estremo Superiore");
		superioreTextField = new JTextField("0");
		infoPanel.add(inferioreLabel);
		infoPanel.add(inferioreTextField);
		infoPanel.add(superioreLabel);
		infoPanel.add(superioreTextField);
		return infoPanel;
	}
	
	public JPanel ButtonPanel(JButton button)
	{
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.add(button);
		return buttonPanel;
	}
	public double getInferiore()
	{
		return Double.parseDouble(inferioreTextField.getText());
	}
	public double getSuperiore()
	{
		return Double.parseDouble(superioreTextField.getText());
	}
}


