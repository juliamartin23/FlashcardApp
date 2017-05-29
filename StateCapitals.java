package flashcards;

import java.util.ArrayList;
import java.util.List;

public class StateCapitals extends FlashSetInitializer {
	
	@Override
    public List<Flashcard> getListOfWords() {

        List<Flashcard> words = new ArrayList<> (); 
        
        words.add(new Flashcard("California", "Sacramento")); 
        words.add(new Flashcard("Arizona", "Phoenix")); 
        words.add(new Flashcard("New York", "Albany")); 
        words.add(new Flashcard("Montana", "Helena")); 
        words.add(new Flashcard("Texas", "Austin")); 
        
        return words;   
    }
    
	@Override
    public FlashSet getFlashSet() {
        // TODO Auto-generated method stub
        return super.getFlashSet();
    }

}
