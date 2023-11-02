// SketchPane.java, CSE205, Arizona State University 
// Name: Jacob Allen
// StudentID: 1221743861
// Lecture time: 9:00 - 10:15 Tue Thurs
// Description: Creates, applies, and modifies all of the nodes and functionality of the SketchPane.

import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class SketchPane extends BorderPane {
	
	//Task 1: Declare all instance variables listed in UML diagram
    private ArrayList<Shape> shapeList;
    private ArrayList<Shape> tempList;
    private Button undoButton;
    private Button eraseButton;
    private Label fillColorLabel;
    private Label strokeColorLabel;
    private Label strokeWidthLabel;
    private ComboBox<String> fillColorCombo;
    private ComboBox<String> strokeWidthCombo;
    private ComboBox<String> strokeColorCombo;
    private RadioButton radioButtonLine;
    private RadioButton radioButtonRectangle;
    private RadioButton radioButtonCircle;
    private Pane sketchCanvas;
    private Color[] colors;
    private String[] strokeWidth;
    private String[] colorLabels;
    private Color currentStrokeColor;
    private Color currentFillColor;
    private int currentStrokeWidth;
    private Line line;
    private Circle circle;
    private Rectangle rectangle;
    private double x1;
    private double y1;
    
    
    
	//Task 2: Implement the constructor
	public SketchPane() {
		
		// Colors, labels, and stroke widths that are available to the user, already added
		colors = new Color[] {Color.BLACK, Color.GREY, Color.YELLOW, Color.GOLD, Color.ORANGE, Color.DARKRED, Color.PURPLE, Color.HOTPINK, Color.TEAL, Color.DEEPSKYBLUE, Color.LIME} ;
        colorLabels = new String[] {"black", "grey", "yellow", "gold", "orange", "dark red", "purple", "hot pink", "teal", "deep sky blue", "lime"};
        fillColorLabel = new Label("Fill Color:");
        strokeColorLabel = new Label("Stroke Color:");
        strokeWidthLabel = new Label("Stroke Width:");
        strokeWidth = new String[] {"1", "3", "5", "7", "9", "11", "13"};    
        
		//ArrayLists
        shapeList = new ArrayList<Shape>();
        tempList = new ArrayList<Shape>();
		//tempList = shapeList;
		
		//RadioButtons
		radioButtonLine = new RadioButton("Line");
		radioButtonRectangle = new RadioButton("Rectangle");
		radioButtonCircle = new RadioButton("Circle");
		
		//Setting to one toggle group
		ToggleGroup toggleGroupRadio = new ToggleGroup();
		radioButtonLine.setToggleGroup(toggleGroupRadio);
		radioButtonRectangle.setToggleGroup(toggleGroupRadio);
		radioButtonCircle.setToggleGroup(toggleGroupRadio);
		radioButtonLine.setSelected(true);
		
		//Buttons
		undoButton = new Button("Undo");
		undoButton.setOnAction(new ButtonHandler());
		eraseButton = new Button("Erase");
		eraseButton.setOnAction(new ButtonHandler());
		
		//ComboBox, Initializing them to their respective arrays, assigning their default values, and their respective button handlers
		fillColorCombo = new ComboBox<String>();
		fillColorCombo.setValue(fillColorLabel.getText());
		fillColorCombo.getItems().addAll(colorLabels);
		fillColorCombo.getSelectionModel().select(0);
		fillColorCombo.setOnAction(new ColorHandler());
		currentFillColor = colors[fillColorCombo.getSelectionModel().getSelectedIndex()];
		
		strokeWidthCombo = new ComboBox<String>();
		strokeWidthCombo.setValue(strokeWidthLabel.getText());
		strokeWidthCombo.getItems().addAll(strokeWidth);
		strokeWidthCombo.getSelectionModel().select(0);
		strokeWidthCombo.setOnAction(new WidthHandler());
		currentStrokeWidth = Integer.parseInt(strokeWidth[strokeWidthCombo.getSelectionModel().getSelectedIndex()]);
		
		strokeColorCombo = new ComboBox<String>();
		strokeColorCombo.setValue(strokeColorLabel.getText());
		strokeColorCombo.getItems().addAll(colorLabels);
		strokeColorCombo.getSelectionModel().select(0);
		strokeColorCombo.setOnAction(new ColorHandler());
		currentStrokeColor = colors[strokeColorCombo.getSelectionModel().getSelectedIndex()];
		
		//HBox creation and adjustment
		HBox sketchHBox = new HBox(20);
		sketchHBox.setMinSize(20, 40);
		sketchHBox.setAlignment(Pos.CENTER);
		sketchHBox.setStyle("-fx-background-color: lightgrey");
		sketchHBox.getChildren().add(fillColorLabel);
		sketchHBox.getChildren().add(fillColorCombo);
		sketchHBox.getChildren().add(strokeWidthLabel);
		sketchHBox.getChildren().add(strokeWidthCombo);
		sketchHBox.getChildren().add(strokeColorLabel);
		sketchHBox.getChildren().add(strokeColorCombo);
		
		//Adding buttons to HBox and creating button HBox
		HBox buttonHBox = new HBox(20);
		buttonHBox.setMinSize(20,40);
		buttonHBox.setStyle("-fx-background-color: lightgrey");
		buttonHBox.getChildren().add(radioButtonLine);
		buttonHBox.getChildren().add(radioButtonRectangle);
		buttonHBox.getChildren().add(radioButtonCircle);
		buttonHBox.getChildren().add(undoButton);
		buttonHBox.getChildren().add(eraseButton);
		buttonHBox.setAlignment(Pos.CENTER);
		
		//SketchPane instantiation and color
		sketchCanvas = new Pane();
		sketchCanvas.setStyle("-fx-background-color: white");

		//BorderPane creation and adding HBoxes + sketchCanvas
		setCenter(sketchCanvas);
		setTop(sketchHBox);
		setBottom(buttonHBox);
		
		sketchCanvas.setOnMousePressed(new MouseHandler());
		sketchCanvas.setOnMouseDragged(new MouseHandler());
		sketchCanvas.setOnMouseReleased(new MouseHandler());
		x1 = 0;
		y1 = 0;
    }

	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			// TASK 3: Implement the mouse handler for Circle and Line
			// Rectange Example given!
			if (radioButtonRectangle.isSelected()) {
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					rectangle = new Rectangle();
					rectangle.setX(x1);
					rectangle.setY(y1);
					shapeList.add(rectangle);
					tempList.add(rectangle);
					rectangle.setFill(Color.WHITE);
					rectangle.setStroke(Color.BLACK);	
					sketchCanvas.getChildren().add(rectangle);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					rectangle.setWidth(Math.abs(event.getX() - x1));
					rectangle.setHeight(Math.abs(event.getY() - y1));

				}
				//Mouse is released
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					rectangle.setFill(currentFillColor);
					rectangle.setStroke(currentStrokeColor);
					rectangle.setStrokeWidth(currentStrokeWidth);
				}
			}
			
			//Circle radio button
			if (radioButtonCircle.isSelected()) {
				//Mouse is pressed
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					circle = new Circle();
					circle.setCenterX(x1);
					circle.setCenterY(y1);
					shapeList.add(circle);
					tempList.add(circle);
					circle.setFill(Color.WHITE);
					circle.setStroke(Color.BLACK);
					sketchCanvas.getChildren().add(circle);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					double x2 = event.getX();
					double y2 = event.getY();
					double radius = getDistance(x1, y1, x2, y2);
					circle.setRadius(radius);
				}
				//Mouse is released
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					circle.setFill(currentFillColor);
					circle.setStroke(currentStrokeColor);
					circle.setStrokeWidth(currentStrokeWidth);
				}
			}
			
			//Line radio button
			if (radioButtonLine.isSelected()) {
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					line = new Line(x1, y1, x1, y1);
					line.setStartX(x1);
					line.setStartY(y1);
					shapeList.add(line);
					tempList.add(line);
					sketchCanvas.getChildren().add(line);
				}
				
				//Mouse is dragged
				if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					//setting the end of the line
					line.setEndX(event.getX());
					line.setEndY(event.getY());
				}
				
				//Mouse is released
				if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					line.setStroke(currentStrokeColor);
					line.setStrokeWidth(currentStrokeWidth);
				}
			}
		}
	}
		
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 4: Implement the button handler
			//UndoButton
			if (event.getSource() == undoButton && shapeList.size() != 0) {
				//Remove last element from array list and remove last drawn element from sketchCanvas < - switch order dont feel like retyping
				sketchCanvas.getChildren().remove(shapeList.get(shapeList.size() - 1));
				shapeList.remove(shapeList.get(shapeList.size()-1));
			}
			else if (shapeList.size() == 0 && tempList.size() != 0) {
				//Copies all of tempList into shapeList and clears tempList
				for (int i = 0; i < tempList.size(); i++) {
					shapeList.add(tempList.get(i));
				}//End of for loop
				tempList.clear();
				
				//for loop that copies all of shapeList onto sketchCanvas
				for (int i = 0; i < shapeList.size(); i++) {
					sketchCanvas.getChildren().add(shapeList.get(i));
				}//End of for loop
			}
			
			//EraseButton
			if (event.getSource() == eraseButton && shapeList.size() != 0) {
				if (tempList.size() != 0)
					tempList.clear();
				//for loop copies all of shapeList into tempList
				for (int i = 0; i < shapeList.size(); i++) {
					tempList.add(shapeList.get(i));
				}
				shapeList.clear();
				sketchCanvas.getChildren().clear();
			}
		}
	}

	private class ColorHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 5: Implement the color handler
			currentFillColor = colors[fillColorCombo.getSelectionModel().getSelectedIndex()];
			currentStrokeColor = colors[strokeColorCombo.getSelectionModel().getSelectedIndex()];
		}
	}
	
	private class WidthHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event){
			// TASK 6: Implement the stroke width handler
			String strokeWidthString = strokeWidth[strokeWidthCombo.getSelectionModel().getSelectedIndex()];
			currentStrokeWidth = Integer.parseInt(strokeWidthString);
		}
	}
	
		
	// Get the Euclidean distance between (x1,y1) and (x2,y2)
    private double getDistance(double x1, double y1, double x2, double y2)  {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}