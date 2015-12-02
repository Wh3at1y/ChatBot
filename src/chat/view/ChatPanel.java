package chat.view;

import java.awt.Color;
import chat.controller.ChatController;
import javax.swing.*;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		
		submitButton = new JButton("Submit your message.");
		
		chatArea = new JTextArea(10, 20);
		
		typingField = new JTextField();
		
		
		promptLabel = new JLabel();
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		chatArea.setEnabled(false);
		typingField.setToolTipText("Type here for something");
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, -1, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, -45, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -10, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = typingField.getText();	//Grav user Text
				String response = baseController.fromUserToChatbot(userText);	//send the text to the controller
				chatArea.append("\nUser: " + userText);	//display users text
				chatArea.append("\nChatbot: " + response);	//display answer
				typingField.setText("");	//clear user field
			}
		});
	}
	
	public JTextField getTextField()
	{
		return typingField;
	}
}
