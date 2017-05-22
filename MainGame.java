package flashcards;

import java.awt.TextField;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tsinn.ui.SimpleApp;

public class MainGame extends SimpleApp {

	private FlashSet flashSet; 
	private Flashcard currentFlashcard; 
	private String userGuessDef; 
	private boolean showDef; 
	private boolean isGuessCorrect = false; 
	
	private Button nextButton; 
	
	public void updateAnimation(long arg0) {
		
	}

	public void draw(GraphicsContext gc) 
	{
		
		
		Flashcard flashCard = flashSet.getCard(); 
		
		currentFlashcard.draw(gc);

		gc.setFill(Color.BLACK);
		gc.fillText("Enter Definition:          ", 452, 400);
		
		//printing out the word 
		gc.setFill(Color.BLACK);
		gc.setFont(new Font("Arial", 30.0));
		gc.fillText(userGuessDef, 690, 400);
		
		
		//print out definition 
		if(showDef)
		{

			String actualDefintion = currentFlashcard.getDefinition(); 
			gc.setFill(Color.RED);
			gc.setFont(new Font("Arial", 30.0));
			gc.fillText("Answer:            " + actualDefintion, 480, 450);
		

			if(isGuessCorrect)
			{	
				gc.setFill(Color.PURPLE);
				gc.fillText("CORRECT!", 530, 500);
			}
			else{
				gc.setFill(Color.PURPLE);
				gc.fillText("INCORRECT!", 530, 500);
			}
		}
		
		nextButton.draw(gc);
	
	}

	public void moveToNext()
	{
		if(showDef)
		{	
			//if the definition is shown, the next step is to clear the state and get the next 
			
			currentFlashcard = flashSet.getCard(); 
			userGuessDef = "";
			
			nextButton.setText("Sumbit");
			nextButton.setColor(Color.CORNFLOWERBLUE);
			

		}
		else{ 
			//if the definition is not shown, show it and check the guess
			
			nextButton.setText("Next Card");
			nextButton.setColor(Color.CORNFLOWERBLUE);
			
			String actualDef = currentFlashcard.getDefinition(); 
			
			if(DefinitionIsContained(userGuessDef, actualDef))
			{
				isGuessCorrect = true; 
			}
			else{
				isGuessCorrect = false; 
			}
		
			
		}	
		showDef = !showDef; 
		
	}
	
	private boolean DefinitionIsContained(String userGuessDefinition2, String actualDef) 
	{
		
		if(actualDef.toLowerCase().equals(userGuessDefinition2.toLowerCase()))
		{
			return true; 
		}
		return false;
	}

	public void onMousePressed(MouseEvent me)
	{ 
		
		int x = (int) me.getX(); 
		int y = (int) me.getY(); 
		
		if(nextButton.isClicked(x, y))
		{
			moveToNext(); 
		}
	}

	public void onKeyPressed(KeyEvent ke)
	{
		
		if(ke.getCode() == KeyCode.ENTER)
		{
			moveToNext(); 
			return; 
		}
		
		String c = ke.getText(); 
		
		System.out.println(ke.getText());
		System.out.println(ke.getCode());
		System.out.println(ke.getCharacter());
		
		userGuessDef += c; 
		
	
	}

	public void setupApp(GraphicsContext arg0) 
	{
		flashSet = new FlashSet(); 
		
		currentFlashcard = flashSet.getCard(); 
		
		userGuessDef = ""; 
		
		showDef = false; 
		
		nextButton = new Button(500, 500, "Sumbit", Color.CORNFLOWERBLUE); 
	}

	public static void main(String[] args)
	{
		launch(); 
	}

	
}
