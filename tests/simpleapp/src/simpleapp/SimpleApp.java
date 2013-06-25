package simpleapp;
import java.text.DateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import barrysoft.twinkle.Twinkle;

public class SimpleApp extends JFrame
{
	private static final long serialVersionUID = 3807502313392617441L;
	
	public SimpleApp()
	{				
		setTitle("Twinkle Test");
		setSize(500, 350);
		JLabel l = new JLabel(DateFormat.getInstance().format(Calendar.getInstance().getTime()));
		l.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(l);
	}
	
	public static void main(String[] argv)
	{		
		try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       e.printStackTrace();
	    }
	    catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    catch (InstantiationException e) {
	    	e.printStackTrace();
	    }
	    catch (IllegalAccessException e) {
	    	e.printStackTrace();
	    }
		
		SimpleApp app = new SimpleApp();	

		Twinkle.getInstance().runUpdate(SimpleApp.class, 
				"http://www.barrysoft.it/twinkle/simpleapp/appcast.xml",
				"/simpleapp/infos.properties");
		
		app.setVisible(true);
	}	
}
