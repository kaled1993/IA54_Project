package graphics;

import javafx.scene.paint.Color;
import java.util.Collection;
import java.util.UUID;

import javafx.scene.shape.Polygon;

public class SituatedObject {

	private Polygon body;
	private ObjectType type;
	private final UUID id;
	private int z;
	public SituatedObject(String type,Collection<Double> xypoints){
		this.body=new Polygon();
		this.id = UUID.randomUUID();
		this.createBody(xypoints);
		switch(type){
		case "M":
			this.type=ObjectType.Mur;
			body.setStroke(Color.BLACK);
			body.setFill(Color.BLACK);
			break;
		case "P":
			this.type=ObjectType.Porte;
			body.setStroke(Color.BLUE);
			body.setFill(Color.BLUE);
			break;
		default:
			this.type=ObjectType.Agent;
		}
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
