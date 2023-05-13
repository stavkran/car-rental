package carRental.gui;
import carRental.core.Client;
import carRental.core.Store;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
public class StoreSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	 ArrayList<Store> storeList;
	 //Flow Pane
	 FlowPane buttonFlowPane;
	 GridPane rootGridPane,inputFieldsPane,inputsearchField;//Grid Panes
	 Button newStoreButton , updateStoreButton , deleteStoreButton , backButton, viewAllButton,searchButton;//Buttons
	 Label storenameLbl , cityLbl;//Labels
	 TextField cityField , storeNameField,searchField;//TextFields
	 // table view
	 TableView<Store> storeTableView;
	int i= Store.MAX_CODE;
	 
	 public StoreSceneCreator(double width, double height) {
		super(width, height);
		storeList = new ArrayList<>();
		rootGridPane=new GridPane();
		buttonFlowPane = new FlowPane();
		storenameLbl= new Label ("Name:");
		searchField = new TextField();
		searchButton= new Button("Search");
		inputsearchField = new GridPane();
		cityLbl = new Label("City:");
		cityField = new TextField();
		storeNameField = new TextField();
		newStoreButton = new Button("New Store");
		updateStoreButton = new Button("Update Store");
		deleteStoreButton = new Button("Delete Store");
		backButton = new Button("Go Back");
		inputFieldsPane = new GridPane();
	    storeTableView = new TableView<>();
	    viewAllButton = new Button ("View all");
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newStoreButton);
		buttonFlowPane.getChildren().add(updateStoreButton);
		buttonFlowPane.getChildren().add(deleteStoreButton);
		buttonFlowPane.getChildren().add(backButton);
		buttonFlowPane.getChildren().add(viewAllButton);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(storenameLbl , 0, 0);
		inputFieldsPane.add(storeNameField , 1, 0);
		inputFieldsPane.add(cityLbl , 0,1);
		inputFieldsPane.add(cityField,1,1);
		inputsearchField.add(searchField, 0, 0);
		inputsearchField.add(searchButton, 1, 0);
		
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(inputsearchField, 0 ,1);
		rootGridPane.add(storeTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backButton, 1, 2);
		
		
		TableColumn<Store,String> storeNameColumn = new TableColumn<>("Store name");
		storeNameColumn.setCellValueFactory(new PropertyValueFactory<>("storeName"));
		storeTableView.getColumns().add(storeNameColumn);
		TableColumn<Store,String> cityColumn= new TableColumn<>("City");
		cityColumn.setCellValueFactory(new PropertyValueFactory<>("storeCity"));
		storeTableView.getColumns().add(cityColumn);
		TableColumn<Store,String> codeColumn= new TableColumn<>("Code");
		codeColumn.setCellValueFactory(new PropertyValueFactory<>("storePassword"));
		storeTableView.getColumns().add(codeColumn);
		
		
		searchButton.setOnMouseClicked(this);
		backButton.setOnMouseClicked(this);
		newStoreButton.setOnMouseClicked(this);
		updateStoreButton.setOnMouseClicked(this);
		deleteStoreButton.setOnMouseClicked(this);
		storeTableView.setOnMouseClicked(this);
		viewAllButton.setOnMouseClicked(this);
	}
	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() == backButton) {
			app.mainStage.setTitle("Car Rental Window");
			app.mainStage.setScene(app.mainScene);
		}
		if(event.getSource()==newStoreButton) {
			String storeName = storeNameField.getText();
			String storeCity = cityField.getText();
			int storePassword= i;
			createStore(storeName,storeCity,storePassword);
			tableSync();
			clearTextFields();
		}
		if(event.getSource()== updateStoreButton) {
			String storeName = storeNameField.getText();
			String storeCity =  cityField.getText();
			Store selectedStore = storeTableView.getSelectionModel().getSelectedItem();
			String k= "";
			if(selectedStore != null) {
				k = selectedStore.getStoreName();
			}
	
			updateStore(k,storeName , storeCity);
			tableSync();
			clearTextFields();
		}
		if(event.getSource() == deleteStoreButton){
			deleteStore(storeNameField.getText());
			tableSync();
			clearTextFields();
		}
		if(event.getSource() == viewAllButton) {
		}
		if(event.getSource() == storeTableView) {
			Store selectedStore = storeTableView.getSelectionModel().getSelectedItem();
			if(selectedStore != null) {
				cityField.setText(selectedStore.getStoreCity());
				storeNameField.setText(selectedStore.getStoreName());
				
			}
		}
		if(event.getSource() == searchButton ) {
			String storeName = searchField.getText();
			sFind(storeName);
		}
		
		
	}
	public void deleteStore(String storeName) {
		for(int i=0; i<storeList.size();i++){
			if(storeList.get(i).getStoreName().equals(storeName)) {
				storeList.remove(i);
				break;
			}
		}
	}
	public void updateStore(String k ,String storeName, String storeCity) {
		for(Store d: storeList) {
			if(d instanceof Store) {
				 if((d.getStoreName())==k) {
				d.setStoreName(storeName);
				d.setStoreCity(storeCity);
			}
		}
	}
	}
	public void clearTextFields() {
		storeNameField.setText("");
		cityField.setText("");
	}
	public void tableSync() {
		List<Store> items = storeTableView.getItems();
		items.clear();
		for(Store d : storeList) {
			if(d instanceof Store) {
				items.add((Store) d);
			}
		}
	}
	public void sFind(String storeName) {
		List<Store> items = storeTableView.getItems();
		items.clear();
		for(Store d : storeList) {
			if(d.getStoreName().equals(storeName) ) {
				items.add((Store)d);
			}
		}
		clearSearchField();
	}
	
	public void clearSearchField() {
		searchField.setText("");
	}
	
	public void createStore(String storeName, String storeCity,int storePassword) {
		Store d = new Store(storeName,storeCity,storePassword);
		storeList.add(d);
	}
	@Override
	Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}
}