package chat.view;

import java.awt.Color;
import chat.controller.ChatController;
import chat.controller.IOController;
import javax.swing.*;
import java.awt.event.*;

public class ChatPanel extends JPanel
	{
		// Declaration Section
		private ChatController baseController;
		private SpringLayout baseLayout;
		private JButton submitButton;
		private JButton sendTweetButton;
		private JButton analyzeTwitterButton;
		private JButton saveButton;
		private JButton loadButton;
		private JTextArea chatArea;
		private JTextField typingField;
		private JLabel promptLabel;
		private JScrollPane textPane;

		public ChatPanel(ChatController baseController)
			{
				this.baseController = baseController; // instance of basecontroller
				chatArea = new JTextArea(10, 25);
				baseLayout = new SpringLayout(); // sets the layout for window builder
				submitButton = new JButton("Submit your message."); // adds a button with text
				sendTweetButton = new JButton("Send Tweet");
				typingField = new JTextField(); // Adds a text field
				promptLabel = new JLabel(); // Adds the label
				typingField.setToolTipText("Type here for something");
				analyzeTwitterButton = new JButton("Analyze Twitter Button");
				saveButton = new JButton("Save");
				loadButton = new JButton("Load");

				// calls methods from below
				setupChatPane();
				setupPanel();
				setupLayout();
				setupListeners();

			}

		private void setupChatPane()
			{
				chatArea.setLineWrap(true);
				chatArea.setWrapStyleWord(true);
				chatArea.setEnabled(false);
				chatArea.setEditable(false);
				textPane = new JScrollPane(chatArea);
				textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			}

		// Adds objects into the panel
		private void setupPanel()
			{
				this.setLayout(baseLayout);
				this.setBackground(Color.BLUE);
				this.add(textPane);
				this.add(typingField);
				this.add(submitButton);
				this.add(promptLabel);
				this.add(sendTweetButton);
				this.add(analyzeTwitterButton);
				this.add(saveButton);
				this.add(loadButton);
			}

		// Puts all the crap from WindowBuilder, into here.
		private void setupLayout()
			{
				baseLayout.putConstraint(SpringLayout.NORTH, typingField, -1, SpringLayout.NORTH, submitButton);
				baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 10, SpringLayout.NORTH, this);
				baseLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.EAST, typingField, -45, SpringLayout.WEST, submitButton);
				baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -10, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.NORTH, textPane, 20, SpringLayout.SOUTH, submitButton);
				baseLayout.putConstraint(SpringLayout.EAST, textPane, -20, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.WEST, sendTweetButton, 10, SpringLayout.WEST, this);
				baseLayout.putConstraint(SpringLayout.SOUTH, sendTweetButton, -10, SpringLayout.SOUTH, this);
				baseLayout.putConstraint(SpringLayout.EAST, submitButton, -20, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, analyzeTwitterButton, 0, SpringLayout.NORTH, sendTweetButton);
				baseLayout.putConstraint(SpringLayout.WEST, analyzeTwitterButton, 6, SpringLayout.EAST, sendTweetButton);
				baseLayout.putConstraint(SpringLayout.EAST, analyzeTwitterButton, 180, SpringLayout.EAST, sendTweetButton);
				baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, sendTweetButton);
				baseLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, this);
				baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, sendTweetButton);
				baseLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, analyzeTwitterButton);
				baseLayout.putConstraint(SpringLayout.EAST, sendTweetButton, 108, SpringLayout.WEST, this);
			}

		// Sets up the listeners
		private void setupListeners()
			{
				submitButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
							{
								String userText = typingField.getText(); // Grey user Text
								String response = baseController.fromUserToChatbot(userText); // send the text to the controller
								chatArea.append("\nUser: " + userText); // display users text
								chatArea.append("\nChatbot: " + response); // display answer
								typingField.setText(""); // clear user field
							}
					});

				sendTweetButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
							{
								baseController.sendTweet("StaticVoid_");
							}
					});

				analyzeTwitterButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
							{
								String user = typingField.getText();
								String results = baseController.analyze(user);
								chatArea.setText(results);
							}
					});

				saveButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
							{
								String file = IOController.saveFile(chatArea.getText());
								promptLabel.setText(file);
							}
					});

				loadButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent click)
							{
								String loadedText = IOController.readTextFromFile(promptLabel.getText());
								chatArea.setText(loadedText);
							}
					});
			}

		/**
		 * Returns what is inside the TextField
		 * 
		 * @return Returns the contents inside
		 */
		public JTextField getTextField()
			{
				return typingField;
			}
	}
