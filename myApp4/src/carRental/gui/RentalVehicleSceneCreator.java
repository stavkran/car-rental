package carRental.gui;
import java.util.ArrayList;
import java.util.List;

import carRental.core.City;
import carRental.core.Rental;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
public class RentalVehicleSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	ArrayList<Rental> rentalList;
	//Flow Pane
	 FlowPane buttonFlowPane;
	GridPane rootGridPane,inputFieldsPane;
	//Grid Panes
	Button newRentalButton , deleteRentalButton , backButton, viewAllButton;
	Label clientnameLbl , marketLbl, reNumVehicleLbl,rDateLbl,hourLbl,sumCostLbl ,rentalvehiclelbl;
	TextField clientnameField , marketField, reNumVehicleField,rDateField,hourField,sumCostField,rentalVehicleField;
	// table view
	TableView<Rental> rentalTableView;
	 int i = City.MAX_CODE;
	public RentalVehicleSceneCreator(double width, double height) {
		super(width, height);
		rentalList = new ArrayList<>();
		rootGridPane=new GridPane();
		buttonFlowPane = new FlowPane();
		clientnameLbl= new Label ("Client Name:");
		marketLbl= new Label ("Store Name:");
		reNumVehicleLbl= new Label ("Registration Number :");
		rDateLbl= new Label ("Date:");
		rentalVehicleField= new TextField();
		hourLbl= new Label ("Hour:");
		sumCostLbl= new Label ("Total Cost:");
		rentalvehiclelbl= new Label ("Vehicle:");
		clientnameField = new TextField();
		marketField= new TextField();
		reNumVehicleField= new TextField();
		rDateField= new TextField();
		hourField= new TextField();
		sumCostField= new TextField();
		newRentalButton = new Button("New Rented Car");
		deleteRentalButton= new Button("Delete Rental Car");
		viewAllButton= new Button("View All");
		backButton = new Button("Go Back");
		inputFieldsPane = new GridPane();
		rentalTableView= new TableView<>();
		//Customize flowPane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newRentalButton);
		buttonFlowPane.getChildren().add(deleteRentalButton);
		buttonFlowPane.getChildren().add(viewAllButton);
		buttonFlowPane.getChildren().add(backButton);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		//customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(clientnameLbl, 0,0);
		inputFieldsPane.add(clientnameField,1,0);
		inputFieldsPane.add(marketLbl, 0,1);
		inputFieldsPane.add(marketField,1,1);
		inputFieldsPane.add(reNumVehicleLbl, 0,2);
		inputFieldsPane.add(reNumVehicleField,1,2);
		inputFieldsPane.add(rDateLbl, 0,3);
		inputFieldsPane.add(rDateField,1,3);
		inputFieldsPane.add(hourLbl, 0,4);
		inputFieldsPane.add(hourField,1,4);
		inputFieldsPane.add(sumCostLbl, 0,5);
		inputFieldsPane.add(sumCostField,1,5);
		inputFieldsPane.add(rentalvehiclelbl, 0,6);
		inputFieldsPane.add(rentalVehicleField,1,6);
		
		//customize rootScene2
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(rentalTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backButton, 1, 2);
		TableColumn<Rental, String> clientNameColumn= new TableColumn<>("Client Name");
		clientNameColumn.setCellValueFactory(new PropertyValueFactory<>("rentalClientName"));
		rentalTableView.getColumns().add(clientNameColumn);
		TableColumn<Rental,String> marketColumn = new TableColumn<>("Store Name");
		marketColumn.setCellValueFactory(new PropertyValueFactory<>("rentalMarket"));
		rentalTableView.getColumns().add(marketColumn);
		TableColumn<Rental,String> reNumVehicleColumn = new TableColumn<>("Registration Number");
		reNumVehicleColumn.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
		rentalTableView.getColumns().add(reNumVehicleColumn);
		TableColumn<Rental, String> DateColumn= new TableColumn<>("Date");
		DateColumn.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
		rentalTableView.getColumns().add(DateColumn);
		TableColumn<Rental,String> hourColumn = new TableColumn<>("Hour");
		hourColumn.setCellValueFactory(new PropertyValueFactory<>("rentalHour"));
		rentalTableView.getColumns().add(hourColumn);
		TableColumn<Rental,String> sumCostColumn = new TableColumn<>("Total Cost");
		sumCostColumn.setCellValueFactory(new PropertyValueFactory<>("sumCost"));
		rentalTableView.getColumns().add(sumCostColumn);
		TableColumn<Rental,Integer> passColumn = new TableColumn<>("Code");
		passColumn.setCellValueFactory(new PropertyValueFactory<>("rentalPassword"));
		rentalTableView.getColumns().add(passColumn);
		TableColumn<Rental,String> vehicleColumn = new TableColumn<>("Vehicle");
		vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("rentalVehicle"));
		rentalTableView.getColumns().add(vehicleColumn);
		
		
		
		
		backButton.setOnMouseClicked(this);
		newRentalButton.setOnMouseClicked(this);
		viewAllButton.setOnMouseClicked(this);
		deleteRentalButton.setOnMouseClicked(this);
		rentalTableView.setOnMouseClicked(this);
	}
	@Override
	public void handle(MouseEvent event) {
	if(event.getSource() == backButton) {
		app.mainStage.setTitle("Car Rental Window");
		app.mainStage.setScene(app.mainScene);}
	if(event.getSource()==newRentalButton) {
		String rentalClientName = clientnameField.getText();
		String rentalMarket = marketField.getText();
		String registrationNumber = reNumVehicleField.getText();
		String rentalDate = rDateField.getText();
		String rentalHour = hourField.getText();
		String sumCost = sumCostField.getText();
		int rentalPassword= i;
		String rentalVehicle = rentalVehicleField.getText();
		createRental(rentalClientName,rentalMarket,registrationNumber,rentalDate,rentalHour,sumCost, rentalPassword,rentalVehicle);
		tableSync();
		clearTextFields();
	}
	if(event.getSource()==deleteRentalButton) {
		deleteRental(clientnameField.getText());
		tableSync();
		clearTextFields();
	}
	if(event.getSource()==rentalTableView) {
		Rental selectedRental= rentalTableView.getSelectionModel().getSelectedItem();
		if(selectedRental!= null) {
			clientnameField.setText(selectedRental.getRentalClientName());
			marketField.setText(selectedRental.getRentalMarket());
			reNumVehicleField.setText(selectedRental.getRentalVehicle());
			rDateField.setText(selectedRental.getRentalDate());
			hourField.setText(selectedRental.getRentalHour());
			sumCostField.setText(selectedRental.getSumCost());
		}
	}
	}
	private void deleteRental(String clientName) {
		for(int i = 0; i< rentalList.size();i++) {
			if(rentalList.get(i).getRentalClientName().equals(clientName)) {
				rentalList.remove(i);
				break;
			}
		}
	}
	public void tableSync() {
		List<Rental>items = rentalTableView.getItems();
		items.clear();
		for(Rental d : rentalList) {
			if(d instanceof Rental) {
				items.add((Rental) d);
			}
		}
	}
	public void clearTextFields() {
		clientnameField.setText("");
		marketField.setText("");
		reNumVehicleField.setText("");
		rDateField.setText("");
		hourField.setText("");
		sumCostField.setText("");
		rentalVehicleField.setText("");
	}
	public void createRental(String rentalClientName, String rentalMarket, String registrationNumber,
			String rentalDate, String rentalHour, String sumCost,int rentalPassword,String rentalVehicle) {
		Rental l = new Rental(rentalClientName,rentalMarket,registrationNumber,rentalDate,rentalHour,sumCost, rentalPassword,rentalVehicle);
		rentalList.add(l);
	}
		
		@Override
	Scene createScene() {
	// TODO Auto-generated method stub
	return new Scene(rootGridPane,width,height);
	}
}
	
	
	
	
	
	
	
	