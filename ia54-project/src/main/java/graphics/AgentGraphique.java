package graphics;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public class AgentGraphique extends Thread{

    private Circle r;
    //private AgentBody agentBody;
    private Polyline p;
    private PathTransition transition;
    private AgentGraphique agAssocie;
    private double posXDepart;
    private double posYDepart;
    
    public AgentGraphique(Circle r, Polyline poly) {
        this.r = r;
        p = poly;
        transition = null;
        agAssocie = null;
    }

    public AgentGraphique(Circle r, Polyline poly, AgentGraphique ag) {
        this.r = r;
        //this.v = v;
        p = poly;
        transition = null;
        agAssocie = ag;	
    }
    
    @Override
    public void run() {
        setTransition(new PathTransition());
        transition.setNode(getR());
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setPath(getP());

        //6 = vitesse dans limplantation precedente
        if (agAssocie == null) {
            transition.setDuration(Duration.seconds(6));
        } else {
            transition.setDuration(agAssocie.getTransition().getDuration());
        }

        transition.play();
    }

    public Circle getR() {
        return r;
    }

    public void setR(Circle r) {
        this.r = r;
    }

    public Polyline getP() {
        return p;
    }

    public void setP(Polyline p) {
        this.p = p;
    }

    public PathTransition getTransition() {
        return transition;
    }

    public void setTransition(PathTransition transition) {
        this.transition = transition;
    }

    public double getPosXDepart() {
        return posXDepart;
    }

    public void setPosXDepart(double posXDepart) {
        this.posXDepart = posXDepart;
    }

    public double getPosYDepart() {
        return posYDepart;
    }

    public void setPosYDepart(double posYDepart) {
        this.posYDepart = posYDepart;
    }

    public void setPosDepart(double x, double y) {
        this.setPosXDepart(x);
        this.setPosYDepart(y);
    }
}
