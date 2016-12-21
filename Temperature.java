import javax.swing.*;
import java.awt.*;

public class Temperature extends JFrame{
    private Container pane;

    private JButton cToF, fToC;
    private JLabel l;
    private JTextField celsius, farenheit;
 
  //CONSTRUCTOR SETS EVERYTHING UP
    public Temperature() {
	this.setTitle("Temperature");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	
	b = new JButton("Do Nothing");
	l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
	celsius = new JTextField(12);
	farenheit = new JTextField(12);
	pane.add(l);
	pane.add(b);
	pane.add(celsius);
	pane.add(farenheit);
    }
    
    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Window2 g = new Window2();
	g.setVisible(true);
    }
}
    public static double CtoF(double t) {
	if (t == -40.0) {
	    return -40.0;
	}
	return t * (9.0 / 5.0) + 32.0;
    }

    public static double FtoC(double t) {
	return (t - 32.0) * (5.0 / 9.0);
    }

}
