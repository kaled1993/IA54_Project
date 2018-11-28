package graphics;

import java.lang.ref.WeakReference;
import java.util.Collection;

import javafx.scene.paint.Color;

public class Porte extends SituatedObject{
	
	public Porte(String type, Collection<Double> xypoints) {
		super(type,xypoints);
		this.type=ObjectType.Porte;
		body.setFill(Color.BLUE);
		isOccluder=false;
	}
}
