package flashcards;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Flashcard {

	
	public String term; 
	public String definition; 

	
	public Flashcard (String term, String definition)
	{
		this.term = term;
		this.definition = definition; 
	}
	
	public String getTerm()
	{
		return term; 
	}
	
	public void setTerm(String term)
	{
		this.term = term; 
	}
	public String getDefinition()
	{
		return definition; 
	}
	
	public void setDefinition(String definition)
	{
		this.definition = definition; 
	}
	public Flashcard addWord(String term, String definition)
	{
		Flashcard w; 
		w = new Flashcard(term, definition); 
		return w; 
	}
	
	public void draw(GraphicsContext gc)
	{
		int x = 100; 
		int y = 100; 
		int size = 50;
		
		gc.setFill(Color.ALICEBLUE);
		gc.fillRect(x + size*6, y, size*9, size*5);

		gc.setFill(Color.BLACK);
		gc.setFont(new Font("Arial", 30.0));
		gc.fillText(getTerm(), x + size*9.5, y + (size/0.4));
	
	}
	
}
