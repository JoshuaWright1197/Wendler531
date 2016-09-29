package wendler531;

import javax.swing.UIManager;


public class lifttester
{
	public static void main(String[] args)
	{
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		InitalWindowGUI win = new InitalWindowGUI();
	}
}
