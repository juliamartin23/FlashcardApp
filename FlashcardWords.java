import java.util.ArrayList;
import java.util.List;

//stores the collection of Words and will give you a word when you request it using getWord()
public class FlashcardWords {

	private FlashcardWordsInitializer flashcardWordsInitializer; 
	
	//getDefinition(), getTerm()
	private List<Word> flashcardSet; 
	
	//keep track of where we are in the set
	private int currentIndex; 
	
	public FlashcardWords()
	{
		flashcardWordsInitializer = new FlashcardWordsInitializer(); 
		
		flashcardSet = flashcardWordsInitializer.getListOfWords();  
	
		currentIndex = 0; 
	}
	
	public Word getWord()
	{
		if(currentIndex >= flashcardSet.size())
		{
			currentIndex = 0; 
		}
		
		Word word = flashcardSet.get(currentIndex); 
		currentIndex++; 
		return word; 
				
	}
}
