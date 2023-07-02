package com.example.demo1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class demo1 extends Application
{
    public static void main(String[] args){
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menubar = createmenu();
        rootNode.getChildren().add(0,menubar);

        Scene scene = new Scene(rootNode);

        stage.setScene(scene);
        stage.setTitle("Temperature converter tool");
        stage.setResizable(true);
        stage.show();
    }
    private MenuBar createmenu() {

        Menu menufile =new Menu("file");
        MenuItem item1=new MenuItem("new");
        item1.setOnAction(actionEvent -> System.out.println("new is clicked"));
        SeparatorMenuItem item0=new SeparatorMenuItem();

        MenuItem item2=new MenuItem("quit");
        item2.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        menufile.getItems().addAll(item1,item0,item2);

        Menu menuhelp=new Menu("help");
        MenuItem item3=new MenuItem("about");
        item3.setOnAction(actionEvent -> getabout());
        menuhelp.getItems().addAll(item3);

        MenuBar menubar=new MenuBar();
        menubar.getMenus().addAll(menufile,menuhelp);
        return menubar;
    }

    private void getabout() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About this app");
        alert.setHeaderText("Content");
        alert.setContentText("This is app based on tha java language using gui to help in converting temperature from celsius to fahrenheit and fahrenheit to celsius");
        ButtonType yes=new ButtonType("Ok");
        alert.getButtonTypes().setAll(yes);
        Optional<ButtonType> clickedbutten = alert.showAndWait();

        if(clickedbutten.isPresent()&&clickedbutten.get()==yes)
        {
            System.out.println("Ok");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}