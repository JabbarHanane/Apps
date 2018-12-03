package application;



import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.mysql.jdbc.Connection;

import application.Outils;
import application.Outils_RH;
import application.Outils_admin;
import application.connecterBD;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class Planning extends Application {
 
////**********Attribut pour relier projet a BD
	   Connection cnn=null;
  	   PreparedStatement prepared=null;    
  	   ResultSet res=null;
//Variables globales*************  	   
  	    static JFXTextField txtutilisateur=new JFXTextField();
   
 
    @Override
    public void start(Stage stage) {
   //Conteneur************
    	AnchorPane p=new AnchorPane();
        p.setPrefHeight(540);
        p.setPrefWidth(450);
        Scene scene = new Scene(p);
        
  //Arrière plan ******************      
        Image image1 = new Image("image/waw.jpg");
	       BackgroundImage bg1 =new BackgroundImage(image1, null, null, null, null );
			 Background img1 = new Background(bg1);	
			 p.setBackground(img1);
	//Panel*************************
			 Pane pi=new Pane();
			 pi.setLayoutX(44);
			 pi.setLayoutY(65);
			 pi.setPrefHeight(440); 
			 pi.setPrefWidth(350);
			
//loading CSS
  	      pi.setStyle("-fx-background-color: #fff;" + "-fx-background-radius: 50px" );
  	      Label lb=new Label();
  	      lb.setAlignment(Pos.CENTER);
  	      lb.setLayoutY(-2);
  	      lb.setMinHeight(64);
  	      lb.setMinWidth(260);
  	      lb.setPrefHeight(64);
  	      lb.setPrefWidth(350);
  	      lb.setStyle( "-fx-background-color: #008080; "+"-fx-background-radius: 50px 50px 0px 0px;"+  "-fx-text-fill: #FFFFFF; ");
  	      lb.setText("Planning");
  	      lb.setFont(new Font(25)); 

  	//link***********************
  	      Label lblink=new Label("Pour accéder à votre agenda,");
  	      lblink.setTranslateY(150);
  	    lblink.setTranslateX(25);
  	    lblink.setFont(Font.font("Arial", 18)); 
  	    Label lblink1=new Label("cliquez ici:");
	    lblink1.setTranslateY(180);
	    lblink1.setTranslateX(15);
	    lblink1.setFont(Font.font("Arial", 18)); 
  	    Hyperlink link = new Hyperlink();
		link.setText("https://calendar.google.com/calendar/render#main_7");
		link.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent t) {
                 getHostServices().showDocument(link.getText());
             }
         });
		link.setFont(Font.font("Arial", 14)); 
        link.setTranslateY(250);
        link.setTranslateX(10);
		
    //Boutton_retour**************
        JFXButton Retour=new JFXButton("Retour");
  	    Retour.setTranslateX(200);
  	    Retour.setTranslateY(350);
  	    Retour.setId("valider1");
  	    Retour.setFont(new Font(15));
        
		  	  //Activer le Button retour
		  					 Retour.setOnAction(new EventHandler<ActionEvent>() {
		  						@Override
		  						public void handle(ActionEvent arg0) {
		  							stage.close(); //je ferme mon premier stage 
		  							
		  						} });
  	    
  	   //Ajout d'elements a la fenetre****************
              pi.getChildren().add(lb);
              pi.getChildren().add(lblink);
              pi.getChildren().add(lblink1);
              pi.getChildren().add(link);
              pi.getChildren().add(Retour);
              p.getChildren().add(pi);
              
      //Reglage fenetre normal**************  
        stage.setScene(scene);
        scene.getStylesheets().add("application/application.css");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
