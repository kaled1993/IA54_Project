package graphics;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends  Application{


	private FenetreSimulation fs;
    //Le launch du main lance la methode start
    public static void main(String[] args) {
        launch(args);
    }
    

	@Override
    public void start(Stage primaryStage) throws Exception {
    	Fenetre f = new Fenetre(this);
    }
	
	

}
