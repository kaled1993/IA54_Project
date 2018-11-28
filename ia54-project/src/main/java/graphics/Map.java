package graphics;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Map extends SituatedObject{

	private Polygon outerBorder;
	private Polygon innerBorder;
	private double width;
	private double height;
	private Polygon obj;
	//A REMPLACER PAR UN QUADTREE
	private ArrayList<Polygon> floor;
	
	public ArrayList<Polygon> getFloor() {
		return floor;
	}

	public void setFloor(ArrayList<Polygon> floor) {
		this.floor = floor;
	}

	public Map(String type, Collection<Double> xypoints, WeakReference<Map> m){
		super(type,xypoints,m);
		this.width=1920;
		this.height=1080;
		floor=new ArrayList<Polygon>();
		outerBorder=new Polygon();
		innerBorder=new Polygon();
		obj= new Polygon();

	}
	
	public Map(){
		super();
		this.width=1920;
		this.height=1080;
		floor=new ArrayList<Polygon>();
		outerBorder=new Polygon();
		innerBorder=new Polygon();
		obj= new Polygon();
		obj.setFill(Color.RED);
	}
	public Polygon getObj() {
		return obj;
	}

	public void setObj(Polygon obj) {
		this.obj = obj;
	}

	public Polygon getOuterBorder() {
		return outerBorder;
	}
	public void setObj(){
		ArrayList<Double> a = new ArrayList<Double>();
		Path p = (Path)Shape.subtract(outerBorder, innerBorder);
		for(PathElement pe:p.getElements()){
			System.out.println(pe.toString());
			if (pe instanceof MoveTo) {
				MoveTo tmp = (MoveTo) pe;
				a.add(tmp.getX());
				a.add(tmp.getY());
			}
			else if(pe instanceof LineTo){
				LineTo tmp = (LineTo) pe;
				a.add(tmp.getX());
				a.add(tmp.getY());
			}
		}
		obj.getPoints().addAll(a);
	}
	
	public void setOuterBorder(Polygon outerBorder) {
		this.outerBorder = outerBorder;
	}

	public Polygon getInnerBorder() {
		return innerBorder;
	}

	public void setInnerBorder(Polygon innerBorder) {
		this.innerBorder = innerBorder;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
}
