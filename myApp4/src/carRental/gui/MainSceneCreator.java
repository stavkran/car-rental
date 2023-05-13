package carRental.gui;


import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	FlowPane rootFlowPane;
	//main scene buttons
	Button cityButton , storeButton , clientsButton , vehicleButton , vehicleRentButton;
	public MainSceneCreator(double width, double height) {
		super(width, height);
		rootFlowPane= new FlowPane();
		cityButton = new Button("City");
		storeButton = new Button("Stores");
		clientsButton = new Button("Clients");
		vehicleButton = new Button("Vehicle");
		vehicleRentButton = new Button("Vehicle Rental");
		
		//attach handle event to citiesButton
		
		cityButton.setOnMouseClicked(this);
		storeButton.setOnMouseClicked(this);
		vehicleButton.setOnMouseClicked(this);
		clientsButton.setOnMouseClicked(this);
		vehicleRentButton.setOnMouseClicked(this);
		//setup flowpane
		
		rootFlowPane.setHgap(10);
		rootFlowPane.setAlignment(Pos.CENTER);
		
		// add cities , stores , clients , vehicle , vehicle rental
		
		rootFlowPane.getChildren().add(cityButton);
		rootFlowPane.getChildren().add(storeButton);
		rootFlowPane.getChildren().add(clientsButton);
		rootFlowPane.getChildren().add(vehicleButton);
		rootFlowPane.getChildren().add(vehicleRentButton);
	}

	@Override
	public void handle(MouseEvent event) {
		if(event.getSource()==cityButton) {
			app.mainStage.setTitle("Cities Window");
			app.mainStage.setScene(app.cityScene);
		}
		if(event.getSource()==storeButton) {
			app.mainStage.setTitle("Store Window");
			app.mainStage.setScene(app.storeScene);
		
		}
		if(event.getSource()==vehicleButton) {
			app.mainStage.setTitle("Vehicle Window");
			app.mainStage.setScene(app.vehicleScene);
		
		}
		if(event.getSource()==clientsButton) {
			app.mainStage.setTitle("Client Window");
			app.mainStage.setScene(app.clientScene);
		
		}
		if(event.getSource()==vehicleRentButton) {
			app.mainStage.setTitle("Rental Window");
			app.mainStage.setScene(app.vehicalRentScene);
	}

	}
	@Override
	public Scene createScene() {
		return new Scene(rootFlowPane , width , height);
	}

}