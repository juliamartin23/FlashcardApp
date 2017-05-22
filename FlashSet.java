package flashcards;
import java.util.ArrayList;
import java.util.List;

//stores the collection of Words and will give you a word when you request it using getWord()
public class FlashSet {

	private FlashSetInitalizer flashInitalizer; 
	
	//getDefinition(), getTerm()
	private List<Flashcard> flashcardSet; 
	
	//keep track of where we are in the set
	private int currentIndex; 
	
	public FlashSet()
	{
		flashInitalizer = new FlashSetInitalizer(); 
		
		flashcardSet = flashInitalizer.getListOfWords();  
	
		currentIndex = 0; 
	}
	
	public Flashcard getCard()
	{
		if(currentIndex >= flashcardSet.size())
		{
			currentIndex = 0; 
		}
		
		Flashcard flashcard = flashcardSet.get(currentIndex); 
		currentIndex++; 
		return flashcard; 
		
	}
}
