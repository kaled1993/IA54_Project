package graphics;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FenetreAccueil extends Scene {

	private final Pane pane;
	private final Launcher launcher;
	
	public FenetreAccueil(Fenetre parent, Launcher l){
		super(new Pane(), 1920,1080);
		
		System.gc();
		
		pane = new Pane();
		this.setRoot(pane);
		this.launcher=l;
		
		initialisationAccueil(parent,l);
	}

	//CHANGER TOUTES LES URL DES IMAGES,
	private void initialisationAccueil(Fenetre parent, Launcher l) {
		// TODO Auto-generated method stub
        ImageView imgPlay = new ImageView("images/play.png");
        imgPlay.setLayoutX(906);
        imgPlay.setLayoutY(421);
        imgPlay.setOnMouseClicked((e) -> parent.setScene(new FenetreSimulation(parent, l)));
        
        
        final ImageView img = new ImageView("images/Menu.png");
        
        pane.getChildren().add(img);
        pane.getChildren().add(imgPlay);
        
        
	}
}
