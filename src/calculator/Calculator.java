/* Justin Kahr
 * Computer Science Block Seven
 * 
 * FileName: Calculator.java
 * Description: A basic four function calculator.
 * 
 * Honor Code: On my honor If have neither given nor revived any
 * unauthorized aid on this assignment.
 * -Justin Kahr
 */

package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.text.DecimalFormat;

public class Calculator extends JFrame implements ActionListener
{
	//initialize decimal format
	DecimalFormat df = new DecimalFormat("###,###,###.##");
	
	//initialize a bunch of buttons as global variables to make life easier
	
	//0-9 number buttons
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	JButton seven;
	JButton eight;
	JButton nine;
	JButton zero;
	
	//4 basic operations
	JButton add;
	JButton minus;
	JButton times;
	JButton divide;
	
	//decimal point
	JButton point;
	
	//negative number
	JButton negative;
	
	//do operation
	JButton equals;
	
	//reset
	JButton clear;
	
	//quit program
	JButton exit;
	
	//calculator "screen" and negative sign
	JLabel screen;
	JLabel negativeLabel;
	
	//stores the input and displays on screen
	String input = " ";
	
	//records which operation is being done
	String operation;
	
	//the two numbers which are being operated on
	double num1;
	double num2;
	
	//checks is a number should be made to be negative
	boolean checknegative = false;
	
	public static void main(String[] args)
	{
		Calculator obj1 = new Calculator();
		obj1.setVisible(true);
	}
	
	public Calculator()
	{
		super("Calculator");//it's a calculator
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setLayout(new BorderLayout());//use border layout
		
		JPanel northCanvas = new JPanel();//north canvas
		northCanvas.setBackground(Color.WHITE);//sets the background to white
			
			negativeLabel = new JLabel(" ");//starts negative label with nothing
			negativeLabel.setFont(new Font("Courier New", Font.PLAIN, 50));//make the font big
			northCanvas.add(negativeLabel);
			
			screen = new JLabel(input);//screen shows the user's input
			screen.setFont(new Font("Courier New", Font.PLAIN, 50));//make the font big
			northCanvas.add(screen);
			
		add(northCanvas, BorderLayout.NORTH);
		
		JPanel centerCanvas = new JPanel();//center canvas
		centerCanvas.setLayout(new GridLayout(4,4));//4x4 grid layout
		centerCanvas.setBackground(Color.DARK_GRAY);//sets the background to dark gray
			
			//number 7 button
			seven = new JButton("7");
			centerCanvas.add(seven);
			seven.addActionListener(this);
			
			//number 8 button
			eight = new JButton("8");
			centerCanvas.add(eight);
			eight.addActionListener(this);
			
			//number 9 button
			nine = new JButton("9");
			centerCanvas.add(nine);
			nine.addActionListener(this);
			
			//divide operation button
			divide = new JButton("/");
			centerCanvas.add(divide);
			divide.addActionListener(this);
			
			//number four button
			four = new JButton("4");
			centerCanvas.add(four);
			four.addActionListener(this);
			
			//number 5 button
			five = new JButton("5");
			centerCanvas.add(five);
			five.addActionListener(this);
			
			//number 6 button
			six = new JButton("6");
			centerCanvas.add(six);
			six.addActionListener(this);
			
			//times operation button
			times = new JButton("*");
			centerCanvas.add(times);
			times.addActionListener(this);
			
			//number one button
			one = new JButton("1");
			centerCanvas.add(one);
			one.addActionListener(this);
		 	
			//number two button
			two = new JButton("2");
			centerCanvas.add(two);
			two.addActionListener(this);
			
			//number 3 button
			three = new JButton("3");
			centerCanvas.add(three);
			three.addActionListener(this);
			
			//minus operation button
			minus = new JButton("-");
			centerCanvas.add(minus);
			minus.addActionListener(this);
			
			//number zero button
			zero = new JButton("0");
			centerCanvas.add(zero);
			zero.addActionListener(this);
			
			//decimal point button
			point = new JButton(".");
			centerCanvas.add(point);
			point.addActionListener(this);
			
			//negative number button
			negative = new JButton("+/-");
			centerCanvas.add(negative);
			negative.addActionListener(this);
			
			//add operation button
			add = new JButton("+");
			centerCanvas.add(add);
			add.addActionListener(this);
			
		add(centerCanvas, BorderLayout.CENTER);
		
		//south canvas
		JPanel southCanvas = new JPanel();
		southCanvas.setLayout(new GridLayout(1,3));//1x3 border layout
		southCanvas.setBackground(Color.DARK_GRAY);//set the color to dark grey
			
			//exit button
			exit = new JButton("Exit");
			southCanvas.add(exit);
			exit.addActionListener(this);
		
			//clear button
			clear = new JButton("AC");
			southCanvas.add(clear);
			clear.addActionListener(this);
			
			//equals button
			equals = new JButton("=");
			southCanvas.add(equals);
			equals.addActionListener(this);
			
		add(southCanvas, BorderLayout.SOUTH);
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		String button = e.getActionCommand();//get the button pressed
		
		for(int i = 0; i < 10; i++)//for 0-9
		{
			if(button.equals(i+""))//if the button is that number
			{
				input += i;//add that number to the input string
				screen.setText(input);//display on screen
			}
		}
		
		if(button.equals("."))//if decimal point
		{
			input+=".";//add a decimal point to the input string
			screen.setText(input);//display on screen
		}
		
		else if(button.equals("+"))//if add
		{
			num1 = Double.parseDouble(input);//lock in input as the first number
			if(checknegative == true)//if it should be negative
			{
				num1 -= 2*(num1);//subtract the number from the number twice
			}
			checknegative = false;//reset the negative check to positive for the next number
			negativeLabel.setText(" ");//reset the negative symbol on screen for the next number
			operation = "+";//remember we are adding
			input = "";//reset the input
			screen.setText(operation);//display the operation
		}
		else if(button.equals("-"))//if subtract
		{
			num1 = Double.parseDouble(input);//lock in input as the first number
			if(checknegative == true)//if it should be negative
			{
				num1 -= 2*(num1);//subtract the number from the number twice
			}
			checknegative = false;//reset the negative check to positive for the next number
			negativeLabel.setText(" ");//reset the negative symbol on screen for the next number
			operation = "-";//remember we are subtracting
			input = "";//reset the input
			screen.setText(operation);//display the operation
		}
		else if(button.equals("*"))//if multiply
		{
			num1 = Double.parseDouble(input);//lock in input as the first number
			if(checknegative == true)//if it should be negative
			{
				num1 -= 2*(num1);//subtract the number from the number twice
			}
			checknegative = false;//reset the negative check to positive for the next number
			negativeLabel.setText(" ");//reset the negative symbol on screen for the next number
			operation = "*";//remember we are multiplying
			input = "";//reset the input
			screen.setText(operation);//display the operation
		}
		else if(button.equals("/"))//if divide
		{
			num1 = Double.parseDouble(input);//lock in input as the first number
			if(checknegative == true)//if it should be negative
			{
				num1 -= 2*(num1);//subtract the number from the number twice
			}
			checknegative = false;//reset the negative check to positive for the next number
			negativeLabel.setText(" ");//reset the negative symbol on screen for the next number
			operation = "/";//remember we are dividing
			input = "";//reset the input
			screen.setText(operation);//display the operation
		}
		
		
		else if(button.equals("="))//if equals
		{
			num2 = Double.parseDouble(input);//lock in input as the second number
			if(checknegative == true)//if it should be negative
			{
				num2 -= 2*(num2);//subtract the number from the number twice
			}
			checknegative = false;//reset the negative check to positive for the next number
			negativeLabel.setText(" ");//reset the negative symbol on screen for the next number
			if(operation.equals("+"))//if operation is add
			{
				input = ""+df.format(num1+num2);//add the two values
				screen.setText(input);//output it to the screen
			}
			else if(operation.equals("-"))//if operation is subtract
			{
				input = ""+df.format(num1-num2);//subtract the two numbers
				screen.setText(input);//output it to the screen
			}
			else if(operation.equals("*"))//if operation is multiplication
			{
				input = ""+df.format(num1*num2);//multiply the two numbers
				screen.setText(input);//output it to the screen
			}
			else if(operation.equals("/"))//if operation is divide
			{
				input = ""+df.format(num1/num2);//divide the two numbers
				screen.setText(input);//output it two the screen
			}
			operation = null;//resets operation
		}
		
		else if(button.equals("+/-"))//if negative button
		{
			if(checknegative == false)//if the number isn't negative
			{
				checknegative = true;//make it negative
				negativeLabel.setText("-");//draw the negative sign for the user
			}
			else//is the number is negative
			{
				checknegative = false;//make it positive
				negativeLabel.setText(" ");//take away the negative sign
			}
		}
		
		else if(button.equals("AC"))//if clear button
		{
			num1 = 0;//reset num1
			num2 = 0;//reset num2
			operation = "";//reset operation
			input = "";//reset input
			screen.setText(input);//draw reset input
		}
		
		else if(button.equals("Exit"))//if exit
		{
			System.exit(0);//exit the program
		}
		
	}

}

