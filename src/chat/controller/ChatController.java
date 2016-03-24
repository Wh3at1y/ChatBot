package chat.controller;

import twitter4j.TwitterException;
import chat.view.ChatView;
import chat.model.Chatbot;
import chat.tests.*;
import chat.view.*;
import chat.model.CTECTwitter;

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
	private CTECTwitter myTwitter;
	
	public ChatController()
	{
		myTwitter = new CTECTwitter(this);
		chatDisplay = new ChatView();
		GUIFrame = new ChatFrame(this);
		
		//Puts userName into the Chatbot constructer.
		String userName = chatDisplay.getUserInput("What is your name?");
		myBot = new Chatbot(userName);
	}
	
	//Uses the Getter and prints whatever is in the userName variable.
	public void start()
	{
		chatDisplay.showText("Hello " + myBot.getUserName());
		
		chat();
	}
	
	/**
	 * Grabs the user input, and checks with the length checker
	 */
	private void chat()
	{
		String textFromUser = chatDisplay.getUserInput("Talk to the chatbot.");
		
		while(myBot.lengthChecker(textFromUser))
		{
			textFromUser = myBot.processConverstation(textFromUser);
			textFromUser = chatDisplay.getUserInput(textFromUser);
		}
	}
	
	/**
	 * 
	 * @param conversation gets the user input, and checks if they want to quit.
	 * @return returns the bot response
	 */
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
	
	/**
	 * Shows a pop up and exits the program
	 */
	private void shutdown()
	{
		chatDisplay.showText("Goodbye, " + myBot.getUserName() + " it has been a good time!");
		System.exit(0);
	}
	
	public String analyze(String userName)
	{
		String userAnalysis = "The Twitter user " + userName + "has...";
		try
			{
				myTwitter.loadTweets(userName);
			}
		catch (TwitterException error)
			{
				handleErrors(error.getErrorMessage());
			}
		userAnalysis += myTwitter.topResults();
		return userAnalysis;
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

	public void handleErrors(String error)
	{
		chatDisplay.showText(error);
	}

	public void sendTweet(String tweet)
	{
		myTwitter.sendTweet(tweet);
	}
}
