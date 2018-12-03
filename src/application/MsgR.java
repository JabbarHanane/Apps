package application;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.xml.crypto.Data;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
 
public class MsgR extends Application {
/////***variable de connexion
	   Connection cnn=null;
	   PreparedStatement prepared=null;    
	   ResultSet res=null;
	   public static int cmp1;
    
  @SuppressWarnings("unchecked")
@Override
    public void start(Stage primaryStage) 
  {
	  TableView<employe_d> table = new TableView<employe_d>();
	  
	 
	  //Conteneur************
 	AnchorPane p=new AnchorPane();
      p.setPrefHeight(650);
      p.setPrefWidth(750);
      p.setTranslateY(-35);
      
      Scene scene = new Scene(p);
      

			 
	//Panel*************************

		     
			 Pane root=new Pane();
			 root.setLayoutX(44);
			 root.setLayoutY(65);
			 root.setPrefHeight(550); 
			 root.setPrefWidth(650);
			 p.getChildren().add(root);
		
			 
			
//loading CSS
			  	    
			  	      Label lb=new Label();
			  	      lb.setAlignment(Pos.CENTER);
			  	      lb.setLayoutY(60);
			  	      lb.setLayoutX(45);
			  	      lb.setMinHeight(64);
			  	      lb.setMinWidth(650);
			  	      lb.setPrefHeight(64);
			  	      lb.setPrefWidth(500);
			  	      lb.setStyle( "-fx-background-color: #008080; "+"-fx-background-radius: 50px 50px 0px 0px;"+  "-fx-text-fill: #FFFFFF; ");
			  	      lb.setText("Demandes à consulter");
			  	      lb.setFont(new Font(25)); 
			  	      p.getChildren().add(lb);	
		
			  	    p.setStyle("-fx-background-color:  linear-gradient(LightGray,LightGray);");
 
      
	  final Label label = new Label("Nouvelle demande:");
      label.setFont(new Font("Arial", 20));
        table.setEditable(true);
       
        TableColumn<employe_d, String> nom = new TableColumn<employe_d, String>("Nom");
        TableColumn<employe_d, String> prenom = new TableColumn<employe_d, String>("Prénom");
        TableColumn<employe_d, String> cin = new TableColumn<employe_d, String>("cin");
        TableColumn<employe_d, String> emploi = new TableColumn<employe_d, String>("emploi");
        TableColumn<employe_d, String> demande = new TableColumn<employe_d, String>("demande");
        TableColumn<employe_d, String> date_debut= new TableColumn<employe_d, String>("date_debut");
        TableColumn<employe_d, String> date_fin = new TableColumn<employe_d, String>("date_fin");
        TableColumn<employe_d, String> reponse = new TableColumn<employe_d, String>("reponse");
        //TableColumn<employe_d, Color> col = new TableColumn<employe_d, Color>("col");
         JFXButton valider=new JFXButton("Valider");
         JFXButton Rejeter=new JFXButton("Rejeter");
       
        
        table.getColumns().addAll(nom,prenom,demande,cin,emploi,date_debut,date_fin,reponse);
        ObservableList<employe_d> data = FXCollections.observableArrayList();
        
       
    
      

	 //compter nbr de ligne*********************
        cnn=(Connection) connecterBD.connexionBD();
    try {
			 String sql1 = "select count(*) from demande ";
		     prepared=cnn.prepareStatement(sql1);
             res=prepared.executeQuery();
			 while (res.next()) {
				cmp1=Integer.parseInt(res.getString("count(*)"));}
			  
	 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
     	//Enregistrer cmp1 dans un fichier**********
    String compte=String.valueOf(cmp1);
	   try (FileOutputStream fos = new FileOutputStream("cmp.txt")) {
   		fos.write(compte.getBytes());
       
        
          }catch(IOException ex){
             ex.printStackTrace();
             }


 


    		
    		
    		try {
    			String sql = "select * from demande ";
    		
    			prepared=cnn.prepareStatement(sql);
	             res=prepared.executeQuery();
    			while (res.next()) {
    			     data.add(new employe_d(res.getString("nom"),res.getString("prenom"),res.getString("demande"),res.getString("cin"),res.getString("emploi"),res.getString("date1"),res.getString("date2"),res.getString("reponse")));
    		   }
           } catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	
    	
    	
    		
    		
    		
    		
    		////Boutton valider activer
    		 valider.setOnAction(new EventHandler<ActionEvent>() {
	          	 
 	    		public void handle(ActionEvent actionEvent)
 	           	 { 
    	    
	               	// TODO Auto-generated method stub
 	    			
							  Alert  dialogC= new Alert(AlertType.CONFIRMATION);
		    					 dialogC.setTitle("Confirmer la demande");
		    					 dialogC.setHeaderText(null);
		    					 dialogC.setContentText("Voulez vous valider cette demande ? ");
		    					 Optional<ButtonType> answer= dialogC.showAndWait();
		    					 if(answer.get() == ButtonType.OK){
		    						 String sql1="update demande set reponse='validé' where num=?+1";
		    						 try {
										prepared=cnn.prepareStatement(sql1);
										prepared.setString(1, ""+ table.getSelectionModel().getSelectedIndex());
										prepared.execute();
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
		    						 
		    					
		    					 }
		    					 
		    					}
	            });
    		 Rejeter.setOnAction(new EventHandler<ActionEvent>() {
	          	 
  	    		public void handle(ActionEvent actionEvent)
  	           	 { 
     	    
 	               	// TODO Auto-generated method stub
 							  Alert  dialogC= new Alert(AlertType.CONFIRMATION);
 		    					 dialogC.setTitle("Rejeter une demande");
 		    					 dialogC.setHeaderText(null);
 		    					 dialogC.setContentText("Voulez vous rejeter cette demande ? ");
 		    					 Optional<ButtonType> answer= dialogC.showAndWait();
 		    					 if(answer.get() == ButtonType.OK){
 		    						 String sql1="update demande set reponse='refusé' where num=?+1";
 		    						 try {
 										prepared=cnn.prepareStatement(sql1);
 										prepared.setString(1, ""+ table.getSelectionModel().getSelectedIndex());
 										prepared.execute();
 										
 									} catch (SQLException e) {
 										// TODO Auto-generated catch block
 										e.printStackTrace();
 									}
 		    						 
 		    					
 		    					 }
 		    					 }
 	            });
	      
	           

    		
    	 	
    		
    //inserer les elements dans le tableview **********************		
    		nom.setCellValueFactory(new PropertyValueFactory<employe_d,String>("nom"));
    		prenom.setCellValueFactory(new PropertyValueFactory<employe_d,String>("prenom"));
    		
    		demande.setCellValueFactory(new PropertyValueFactory<employe_d,String>("demande"));
    		date_debut.setCellValueFactory(new PropertyValueFactory<employe_d,String>("date_debut"));
    		date_fin.setCellValueFactory(new PropertyValueFactory<employe_d,String>("date_fin"));
    		cin.setCellValueFactory(new PropertyValueFactory<employe_d,String>("cin"));
    		emploi.setCellValueFactory(new PropertyValueFactory<employe_d,String>("emploi"));
    		reponse.setCellValueFactory(new PropertyValueFactory<employe_d,String>("reponse"));
    		
    		
    //******************
    		
    		     
    		       
                     
    		
    		
    		
    		table.setItems(data);
    				
     	
     //modifier l'apparence des bouttons**************	
     	valider.setFont(new Font(25));
     	Rejeter.setFont(new Font(25));
    	valider.setId("valider");
     	Rejeter.setId("Rejeter");
    	
     	valider.setTranslateY(490);
     	Rejeter.setTranslateY(487);
     	valider.setTranslateX(300);
     	Rejeter.setTranslateX(400);
     	table.setTranslateY(75);
     	 
     	
	     label.setTranslateX(200);
	     label.setTranslateY(20);
	     
	    
	   
	       // root.setSpacing(5);
	       root.setPadding(new Insets(10, 0, 0, 10));
	        root.getChildren().addAll(label, table,valider,Rejeter);
	 
	        
	        root.setStyle("-fx-background-color: #fff;" + "-fx-background-radius:50px" );
	   
	   
	 /////Fenetre Principale***************		
		//	Scene scene = new Scene(root,550,600);
	        table.setId("table");
		        primaryStage.setTitle("Nouvelle demande"); 
		        scene.getStylesheets().add("application/application.css");
		        primaryStage.setScene(scene);
		        primaryStage.show();
        
     

         
    }
    public static void main(String[] args) {
        launch(args);
    }
}