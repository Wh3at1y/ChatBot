package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Grabs user inputs and displays text to the screen.
 * @author Sam Montoya
 * @version 1.1 10/21/15 : Added the icon location
 * @version 1.2 Added icon to input window and displayText method
 */

public class ChatbotDisplay
{

	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatbotDisplay()
	{
		windowMessage = "Stupid Chatbot message";
		chatIcon = new ImageIcon(getClass().getResource("images/WorldIcon.png"));
		
	}

	/**
	 * Displays text and asks for a user input.
	 * @param displayText : Shows what is printed to the screen.
	 * @return answer : Gets the user's answer and returns it.
	 */
	public String getUserInput(String displayText)
		{
			String answer = JOptionPane.showInputDialog(null, displayText, windowMessage, 
														JOptionPane.INFORMATION_MESSAGE, 
														chatIcon, null, "").toString();
			return answer;
		}
	
	/**
	 * Prints something to the screen
	 * @param displayText : Shows what is printed to the screen.
	 */
	public void showText(String displayText)
		{ JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon); }
}
