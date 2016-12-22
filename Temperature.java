import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temperature extends JFrame implements ActionListener{
    private Container pane;

    private JButton cToF, fToC;
    private JLabel l;
    private JTextField input, result;
 
  //CONSTRUCTOR SETS EVERYTHING UP
    public Temperature() {
	this.setTitle("Temperature");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)

	cToF = new JButton("celsius to farenheit");
	fToC = new JButton("farenheit to celsius");
	cToF.addActionListener(this);
	cToF.setActionCommand("cToF");
	fToC.addActionListener(this);
	fToC.setActionCommand("fToC");
	input = new JTextField(12);
        result = new JTextField(12);
	pane.add(input);
	pane.add(cToF);
	pane.add(fToC);
	pane.add(result);
    }

    public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("cToF")) {
	    result.setText(Double.toString(CtoF(Double.parseDouble(input.getText()))));
	}
	else if (e.getActionCommand().equals("fToC")) {
	    result.setText(Double.toString(FtoC(Double.parseDouble(input.getText()))));
	}
    }
    
    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Temperature g = new Temperature();
	g.setVisible(true);
    }
    
    public static double CtoF(double t) {
	return t * (9.0 / 5.0) + 32.0;
    }

    public static double FtoC(double t) {
	return (t - 32.0) * (5.0 / 9.0);
    }

}
