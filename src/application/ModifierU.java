package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ModifierU extends Application {
	   Connection cnn=null;
	   PreparedStatement prepared=null;    
	   ResultSet res=null;
	static JFXTextField txtUti=new JFXTextField();
	static JFXTextField txtmdp=new JFXTextField();
	public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setTranslateX(-100);
        root.setTranslateY(30);
        //Conteneur************
    	AnchorPane p=new AnchorPane();
        p.setPrefHeight(500);
        p.setPrefWidth(600);
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
			 pi.setPrefHeight(400); 
			 pi.setPrefWidth(500);
			 p.getChildren().add(pi);
			 pi.getChildren().add(root);
			 
			
//loading CSS
			  	     pi.setStyle("-fx-background-color: #fff;" + "-fx-background-radius: 50px" );
			  	      Label lb=new Label();
			  	      lb.setAlignment(Pos.CENTER);
			  	      lb.setLayoutY(60);
			  	      lb.setLayoutX(45);
			  	      lb.setMinHeight(64);
			  	      lb.setMinWidth(500);
			  	      lb.setPrefHeight(64);
			  	      lb.setPrefWidth(301);
			  	      lb.setStyle( "-fx-background-color: #008080; "+"-fx-background-radius: 50px 50px 0px 0px;"+  "-fx-text-fill: #FFFFFF; ");
			  	      lb.setText("Modifier");
			  	      lb.setFont(new Font(25)); 
			  	      p.getChildren().add(lb);	
    //champs utilis et mdp   
        Label Uti=new Label("Utilsateur");
        VBox vbox=new VBox();
        Label mdp=new Label("Password");
        
    //boutton 
	    Button ajout=new Button();
	    Button supp=new Button();
	    Button modi=new Button();
	    Label lb1=new Label("Ajouter");
	    Label lb2=new Label("Supprimer");
	    Label lb3=new Label("Modifier");
	    MenuBar menuBar = new MenuBar();
	
	
      
     
	
//////Creation de Menu******************** 
	   
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
	 //Positinner les élements
	   //**ajout
	     ajout.setGraphic(new ImageView("image/ajout1.jpg"));
		 ajout.setContentDisplay(ContentDisplay.TOP);
		 ajout.setTranslateX(200);
	     ajout.setTranslateY(220);
	     lb1.setTranslateX(200);
	     lb1.setTranslateY(280);
	     lb1.setFont(new Font(15));
	   //**supprimer
	     supp.setGraphic(new ImageView("image/supp.jpg"));
	 	 supp.setContentDisplay(ContentDisplay.TOP);
	 	 supp.setTranslateX(300);
	     supp.setTranslateY(220);
	     lb2.setTranslateX(300);
	     lb2.setTranslateY(280);
	     lb2.setFont(new Font(15));
	   //**modifier
	     modi.setGraphic(new ImageView("image/mod2.jpg"));
	 	 modi.setContentDisplay(ContentDisplay.TOP);
	 	 modi.setTranslateX(400);
	     modi.setTranslateY(220);
	     lb3.setTranslateX(400);
	     lb3.setTranslateY(280);
	     lb3.setFont(new Font(15));
	   //**element utilisateur
	     Uti.setTranslateX(200);
	     Uti.setTranslateY(50);
	     txtUti.setTranslateX(300);
	     txtUti.setTranslateY(50);
	     txtUti.setMaxSize(150,0);
	     Uti.setFont(new Font("Italique", 20));
	   //**element mdp
	     mdp.setTranslateX(200);
	     mdp.setTranslateY(100);
	     txtmdp.setTranslateX(300);
	     txtmdp.setTranslateY(100);
	     txtmdp.setMaxSize(150,0);
	     mdp.setFont(new Font("Italique", 20));
//***Activer Ajouter
	    
	    ajout.setOnAction(new EventHandler<ActionEvent>() {
         	 
    		public void handle(ActionEvent actionEvent)
           	 {  
       
    			 if(txtmdp.getText().isEmpty() || txtUti.getText().isEmpty()  ){
          		   
          		   
          		   Alert dialogW = new Alert(AlertType.WARNING);
          		   dialogW.setTitle("A warning ");
          		   dialogW.setHeaderText(null); // No header
          		   dialogW.setContentText("Vous devez remplir d'abord le login et password!!");
          		   dialogW.showAndWait();
          		   
    			 }else{
    			
             Stage s=new Stage();
         	   Ajouter_utili a =new Ajouter_utili(); 
	          try {
				a.start(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	} }});
           
 //**Activer l'affichage de mdp
	     
	    txtUti.setOnKeyReleased(new EventHandler<KeyEvent>()
	    {
	        @Override
	        public void handle(KeyEvent event)
	        {
	      		   	cnn= connecterBD.connexionBD();
	      			 String sql="select passwd from autho where login = ? ";
	        	     
						try {
							prepared=cnn.prepareStatement(sql);
							prepared.setString(1,txtUti.getText().toString());
							res=prepared.executeQuery();
							
						if(res.next())
						{   String mot=res.getString("passwd");
							txtmdp.setText(mot);
						}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	      			
	          }});
	    
	    
 //**Activer Supprimer
	   supp.setOnAction(new EventHandler<ActionEvent>() {
        	 
    		public void handle(ActionEvent actionEvent)
           	 {   	cnn= connecterBD.connexionBD();
                if(txtUti.getText().isEmpty()){
                	 Alert dialogW = new Alert(AlertType.WARNING);
          		   dialogW.setTitle("A warning ");
          		   dialogW.setHeaderText(null); // No header
          		   dialogW.setContentText("Vous devez entrer le nom de l'utilisateur !");
          		   dialogW.showAndWait();
          		   
                }else{
           	Alert dialogC= new Alert(AlertType.CONFIRMATION);
           	dialogC.setTitle("A confirmation dialog-box");
           	dialogC.setHeaderText(null);
           	dialogC.setContentText("Etes vous sur de supprimer cet employé ?");
           	Optional<ButtonType> answer= dialogC.showAndWait();
           	if(answer.get() == ButtonType.OK){
           

			  String sql1="delete from autho where login =? ";
			  try {
				prepared=cnn.prepareStatement(sql1);
				prepared.setString(1, txtUti.getText().toString());
				prepared.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
           	}
           	else{
       
           	}
                }
    			  //vider les deux premier champs
	        	    txtUti.setText("");
	        	    txtmdp.setText("");
                   
    			
           	  }});
//**Activer Modifier***************************
	   modi.setOnAction(new EventHandler<ActionEvent>() {
      	public void handle(ActionEvent actionEvent)
          	 {   	
   			 //inserer information
   			   cnn= connecterBD.connexionBD();
   			    String sql2="select * from autho where login= ?";
   			    try {
   			    	
					prepared=cnn.prepareStatement(sql2);
					prepared.setString(1, txtUti.getText().toString());
					res=prepared.executeQuery();
					while(res.next()){
					  changer.txtUti.setText(res.getString("login"));
				      changer.txtmdp.setText(res.getString("passwd"));
					  changer.nom.setText(res.getString("nom"));	
					  changer.prenom.setText(res.getString("prenom"));	
					  changer.DateNaissance.setText(res.getString("date_naiss"));
					  changer.adresse.setText(res.getString("adresse"));
					  changer.emploi.setText(res.getString("emploi"));
					   changer.cin.setText(res.getString("cin"));
	                  changer.Code_pos.setText(res.getString("code_postal"));
                      changer.type.setText(res.getString("type"));
	                   changer.email.setText(res.getString("email"));
	                  changer.tel.setText(res.getString("tel"));
	                   changer.Date_emb.setText(res.getString("date_emb"));
	                   changer.grade.setText(res.getString("grade"));}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   			    
   			  Stage s=new Stage();
        	    changer a =new changer(); 
	          try {
				a.start(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
          
          	 
          	}});	 
          	 
///ajout des composants a la fenetre
	     root.getChildren().add(ajout);
	     root.getChildren().add(supp);
	     root.getChildren().add(modi);
	     root.getChildren().add(Uti);
	     root.getChildren().add(mdp);
	     root.getChildren().add(lb1);
	     root.getChildren().add(lb2);
	     root.getChildren().add(lb3);
	     root.getChildren().add(txtUti);
	     root.getChildren().add(txtmdp);
	     root.getChildren().add(menuBar);
	
	menuBar.setTranslateX(100);
	menuBar.setMaxSize(500, 10);
	
////Fenetre Principale	
	  /*  root1.setCenter(root);
	     Scene scene = new Scene(root1,600, 500); */
	        primaryStage.setTitle("Modfier"); 
	        primaryStage.setScene(scene);
	  	  scene.getStylesheets().add("application/application.css");
	        primaryStage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          launch(args);
	}

}
