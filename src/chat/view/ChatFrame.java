package chat.view;

import chat.controller.ChatController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController; //instance for baseController
		basePanel = new ChatPanel(baseController);
		
		setupFrame();	//calls the method
	}
	
	//This adds the content pane into base panel, and other parameters.
	private void setupFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(basePanel);
		this.setSize(500,400);
		this.setTitle("Brettly's ChatBot");
		this.setVisible(true);
	}
	
	/**
	 * Returns the baseController
	 * @return	baseController
	 */
	public ChatController getBaseController()
	{
		return baseController;
	}
}
