package chat.controller;

import chat.view.ChatbotDisplay;
import chat.model.Chatbot;

/**
 * Controller for the ChatBot project.
 * @author Sam Montoya
 * @version 1.3 10/23/15 : Asks the user to talk to the chatbot in a while loop.
 */

public class ChatbotController
{
	private ChatbotDisplay chatDisplay;
	private Chatbot myBot;
	
	public ChatbotController()
	{	
		chatDisplay = new ChatbotDisplay();
		String userName = chatDisplay.getUserInput("What is your name?");
		
		//Puts userName into the Chatbot constructer.
		myBot = new Chatbot(userName);
	}
	
	public void start()
	{
		//Uses the Getter and prints whatever is in the userName variable.
		chatDisplay.showText("Hello " + myBot.getUserName());
		
		chat();
	}
	
	private void chat()
	{
		String textFromUser = chatDisplay.getUserInput("Talk to the chatbot.");
		
		while(myBot.lengthChecker(textFromUser))
		{
			textFromUser = chatDisplay.getUserInput("");
		}
	
	}
}
