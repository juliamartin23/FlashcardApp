package flashcards;

import java.util.ArrayList;
import java.util.List;

public class FlashSetInitalizer  {
	
	public FlashSetInitalizer() {
		
	}

	public List<Flashcard> getListOfWords()
	{
		List<Flashcard> words = new ArrayList<> (); 
		
		words.add(new Flashcard("apple", "red")); 
		words.add(new Flashcard("banana", "yellow")); 
		words.add(new Flashcard("orange", "orange")); 
		words.add(new Flashcard("grape", "purple")); 
		words.add(new Flashcard("blueberry", "blue")); 
		
		return words;	
		
	}

}
	
	