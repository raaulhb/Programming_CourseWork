import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>
{
    private Button myButton;
    private Button myButton2;
    
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Main Class implementing interface");
        
        myButton = new Button();
        myButton2 = new Button();
        myButton.setText("Click Here");
        myButton2.setText("Say Hello");
        
        myButton.setLayoutX(10);
        myButton.setLayoutY(20);
        myButton2.setLayoutX(50);
        myButton2.setLayoutY(100);
        
        myButton.setOnAction(this);
        myButton2.setOnAction(this);
        
        Pane root = new Pane();
        root.getChildren().addAll(myButton, myButton2);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }
    
    @Override
    public void handle(ActionEvent e)
    {
        if(e.getSource() == myButton)
        {
            buttonResponse();
        }
        else if(e.getSource() == myButton2)
        {
            buttonResponse2();
        }
    }
    
    
    private void buttonResponse()
    {
        System.out.println("Button has been clicked!");
    }
    
    private void buttonResponse2()
    {
        System.out.println("Hello Students of CS4001 Module!");
    }
    
    
    public static void main(String[] args) { 
        launch(args); 
    }
}
