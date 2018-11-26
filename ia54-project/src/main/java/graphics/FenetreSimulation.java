package graphics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class FenetreSimulation extends Scene{

	private final Pane pane;
	private final Launcher launcher;
	private ArrayList<SituatedObject> components;

	public FenetreSimulation(Fenetre parent, Launcher l){
		super(new Pane(), 1920,1080);
		components= new ArrayList<SituatedObject>();
		System.gc();

		pane = new Pane();
		this.setRoot(pane);
		this.launcher=l;

		initialisationNiveau(parent,l);
	}

	private void initialisationNiveau(Fenetre parent, Launcher l) {
		// TODO Auto-generated method stub
		final ImageView img = new ImageView("file:///D:/max_m/T%E9l%E9chargements/MiniMetroV1.1/MiniMetro/");
		pane.getChildren().add(img);

		try {
			initLevel("src/images/MaDesc.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initLevel(String levelDescPath) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("FILE PATH " + levelDescPath);
		try (BufferedReader buff = new BufferedReader(new FileReader(levelDescPath))) {
			Iterator<String> it = buff.lines().iterator();
			String tmp;

			//Tant que le fichier n'est pas lu en entier
			//on recupere chaque ligne, on separe la string selon un separateur qu'on aura convenu, ici le format est le suivant type:[coordx,coordy...]
			//et on cree l'objet selon la string recuperee
			String[] tab;
			ArrayList<Double> tabxy = new ArrayList<Double>();
			SituatedObject sOTmp;
			int i=0;
			while (it.hasNext()) {
				tmp = it.next();
				tab = tmp.split(":");
				for(String s: tab[1].split(";")){
					tabxy.add(Double.parseDouble(s.split((","))[0]));
					tabxy.add(Double.parseDouble(s.split((","))[1]));
				}
				components.add(new SituatedObject(tab[0],tabxy));
				pane.getChildren().add(components.get(i).getBody());
				tabxy=new ArrayList<Double>();
				i++;
			}


		}
	}

	public ArrayList<SituatedObject> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<SituatedObject> components) {
		this.components = components;
	}

}
