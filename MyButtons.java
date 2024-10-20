
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionListener;;

public  class MyButtons {

	public JButton 			addButton;
	public JButton 			subButton;
	public JButton 			mulButton;
	public JButton 			divButton;
	public JButton 			modButton;
	public JButton 			equButton;
	public JButton 			delButton;
	public JButton 			clrButton;
	public JButton 			dotButton;
	public JButton 			signButton;
	public Color			speColor;
	public Color			operColor;
	private JButton []		operationButtons;
	private JButton [] 		numButtons;
	private ActionListener	Action;
	private Font			buttonFont;

	public MyButtons(ActionListener pAction)
	{
		this.Action = pAction;
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		modButton = new JButton("%");
		equButton = new JButton("=");
		delButton = new JButton("delete");
		clrButton = new JButton("clear");
		dotButton = new JButton(".");
		signButton = new JButton("+/-");
		operationButtons = new JButton[10];
		numButtons = new JButton[10];
		speColor = new Color(65, 65, 65);
		operColor = new Color(255, 165, 0);
		buttonFont = new  Font("Arial", Font.BOLD, 18);
	}
	public  void getOperButtons()
	{
		operationButtons[0] = addButton;
		operationButtons[1] = subButton;
		operationButtons[2] = mulButton;
		operationButtons[3] = divButton;
		operationButtons[4] = modButton;
		operationButtons[5] = equButton;
		operationButtons[6] = delButton;
		operationButtons[7] = clrButton;
		operationButtons[8] = dotButton;
		operationButtons[9] = signButton;
		for(int i = 0; i < 10; i++)
		{
			operationButtons[i].setFocusable(false);
			operationButtons[i].addActionListener(this.Action);
			operationButtons[i].setForeground(Color.white);
			if (i <= 5)
				operationButtons[i].setBackground(operColor);
			else 
				operationButtons[i].setBackground(speColor);

			operationButtons[i].setOpaque(true);
			operationButtons[i].setBorderPainted(false);
			operationButtons[i].setFont(buttonFont);
		}
	}

	public	JButton[] getNumButtons()
	{
		for (int i = 0; i < 10; i++)
		{
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].setFocusable(false);
			numButtons[i].addActionListener(this.Action);
			numButtons[i].setForeground(Color.white);
			numButtons[i].setBackground(Color.gray);
			numButtons[i].setOpaque(true);
			numButtons[i].setBorderPainted(false);
			numButtons[i].setFont(buttonFont);
		}
		return (numButtons);
	}

	public void addToPanel(JPanel panel)
	{
		panel.add(delButton);
		panel.add(clrButton);
		panel.add(modButton);
		panel.add(divButton);
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(mulButton);
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subButton);
		panel.add(numButtons[1]);
		panel.add(numButtons[2]);
		panel.add(numButtons[3]);
		panel.add(addButton);
		panel.add(signButton);
		panel.add(numButtons[0]);
		panel.add(dotButton);
		panel.add(equButton);
	}
}
