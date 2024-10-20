
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Calculator implements ActionListener{
	
	private double		result;
	private double		number;
	private boolean		numberFlag;
	private boolean		operFlag;
	private char		operature;
	private boolean		start;
	private boolean		restart;
	private boolean		sign;
	private MyWindow	Window;
	private String		DisplayedText;
	private JButton		pressedButton;
	ActionListener		Action;


	public Calculator(){
		Window = new MyWindow(this);
		result = 0;
		number = 0;
		numberFlag = true;
		operFlag = false;
		operature = 'n';
		start = false;
		restart = false;
		sign = true;
	}


	public void openCalc(){
		Window.displayWindow();
	}

	private void	calculating(char operature)
	{
		this.numberFlag = true;
		if (this.start == false)
			this.start = true;
		applyOperation();
		this.operature = operature;
		this.restart = false;
		Window.printResult(result);
	}

	private void	clearingField()
	{
		Window.textField.setText("0");
		start = false;
		restart = true;
		result = 0;
		operature = 'n';
		numberFlag = true;
		sign = true;
	}

	private void asigning()
	{
		if (DisplayedText.length() == 1 && DisplayedText.charAt(0) == '0')
				Window.textField.setText("0");
		else
		{
			if (sign == true)
			{
				if (DisplayedText.charAt(0) != '-')
					Window.textField.setText("-".concat(DisplayedText));
				result *= -1;
				sign = false;
			}
			else
			{
				Window.textField.setText(DisplayedText.substring(1));
				sign = true;
				result *= -1;
			}
		}
	}

	private void deleting()
	{
		if (DisplayedText.length() > 0)
		{
			DisplayedText = DisplayedText.substring(0, DisplayedText.length() - 1);
			Window.textField.setText(DisplayedText);
		}
		if (DisplayedText.length() == 0)
		{
			Window.textField.setText("0");
			numberFlag = true;
		}
	}

	private void addingNumber(int i)
	{
		if (numberFlag == true)
		{
			Window.textField.setText("");
			numberFlag = false;
			sign = true;
			if (restart == true)
			{
				start = false;
				result = 0;
				operature = 'n';
			}
		}
		operFlag = true;
		Window.textField.setText(Window.textField.getText().concat(String.valueOf(i)));
	}
	
	private void applyOperation()
	{
		if (operFlag == true)
		{
			switch (operature){
				case '+' :
					result += number;
					break;
				case '-' :
					result -= number;
					break;
				case '*' :
					result *= number;
					break;
				case '/' :
					result /= number;
					break;
				case '%' :
					result %= number;
					break;
			}
			operFlag = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		pressedButton = (JButton) e.getSource();
		for(int i = 0; i < 10; i++)
		{
			if (pressedButton == Window.numButtons[i])
				addingNumber(i);
		}
		DisplayedText = Window.textField.getText();
		if (DisplayedText.length() == 1 && DisplayedText.charAt(0) =='-')
			number = 0;
		else if (DisplayedText.length() > 0) 
		{
			number = Double.parseDouble(DisplayedText);
			if (start == false)
				result = Double.parseDouble(DisplayedText);
		}
		if (pressedButton == Window.button.addButton)
			calculating('+');
		else if (pressedButton == Window.button.subButton)
			calculating('-');
		else if (pressedButton == Window.button.mulButton)
			calculating('*');
		else if (pressedButton == Window.button.divButton)
			calculating('/');
		else if (pressedButton == Window.button.modButton)
			calculating('%');

		else if (pressedButton == Window.button.clrButton)
			clearingField();
		else if (pressedButton == Window.button.dotButton)
		{
			if (!DisplayedText.contains("."))
				Window.textField.setText(DisplayedText.concat("."));
			numberFlag = false;
		}
		else if (pressedButton == Window.button.signButton)
			asigning();
		else if (pressedButton == Window.button.equButton)
		{
			applyOperation();
			Window.printResult(result);
			restart = true;
			numberFlag = true;
		}
		else if(pressedButton == Window.button.delButton)
			deleting();
	}
}
