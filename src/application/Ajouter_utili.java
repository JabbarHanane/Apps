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

public class Ajouter_utili extends Application{
 /////***variable de connexion
	   Connection cnn=null;
	   PreparedStatement prepared=null;    
	   ResultSet res=null;
	   
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		cnn=(Connection) connecterBD.connexionBD();
		 GridPane root = new GridPane();
		// BorderPane root1 =new BorderPane();
		 root.setTranslateY(50);
		 
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
				  	      lb.setText("Ajouter Utilisateur");
				  	      lb.setFont(new Font(25)); 
				  	      p.getChildren().add(lb);	
		
		 
	//*** boutton imprimante
		 Button retour=new Button("Annuler");
		 Button save=new Button("Enregistrer");
		
		 
	////***LABELS
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
		 
   /////****textField	 
		TextField nom=new TextField();
		TextField prenom=new TextField();
		TextField DateNaissance=new TextField();
		TextField cin=new TextField();
		TextField emploi=new TextField();
		TextField adresse=new TextField();
		TextField Code_pos=new TextField();
		TextField ville=new TextField();
		TextField email=new TextField();
		TextField tel=new TextField();
		TextField Date_emb=new TextField();
		TextField grade=new TextField();
		TextField employeur=new TextField();
		TextField type=new TextField();
		
		ComboBox<String> service= new ComboBox<String>();
		service.getItems().addAll("Comptabilité finance","Direction","Accueil");
		service.setOnAction(event -> {
		
		});
		ComboBox<String> fonction= new ComboBox<String>();
		fonction.getItems().addAll("technique", "Chef", "Ingénieur");
		
		fonction.setVisibleRowCount(5); // Max 5 éléments visibles
		fonction.setOnAction(event -> {
		
		});


		/*&& prenom.getText().isEmpty() && DateNaissance.getText().isEmpty() && cin.getText().isEmpty() && emploi.getText().isEmpty() && adresse.getText().isEmpty() 
		   && Code_pos.getText().isEmpty() && ville.getText().isEmpty() && email.getText().isEmpty() && tel.getText().isEmpty() && Date_emb.getText().isEmpty() && grade.getText().isEmpty() 
		   && employeur.getText().isEmpty() && type.getText().isEmpty()*/
 
		
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
               	dialogC.setContentText("Etes vous sur d'ajouter ce nouveau employé ?");
               	Optional<ButtonType> answer= dialogC.showAndWait();
        	if(answer.get() == ButtonType.OK){
               		
            // Enregister les données dans la BD************************
        	     cnn= (Connection) connecterBD.connexionBD();
        	  
        	     String sql="insert into autho values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        	     try {
        	    	
        	    	int a=Integer.parseInt(Code_pos.getText().toString());
					prepared=cnn.prepareStatement(sql);
					prepared.setString(1,ModifierU.txtUti.getText().toString());
					prepared.setString(2,ModifierU.txtmdp.getText().toString());
					prepared.setString(3,nom.getText().toString());
					prepared.setString(4,prenom.getText().toString());
					prepared.setString(5,DateNaissance.getText().toString());
					prepared.setString(6,cin.getText().toString());
					prepared.setString(7,emploi.getText().toString());
					prepared.setString(8,type.getText().toString());
					
					prepared.setString(9,adresse.getText().toString());
					prepared.setString(10,ville.getText().toString());
					prepared.setInt(11, a);
					prepared.setString(12,email.getText().toString());
					prepared.setString(13,tel.getText().toString());
					prepared.setString(14,Date_emb.getText().toString());
					prepared.setString(15,grade.getText().toString());
	                  
                    prepared.execute();
           
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	 
        	 
        	 //id   
        	     String H="a";
				String sql1="select id from autho where login=?";
        	     try {
					prepared=cnn.prepareStatement(sql1);
					prepared.setString(1,ModifierU.txtUti.getText().toString());
				    res=prepared.executeQuery();
				    while(res.next())
				    { H=res.getString("id");
				     // System.out.println(H);
				    }
        	   } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
       
               //table pointage************************
        	     String sql2="insert into pointage values (?,sysdate(),sysdate())";
        	     try {
					prepared=cnn.prepareStatement(sql2);
					prepared.setString(1,H);
					prepared.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               		}
        	   }
        	   primaryStage.close();
        	      //vider les deux premier champs
        	     ModifierU.txtUti.setText("");
        	     ModifierU.txtmdp.setText("");
           	 }});
	       
	   		
/////****positionement
    		   /////position de label_nom
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
		  primaryStage.setTitle("Ajouter");
        primaryStage.setTitle("Informations Personnelles"); 
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	
	
	
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
         launch(args);
	}
}
