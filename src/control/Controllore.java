/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controllore implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }
    
    private Random estrattore = new Random();
    
    private int cartaVincente;
    
    private int totale = 1;
    private int vinte = 0;   
    
    @FXML private Label TotPartite;
    @FXML private Label TotVittorie;
    @FXML private Label PercentVittorie;
    @FXML private Label Info;
    
    @FXML private Button Carta1;
    @FXML private Button Carta2;
    @FXML private Button Carta3;
    
    @FXML
    
    
    private void nuovaPartita (ActionEvent ae) {
        
        
        totale ++;
        cartaVincente = estrattore.nextInt(3);
        Info.setText("");
        this.setStatistiche();
        
        
        Carta1.setDisable(false);
        Carta2.setDisable(false);
        Carta3.setDisable(false);
        
        Carta1.setText("Carta ");
        Carta2.setText("Carta ");
        Carta3.setText("Carta ");
        
        Carta1.setStyle("-fx-base: #E6E6E6;");
        Carta2.setStyle("-fx-base: #E6E6E6;");
        Carta3.setStyle("-fx-base: #E6E6E6;");
    }   
        
    @FXML
    private void premi_0 () { 
        this.setButton(0);
    }
    
   @FXML
    private void premi_1 () { 
        this.setButton(1);
    }
    
     @FXML
    private void premi_2 () { 
        this.setButton(2);
    }
     @FXML
    private void setStatistiche () {
        
        
        TotPartite.setText(String.valueOf(this.totale));
        TotVittorie.setText(String.valueOf(this.vinte));
        if (this.totale != 0){
            PercentVittorie.setText(String.valueOf(this.vinte*100/this.totale));
        }
        else {
            PercentVittorie.setText(String.valueOf(this.vinte*100));
        }
    }
    
    private void setButton (int b) {
        Carta1.setDisable(true);
        Carta2.setDisable(true);
        Carta3.setDisable(true);
        
        switch (b) {
            case 0:  
                Carta2.setStyle("-fx-base: #669999;");
                Carta3.setStyle("-fx-base: #669999;");
                if (this.cartaVincente == 0) {
                    Info.setText("HAI VINTO!");
                    vinte ++;
                    Carta1.setStyle("-fx-base: #00FF00;");
                }
                else {
                    Info.setText("HAI PERSO!");
                    Carta1.setStyle("-fx-base: #FF0000;");
                }
                break;
            case 1:
                Carta1.setStyle("-fx-base: #669999;");
                Carta3.setStyle("-fx-base: #669999;");
                if (this.cartaVincente == 1) {
                    Info.setText("HAI VINTO!");
                    vinte ++;
                    Carta2.setStyle("-fx-base: #00FF00;");
                }
                else {
                    Info.setText("HAI PERSO!"); 
                    Carta2.setStyle("-fx-base: #FF0000;");
                }
                break;                
            case 2:
                Carta1.setStyle("-fx-base: #669999;");
                Carta2.setStyle("-fx-base: #669999;");
                if (this.cartaVincente == 2) {
                    Info.setText("HAI VINTO!");
                    vinte ++;
                    Carta3.setStyle("-fx-base: #00FF00;");
                }
                else {
                    Info.setText("HAI PERSO!");
                    Carta3.setStyle("-fx-base: #FF0000;");
                }
                break;                
        }
        
        switch (this.cartaVincente) {
            case 0:
                Carta1.setText("Asso");
                Carta2.setText("Re");
                Carta3.setText("Cavallo");
                break;
            case 1:
                Carta1.setText("Re");
                Carta2.setText("Asso");                
                Carta3.setText("Cavallo");
                break;
            case 2:
               Carta1.setText("Cavallo");
               Carta2.setText("Re");
               Carta3.setText("Asso");
                break;
        }
        
        this.setStatistiche();
    }
    
}