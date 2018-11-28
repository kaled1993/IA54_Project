package graphics;

import javafx.scene.paint.Color;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.UUID;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;

public abstract class SituatedObject {

	protected Polygon body;
	protected ObjectType type;
	protected UUID id;
	protected Polyline path;
	protected boolean isOccluder;
	private WeakReference<Map> map;
	
	//POSSIBILITE DE RENDRE CETTE CLASSE ABSTRAITE AVEC DES TYPES UN PEU PLUS PRECIS
	//FEEL FREE TO DO THAT
	public SituatedObject(){
		this.id = UUID.randomUUID();
		this.body= new Polygon();
	}
	public SituatedObject(String type,Collection<Double> xypoints, WeakReference<Map> m)
	{
		this.body=new Polygon();
		this.id = UUID.randomUUID();
		this.createBody(xypoints);
		body.setStroke(Color.BLACK);
		body.setFill(Color.TRANSPARENT);
		//this.map=m;
	}
	public SituatedObject(String type,Collection<Double> xypoints)
	{
		this.body=new Polygon();
		this.id = UUID.randomUUID();
		this.createBody(xypoints);
		body.setStroke(Color.BLACK);
		body.setFill(Color.TRANSPARENT);

	}
	private void createBody(Collection<Double> xypoints) {
		body.getPoints().addAll(xypoints);		
	}

	public Polygon getBody() {
		return body;
	}

	public void setBody(Polygon body) {
		this.body = body;
	}

	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public UUID getId() {
		return id;
	}

}
