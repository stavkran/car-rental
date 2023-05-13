package carRental.gui;
import java.util.ArrayList;
import java.util.List;

import carRental.core.Car;
import carRental.core.Client;
import carRental.core.Vehicle;
import carRental.core.twoWheeled;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class VehicleSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

	Button viewVehicleButton,updateVehicleButton,deleteVehicleButton,newVehicleButton,backButton,searchButton;;
	TableView<Vehicle> vehicleTableView;
	FlowPane buttonFlowPane;
	GridPane rootGridPane,inputFieldsPane,inputsearchField;
	ArrayList<Vehicle> vehicleList;
	ComboBox<String> comboBox;
	TextField searchField,registerNumberField,modelField,cubicFiels,costField,typeofgasField,seatsField,doorField,heightField,baggageField;
	Label registerNumberLabel,modelLabel,cubicLabel,costLabel,typeofgasLabel,seatsLabel,doorLabel,heightLabel,baggageLabel,comboboxLabel;
	
	public VehicleSceneCreator(double width, double height) {
		super(width, height);
		 vehicleList = new ArrayList<>();
		 rootGridPane=new GridPane();
		 buttonFlowPane = new FlowPane();
		 viewVehicleButton = new Button("View All");
		 searchField = new TextField();
		 updateVehicleButton = new Button ("Update Vehicle");
		 deleteVehicleButton = new Button("Delete Vehicle");
		 backButton = new Button("Go Back");
		 newVehicleButton = new Button ("New Vehicle");
		 vehicleTableView = new TableView<>();
		 comboBox = new ComboBox<>();
		 inputFieldsPane = new GridPane();
		 registerNumberLabel= new Label ("Register Number");
		 modelLabel= new Label ("Model");
		 cubicLabel = new Label ("Cubic Meters");
		 costLabel= new Label ("Cost Per Day");
		 comboboxLabel= new Label ("Car or TwoWheeled");
		 typeofgasLabel= new Label ("Type Of Gas");
		 seatsLabel= new Label ("Number Of Seats");
		 doorLabel= new Label ("Number Of Doors");
		 heightLabel= new Label ("Height");
		 baggageLabel= new Label ("Baggage");
		 searchButton= new Button("Search");
		 searchField  = new TextField();
		 inputsearchField = new GridPane();
		 registerNumberField = new TextField();
		 modelField= new TextField();
		 cubicFiels= new TextField();
		 costField= new TextField();
		 typeofgasField= new TextField();
		 seatsField= new TextField();
		 doorField = new TextField();
		 heightField = new TextField();
		 baggageField= new TextField();

		 
		 
		 comboBox.getItems().addAll("car","twowheeled");
			//newVehicleButton.setOnAction(e -> getChoice(comboBox));
			//updateVehicleButton.setOnAction(e -> getChoice(comboBox));
			
		 buttonFlowPane.setHgap(10);
		 buttonFlowPane.getChildren().add(newVehicleButton);
		 buttonFlowPane.getChildren().add(viewVehicleButton );
			buttonFlowPane.getChildren().add(updateVehicleButton);
			buttonFlowPane.getChildren().add(deleteVehicleButton);			
			buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
			
			inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
			inputFieldsPane.setVgap(10);
			inputFieldsPane.setHgap(10);
			inputFieldsPane.add( comboboxLabel ,0,0);
			inputFieldsPane.add(comboBox  ,0,1);
			inputFieldsPane.add(registerNumberLabel, 0,2);
			inputFieldsPane.add(registerNumberField, 1,2);
			inputFieldsPane.add(modelLabel, 0,3);
			inputFieldsPane.add( modelField, 1,3);
			inputFieldsPane.add(cubicLabel, 0,4);
			inputFieldsPane.add( cubicFiels, 1,4);
			inputFieldsPane.add(costLabel, 0,5);
			inputFieldsPane.add(costField, 1,5);
			inputFieldsPane.add(typeofgasLabel, 0,6);
			inputFieldsPane.add( typeofgasField, 1,6);
			inputFieldsPane.add( seatsLabel, 0,7);
			inputFieldsPane.add(seatsField, 1,7);
			inputFieldsPane.add(doorLabel, 0,8);
			inputFieldsPane.add( doorField, 1,8);
			inputFieldsPane.add( heightLabel, 0,9);
			inputFieldsPane.add( heightField, 1,9);
			inputFieldsPane.add( baggageLabel, 0,10);
			inputFieldsPane.add(baggageField, 1,10);
			inputsearchField.add(searchField, 0, 0);
			inputsearchField.add(searchButton, 1, 0);
			
			rootGridPane.setVgap(10);
			rootGridPane.setHgap(10);
			rootGridPane.add(inputFieldsPane, 1, 0);
			rootGridPane.add(inputsearchField,0,1);
			rootGridPane.add(vehicleTableView, 0, 0);
			rootGridPane.add(buttonFlowPane, 0, 2);
			rootGridPane.add(backButton, 1, 2);
		
		
	
		
		
		TableColumn<Vehicle, String> registernumColumn= new TableColumn<>("Register Number");
		registernumColumn.setCellValueFactory(new PropertyValueFactory<>("registerNumber"));
		vehicleTableView.getColumns().add(registernumColumn);
		
		TableColumn<Vehicle, String> modelColumn= new TableColumn<>("Model");
		modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
		vehicleTableView.getColumns().add(modelColumn);
		
		TableColumn<Vehicle, String> typeColumn= new TableColumn<>("Type of Gas");
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		vehicleTableView.getColumns().add(typeColumn);
		
		TableColumn<Vehicle, Integer> cubicColumn= new TableColumn<>("Cubic Meters");
		cubicColumn.setCellValueFactory(new PropertyValueFactory<>("cubic"));
		vehicleTableView.getColumns().add(cubicColumn);
		
		TableColumn<Vehicle, Integer> costColumn= new TableColumn<>("Cost Per Day");
		costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
		vehicleTableView.getColumns().add(costColumn);
		
		TableColumn<Vehicle, Integer> seatsColumn= new TableColumn<>("Number Of Seats");
		seatsColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
		vehicleTableView.getColumns().add(seatsColumn);
		
		TableColumn<Vehicle, Integer> doorColumn= new TableColumn<>("Number Of Doors");
		doorColumn.setCellValueFactory(new PropertyValueFactory<>("doors"));
		vehicleTableView.getColumns().add(doorColumn);
		
		TableColumn<Vehicle, Integer> heightColumn= new TableColumn<>("Height");
		heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
		vehicleTableView.getColumns().add(heightColumn);
		
		TableColumn<Vehicle, String> baggageColumn= new TableColumn<>("Baggage");
		baggageColumn.setCellValueFactory(new PropertyValueFactory<>("baggage"));
		vehicleTableView.getColumns().add(baggageColumn);
		
		searchButton.setOnMouseClicked(this);
		deleteVehicleButton.setOnMouseClicked(this);
		updateVehicleButton .setOnMouseClicked(this);
		viewVehicleButton.setOnMouseClicked(this);
		newVehicleButton.setOnMouseClicked(this);
		backButton.setOnMouseClicked(this);
		
	}

	private String getChoice(ComboBox<String> comboBox) {
		String vehicl = comboBox.getValue();
		return vehicl;
	}
		
	
	
	@Override
	Scene createScene() {
		
		return new Scene(rootGridPane,width,height);
	}

	@Override
	public void handle(MouseEvent event) {
       if(event.getSource() == newVehicleButton ) {
    	 String  vehicl = getChoice(comboBox);
    	   
    	 if(vehicl.equals("car")) {
  			 String registerNumber = registerNumberField.getText();
  			 String model = modelField.getText();
  			 String type = typeofgasField.getText();
  			 String cubic = cubicFiels.getText();
  			 String cost = costField.getText();
  			 String seats= seatsField.getText();
  		     String doors= doorField.getText();
  		     String height= heightField.getText();
  			 String baggage= baggageField.getText();
  			
  			 createCar(registerNumber,model,type,cubic,cost,seats,doors,height,baggage);
  			 tableSync();
  	    	  clearTextFields();  }
    	   
    	 
    	 if(vehicl.equals("twowheeled")) {
    			String registerNumber = registerNumberField.getText();
    			String model = modelField.getText();
    			String type = typeofgasField.getText();
    			String cubic = cubicFiels.getText();
    			String cost = costField.getText();
    			String height= heightField.getText();
    		    String baggage= baggageField.getText();
    		    String seats= seatsField.getText();
    		    String  doors= doorField.getText();
    		  
    		    createTwoWheeled(registerNumber,model,type,cubic,cost,seats,doors,height,baggage);
    	    
  			 tableSync();
    	  clearTextFields();
    	    }
		
		if(event.getSource() == deleteVehicleButton) {
			deleteVehicle(registerNumberField.getText());
			tableSync();
			clearTextFields();
			
		}
		if(event.getSource()==updateVehicleButton) {
			String  vehicl2 = getChoice(comboBox);
			if(vehicl2.equals("car")) {
	  			 String registerNumber = registerNumberField.getText();
	  			 String model = modelField.getText();
	  			 String type = typeofgasField.getText();
	  			 String cubic = cubicFiels.getText();
	  			 String cost = costField.getText();
	  			 String seats= seatsField.getText();
	  		     String doors= doorField.getText();
	  		     String height= heightField.getText();
	  			 String baggage= baggageField.getText();
	  			 String h = "";
	 			Vehicle selectedregisterNumber = vehicleTableView.getSelectionModel().getSelectedItem();
	 			if(selectedregisterNumber != null) {
	 				h = selectedregisterNumber.getRegisterNumber();
	 			}
	 			updateVehicleCar(h,registerNumber,model,type,cubic,cost,seats,doors,height,baggage);
		
			
			tableSync();
			clearTextFields();}
			
			
			if(vehicl2.equals("twowheeled")) {
				String registerNumber = registerNumberField.getText();
				String model = modelField.getText();
				String type = typeofgasField.getText();
				String cubic = cubicFiels.getText();
				String cost = costField.getText();
				String height= heightField.getText();
			    String baggage= baggageField.getText();
			    String seats= seatsField.getText();
			    String  doors= doorField.getText();
			  
			   
		    
		    String h = "";
			Vehicle selectedregisterNumber = vehicleTableView.getSelectionModel().getSelectedItem();
			if(selectedregisterNumber != null) {
				h = selectedregisterNumber.getRegisterNumber();
			}
			updateVehicleTwoWheeled(h,registerNumber,model,type,cubic,cost,seats,doors,height,baggage);
			tableSync();
			clearTextFields();
				
			}
			}
			
			
			
			
		}
		
		if(event.getSource()== viewVehicleButton) {
			
			
		}
		if(event.getSource() == backButton) {
			app.mainStage.setTitle("Car Rental Window");
			app.mainStage.setScene(app.mainScene);
		}
		
		if(event.getSource() == vehicleTableView) {
			Vehicle selectedVehicle = vehicleTableView.getSelectionModel().getSelectedItem();
			if(selectedVehicle != null) {
				registerNumberField.setText(selectedVehicle.getRegisterNumber());
				modelField.setText(selectedVehicle.getModel());
				typeofgasField.setText(selectedVehicle.getType());
				costField.setText(selectedVehicle.getCost());
				cubicFiels.setText(selectedVehicle.getCubic());
				heightField.setText(((twoWheeled)selectedVehicle).getHeight());
			    baggageField.setText(((twoWheeled)selectedVehicle).getBaggage());
				doorField.setPromptText(((Car) selectedVehicle).getDoors());
				seatsField.setText((((Car) selectedVehicle).getSeats()));
			}
		}
		
		if(event.getSource() == searchButton ) {
			String registerNumber = searchField.getText();
			sFind(registerNumber);
		}
		
		
	}

	private void deleteVehicle(String text) {
		for(int i = 0 ; i<vehicleList.size();i++) {
			if(vehicleList.get(i).getRegisterNumber().equals(text)) {
				vehicleList.remove(i);
				break;
			}
		}
	}
	public void updateVehicleCar(String h,String registerNumber,String model,String type, String cubic,String cost,String seats,String doors,String height,String baggage) {
		for(Vehicle d : vehicleList) {
			if(d instanceof Car) {
				if((d.getRegisterNumber())==h) {
					d.setModel(model);
					d.setType(type);
					d.setCubic(cubic);
					d.setCost(cost);
					((Car)d).setSeats(seatsField.getText());
					((Car)d).setDoors(doorField.getText());
					((Car)d).setHeight(heightField.getText());
					((Car)d).setBaggage(baggageField.getText());
				}
			}
		}
	}		
		
	
	public void updateVehicleTwoWheeled(String h,String registerNumber,String model,String type, String cubic,String cost,String seats,String doors,String height,String baggage) {
		for(Vehicle d : vehicleList) {
			if(d instanceof twoWheeled) {
				if((d.getRegisterNumber())==h) {
					d.setModel(model);
					d.setType(type);
					d.setCubic(cubic);
					d.setCost(cost);
					((twoWheeled)d).setHeight(heightField.getText());
					((twoWheeled)d).setBaggage(baggageField.getText());
					((twoWheeled)d).setSeats(seatsField.getText());
					((twoWheeled)d).setDoors(doorField.getText());
				}
			}
		}
		
	}
	
	
	
	
	
	
	public void clearTextFields() {
		registerNumberField.setText("");
		modelField.setText("");
		cubicFiels.setText("");
		costField.setText("");
		typeofgasField.setText("");
		seatsField.setText("");
		doorField.setText("");
		baggageField.setText("");
		heightField.setText("");
	
		
	}
	public void tableSync() {
		List<Vehicle> items =vehicleTableView.getItems();
		items.clear();
		for(Vehicle d : vehicleList) {
			if(d instanceof Vehicle) {
				items.add((Vehicle)d);
			}
		}
	}
	public void sFind(String registerNumber) {
		List<Vehicle> items = vehicleTableView.getItems();
		items.clear();
		for(Vehicle d : vehicleList) {
			if(d.getRegisterNumber().equals(registerNumber) ) {
				items.add((Vehicle)d);
			}
		}
		clearSearchField();
	}
	
	
	
	public void clearSearchField() {
		searchField.setText("");
	}
	
	
	public void createCar(String registerNumber, String model, String type, String cubic, String cost,String seats,String doors,String height,String baggage) {
		Car d = new Car(registerNumber, model,type,cubic,cost,seats,doors,height,baggage);
		vehicleList.add(d);
	}
	
		public void createTwoWheeled(String registerNumber2, String model2 , String type2,String cubic2 , String cost2,String seats2,String doors2,String height2 ,String baggage2) {
		twoWheeled d = new twoWheeled(registerNumber2, model2,type2,cubic2,cost2,seats2,doors2,height2,baggage2 );
		vehicleList.add(d);
		}
	
	
	
}
