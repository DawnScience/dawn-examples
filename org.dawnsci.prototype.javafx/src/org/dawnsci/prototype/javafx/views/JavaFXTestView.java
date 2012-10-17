package org.dawnsci.prototype.javafx.views;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.embed.swt.FXCanvas;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class JavaFXTestView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.dawnsci.prototype.javafx.views.JavaFXTestView";


    private Timeline animation;


	/**
	 * The constructor.
	 */
	public JavaFXTestView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {

		parent.setLayout(new GridLayout(1, false));
		final FXCanvas fxCanvas = new FXCanvas(parent, SWT.NONE);
        fxCanvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
        Group root = new Group();
        fxCanvas.setScene(new Scene(root));

        fxCanvas.getScene().setCamera(new PerspectiveCamera());

        root.getTransforms().addAll(

            new Translate(250, 200),

            new Rotate(180, Rotate.X_AXIS)

        );

        root.getChildren().add(create3dContent());       
   
        play();

	}

    protected PieChart createPieChart() {

        final PieChart pc = new PieChart(FXCollections.observableArrayList(

            new PieChart.Data("Sun", 20),

            new PieChart.Data("IBM", 12),

            new PieChart.Data("HP", 25),

            new PieChart.Data("Dell", 22),

            new PieChart.Data("Apple", 30)

        ));

        // setup chart

        pc.setId("BasicPie");

        pc.setTitle("Pie Chart Example");

        return pc;

    }
    protected AreaChart<Number, Number> createAreaChart() {

        NumberAxis xAxis = new NumberAxis();

        NumberAxis yAxis = new NumberAxis();

        AreaChart<Number,Number> ac = new AreaChart<Number,Number>(xAxis,yAxis);

        // setup chart

        ac.setTitle("Area Chart Example");

        xAxis.setLabel("X Axis");

        yAxis.setLabel("Y Axis");

        // add starting data

        for (int s=0;s<3;s++) {

            XYChart.Series<Number,Number> series = new XYChart.Series<Number,Number>();

            series.setName("Data Series "+s);

            double x = 0;

            while (x<95) {

                series.getData().add(new XYChart.Data<Number,Number>(x, Math.random()*99));

                x += 5 + (15*Math.random());

            }

            series.getData().add(new XYChart.Data<Number,Number>(99d, Math.random()*99));

            ac.getData().add(series);

        }

        return ac;

    }
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		
	}
	
	
    public Node create3dContent() {

        Xform sceneRoot = new Xform();

 

        Xform cube1X = new Xform();

        Cube cube1  = new Cube(40, new Color(1.0, 0.9, 0.0, 1.0), 1.0);

         

        Xform cube1_1X = new Xform();

        Xform cube1_2X = new Xform();

        Xform cube1_3X = new Xform();

        Xform cube1_4X = new Xform();

        Xform cube1_5X = new Xform();

        Xform cube1_6X = new Xform();

        Xform cube1_7X = new Xform();

        Xform cube1_8X = new Xform();

        Xform cube1_9X = new Xform();

 

        Cube cube1_1 = new Cube(4, Color.RED, 1.0);

        Cube cube1_2 = new Cube(5, Color.ORANGE, 1.0);

        Cube cube1_3 = new Cube(6, Color.CORNFLOWERBLUE, 1.0);

        Cube cube1_4 = new Cube(7, Color.DARKGREEN, 1.0);

        Cube cube1_5 = new Cube(8, Color.BLUE, 1.0);

        Cube cube1_6 = new Cube(9, Color.PURPLE, 1.0);

        Cube cube1_7 = new Cube(10, Color.BLUEVIOLET, 1.0);

        Cube cube1_8 = new Cube(11, Color.DARKGOLDENROD, 1.0);

        Cube cube1_9 = new Cube(12, Color.KHAKI, 1.0);

 

        sceneRoot.getChildren().add(cube1X);

 

        cube1X.getChildren().add(cube1);

        cube1X.getChildren().add(cube1_1X);

        cube1X.getChildren().add(cube1_2X);

        cube1X.getChildren().add(cube1_3X);

        cube1X.getChildren().add(cube1_4X);

        cube1X.getChildren().add(cube1_5X);

        cube1X.getChildren().add(cube1_6X);

        cube1X.getChildren().add(cube1_7X);

        cube1X.getChildren().add(cube1_8X);

        cube1X.getChildren().add(cube1_9X);

 

        cube1_1X.getChildren().add(cube1_1);

        cube1_2X.getChildren().add(cube1_2);

        cube1_3X.getChildren().add(cube1_3);

        cube1_4X.getChildren().add(cube1_4);

        cube1_5X.getChildren().add(cube1_5);

        cube1_6X.getChildren().add(cube1_6);

        cube1_7X.getChildren().add(cube1_7);

        cube1_8X.getChildren().add(cube1_8);

        cube1_9X.getChildren().add(cube1_9);

 

        cube1_1.setTranslateX(40.0);

        cube1_2.setTranslateX(60.0);

        cube1_3.setTranslateX(80.0);

        cube1_4.setTranslateX(100.0);

        cube1_5.setTranslateX(120.0);

        cube1_6.setTranslateX(140.0);

        cube1_7.setTranslateX(160.0);

        cube1_8.setTranslateX(180.0);

        cube1_9.setTranslateX(200.0);

 

        cube1_1X.rx.setAngle(30.0);

        cube1_2X.rz.setAngle(10.0);

        cube1_3X.rz.setAngle(50.0);

        cube1_4X.rz.setAngle(170.0);

        cube1_5X.rz.setAngle(60.0);

        cube1_6X.rz.setAngle(30.0);

        cube1_7X.rz.setAngle(120.0);

        cube1_8X.rz.setAngle(40.0);

        cube1_9X.rz.setAngle(-60.0);

 

        double endTime = 4000.0; 

         

        // Animate

        animation = new Timeline();

        animation.getKeyFrames().addAll

            (new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1X.ry.angleProperty(), 360.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1X.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1X.rx.angleProperty(), 360.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_1X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_1X.ry.angleProperty(), -2880.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_2X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_2X.ry.angleProperty(), -1440.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_3X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_3X.ry.angleProperty(), -1080.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_4X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_4X.ry.angleProperty(), -720.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_5X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_5X.ry.angleProperty(), 1440.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_6X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_6X.ry.angleProperty(), 1080.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_7X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_7X.ry.angleProperty(), -360.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_8X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_8X.ry.angleProperty(), -720.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_9X.ry.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_9X.ry.angleProperty(), -1080.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_1.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_1.rx.angleProperty(), 7200.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_2.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_2.rx.angleProperty(), -7200.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_3.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_3.rx.angleProperty(), 7200.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_4.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_4.rx.angleProperty(), -7200.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_5.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_5.rx.angleProperty(), 7200.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_6.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_6.rx.angleProperty(), -7200.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_7.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_7.rx.angleProperty(), 7200.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_8.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_8.rx.angleProperty(), -7200.0)),

             new KeyFrame(Duration.ZERO,  

                          new KeyValue(cube1_9.rx.angleProperty(), 0.0)),

             new KeyFrame(new Duration(endTime),  

                          new KeyValue(cube1_9.rx.angleProperty(), 7200.0)) 

             );

        animation.setCycleCount(Timeline.INDEFINITE);

        animation.play();

 

        return sceneRoot;

    }

 

    public void play() {

        animation.play();

    }

 

   public void stop() {

        animation.pause();

    }

 

    class Xform extends Group {

        final Rotate rx = new Rotate(0, Rotate.X_AXIS);

        final Rotate ry = new Rotate(0, Rotate.Y_AXIS);

        final Rotate rz = new Rotate(0, Rotate.Z_AXIS);

        public Xform() { 

            super(); 

            getTransforms().addAll(rz, ry, rx); 

        }

    }

 

    public class Cube extends Group {

        final Rotate rx = new Rotate(0,Rotate.X_AXIS);

        final Rotate ry = new Rotate(0,Rotate.Y_AXIS);

        final Rotate rz = new Rotate(0,Rotate.Z_AXIS);

        public Cube(double size, Color color, double shade) {

            getTransforms().addAll(rz, ry, rx);

            getChildren().addAll(

                RectangleBuilder.create() // back face

                    .width(size).height(size)

                    .fill(color.deriveColor(0.0, 1.0, (1 - 0.5*shade), 1.0))

                    .translateX(-0.5*size)

                    .translateY(-0.5*size)

                    .translateZ(0.5*size)

                    .build(),

                RectangleBuilder.create() // bottom face

                    .width(size).height(size)

                    .fill(color.deriveColor(0.0, 1.0, (1 - 0.4*shade), 1.0))

                    .translateX(-0.5*size)

                    .translateY(0)

                    .rotationAxis(Rotate.X_AXIS)

                    .rotate(90)

                    .build(),

                RectangleBuilder.create() // right face

                    .width(size).height(size)

                    .fill(color.deriveColor(0.0, 1.0, (1 - 0.3*shade), 1.0))

                    .translateX(-1*size)

                    .translateY(-0.5*size)

                    .rotationAxis(Rotate.Y_AXIS)

                    .rotate(90)

                    .build(),

                RectangleBuilder.create() // left face

                    .width(size).height(size)

                    .fill(color.deriveColor(0.0, 1.0, (1 - 0.2*shade), 1.0))

                    .translateX(0)

                    .translateY(-0.5*size)

                    .rotationAxis(Rotate.Y_AXIS)

                    .rotate(90)

                    .build(),

                RectangleBuilder.create() // top face

                    .width(size).height(size)

                    .fill(color.deriveColor(0.0, 1.0, (1 - 0.1*shade), 1.0))

                    .translateX(-0.5*size)

                    .translateY(-1*size)

                    .rotationAxis(Rotate.X_AXIS)

                    .rotate(90)

                    .build(),

                RectangleBuilder.create() // top face

                    .width(size).height(size)

                    .fill(color)

                    .translateX(-0.5*size)

                    .translateY(-0.5*size)

                    .translateZ(-0.5*size)

                    .build()

            );

        }

    }

 

 

    public double getSampleWidth() { return 400; }

 

    public double getSampleHeight() { return 150; }


}