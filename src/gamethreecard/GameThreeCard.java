/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamethreecard;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameThreeCard extends Application {

    public static void main(String[] args) {
        
        launch(args);
        
    }

 @Override
    public void start(Stage s) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
        } catch (IOException ex) {
            System.out.println("filenon trovato");
        }
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }
    
}