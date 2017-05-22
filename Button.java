package flashcards;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Button {

	private int x; 
	private int y; 
	private String text; 
	private Color color; 
	private final int width = 300; 
	public String getText() {
		return text;
	}

	private final int height = 200; 
	
	public Button(int x, int y, String text, Color color)
	{
		this.x = x; 
		this.y = y; 
		this.text = text; 
		this.color = color; 
	}
	
	public void draw(GraphicsContext gc)
	{
		gc.setFill(color);
		gc.fillRect(x + 10, y + 100, width/2 + 80, height/2);
		
		gc.setFill(Color.BLACK);
		gc.fillText(text, x + 65, y + 155);
		

	}
	
	public boolean isClicked(int cx, int cy)
	{
		return(cx >= x && cx <= x + width && cy >= y && cy <= y + height); 
 
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
