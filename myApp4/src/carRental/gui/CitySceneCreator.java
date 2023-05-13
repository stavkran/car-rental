package carRental.gui;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;

import carRental.core.City;
import carRental.core.Client;

public class CitySceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	public static ArrayList<City> cityList;
	//Flow Pane
	FlowPane buttonFlowPane;
	//Grid Panes
	GridPane rootGridPane, inputFieldsPane;
	//second scene buttons
	Button newCityButton , updateCityButton , deleteCityButton , backButton;
	//second scene labels
	Label nameLbl ;
	//second scene TextFields
	TextField nameField ;
	// table view
	public static TableView<City> cityTableView;
    int i = City.MAX_CODE;
	public CitySceneCreator(double width, double height) {
		super(width, height);
		// initialize fields
		cityList = new ArrayList<>();
		rootGridPane=new GridPane();
		buttonFlowPane = new FlowPane();
		nameLbl= new Label ("Name:");
		nameField = new TextField();
		newCityButton = new Button("New City");
		updateCityButton = new Button("Update City");
		deleteCityButton = new Button("Delete City");
		backButton = new Button("Go Back");
		inputFieldsPane = new GridPane();
		cityTableView = new TableView<>();
		//Customize flowPane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newCityButton);
		buttonFlowPane.getChildren().add(updateCityButton);
		buttonFlowPane.getChildren().add(deleteCityButton);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		//customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(nameLbl, 0,0);
		inputFieldsPane.add(nameField,1,0);
		//customize rootScene2
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(cityTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backButton, 1, 2);
		//customize tableView
		TableColumn<City, String> nameColumn= new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
		cityTableView.getColumns().add(nameColumn);
		TableColumn<City, String> idColumn = new TableColumn<>("Code");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("cityCode"));
		cityTableView.getColumns().add(idColumn);
		backButton.setOnMouseClicked(this);
		newCityButton.setOnMouseClicked(this);
		updateCityButton.setOnMouseClicked(this);
		deleteCityButton.setOnMouseClicked(this);
		cityTableView.setOnMouseClicked(this);
	}
	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() == backButton) {
			app.mainStage.setTitle("Car Rental Window");
			app.mainStage.setScene(app.mainScene);
		}
		if(event.getSource()==newCityButton) {
			String cName = nameField.getText();
			int cityCode =i;
			createCity(cName, cityCode);
			tableSync();
			clearTextFields();
		}
		if(event.getSource()== updateCityButton) {
			String name = nameField.getText();
			int password = i;
			City selectedCity = cityTableView.getSelectionModel().getSelectedItem();
			String g= "";
			if(selectedCity != null) {
				g = selectedCity.getCityName();
			}
			updateCity(g,name,password);
			tableSync();
			clearTextFields();

		}
		if(event.getSource() == deleteCityButton){
			deleteCity(nameField.getText());
			tableSync();
			clearTextFields();
		}
		if(event.getSource() == cityTableView) {
			City selectedCity = cityTableView.getSelectionModel().getSelectedItem();
			if(selectedCity != null) {
				nameField.setText(selectedCity.getCityName());
			}
		}
	}
	private void deleteCity(String name) {
		for(int i = 0 ; i<cityList.size();i++) {
			if(cityList.get(i).getCityName().equals(name)) {
				cityList.remove(i);
				break;
			}
		}
	}
	public void updateCity(String g,String name,int password) {
		for(City d: cityList) {
			if(d instanceof City) {
				 if((d.getCityName())==g) {
				d.setCityName(name);
				
			}
		}
	}
	}
	public void clearTextFields() {
		nameField.setText("");
	}
	public void tableSync() {
		List<City> items = cityTableView.getItems();
		items.clear();
		for(City d : cityList) {
			if(d instanceof City) {
				items.add((City)d);
			}
		}
	}
	public void createCity(String cityName,int cPassword) {
		City d = new City(cityName, cPassword);
		cityList.add(d);
	}
	@Override
	Scene createScene() {
		// TODO Auto-generated method stub
		return new Scene(rootGridPane,width,height);
	}
}
	