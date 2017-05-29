package flashcards;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import tsinn.ui.SimpleApp;

public class MainGame extends SimpleApp {

    private SetInitializer setInitializer; 
    private FlashSet flashSet; 
    private Flashcard currentFlashcard; 
    private String userGuessDef; 
    private boolean showDef; 
    private boolean isGuessCorrect = false; 
    private boolean gameOver = false;
    private Button nextButton; 
    
    private int score = 100; 
    
    public void updateAnimation(long arg0) {
        
    }

    public void draw(GraphicsContext gc) 
    {
        if (gameOver) {
            flashSet.draw(gc);
        	return;
        }

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
        
        gc.setFill(Color.BLACK);
        gc.fillText("Score:  " + score + "%", 130, 230);
        
       
        
        
    }

    public void moveToNext()
    {
        if(showDef)
        {   
            //if the definition is shown, the next step is to clear the state and get the next 
            if (flashSet.isGameOver()) {
                gameOver = true;
            
                return;
            }
            
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
            
            if(Flashcard.DefinitionIsContained(userGuessDef, actualDef))
            {
                isGuessCorrect = true; 
                incrementScore(); 
            }
            else{
                isGuessCorrect = false; 
                decrementScore();
                flashSet.addCard(currentFlashcard);
            }
        
            
        }   
        showDef = !showDef; 
        
    }
    
    public int incrementScore()
    {
        if(score != 100)
        {
            score+=5; 
        }
        return score; 
    }
    
    public int decrementScore()
    {
        if(score != 0)
        {
            score-=10; 
        }
        return score; 
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
        
        if(ke.getCode() == KeyCode.BACK_SPACE)
        {
            userGuessDef = userGuessDef.substring(0, userGuessDef.length() -1); 
             
        }
        
        String c = ke.getText(); 
        
        System.out.println(ke.getText());
        System.out.println(ke.getCode());
        System.out.println(ke.getCharacter());
        
        userGuessDef += c; 
        
    }

 
    public void setupApp(GraphicsContext arg0) 
    {
        //chooses a set at random 
        Random r = new Random(System.currentTimeMillis());
        if (r.nextInt() % 2 == 0) {
            setInitializer = new StateCapitals();
        }
        else {
            setInitializer = new FlashSetInitializer();
        }

        flashSet = setInitializer.getFlashSet();
        
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
