import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestMultipleStage extends Application {
	Pane mainPane, pane0, pane1, pane2, pane3;
	Label lb1, lb2, lb3;
	Button bt1, bt2, bt3;
	Stage stage, stage1, stage2, stage3;

	Pane getPane() {
		pane0 = new FlowPane(10, 10);
		bt1 = new Button();
		bt1.setText("Button 1");
		bt1.setOnAction((e) -> {
			lb1 = new Label();
			lb1.setText("HELLO");
			pane1 = new StackPane();
			pane1.getChildren().add(lb1);
			Scene scene1 = new Scene(pane1, 200, 100);
			stage1 = new Stage();
			stage1.setScene(scene1);
			stage1.show();
		});
		bt2 = new Button();
		bt2.setText("Button 2");
		bt2.setOnAction(e -> {
			lb2 = new Label();
			lb2.setText("COOL!!!");
			pane2 = new StackPane();
			pane2.getChildren().add(lb2);
			Scene scene2 = new Scene(pane2, 200, 100);
			stage2 = new Stage();
			stage2.setScene(scene2);
			stage2.show();
		});
		bt3 = new Button();
		bt3.setText("Button 3");
		bt3.setOnAction(e -> {
			lb3 = new Label();
			lb3.setText("FANTASTIC");
			pane3 = new StackPane();
			pane3.getChildren().add(lb3);
			Scene scene3 = new Scene(pane3, 200, 100);
			stage3 = new Stage();
			stage3.setScene(scene3);
			stage3.show();
		});

		pane0.getChildren().addAll(bt1, bt2, bt3);
		mainPane = new StackPane();
		mainPane.getChildren().add(pane0);
		return mainPane;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(getPane(), 300, 150);
		primaryStage.setScene(scene);

		Pane firstPane = new StackPane();
		Pane secondPane = new StackPane();
		Button btOK = new Button();
		Button btClick = new Button();
		btOK.setText("OK");
		btClick.setText("Click");
		firstPane.getChildren().add(btOK);
		secondPane.getChildren().add(btClick);
		Stage firstStage = new Stage();
		Scene firstScene = new Scene(firstPane, 200, 100);
		Scene secondScene = new Scene(secondPane, 200, 100);
		firstStage.setScene(firstScene);
		//Change Scene of firstStage
		btOK.setOnAction(e -> {
			firstStage.setScene(secondScene);
		});
		btClick.setOnAction(e -> {
			firstStage.close();
			primaryStage.show();
		});
		firstStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
