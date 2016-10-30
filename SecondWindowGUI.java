package wendler531;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class SecondWindowGUI extends JFrame
{
	private JTextField liftNameF;
	private JTextField weightF;
	private JTextField repsF;
	private JTextField ormF;
	private JLabel number;
	private JLabel liftName;
	private JLabel weight;
	private JLabel reps;
	private JLabel orm;
	private JLabel or;
	private JButton continueB,calculateB;
	private int counter;
	
	public SecondWindowGUI()
	{
		super("Wendler 5/3/1");
		
		counter = 1;
		number = new JLabel("Lift # " + (counter));
		liftName = new JLabel("Lift");
		weight = new JLabel("Weight");
		reps = new JLabel("Reps");
		orm = new JLabel("One Rep Max");
		or = new JLabel("Or");
		liftNameF = new JTextField();
		weightF = new JTextField();
		repsF = new JTextField();
		ormF = new JTextField();
		continueB = new JButton("Continue");
		calculateB = new JButton("Calculate");
		Font font = new Font(Font.DIALOG, Font.PLAIN, 16);
		SpringLayout layout = new SpringLayout();
		
		number.setFont(font);
		liftName.setFont(font);
		liftNameF.setFont(font);
		orm.setFont(font);
		ormF.setFont(font);
		or.setFont(font);
		weight.setFont(font);
		weightF.setFont(font);
		reps.setFont(font);
		repsF.setFont(font);
		calculateB.setFont(font);
		continueB.setFont(font);
		
		this.setLayout(layout);
		this.setSize(400, 320);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		liftNameF.setPreferredSize(new Dimension(180,30));
		ormF.setPreferredSize(new Dimension(70,30));
		weightF.setPreferredSize(new Dimension(60,30));
		repsF.setPreferredSize(new Dimension(50,30));
		
		
		calculateB.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( weightF.getText().isEmpty() == false && repsF.getText().isEmpty() == false)
				{
						InitalWindowGUI.liftArray[counter-1].calOneRepMax(Integer.parseInt(weightF.getText()),
								Integer.parseInt(repsF.getText()));

						ormF.setText(""+InitalWindowGUI.liftArray[counter-1].getOneRepMax());	
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane,"fill out all required fields.");
				}

			}
		}
				);
		
		
		continueB.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( liftNameF.getText().isEmpty() == false && ormF.getText().isEmpty() == false )
				{
					InitalWindowGUI.liftArray[counter-1].setName(liftNameF.getText());
					InitalWindowGUI.liftArray[counter-1].setOneRepMax(Integer.parseInt(ormF.getText()));

					if(counter < InitalWindowGUI.numl)
					{
						counter++;
						number.setText("Lift # " + (counter));
						ormF.setText("");
						liftNameF.setText("");
						weightF.setText("");
						repsF.setText("");
						InitalWindowGUI.liftArray[counter-1] = new Lift();
					}
					else
					{
						rid();
						DisplayWindowGUI d = new DisplayWindowGUI();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane,"fill out all required fields.");
				}
			}
		}
				);
		
		add(liftName);
		add(liftNameF);
		add(number);
		add(orm);
		add(ormF);
		add(or);
		add(weight);
		add(weightF);
		add(reps);
		add(repsF);
		add(calculateB);
		add(continueB);
		
		
		layout.putConstraint(layout.NORTH, number, 10, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, number, 10, layout.WEST, getContentPane());
		
		layout.putConstraint(layout.NORTH,liftName, 50, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, liftName,70, layout.WEST,getContentPane());
		
		layout.putConstraint(layout.NORTH, liftNameF, 47, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, liftNameF, 100, layout.WEST,getContentPane());
		
		layout.putConstraint(layout.NORTH, orm, 90, layout.NORTH,getContentPane());
		layout.putConstraint(layout.WEST, orm, 70, layout.WEST,getContentPane());
		
		layout.putConstraint(layout.NORTH, ormF, 87, layout.NORTH,getContentPane());
		layout.putConstraint(layout.WEST, ormF, 170, layout.WEST,getContentPane());
		
		layout.putConstraint(layout.NORTH, or, 90, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, or, 250, layout.WEST, getContentPane());
		
		layout.putConstraint(layout.NORTH, weight, 130, layout.NORTH,getContentPane());;
		layout.putConstraint(layout.WEST, weight, 70, layout.WEST,getContentPane());
		
		layout.putConstraint(layout.NORTH, weightF, 127, layout.NORTH, getContentPane());;
		layout.putConstraint(layout.WEST, weightF, 125, layout.WEST,getContentPane());
		
		layout.putConstraint(layout.NORTH, reps, 130, layout.NORTH, getContentPane());;
		layout.putConstraint(layout.WEST, reps, 190, layout.WEST, getContentPane());
		
		layout.putConstraint(layout.NORTH, repsF, 127, layout.NORTH, getContentPane());;
		layout.putConstraint(layout.WEST, repsF, 230, layout.WEST,getContentPane());
		
		layout.putConstraint(layout.NORTH, calculateB, 170, layout.NORTH, getContentPane());;
		layout.putConstraint(layout.WEST, calculateB, 80, layout.WEST, getContentPane());
		
		layout.putConstraint(layout.NORTH, continueB, 220, layout.NORTH, getContentPane());;
		layout.putConstraint(layout.WEST, continueB, 200, layout.WEST, getContentPane());
		
		
		setVisible(true);
	}
	
	private void rid()
	{
		this.dispose();
	}
	// end of class
}
