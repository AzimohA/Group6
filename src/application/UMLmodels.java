package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

public class UMLmodels {
	public final int ARR_SIZE = 4;
	public GraphicsContext gc, gc1, gc2,gc3, arr,arrOpp;

	public void drawObjects(GraphicsContext gc) {
		//gc.setStroke(Color.BLACK);
	
		gc.fillRoundRect(190, 60, 50, 40, 10, 10); 
		gc.fillRect(210, 110, 10, 50);
		gc.fillText("Node B", 195, 50);
        gc.strokeLine(215, 100,215, 300);
        gc.fillRect(210, 170, 10, 50);// 2nd message'
        gc.fillText("msg5", 200, 240);
	
	}
	public void drawObjects1(GraphicsContext gc1) {
			gc1.setFill(Color.GREY);
			gc1.fillRoundRect(80, 60, 50, 40, 10, 10);
			gc1.setLineDashes(2);
			gc1.fillRect(100, 110, 10, 50);
			gc1.strokeLine(105, 100,105, 300);
			gc1.fillText("Node A", 85, 50);
			gc1.fillRect(100, 230, 10, 30);
		}
	public void node3(GraphicsContext gc2) {
		//gc2.setStroke(Color.BLACK);
		gc2.fillRoundRect(300, 60, 50, 40, 10, 10); 
		gc2.fillText("Node C", 305, 50);
		gc2.fillRect(320, 170, 10, 50);
        gc2.strokeLine(325, 100,325, 300);
        gc2.fillRect(320, 230, 10, 30);
        gc2.fillText("msg3", 250, 180);
        gc2.fillText("msg4", 250, 200);
	}

	public void drawArrow(GraphicsContext arr, int x1, int y1, int x2, int y2) {

	    arr.setFill(Color.BLACK);

	    double dx = x2 - x1, dy = y2 - y1;
	    double angle = Math.atan2(dy, dx);
	    int len = (int) Math.sqrt(dx * dx + dy * dy);

	    Affine affine = new Affine(Affine.translate(x1, y1));
	    affine.createConcatenation(Affine.rotate(angle, 0, 0));
	    arr.setTransform(affine);

	    arr.strokeLine(0, 0, len, 0);
	    arr.fillPolygon(new double[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new double[]{0, -ARR_SIZE, ARR_SIZE, 0},
	            4);

	}
	
	public void drawArrowOpp(GraphicsContext arrOpp,int x2, int y1, int x1, int y2) {
		    arrOpp.setFill(Color.BLACK);

		    double dx = x2 - x1, dy = y2 - y1;
		    double angle = Math.atan2(dy, dx);
		    int len = (int) Math.sqrt(dx * dx + dy * dy);

		    Transform transform = Transform.translate(x1, y1);
		    transform = transform.createConcatenation(Transform.rotate(Math.toDegrees(angle), 0, 0));
		    arrOpp.setTransform(new Affine(transform));

		    arrOpp.strokeLine(0, 0, len, 0);
		    arrOpp.fillPolygon(new double[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new double[]{0, -ARR_SIZE, ARR_SIZE, 0},
		            4);
	}
	
}
