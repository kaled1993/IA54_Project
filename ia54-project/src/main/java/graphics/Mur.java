package graphics;

import java.lang.ref.WeakReference;
import java.util.Collection;

import javafx.scene.paint.Color;

public class Mur extends SituatedObject{

	public Mur(String type, Collection<Double> xypoints) {
		super(type, xypoints);
		this.type=ObjectType.Mur;
		body.setFill(Color.BLACK);
		isOccluder=true;
	}

}
