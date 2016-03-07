package chat.model;

import java.util.ArrayList;
import twitter4j.*;
import chat.controller.ChatController;

public class CTECTwitter
	{
		//Declaration Section
		private ChatController baseController;
		private Twitter chatbotTwitter;
		private ArrayList<Status> statusList;
		private ArrayList<String> wordsList;
		
		//Constructor
		public CTECTwitter(ChatController baseController)
		{
			this.baseController = baseController;
			statusList = new ArrayList<Status>();
			wordsList = new ArrayList<String>();
			chatbotTwitter = TwitterFactory.getSingleton();
		}
		
		public void sendTweet(String message)
		{
			try
				{
					chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
				}
			catch (TwitterException error)
				{
					baseController.handleErrors(error.getErrorMessage());
				}
		}
	}
