package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout , 800, 500);

        GridPane grid = new GridPane();
        Scene helloScene = new Scene(grid,800,500);

        primaryStage.setTitle("JavaFX Illustration Application");
        primaryStage.setScene(scene);
        primaryStage.show();

        // JavaFX Menus
        Menu fileMenu = new Menu("_File");
        fileMenu.getItems().add(new MenuItem("New Project..."));
        fileMenu.getItems().add(new MenuItem("New Module..."));
        fileMenu.getItems().add(new MenuItem("Import Project..."));

        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy..."));
        editMenu.getItems().add(new MenuItem("Paste..."));

        Menu runMenu = new Menu("Run");
        runMenu.getItems().add(new MenuItem("Run"));
        runMenu.getItems().add(new MenuItem("Debug"));

            Menu debug = new Menu("Debug using");
            debug.getItems().add(new MenuItem(" Using Default Debugger"));
            debug.getItems().add(new MenuItem("Config. Debugger"));
            runMenu.getItems().add(debug);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,runMenu);

        // Menus end..


        //JavaFX controls

        Button randBtn  = new Button("Random");
        Button switchBtn = new Button("Switch Scene");
        Button exitBtn = new Button("Exit");
        TextField txt = new TextField();
        Label txtLabel = new Label("Some random Integer");
        txt.setMaxWidth(50.0);


        // set random button
        randBtn.setOnAction(actionEvent -> {
            Random rand = new Random();
            int num = rand.nextInt(1000);
            txt.setText(Integer.toString(num));
        });

        //set switch scene button and helloScene
        switchBtn.setOnAction(actionEvent -> {
            primaryStage.setScene(helloScene);
            Button helloBtn = new Button("print HelloFx at random pos");
            grid.add(helloBtn,1,1);
            grid.add(exitBtn,1,2);
            grid.setPadding(new Insets(10));
            grid.setVgap(8);

            helloBtn.setOnAction(e -> {
                int i,j;
                Random random2 = new Random();
                i=random2.nextInt(10);
                j=random2.nextInt(10);
                Label helloLable = new Label("HelloFX");
                grid.add(helloLable,i,j);
            });

            primaryStage.show();
        });

        //set exit button
        exitBtn.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        // controls end..

        // First scene toggling...
        layout.setTop(menuBar);

        VBox leftSide = new VBox();
        leftSide.setPadding(new Insets(10));
        layout.setLeft(leftSide);
        leftSide.getChildren().add(randBtn);
        VBox.setMargin(randBtn, new Insets(10, 10, 0, 0));
        leftSide.getChildren().add(switchBtn);
        VBox.setMargin(switchBtn,new Insets(10,10,0,0));

        FlowPane flow = new FlowPane();
        layout.setCenter(flow);
        flow.setHgap(4);
        flow.setAlignment(Pos.CENTER);
        flow.getChildren().add(txtLabel);
        flow.getChildren().add(txt);

        // first scene end....

    }


    public static void main(String[] args) {
        launch(args);
    }
}
