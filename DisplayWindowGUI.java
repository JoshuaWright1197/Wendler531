package wendler531;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class DisplayWindowGUI extends JFrame
{
	private JTextArea area;
	private String result;
	private JScrollPane scrollPane;
	private Font font;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem export;
	private File file;
	private BufferedWriter bf;
	private FileWriter fw;
	
	public DisplayWindowGUI()
	{
		super("Wendler 5/3/1");
		
		
		font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
		area = new JTextArea();
		
		
		scrollPane = new JScrollPane(area);
		result = "";
		
		setResizable(true);
		setSize(1200,700);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1,1));
		
		
		
		for(int i = 0; i < InitalWindowGUI.liftArray.length; i++)
		{
			result += InitalWindowGUI.liftArray[i].toString()+"\n";	
		}
		
		area.setEditable(false);
		area.setFont(font);
		area.setText(result);
		area.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		BuildMenu();
		
		add(scrollPane);
		
		setVisible(true);
	}
	
	private void BuildMenu()
	{
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		export = new JMenuItem("Export as .txt");
		
		fileMenu.add(export);
		menuBar.add(fileMenu);
		
		this.setJMenuBar(menuBar);
		
		
		export.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				file = new File("Wnedler531.txt");

				try
				{
					fw = new FileWriter(file);
					bf = new BufferedWriter(fw);
					bf.write(result);
					bf.close();
					fw.close();
				}
				catch (IOException e1)
				{
					System.out.print(e1.getMessage());
				}	
			}
		}
				);
	}
	
	
	
	
}// end of class
