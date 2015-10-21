package chat.view;

import javax.swing.JOptionPane;

/**
 * Grabs user inputs and displays text to the screen.
 * @author Sam Montoya
 * @version 1.0 10/21/15
 */

public class ChatbotDisplay
{
	/**
	 * Displays text and asks for a user input.
	 * @param displayText : Shows what is printed to the screen.
	 * @return answer : Gets the user's answer and returns it.
	 */
	public String getUserInput(String displayText)
		{
			String answer = JOptionPane.showInputDialog(null, displayText);
			return answer;
		}
	
	/**
	 * Prints something to the screen
	 * @param displayText : Shows what is printed to the screen.
	 */
	public void showText(String displayText)
		{ JOptionPane.showMessageDialog(null, displayText); }
}
