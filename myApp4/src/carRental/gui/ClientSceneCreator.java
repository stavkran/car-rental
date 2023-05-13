package carRental.gui;
import carRental.core.Client;
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

public class ClientSceneCreator  extends SceneCreator implements EventHandler<MouseEvent> {
	ArrayList<Client> clientList;
	//Flow Pane
	 FlowPane buttonFlowPane;
	GridPane rootGridPane,inputFieldsPane,inputsearchField;//Grid Panes
	Button newClientButton , updateClientButton , deleteClientButton , backButton, viewAllButton,searchButton;
	Label clientNameLbl, clientIdLbl,clientLisenceNumberLbl,clientSurnameLbl,clientEmailLbl,clientAdressLbl,clientTelephoneLbl;
 ;
	TextField   searchBoxes,clientNameField,clientIdField,clientLisenceNumberField,clientSurnameField,clientEmailField,clientAdressField,clientTelephoneField;
;
	// table view
	TableView<Client> clientTableView;
	
	
	
	
	public ClientSceneCreator(double width, double height) {
		super(width, height);
		clientList = new ArrayList<>();
		rootGridPane=new GridPane();
		buttonFlowPane = new FlowPane();
		clientNameLbl= new Label ("Name:");
		clientIdLbl= new Label("Id number");
		clientLisenceNumberLbl = new Label("Lisence Number");
		clientEmailLbl = new Label("Email");
		clientAdressLbl = new Label("Adress");
		clientTelephoneLbl = new Label("Telephone");
		clientSurnameLbl= new Label("Surname");
		clientIdField = new TextField();
		clientLisenceNumberField = new TextField();
		clientEmailField = new TextField();
		clientAdressField = new TextField();
		clientTelephoneField= new TextField();
		clientSurnameField= new TextField();
	    searchButton= new Button("Search");
	    searchBoxes= new TextField();
	    inputsearchField = new GridPane();
	    clientNameField = new TextField();
		newClientButton = new Button("New Client");
		updateClientButton = new Button("Update Client");
		deleteClientButton = new Button("Delete Client");
		backButton = new Button("Go Back");
		inputFieldsPane = new GridPane();
	    clientTableView = new TableView<>();
	    viewAllButton = new Button ("View all");
		
	    buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newClientButton);
		buttonFlowPane.getChildren().add(updateClientButton);
		buttonFlowPane.getChildren().add(deleteClientButton);
		buttonFlowPane.getChildren().add(backButton);
		buttonFlowPane.getChildren().add(viewAllButton);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(clientNameLbl , 0, 0);
		inputFieldsPane.add(clientNameField , 1, 0);
		inputFieldsPane.add(clientIdLbl,0,1);
		inputFieldsPane.add(clientIdField,1,1);
		inputFieldsPane.add(clientLisenceNumberLbl,0,2);
		inputFieldsPane.add(clientLisenceNumberField, 1, 2);
		inputFieldsPane.add(clientEmailLbl,0,3);
		inputFieldsPane.add(clientEmailField,1,3);
		inputFieldsPane.add(clientAdressLbl,0,4);
		inputFieldsPane.add(clientAdressField,1,4);
		inputFieldsPane.add(clientTelephoneLbl,0,5);
		inputFieldsPane.add(clientTelephoneField, 1,5);
		inputFieldsPane.add(clientSurnameLbl,0,6);
		inputFieldsPane.add(clientSurnameField,1,6);
		inputsearchField.add(searchBoxes, 0, 0);
		inputsearchField.add(searchButton, 1, 0);
		
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(inputsearchField, 0,1);
		rootGridPane.add(clientTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backButton, 1, 2);
		
		TableColumn<Client, String> clientNameColumn= new TableColumn<>("Client Name");
		clientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		clientTableView.getColumns().add(clientNameColumn);
		TableColumn<Client, String> clientSurnameColumn= new TableColumn<>("Client Surname");
		clientSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
		clientTableView.getColumns().add(clientSurnameColumn);	
		TableColumn<Client, String> clientIdColumn= new TableColumn<>("Client Id");
		clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		clientTableView.getColumns().add(clientIdColumn);
		TableColumn<Client, String> clientLisenceNumberColumn= new TableColumn<>("Client Lisence Number");
		clientLisenceNumberColumn.setCellValueFactory(new PropertyValueFactory<>("licenseNumber"));
		clientTableView.getColumns().add(clientLisenceNumberColumn);
		TableColumn<Client, String> clientEmailColumn= new TableColumn<>("Client Email");
		clientEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		clientTableView.getColumns().add(clientEmailColumn);
		TableColumn<Client, String> clientAdressColumn= new TableColumn<>("Client Adress");
		clientAdressColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));
		clientTableView.getColumns().add(clientAdressColumn);
		TableColumn<Client, String> clientTelephoneColumn= new TableColumn<>("Client Telephone");
		clientTelephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
		clientTableView.getColumns().add(clientTelephoneColumn);
		
		
		searchButton.setOnMouseClicked(this);
		backButton.setOnMouseClicked(this);
		newClientButton.setOnMouseClicked(this);
		updateClientButton.setOnMouseClicked(this);
		deleteClientButton.setOnMouseClicked(this);
		clientTableView.setOnMouseClicked(this);
		viewAllButton.setOnMouseClicked(this);
	}

	
	@Override
	Scene createScene() {
		return new Scene(rootGridPane, width, height);
	}
	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() == backButton) {
			app.mainStage.setTitle("Car Rental Service");
			app.mainStage.setScene(app.mainScene);
		}
		if(event.getSource() == newClientButton) {
			int o = 0,p = 0;
			for (int i = 0; i < clientList.size(); i++) {
				if(clientList.get(i).getId().equals(clientIdField.getText())) {
					o = 1;
				}
			}
			for (int i = 0; i < clientList.size(); i++) {
				if(clientList.get(i).getLicenseNumber().equals(clientLisenceNumberField.getText())) {
					p = 1;
				}
			}
			if(o == 0 && p == 0) {
			if(!(clientIdField.getText().isBlank())) {
				String clientID = clientIdField.getText();
				String clientDrivingL = clientLisenceNumberField.getText();
				String clientName = clientNameField.getText();
				String clientSurname=clientSurnameField.getText();
				String clientEmail = clientEmailField.getText();
				String clientAddress = 	clientAdressField.getText();
				String clientPhoneN = clientTelephoneField.getText();
				createClient(clientID, clientDrivingL, clientName,clientSurname, clientEmail, clientAddress, clientPhoneN);
				tableSync();
				clearTextFields();
			}
			}
		}
		if(event.getSource() == updateClientButton) {
			
			String clientID = clientIdField.getText();
			String clientDrivingL = clientLisenceNumberField.getText();
			String clientName = clientNameField.getText();
			String clientSurname=clientSurnameField.getText();
			String clientEmail = clientEmailField.getText();
			String clientAddress = 	clientAdressField.getText();
			String clientPhoneN = clientTelephoneField.getText();
				String k = "";
				Client selectedcId = clientTableView.getSelectionModel().getSelectedItem();
				if(selectedcId != null) {
					k = selectedcId.getId();
				}
				updateClient(k,clientID, clientDrivingL, clientName,clientSurname, clientEmail, clientAddress, clientPhoneN);
				tableSync();
				clearTextFields();
			
		}
		if(event.getSource() == deleteClientButton) {
			deleteClient(clientIdField.getText());
			tableSync();
			clearTextFields();
		}
		if(event.getSource() == clientTableView) {
			Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
			if(selectedClient != null) {
				clientIdField.setText(selectedClient.getId());
				clientLisenceNumberField.setText(selectedClient.getLicenseNumber());
				clientNameField.setText(selectedClient.getName());
				clientSurnameField.setText(selectedClient.getSurname());
				clientEmailField.setText(selectedClient.getEmail());
				clientAdressField.setText(selectedClient.getAdress());
				clientTelephoneField.setText(selectedClient.getTelephone());
			}
		}
		if(event.getSource() == searchButton ) {
			String clientId = searchBoxes.getText();
			sFind(clientId);
		}
	}
	public void createClient(String clientID, String clientDrivingL, String clientName,String clientSurname, String clientEmail,
			String clientAddress, String clientPhoneN) {
		Client d = new Client(clientID, clientDrivingL, clientName,clientSurname, clientEmail, clientAddress, clientPhoneN);
		clientList.add(d);
	}
	public void updateClient(String k,String clientID, String clientDrivingL, String clientName,String clientSurname, String clientEmail,
			String clientAddress, String clientPhoneN) {
		for(Client d : clientList) {
			if(d instanceof Client) {
				if((d.getId())==k) {
					d.setSurname(clientSurname);
					d.setName(clientName);
					d.setEmail(clientEmail);
					d.setAdress(clientAddress);
					d.setTelephone(clientPhoneN);
				}
			}
		}
	}
	public void deleteClient(String clientID) {
		for (int i = 0; i < clientList.size(); i++) {
			if(clientList.get(i).getId().equals(clientID)) {
				clientList.remove(i);
				break;
			}
		}
	}
	public void tableSync() {
		List<Client> items = clientTableView.getItems();
		items.clear();
		for(Client d : clientList) {
			if(d instanceof Client) {
				items.add((Client) d);
			}
		}
	}
	public void sFind(String clientId) {
		List<Client> items = clientTableView.getItems();
		items.clear();
		for(Client d : clientList) {
			if(d.getId().equals(clientId) ) {
				items.add((Client)d);
			}
		}
		clearSearchField();
	}
	public void clearTextFields(){
		clientIdField.setText("");
		clientLisenceNumberField.setText("");
		clientNameField.setText("");
		clientSurnameField.setText("");
		clientEmailField.setText("");
		clientAdressField.setText("");
		clientTelephoneField.setText("");
	}
	public void clearSearchField() {
		searchBoxes.setText("");
	}
 }
	
	
	
	
	
	
	