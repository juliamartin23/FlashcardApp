package flashcards;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//stores the collection of Words and will give you a word when you request it using getWord()
public class FlashSet {

	
	//getDefinition(), getTerm()
	private List<Flashcard> flashcardSet; 

	private List<Flashcard> reTest = new ArrayList<>(); 
	
	//keep track of where we are in the set
	private int currentIndex; 
	
	public FlashSet(List<Flashcard> flashcardSet)
	{
		this.flashcardSet = flashcardSet; 
	
		currentIndex = 0; 
	}
	

	public Flashcard getCard()
	{		
		if(currentIndex >= flashcardSet.size())
		{
		
			return getReTestCard(); 
			
		}
	
		Flashcard flashcard = flashcardSet.get(currentIndex); 
		currentIndex++;  
		return flashcard; 
		
	}
	
	public void addCard(Flashcard f)
	{
		reTest.add(f); 
		
	}
	
	public boolean isGameOver()
	{
		return currentIndex >= flashcardSet.size() && 
				currentIndex - flashcardSet.size() >= reTest.size(); 
	}
	
	public Flashcard getReTestCard()
	{
		Flashcard card = reTest.get(currentIndex - flashcardSet.size()); 
		currentIndex++; 
		return card; 
	}
	
	public void draw(GraphicsContext gc)
	{
		int x = 100; 
		int y = 100; 
		int size = 50;
		
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillRect(x + size*6, y, size*9, size*5);

		gc.setFill(Color.BLACK);
		gc.setFont(new Font("Arial", 30.0));
		gc.fillText("Good Job! You finished!", x + size*7.6, y + (size/0.4));
		
	
	}
	
}
