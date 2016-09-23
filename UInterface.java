package UBTuitionCalculator;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * ProjectPortfolio
 * @author Winnie Sep 22, 2016
 * UInterface.java
 * The purpose of this small summer tuition calculator is to implement 
 * the MVC (Model-View-Controller) architectural pattern. 
 * Model - transitioning the data to object classes and making a UML diagram to show the design of the UI
 * View - what the user visualizes; particularly the user interface (UI)
 * Controller - the code and logic behind the program; links the model and the view together
 * 
 * The interface allows a typical undergraduate student from University at Buffalo
 * to input their name, resident status, and # credits they are taking. 
 * The estimated cost is then displayed to them on the interface. 
 */


public class UInterface extends JFrame implements ActionListener{
	//*******MY INTERFACE********
	JLabel lblLastName = new JLabel("Enter your last name: ");
	JTextField txtLastName = new JTextField(10);
	JRadioButton radNYS = new JRadioButton("NYS Resident", false);
	JRadioButton radNONNYS = new JRadioButton("NonNYS Resident", false);
	ButtonGroup butStatus = new ButtonGroup();
	JLabel lblCredits = new JLabel("Enter the number of credits you are taking: ");
	JTextField txtCredits = new JTextField(10);
	JButton butSubmit = new JButton("Submit details");
	JLabel lblTotalFees = new JLabel("The total fees came up to be: ");
	JTextField txtTotalFees = new JTextField(10);
	JButton butClear = new JButton("Clear fields");
	
	public UInterface(){
		setTitle("Summer Tuition Calculator");
		setLayout(new FlowLayout());
		setSize(300, 220); //w, h
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		butStatus.add(radNYS);
		butStatus.add(radNONNYS);
		add(lblLastName);
		add(txtLastName);
		add(radNYS);
		add(radNONNYS);
		add(lblCredits);
		add(txtCredits);
		add(butSubmit);
		add(lblTotalFees);
		add(txtTotalFees);
		add(butClear);
		butSubmit.addActionListener(this);
		butClear.addActionListener(this);
		
	}
	

	
	//*******MY CONTROLLER********
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == butSubmit){
			DecimalFormat formatDollars = new DecimalFormat("$###,##0.00");
			String name = txtLastName.getText();
			boolean nysResident = radNYS.isSelected();
			if(txtCredits.getText().length() > 0){
				int credits = Integer.parseInt(txtCredits.getText());
				Fees fees = new Fees(name, nysResident, credits);
				double totalFees = fees.calculateFee();
				txtTotalFees.setText(formatDollars.format(totalFees));
			}
		}
		if(e.getSource() == butClear){
			txtLastName.setText("");
			txtCredits.setText("");
			txtTotalFees.setText("");;
		}
		
	}
	
	public static void main(String[] args){
		UInterface calculateFeeUI = new UInterface();
		calculateFeeUI.setVisible(true);
	}
	
}
