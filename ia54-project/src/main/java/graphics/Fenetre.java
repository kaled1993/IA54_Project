package graphics;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Fenetre extends Stage{

	public Fenetre(Launcher l){
		super();
		
		this.setTitle("IA54: Projet 7");
        this.setResizable(false);
        this.setScene(new FenetreAccueil(this, l));
        this.show();
        
	}
}
