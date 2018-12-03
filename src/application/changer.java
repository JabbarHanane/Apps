package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.mysql.jdbc.Connection;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class changer extends Application{
 /////***variable de connexion
	   Connection cnn=null;
	   PreparedStatement prepared=null;    
	   ResultSet res=null;
	/////****textField	 
			static TextField nom=new TextField();
			static TextField prenom=new TextField();
			static TextField DateNaissance=new TextField();
			static TextField cin=new TextField();
			static TextField emploi=new TextField();
			static TextField adresse=new TextField();
			static TextField Code_pos=new TextField();
			static TextField ville=new TextField();
			static TextField email=new TextField();
			static TextField tel=new TextField();
			static TextField Date_emb=new TextField();
			static TextField grade=new TextField();
			static TextField employeur=new TextField();
			static TextField type=new TextField();
			
	   static  TextField txtUti=new TextField();
	    static  TextField txtmdp=new TextField();
	   
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		cnn=(Connection) connecterBD.connexionBD();
		 GridPane root = new GridPane();
		 root.setTranslateY(60);
		 //Conteneur************
	    	AnchorPane p=new AnchorPane();
	        p.setPrefHeight(600);
	        p.setPrefWidth(850);
	        p.setTranslateY(-35);
	        
	        Scene scene = new Scene(p);
	        
	  //Arriére plan ******************      
	        Image image1 = new Image("image/waw.jpg");
		       BackgroundImage bg1 =new BackgroundImage(image1, null, null, null, null );
				 Background img1 = new Background(bg1);	
				 p.setBackground(img1);
				 
		//Panel*************************
				 Pane pi=new Pane();
				 pi.setLayoutX(44);
				 pi.setLayoutY(65);
				 pi.setPrefHeight(500); 
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
				  	      lb.setText("Modifier Utilisateur");
				  	      lb.setFont(new Font(25)); 
				  	      p.getChildren().add(lb);	
			  // BACKGROUND entete**************
				/*	Label lblTitle= new Label("     Point_Tech   ");
					  lblTitle.setTextFill(Color.WHITE);
	             vbox.setAlignment(Pos.TOP_CENTER);
	             vbox.setId("entete");
			     /*  Image image1 = new Image("image/arr.jpg");
		 	       BackgroundImage bg1 =new BackgroundImage( image1, null, null, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT );
					 Background img1 = new Background(bg1);	
					
					 lblTitle.setBackground(img1);
					
					 lblTitle.setFont(new Font(60));
					
					 BorderPane.setAlignment(lblTitle, Pos.CENTER);
					 lblTitle.setTranslateX(0);
					 lblTitle.setTranslateY(0);
					vbox.getChildren().add(lblTitle);
					
					
					 root1.setTop(vbox);*/
	
//Creation de menu 
				//////Creation de Menu******************** 
				/*	    MenuBar menuBar = new MenuBar();
					    Region spacer = new Region();
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
	                   menuBar.setTranslateY(0); 
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
					       			
	   vbox.getChildren().add(menuBar);*/
///essai de creer un panel et mettre une bordure
		 //Bordure****************
 	 ////   Border border1 = new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY,new BorderWidths(6), new Insets(1) ));
 	    //		  root.setBorder(border1);
        
        
      
        // background du GridPane
		/* Image image = new Image("image/waw.jpg");
         BackgroundImage bg =new BackgroundImage( image, null, null, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT );
		 Background img = new Background(bg);
		 root.setBackground(img);*/
	  // root.setId("root1");
		 
	//*** boutton imprimante
		 Button retour=new Button("Annuler");
		 Button save=new Button("Enregistrer");
		/* Button impri=new Button("");
		  impri.setGraphic(new ImageView("image/impri3.jpg"));
		  impri.setContentDisplay(ContentDisplay.TOP);
		  impri.setTranslateX(600);
		  impri.setTranslateY(100);
		  root.getChildren().add(impri);*/
		 
	////***LABELS
		 Label Uti=new Label("Utilsateur");
	     Label mdp=new Label("Password");
		 Label lb0=new Label("Etat Civil      ");
		 Label lb1=new Label("NOM             ");
		 Label lb2=new Label("PRENOM          ");
		 Label lb3=new Label("Date de naissance ");
		 Label lb4=new Label("CIN            ");
		 Label lb5=new Label("EMPLOI             ");
		 Label lb6=new Label("Cordonnées     ");
		 Label lb7=new Label("Adresse            ");
		 Label lb8=new Label("Ville        ");
		 Label lb9=new Label("Code Postal  ");
		 Label lb10=new Label("Email           ");
		 Label lb11=new Label("Tél             ");
		 Label lb12=new Label("Fonction             ");
		 Label lb13=new Label("Fonction             ");
		 Label lb14=new Label("Service             ");
		 Label lb15=new Label("Date d'embauche           ");
		 Label lb16=new Label("Grade             ");
		 Label lb17=new Label("Employeur             ");
		 Label lb18=new Label("Type          ");
		 
   
		ComboBox<String> service= new ComboBox<String>();
		service.getItems().addAll("Comptabilité finance","Direction","Accueil");
		service.setOnAction(event -> {
		
		});
		ComboBox<String> fonction= new ComboBox<String>();
		fonction.getItems().addAll("technique", "Chef", "Ingénieur");
		
		fonction.setVisibleRowCount(5); // Max 5 éléments visibles
		fonction.setOnAction(event -> {
		
		});



 
		
/////**inseration d'info de la BD
		//Activer Boutton enregistrer
	    save.setOnAction(new EventHandler<ActionEvent>() {
           public void handle(ActionEvent actionEvent)
           	 {   
        	   if(nom.getText().isEmpty() || prenom.getText().isEmpty() || DateNaissance.getText().isEmpty() || cin.getText().isEmpty() || emploi.getText().isEmpty() || adresse.getText().isEmpty() 
        			   || Code_pos.getText().isEmpty() || ville.getText().isEmpty() || email.getText().isEmpty() || tel.getText().isEmpty() || Date_emb.getText().isEmpty() || grade.getText().isEmpty() 
        			   || employeur.getText().isEmpty() || type.getText().isEmpty() ){
        		   
        		   
        		   Alert dialogW = new Alert(AlertType.WARNING);
        		   dialogW.setTitle("A warning ");
        		   dialogW.setHeaderText(null); // No header
        		   dialogW.setContentText("Vous devez remplir tous les champs !");
        		   dialogW.showAndWait();
        		   
        		   
        	   }else{
        		Alert dialogC= new Alert(AlertType.CONFIRMATION);
               	dialogC.setTitle("A confirmation dialog-box");
               	dialogC.setHeaderText(null);
               	dialogC.setContentText("Etes vous sur enregistrer les modifications ?");
               	Optional<ButtonType> answer= dialogC.showAndWait();
        	if(answer.get() == ButtonType.OK){
               		
           primaryStage.close();
 			   			cnn= (Connection) connecterBD.connexionBD();
 			   			String sql="update autho set login=? , passwd=? , nom=? ,prenom=? ,date_naiss=? ,cin=? ,emploi=? ,type=?,adresse=? ,ville=?,code_postal=? , email=?, tel=? , date_emb=? , grade=? where login=?";
 			   			
 			   			try {
 			   			int a=Integer.parseInt(Code_pos.getText().toString());
 							prepared=cnn.prepareStatement(sql);
 							prepared.setString(1, txtUti.getText().toString());
 							prepared.setString(2, txtmdp.getText().toString());
 							prepared.setString(3, nom.getText().toString());
 							prepared.setString(4, prenom.getText().toString());
 							prepared.setString(5, DateNaissance.getText().toString());
 							prepared.setString(6, cin.getText().toString());
 							prepared.setString(7, emploi.getText().toString());
 							
 							prepared.setString(8,type.getText().toString());
 							
 							prepared.setString(9,adresse.getText().toString());
 							prepared.setString(10,ville.getText().toString());
 							prepared.setInt(11, a);
 							prepared.setString(12,email.getText().toString());
 							prepared.setString(13,tel.getText().toString());
 							prepared.setString(14,Date_emb.getText().toString());
 							prepared.setString(15,grade.getText().toString());
 							prepared.setString(16, ModifierU.txtUti.getText().toString());
 							prepared.execute();
 							  
 						} catch (SQLException e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 						}
 			   			  }
 			   			//vider les deux premier champs
 			        	     ModifierU.txtUti.setText("");
 			        	     ModifierU.txtmdp.setText("");
        	}        	 }});
	       
	   		
/////****positionement
    		   /////position de label_nom
	    
	          txtUti.setTranslateX(200);                 
	          txtUti.setTranslateY(5);
	          txtmdp.setTranslateX(500);                 
		       txtmdp.setTranslateY(5);
		       Uti.setTranslateX(100);                 
		          Uti.setTranslateY(5);
		          mdp.setTranslateX(400);                 
			       mdp.setTranslateY(5);
			       Uti.setFont(new Font(20));
			       mdp.setFont(new Font(20));
			       root.getChildren().add(txtUti);
			       root.getChildren().add(txtmdp);
			       root.getChildren().add(Uti);
			       root.getChildren().add(mdp);
    		    lb0.setTranslateX(40);                 lb6.setTranslateX(400);
		       lb0.setTranslateY(40);                  lb6.setTranslateY(40);
		       lb0.setTextFill(Color.BLUE);            lb6.setTextFill(Color.BLUE);
		       lb0.setFont(new Font(25));              lb6.setFont(new Font(25));
		       root.getChildren().add(lb0);             root.getChildren().add(lb6);
    		   lb1.setTranslateX(30);       		   lb7.setTranslateX(370);
		       lb1.setTranslateY(70);				   lb7.setTranslateY(70);
		       root.getChildren().add(lb1);			 root.getChildren().add(lb7);
		       /////position de txtfield_nom
			   nom.setTranslateX(140);				adresse.setTranslateX(450);
		       nom.setTranslateY(70);			    adresse.setTranslateY(70);
		       root.getChildren().add(nom);		      root.getChildren().add(adresse);
		 //fonction***********
		       lb12.setTranslateX(40);                
		       lb12.setTranslateY(240);                 
		       lb12.setTextFill(Color.BLUE);           
		       lb12.setFont(new Font(25)); 
		       root.getChildren().add(lb12);
		       lb13.setTranslateX(30);				 
		       lb13.setTranslateY(260);				 
		       root.getChildren().add(lb13); 
		       fonction.setTranslateX(140);				 
		       fonction.setTranslateY(260);				 
		       root.getChildren().add(fonction); 
		  //service***********
		       lb14.setTranslateX(30);				 
		       lb14.setTranslateY(290);				 
		       root.getChildren().add(lb14); 
		       service.setTranslateX(140);				 
		       service.setTranslateY(290);				 
		       root.getChildren().add(service); 
		  // date_embauche******
		       lb15.setTranslateX(30);				 
		       lb15.setTranslateY(320);				 
		       root.getChildren().add(lb15); 
		       Date_emb.setTranslateX(140);				 
		       Date_emb.setTranslateY(320);				 
		       root.getChildren().add(Date_emb);
		   // grade******
		       lb16.setTranslateX(30);				 
		       lb16.setTranslateY(350);				 
		       root.getChildren().add(lb16); 
		       grade.setTranslateX(140);				 
		       grade.setTranslateY(350);				 
		       root.getChildren().add(grade); 
		       
		       //position de label_prenom
		      
		        lb2.setTranslateX(30);				 lb8.setTranslateX(370);
		        lb2.setTranslateY(100);				 lb8.setTranslateY(100);
		        root.getChildren().add(lb2);		  root.getChildren().add(lb8);
		  
		         
		        
		        
		       //position de txtfield_prenom
		        prenom.setTranslateX(140);       ville.setTranslateX(450);
		        prenom.setTranslateY(100);		  ville.setTranslateY(100);
		        //prenom.setFont(new Font(25));
		        root.getChildren().add(prenom);		root.getChildren().add(ville);
		       
		      //position de label_datenaissance
		      //lb2.setTextFill(Color.BLACK);
		        lb3.setTranslateX(30);			lb9.setTranslateX(370);		
		        lb3.setTranslateY(130);			  lb9.setTranslateY(130);
		         root.getChildren().add(lb3);		root.getChildren().add(lb9);
		        
		        
		       //position de date
		        DateNaissance.setTranslateX(140);		Code_pos.setTranslateX(450);
		        DateNaissance.setTranslateY(130);		  Code_pos.setTranslateY(130);
		        //prenom.setFont(new Font(25));
		        root.getChildren().add(DateNaissance);		root.getChildren().add(Code_pos);
		     
		       //position de label_adresse
		        //lb2.setTextFill(Color.BLACK);
		        lb4.setTranslateX(30);				lb10.setTranslateX(370);
		        lb4.setTranslateY(160);				 lb10.setTranslateY(160);
		         root.getChildren().add(lb4);		root.getChildren().add(lb10);
		        
		        
		       //position de adresse
		       cin.setTranslateX(140);			 email.setTranslateX(450);
		         cin.setTranslateY(160);		 email.setTranslateY(160);
		        //prenom.setFont(new Font(25));
		        root.getChildren().add(cin);		root.getChildren().add(email);

		        //position de emploi
		        //lb2.setTextFill(Color.BLACK);
		        lb5.setTranslateX(30);			 lb11.setTranslateX(370);
		        lb5.setTranslateY(190);			 lb11.setTranslateY(190);
		         root.getChildren().add(lb5);		root.getChildren().add(lb11);
		        
		        
		       //position de emploi
		        emploi.setTranslateX(140);			 tel.setTranslateX(450);
		        emploi.setTranslateY(190);			 tel.setTranslateY(190);
		        //prenom.setFont(new Font(25));
		        root.getChildren().add(emploi);			root.getChildren().add(tel);
		     ///table view
		     /*  TableView table = new TableView();
		        table.setEditable(true);

		        TableColumn firstNameCol = new TableColumn("TYPE/Employeur");
		        TableColumn lastNameCol = new TableColumn("Début Embauche");
		        TableColumn serviceCol = new TableColumn("Service");
		                
		        table.getColumns().addAll(firstNameCol, lastNameCol,serviceCol);
		        root.getChildren().add(table);
		         table.setTranslateX(370);
		         table.setTranslateY(550);*/
		     //champ4*****************
		        lb17.setTranslateX(370);				 
			       lb17.setTranslateY(260);				 
			       root.getChildren().add(lb17);
			       lb18.setTranslateX(370);				 
			       lb18.setTranslateY(290);				 
			       root.getChildren().add(lb18);
			       employeur.setTranslateX(450);				 
			       employeur.setTranslateY(260);				 
			       root.getChildren().add(employeur);
			       type.setTranslateX(450);				 
			       type.setTranslateY(290);				 
			       root.getChildren().add(type);
			       //position de retour et save
			        retour.setTranslateX(580);
			        retour.setTranslateY(380);
			        save.setTranslateX(450);
			        save.setTranslateY(380);
			        root.getChildren().add(retour);
			        root.getChildren().add(save);
			        retour.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 20));
	  		        retour.setTextFill(Color.WHITE);
	  		        save.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 20));
	  		        save.setTextFill(Color.WHITE);
	  		        retour.setId("Retour");
	  		        save.setId("Retour");
			        
		  	  //Button retour
		  					 retour.setOnAction(new EventHandler<ActionEvent>() {
		  						@Override
		  						public void handle(ActionEvent arg0) {
		  							primaryStage.close(); //je ferme mon premier stage 
		  							
		  						} });
		   
		       
/////Fenetre Principale		
		
		  scene.getStylesheets().add("application/application.css");
		  primaryStage.setTitle("Modifier");
        primaryStage.setTitle("Informations Personnelles"); 
        primaryStage.setScene(scene);
        primaryStage.show();
		
	
	
	
	    }
	
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
         launch(args);
	}
}
