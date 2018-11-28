package graphics;

import java.lang.ref.WeakReference;
import java.util.Collection;

import javafx.scene.paint.Color;

public class Sol extends SituatedObject{

	public Sol(String type, Collection<Double> xypoints) {
		super(type, xypoints);
		this.type=ObjectType.Sol;
		isOccluder=false;
		body.setFill(Color.GRAY);
		body.setStroke(Color.TRANSPARENT);
		// TODO Auto-generated constructor stub
	}
}
