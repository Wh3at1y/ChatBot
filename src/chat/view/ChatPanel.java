package chat.view;

import java.awt.Color;
import chat.controller.ChatController;
import javax.swing.*;

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
		
		submitButton = new JButton();
		chatArea = new JTextArea();
		typingField = new JTextField();
		promptLabel = new JLabel();
	}
	
	private void setupLayouut()
	{
		
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
	
	private void setupListeners()
	{
		
	}
	
	public JTextField getTextField()
	{
		return typingField;
	}
}
