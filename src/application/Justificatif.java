package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import com.mysql.jdbc.Connection;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Justificatif extends Application {
	Connection cnn=null;
	PreparedStatement prepared=null;
	ResultSet res=null;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox root=new VBox();
		root.setTranslateY(60);
		 
		 //Conteneur************
   	AnchorPane p=new AnchorPane();
       p.setPrefHeight(700);
       p.setPrefWidth(850);
       p.setTranslateY(-35);
       
       Scene scene = new Scene(p);
       
 
			 
	//Panel*************************
			 Pane pi=new Pane();
			 pi.setLayoutX(44);
			 pi.setLayoutY(65);
			 pi.setPrefHeight(600); 
			 pi.setPrefWidth(750);
			 p.getChildren().add(pi);
			 pi.getChildren().add(root);
			 
			
//loading CSS
			  	     pi.setStyle("-fx-background-color: #fff;" + "-fx-background-radius: 50px" );
			  	      Label lb=new Label();
			  	      lb.setAlignment(Pos.CENTER);
			  	      lb.setLayoutY(60);
			  	      lb.setLayoutX(45);
			  	      lb.setMinHeight(64);
			  	      lb.setMinWidth(750);
			  	      lb.setPrefHeight(64);
			  	      lb.setPrefWidth(301);
			  	      lb.setStyle( "-fx-background-color: #008080; "+"-fx-background-radius: 50px 50px 0px 0px;"+  "-fx-text-fill: #FFFFFF; ");
			  	      lb.setText("Justification");
			  	      lb.setFont(new Font(25)); 
			  	      p.getChildren().add(lb);	
		
		//root.setPadding(new Insets(20));
		GridPane gridpane1=new GridPane();
		Button valider =new Button("Valider");
		Button annuler =new Button("Annuler");
		gridpane1.setHgap(20);
        gridpane1.setVgap(10);
		GridPane gridpane2=new GridPane();
		gridpane2.setHgap(20);
        gridpane2.setVgap(10);
		GridPane gridpane3=new GridPane();
		gridpane3.setHgap(20);
        gridpane3.setVgap(10);
        
		//implementer  dans gridpane1
        Label infos =new Label("Infos :");
        infos.setTextFill(Color.BLUE);
        infos.setFont(new Font(20));
        infos.setTranslateX(10);
		 Label nom=new Label("Nom :     ");
		 Label prenom=new Label("Prénom :     ");
		 Label cin=new Label("Cin");
		 Label Emploi=new Label("Emlpoi:");
		 TextField txtnom = new TextField();
		 TextField txtprenom= new TextField();
		 TextField txtcin = new TextField();
		 TextField txtemploi= new TextField();
		 
		//Implementer dans gridpane2
		 Label période =new Label("Période :");
	     période.setFont(new Font(20));
	     période.setTextFill(Color.BLUE);
	     période.setTranslateX(10);
	     période.setTranslateY(25);
	   //Implementing Nodes for GridPane3
	        Label de=new Label("De :");
			Label au=new Label("Au :");
	          //**date debut
		        DatePicker cal= new DatePicker();
		        cal.setOnAction(e-> {LocalDate date= cal.getValue();
		        });
	         //**date fin
		        DatePicker cal2= new DatePicker();
		        cal.setOnAction(e-> {LocalDate date= cal.getValue();
		       
		        });
	       
		 //implementer dans gridpane3
		 Label fichier =new Label("Fichier :");
		 fichier.setTranslateX(10);
		 fichier.setTranslateY(50);
	     fichier.setFont(new Font(20));
	     fichier.setTextFill(Color.BLUE);
         Label dossier = new Label("Fichier :");
         TextField Textdossier = new TextField();
         Button parcourir = new Button("Parcourir");

         
       
	     //activation de boutton parcourir*****
      
         parcourir.setOnAction(new EventHandler<ActionEvent>() {
           public void handle(ActionEvent actionEvent)
             	 {  
      			    FileChooser chooser = new FileChooser();
                   File returnVal = chooser.showOpenDialog(null);
                   if (returnVal != null) {
                     Textdossier.setText( returnVal.getName());}
                        
                } });
         
         
	      //ajout au gridpane1
                        
	        	        gridpane1.add(nom, 1, 1);
	        
	        	        gridpane1.add(txtnom, 2, 1);
	        
	        	        gridpane1.add(prenom, 1, 2);
	        	        
	        	        gridpane1.add(txtprenom, 2, 2);
	        	        gridpane1.add(cin, 3, 1);
	        	        gridpane1.add(txtcin, 4, 1);
	        	        gridpane1.add(Emploi, 3, 2);
	        	        gridpane1.add(txtemploi, 4, 2);
         //ajout au gridpane2
	        	        gridpane2.setTranslateY(25);
	        	        gridpane2.add(de, 0, 1);
	        	        gridpane2.add(cal, 1, 1);
	        	        gridpane2.add(au, 2, 1);
	        	        gridpane2.add(cal2, 3, 1);
	     //ajout au gridpane3
	        	        gridpane3.setTranslateY(50);
	        	        gridpane3.add(dossier, 1, 2);
	        	        gridpane3.add(Textdossier, 2, 2);
	        	        gridpane3.add(parcourir, 3, 2);
	        	       
        //Valider/annuler
	        	        
	        	        valider.setTranslateX(500);
	        	        valider.setTranslateY(2);

	        	        annuler.setTranslateX(610);
	        	        annuler.setTranslateY(55);
	        	        valider.setTextFill(Color.WHITE);
	        	        annuler.setTextFill(Color.WHITE);
	        	        valider.setFont(new Font(18));
	        	        annuler.setFont(new Font(18));
  valider.setId("valider1");
 annuler.setId("valider1");
	        	        //info.setTranslateX()
	        	      //Creation de menu 
	    				//////Creation de Menu******************** 
	    					    MenuBar menuBar = new MenuBar();
	    					  //  menuBar.setStyle("-fx-background-color:  linear-gradient(gray,gray);");
	    					    Region spacer = new Region();
	    					    menuBar.setMaxSize(5, 5);
	    					    menuBar.setMinWidth(200);
	    					    menuBar.setMaxWidth(750);
	    				        spacer.getStyleClass().add("menu-bar");
	    				        HBox.setHgrow(spacer, Priority.SOMETIMES);
	    					    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	    				/////Menu Consulter**    
	    					    Menu MenuCons = new Menu("Consulter");
	    					    MenuItem MenuInfo = new MenuItem("info");
	    					    MenuItem MenuPla = new MenuItem("Planning");
	    					    MenuItem MenuDema = new MenuItem("Demande");
	    					    MenuItem MenuExit = new MenuItem("Exit");
	    					   MenuExit.setOnAction(actionEvent -> Platform.exit());
	    					 
	    		///Activation Menu item*************************************************
	    					   MenuInfo.setOnAction(new EventHandler<ActionEvent>() {
	    					        public void handle(ActionEvent actionEvent){
	    					        	  Stage s=new Stage();
	    					           	   info a =new info(); 
	    						          try {
	    									a.start(s);
	    								} catch (Exception e) {
	    									// TODO Auto-generated catch block
	    									e.printStackTrace();
	    								}
	    					        	
	    					        	
	    					        }});
	    		
	    					   MenuDema.setOnAction(new EventHandler<ActionEvent>() {
	    					        public void handle(ActionEvent actionEvent){
	    					        	  Stage s=new Stage();
	    					           	   demande a =new demande(); 
	    						          try {
	    									a.start(s);
	    								} catch (Exception e) {
	    									// TODO Auto-generated catch block
	    									e.printStackTrace();
	    								}
	    					        }});
	    				
	    					        
	    			          
	    	                   MenuCons.getItems().addAll(MenuInfo, MenuPla,MenuDema,new SeparatorMenuItem(), MenuExit);
	    	                   menuBar.setTranslateY(-5); 
	    	                   menuBar.getMenus().addAll(MenuCons);	
	    			       //Menu Remplir**
	    	                   Menu MenuRemplir = new Menu("Remplir");
	    					    MenuItem MenuDeman = new MenuItem("Demande");
	    					    MenuItem MenuJust = new MenuItem("Justificatifs");
	    					    MenuRemplir.getItems().addAll(MenuDeman,MenuJust);
	    	                    menuBar.getMenus().addAll(MenuRemplir);	       
	    				   //Menu voir**
	    	                    Menu Menuplus = new Menu("Voir");
	    					    MenuItem  quitt= new MenuItem("Quitter");
	    					    MenuItem plus = new MenuItem("plus");
	    					    Menuplus.getItems().addAll(quitt,new SeparatorMenuItem(),plus);
	    	                    menuBar.getMenus().addAll(Menuplus);
	    	                    quitt.setOnAction(actionEvent -> Platform.exit());
	    	                    
	    	         ////		///essai*************************************************
	    	 				   MenuDeman.setOnAction(new EventHandler<ActionEvent>() {
	    					        public void handle(ActionEvent actionEvent){
	    					        	  Stage s=new Stage();
	    					           	  demande a =new demande(); 
	    						          try {
	    									a.start(s);
	    								} catch (Exception e) {
	    									// TODO Auto-generated catch block
	    									e.printStackTrace();
	    								}
	    					        	
	    					        	
	    					        }});           
	    	                    
	    	 					
	    					   MenuJust.setOnAction(new EventHandler<ActionEvent>() {
	    					        public void handle(ActionEvent actionEvent){
	    					        	  Stage s=new Stage();
	    					           	  Justificatif a =new Justificatif(); 
	    						          try {
	    									a.start(s);
	    								} catch (Exception e) {
	    									// TODO Auto-generated catch block
	    									e.printStackTrace();
	    								}
	    					        	
	    					         }});	
	    					  
	    					 //Button annuler
			  					 annuler.setOnAction(new EventHandler<ActionEvent>() {
			  						@Override
			  						public void handle(ActionEvent arg0) {
			  							primaryStage.close(); //je ferme mon premier stage 
			  							
			  						} });	      
	    					      
	    					    //button valider*****************
			  					 valider.setOnAction(new EventHandler<ActionEvent>() {
				  						@Override
				  						public void handle(ActionEvent arg0) {
				  						   
				  			        	   if(Textdossier.getText().isEmpty()){
				  			        		   
				  			        		   Alert dialogW = new Alert(AlertType.WARNING);
				  			        		   dialogW.setTitle("A warning ");
				  			        		   dialogW.setHeaderText(null); // No header
				  			        		   dialogW.setContentText("Vous devez remplir tous les champs !");
				  			        		   dialogW.showAndWait();
				  			        		   
				  			        	   } else{
				  			        		   
				  			        		 Alert dialogC= new Alert(AlertType.CONFIRMATION);
				  			               	dialogC.setTitle("A confirmation dialog-box");
				  			               	dialogC.setHeaderText(null);
				  			               	dialogC.setContentText("Etes vous sur d'envoyer ce justificatif ?");
				  			               	Optional<ButtonType> answer= dialogC.showAndWait();
				  			        	if(answer.get() == ButtonType.OK){
				  			        	/*	File file = new File(Textdossier.getText());
				  			        		 FileInputStream stream;
											try {
												stream = new FileInputStream(file);
												 //préparation de l'instruction SQL 
												String sql8 = "INSERT INTO justi VALUES (null, ?)"; 
												try {
														prepared = cnn.prepareStatement(sql8);
														//insertion de l'image 
							  			        	     prepared.setBinaryStream(2, stream, (int)file.length()); 
							  			        	     prepared.executeUpdate();
													} catch (SQLException e) {
														// TODO Auto-generated catch block
															e.printStackTrace();
													} 
				  			        	  
				  			        	      
												
											} catch (FileNotFoundException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} 
				  			        		  
				  			        	     
				  			        		
				  			        	  */
				  			        		
				  			        		
				  			        	}
				  			        		   
				  			        	   }
				  							
				  						} });	      
		    					      
	    	
	
	        	        
	    //ajout au VBox
	    	root.getChildren().add(menuBar);
	        root.getChildren().add(infos);
	        root.getChildren().add(gridpane1);
	        root.getChildren().add(période);
	        root.getChildren().add(gridpane2);
	        root.getChildren().add(fichier);
	        root.getChildren().add(gridpane3);
	        root.getChildren().add(annuler);
	        root.getChildren().add(valider);
	        
	        
	        
	      //Style
	        gridpane1.setStyle("-fx-padding: 20;" + 
	                "-fx-border-style: solid inside;" +  
	                "-fx-border-width: 2;" +
	                "-fx-border-insets: 5;" + 
	                "-fx-border-radius: 10;" +
	                "-fx-border-color:black;");

	        gridpane2.setStyle("-fx-padding: 20;" + 
	                "-fx-border-style: solid inside;" +  
	                "-fx-border-width: 2;" +
	                "-fx-border-insets: 5;" + 
	                "-fx-border-radius: 10;" +
	                "-fx-border-color: black;");
	        gridpane3.setStyle("-fx-padding: 20;" + 
	                "-fx-border-style: solid inside;" +  
	                "-fx-border-width: 2;" +
	                "-fx-border-insets: 5;" + 
	                "-fx-border-radius: 10;" +
	                "-fx-border-color: black;");
	       
	        p.setStyle("-fx-background-color:  linear-gradient(LightGray,LightGray);");
	       
 	/////**inseration d'info de la BD
          String temp=S_Authentifier.txtutilisateur.getText().toString();
          //System.out.println(temp);
		  String sql="select login,nom,prenom,date_naiss,cin,emploi,adresse,emploi from autho ";
		  cnn=(Connection) connecterBD.connexionBD();
   //comment recuperer login et passswd
		  try {
				 prepared=cnn.prepareStatement(sql);
			     res=prepared.executeQuery();
			    while(res.next())  
			       { 
			    	
			    	if(res.getString("login").equals(temp))
			             {   
			                 txtnom.setText(res.getString("nom"));	
		                     txtprenom.setText(res.getString("prenom"));
		                     txtcin.setText(res.getString("cin"));	
		                     txtemploi.setText(res.getString("emploi"));
	             	       
		                 }
		           }
		   } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}
   		
	        
	       //fenetre principale
           // Scene scene = new Scene(root,750,600);
		  primaryStage.setTitle("Justificatif");
            primaryStage.setScene(scene);
            scene.getStylesheets().add("application/application.css");
          //primaryStage.setResizable(false);
            primaryStage.show();
	      
	        
        
	}
	public static void main(String []args)
	{
		launch(args);
	}

}
