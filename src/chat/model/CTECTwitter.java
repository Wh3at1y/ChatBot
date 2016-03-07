package chat.model;

import java.util.ArrayList;
import twitter4j.*;

public class CTECTwitter
	{
		//Declaration Section
		private ArrayList<Status> statusList;
		private ArrayList<String> wordsList;
		
		//Constructor
		public CTECTwitter()
		{
			statusList = new ArrayList<Status>();
			wordsList = new ArrayList<String>();
		}
	}
