package carRental.gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class app extends Application  {
	static Stage mainStage;
	static Scene cityScene,mainScene,storeScene,clientScene,vehicleScene,vehicalRentScene;
	
	
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage)  {
		mainStage = primaryStage;
		SceneCreator mainSceneCreator= new MainSceneCreator(650,400);
		mainScene = mainSceneCreator.createScene();
		SceneCreator citySceneCreator = new CitySceneCreator(650,400);
		cityScene= citySceneCreator.createScene();
		SceneCreator storeSceneCreator = new StoreSceneCreator(650,400);
		storeScene = storeSceneCreator.createScene();
		SceneCreator vehicleSceneCreator = new VehicleSceneCreator(1000,500);
		vehicleScene =  vehicleSceneCreator.createScene();
		SceneCreator clientSceneCreator = new ClientSceneCreator(900,500);
		clientScene =  clientSceneCreator.createScene();
		SceneCreator rentalSceneCreator = new RentalVehicleSceneCreator(1000,500);
		vehicalRentScene =  rentalSceneCreator.createScene();
		
		primaryStage.setTitle("Car Rental Service");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}
	public static void main  (String[] args) {
		 launch(args);
		}
}