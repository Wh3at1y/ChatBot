package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Sam Montoya
 * @version 1.3 10/14/15 - Built and called the buildMemesList method. Updated and completed the contentChecker method.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.userName = userName;
		this.content = "CSGO";
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("grumpy cat");
		this.memesList.add("bad luck brian");
		this.memesList.add("pepe");
		this.memesList.add("trolling");
		this.memesList.add("nian cat");
		this.memesList.add("john cena");
		this.memesList.add("meme");
		this.memesList.add("inception");
		
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("Donald Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/4/16");
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("convervative");
		
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null)
		{
			if(currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
			if(currentInput.toLowerCase().contains(content.toLowerCase()))
			{
				hasContent = true;
			}
			
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitical = false;
		
		for(String political: politicalTopicList)
		{
			if(currentInput.toLowerCase().contains(political.toLowerCase()))
			{
				hasPolitical = true;
			}
		}
		
		return hasPolitical;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String meme: memesList)
		{
			if(currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		
		return hasMeme;
	}
	
	public String processConverstation(String currentInput)
	{
		String nextConversation = "Oh, what else would you like to talk about?";
		int randomTopic = (int) (Math.random() * 5); // generates a random number between 0 and 4
		
		if(keyboardMashChecker(currentInput))
		{
			return "Stop just pressing keys n' stuff, kay?";
		}
		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				nextConversation = "You talked about my favorite game! What else do you like?";
			}
			break;
		case 1:
			if(memeChecker(currentInput))
			{
				nextConversation = "You know memes pretty well. What fast food do you like?";
			}
			break;
		case 2:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "You like Trump Donalds? Same!";
			}
			break;
		case 3:
			if(currentInput.equalsIgnoreCase("hi"))
			{
				nextConversation = "Hello there!";
			}
			break;
		case 4:
			break;
			
			//default means the else in an if-else statement. Only happens if nothing else works.
		default:
			break;
		}
		
		return nextConversation;
	}
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean quitCheck = false;
		
		if(currentInput.equalsIgnoreCase("quit"))
		{
			quitCheck = true;
		}
		return quitCheck;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isMash = false;
		if(currentInput.equalsIgnoreCase("sdf") || currentInput.equalsIgnoreCase("dfg") || currentInput.equalsIgnoreCase("cvb") || currentInput.equalsIgnoreCase(",./"))
		{
			isMash = true;
		}
		return isMash;
	}
}