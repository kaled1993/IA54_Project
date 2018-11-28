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
	private Map map;
	private ArrayList<SituatedObject> Agents;

	public FenetreSimulation(Fenetre parent, Launcher l){
		super(new Pane(),1920,1080);
		components= new ArrayList<SituatedObject>();
		System.gc();

		pane = new Pane();
		this.setRoot(pane);
		this.launcher=l;

		this.map = new Map();
		initialisationNiveau(parent,l);
		//After everything is init we init the objective field
		//pane.getChildren().add(this.map.getObj());
	}

	private void initialisationNiveau(Fenetre parent, Launcher l){
		// TODO Auto-generated method stub
		final ImageView img = new ImageView("images/mapAgent2.png");
		pane.getChildren().add(img);
		try {
			initLevel("src/images/MaDesc.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//MAP OBJ EST INIT ICI
	private void addComponents(String type, ArrayList<Double> tabxy){
		SituatedObject s = null;
		switch(type){
		case "S":
			s=new Sol(type,tabxy);
			//pane.getChildren().add(s.body);
			break;
		case "M":
			s=new Mur(type,tabxy);
			//pane.getChildren().add(s.body);
			break;
		case "P":
			s=new Porte(type,tabxy);
			//pane.getChildren().add(s.body);
			break;
		case "O":
			System.out.println(type);
			s=new Objectif(type,tabxy);
			if(tabxy.get(0)!=0 && tabxy.get(1)!=0){
				map.setInnerBorder(s.body);
				this.map.setObj();
			}
			else{				
				map.setOuterBorder(s.body);
			}
			//pane.getChildren().add(this.map.getObj());
			break;
		default:
			break;
		}			
		components.add(s);
		//pane.getChildren().add(s.getBody());
	}

	private void initLevel(String levelDescPath) throws IOException{
		// TODO Auto-generated method stub
		try (BufferedReader buff = new BufferedReader(new FileReader(levelDescPath))) {
			Iterator<String> it = buff.lines().iterator();
			String tmp;
			//Tant que le fichier n'est pas lu en entier
			//on recupere chaque ligne, on separe la string selon un separateur qu'on aura convenu, ici le format est le suivant type:[coordx,coordy...]
			//et on cree l'objet selon la string recuperee
			String[] tab;
			ArrayList<Double> tabxy = new ArrayList<Double>();
			while (it.hasNext()){
				tmp = it.next();
				tab = tmp.split(":");
				for(String s: tab[1].split(";"))
				{
					tabxy.add(Double.parseDouble(s.split((","))[0]));
					tabxy.add(Double.parseDouble(s.split((","))[1]));
				}
				this.addComponents(tab[0],tabxy);
				//AFFICHAGE DES POLYGONES EN CAS DE DEBUG
				tabxy=new ArrayList<Double>();
			}
		}
		//this.map.setMap();
	}

	//NEED BOUCLE DU JEU POUR CA
	//	private void initAgent(int nb){
	//		while(nb>0){
	//			components.add(new AgentGraphique());
	//		}
	//	}

	public ArrayList<SituatedObject> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<SituatedObject> components) {
		this.components = components;
	}

}
