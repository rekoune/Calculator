
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;


public class MyWindow {

	JFrame frame;
	JTextField textField;
	JButton [] numButtons;
	JPanel panel;
	MyButtons button;
	Color backroundColor;
	ActionListener Action;

	public MyWindow (ActionListener pAction){
		this.Action = pAction;
		frame = new JFrame();
		textField = new JTextField(12);
		backroundColor = new Color(64, 64, 65);
		button = new MyButtons(this.Action);
		button.getOperButtons();
		numButtons = button.getNumButtons();
		panel = new JPanel();
	}

	public void displayWindow()
	{
		frame.getContentPane().setBackground(backroundColor);
		frame.setBounds(1000, 500, 400, 583);
		frame.setLayout(null);
		
		textField.setBounds(0, 0, 403, 80);
		textField.setFont(new Font("Arial", Font.PLAIN, 30));
		textField.addActionListener(this.Action);;
		textField.setBackground(backroundColor);
		textField.setForeground(Color.white);
		textField.setFocusable(false);
		textField.setText("0");

		panel.setBounds(0, 70, 400, 490);
		panel.setBackground(Color.black);
		panel.setLayout(new GridLayout(5, 4, 2 ,2));
		button.addToPanel(panel);
		
		frame.add(panel);
		frame.add(textField);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void printResult(Double result)
	{
		if (result % 1 == 0)
			textField.setText(String.format("%.0f", result));
		else
			textField.setText(String.valueOf(result));
	}
}
