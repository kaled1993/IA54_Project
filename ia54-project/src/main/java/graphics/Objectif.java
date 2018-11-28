package graphics;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.UUID;

import javafx.scene.paint.Color;

public class Objectif extends SituatedObject{

	public Objectif(String type, Collection<Double> xypoints) {
		super(type, xypoints);
		this.isOccluder=false;
		this.type=ObjectType.Objectif;
	}

}
