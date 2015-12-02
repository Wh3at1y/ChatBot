package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;
import chat.tests.*;
import chat.view.*;

/**
 * Controller for the ChatBot project.
 * @author Sam Montoya
 * @version 1.3 10/23/15 : Asks the user to talk to the chatbot in a while loop.
 */

public class ChatController
{
	private ChatView chatDisplay;
	private Chatbot myBot;
	private ChatFrame GUIFrame;
	
	public ChatController()
	{	
		chatDisplay = new ChatView();
		GUIFrame = new ChatFrame(this);
		
		//Puts userName into the Chatbot constructer.
		String userName = chatDisplay.getUserInput("What is your name?");
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
			textFromUser = myBot.processConverstation(textFromUser);
			textFromUser = chatDisplay.getUserInput(textFromUser);
		}
	}
	
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(myBot.quitChecker(conversation))
		{
			shutdown();
		}
		
		botResponse = myBot.processConverstation(conversation);
		return botResponse;
	}
	
	private void shutdown()
	{
		chatDisplay.showText("Goodbye, " + myBot.getUserName() + " it has been a good time!");
		System.exit(0);
	}
	
	public ChatView getChatView()
	{
		return chatDisplay;
	}
	
	public Chatbot getChatbot()
	{
		return myBot;
	}
	
	public ChatFrame getBaseFrame()
	{
		return GUIFrame;
	}
}
