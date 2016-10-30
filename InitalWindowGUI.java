package wendler531;

import java.awt.Color;
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

public class InitalWindowGUI extends JFrame
{
	private int numc;
	public static int numl;
	public static Lift[] liftArray;
	private JLabel numLifts;
	private JLabel pSet;
	private JLabel numCycle;
	private JTextField numliftsF;
	private JTextField numCycleF;
	private JComboBox<String> pSetComboB;
	private String[] selection = {"Fresh","Heavy"};
	private JButton continueB;

	public InitalWindowGUI()
	{
		super("Wendler 5/3/1");
		numLifts = new JLabel("Number of lifts   ");
		numCycle = new JLabel("Cycle(s)  ");
		pSet = new JLabel("Percentages set  ");
		pSetComboB = new JComboBox<String>(selection);
		numliftsF = new JTextField();
		numCycleF = new JTextField();
		continueB = new JButton("Continue");
		Font font = new Font(Font.DIALOG, Font.PLAIN, 16);
		SpringLayout layout = new SpringLayout();

		this.setLayout(layout);
		this.setSize(400, 320);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		numLifts.setFont(font);
		numliftsF.setFont(font);
		numCycle.setFont(font);
		numCycleF.setFont(font);
		pSet.setFont(font);
		pSetComboB.setFont(font);
		continueB.setFont(font);

		numCycleF.setPreferredSize(new Dimension(40,30));
		numliftsF.setPreferredSize(new Dimension(40,30));


		continueB.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{


				if(numCycleF.getText().isEmpty() || numliftsF.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane,"fill out all required fields.");
				}
				else
				{
					numc = Integer.parseInt(numCycleF.getText());
					numl = Integer.parseInt(numliftsF.getText());
				}

				if(pSetComboB.getSelectedItem() == "Fresh")
				{
					Lift.freshSwitch = true;
				}

				if((numc > 12 || numc < 1))
				{
					JOptionPane.showMessageDialog(rootPane,"Cycle cannto be below 0 or above 12.");
				}
				else if(numl > 10 || numl < 1)
				{
					JOptionPane.showMessageDialog(rootPane,"lifts cannot be below 0 or above 10.");
				}
				else
				{
					Lift.weeks = numc*4;
					liftArray = new Lift[numl];
					liftArray[0] = new Lift();
					rid();
					SecondWindowGUI next = new SecondWindowGUI();
				}
			}
		}
				);


		layout.putConstraint(layout.NORTH, numLifts, 50, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, numLifts, 100, layout.WEST, getContentPane());

		layout.putConstraint(layout.NORTH, numliftsF, 47, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, numliftsF,210, layout.WEST, getContentPane());

		layout.putConstraint(layout.NORTH, numCycle, 90, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, numCycle, 142, layout.WEST, getContentPane());

		layout.putConstraint(layout.NORTH, numCycleF, 87, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, numCycleF, 210, layout.WEST, getContentPane());

		layout.putConstraint(layout.NORTH, pSet, 130, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, pSet, 86, layout.WEST, getContentPane());

		layout.putConstraint(layout.NORTH, pSetComboB, 127, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, pSetComboB, 210, layout.WEST, getContentPane());

		layout.putConstraint(layout.NORTH, continueB, 200, layout.NORTH, getContentPane());
		layout.putConstraint(layout.WEST, continueB, 160, layout.WEST, getContentPane());

		this.add(numLifts);
		this.add(numCycle);
		this.add(pSet);
		this.add(numCycleF);
		this.add(numliftsF);
		this.add(pSetComboB);
		this.add(continueB);

		this.setVisible(true);
	}

	private void rid()
	{
		this.dispose();
	}
	// end of class
}
