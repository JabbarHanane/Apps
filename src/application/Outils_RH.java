
package application;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawer.DrawerDirection;
import com.mysql.jdbc.Connection;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Outils_RH extends Application {

	 /////***variable de connexion
	   Connection cnn=null;
	   PreparedStatement prepared=null;    
	   ResultSet res=null;   
	   static int cmp2;

    @Override
    public void start(Stage stage) {
        FlowPane content = new FlowPane();
    //hamburger******************   
        JFXHamburger ham=new JFXHamburger();
        Label men=new Label("Menu"); 
        men.setTranslateX(280);
        men.setTranslateY(-65);
        
        ham.setTranslateX(370);
        ham.setTranslateY(-65);
        men.setFont(new Font(20));
        JFXDrawersStack root = new JFXDrawersStack();
        content.getChildren().addAll(ham);
        content.getChildren().addAll(men);
        content.setMaxSize(200, 200);

       
        JFXDrawer drawer = new JFXDrawer();
        VBox grid = new VBox();
        ScrollPane scroll=new ScrollPane(grid);
        scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
       // scroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
       
        drawer.setSidePane(scroll);
        drawer.setDefaultDrawerSize(125);
        drawer.setOverLayVisible(false);
        drawer.setResizableOnDrag(true);
        
  //label********************
        Label bonj=new Label();
        bonj.setFont(new Font(20));
        bonj.setTextFill(Color.TEAL);
        //bonj.setStyle("-fx-background-color: white;");
       // root.getChildren().add(bonj);
        //bonj.setTranslateX(-50);
       // bonj.setTranslateY(-80);
        bonj.setFont(new Font(20));
        //du css*************
       
        bonj.setFont(Font.font ("Arial Black", 20));
        
        
        
     ///label_menu*************
        Label lb=new Label();
	      lb.setAlignment(Pos.CENTER);
	      lb.setTranslateY(-200); 
	    
	      lb.setMinHeight(64);
	      lb.setMinWidth(600);
	      lb.setPrefHeight(64);
	      lb.setPrefWidth(301);
	      lb.setStyle( "-fx-background-color: #008080; "+"-fx-background-radius: 50px 50px 0px 0px;"+  "-fx-text-fill: #FFFFFF; ");
	      lb.setText("Menu");
	      lb.setFont(new Font(25)); 
	      root.getChildren().add(lb);
	      
	      
	    //fixer le truc de demande*************
			
			 cnn=(Connection) connecterBD.connexionBD();
	       String sql1="select count(*) from demande ";
	     try{  
	    	     prepared=cnn.prepareStatement(sql1);
	             res=prepared.executeQuery();
	             while(res.next())
	                 {  
	            	    cmp2=Integer.parseInt(res.getString("count(*)"));
	            	    
	            	 	//Recuperer cmp1 d'un un fichier**********
	            	  /*  String  compte = null;
	            		   try (FileInputStream fos = new FileInputStream("cmp.txt")) {
	            		 // fos.read(compte.);
	            	        }catch(IOException ex){
	            	             ex.printStackTrace();
	            	             }
	            	             
          MsgR.cmp1=Integer.parseInt(compte);*/
	            	    
	            	    
	            	  try{
	        			InputStream ips=new FileInputStream("cmp.txt"); 
	        			InputStreamReader ipsr=new InputStreamReader(ips);
	        			BufferedReader br=new BufferedReader(ipsr);
	        			String ligne;
	        			while ((ligne=br.readLine())!=null){
	        			MsgR.cmp1=Integer.parseInt(ligne);
	        				
	        			}
	        			br.close(); 
	        		}		
	        		catch (Exception e){
	        			//System.out.println(e.toString());
	        		}
	            	    
	            	    
	                    if(MsgR.cmp1<cmp2)
	                    {  
	                      TrayNotification tray = new TrayNotification();
	                    tray.setNotificationType(NotificationType.SUCCESS);
	                    tray.setTitle("Nothification");
	                    tray.setMessage("Vous avez une nouvelle demande à traiter ");
	                    tray.setAnimationType(AnimationType.SLIDE);
	                    tray.showAndDismiss(Duration.millis(1500));
	                    }
	             
	                 }

   

} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


			 
		       
	      
//Grid_horaire******************	      
	     
	      GridPane gridpane1=new GridPane();
	  	
	   	Label lb1=new Label("Entrée : ");
			lb1.setTextFill(Color.TEAL);
			lb1.setFont(new Font(20));
		    TextField lb3=new TextField();
		    //lb3.setSi
			lb3.setDisable(true);
		    
			lb3.setTranslateX(-70);
			lb3.setTranslateY(20);
			lb1.setTranslateY(20);
			
//ajout de l'heure de pointage au champ entree********
		
			//recuperer le num du personne connecte S_Authentifier.txtutilisateur.getText().toString()
	        String sql0="select id from autho where login =? ";
	             try {
	            	   cnn=(Connection) connecterBD.connexionBD();
					prepared=cnn.prepareStatement(sql0);
					prepared.setString(1,S_Authentifier.txtutilisateur.getText().toString());
	                res=prepared.executeQuery();
	               
	               while(res.next()){
	                  
	            	 int   k=Integer.parseInt(res.getString("id"));
	             
	               //recherche d'heure de pointage*****
	            	   cnn=(Connection) connecterBD.connexionBD();
	       	                   	String sql="select pointu from pointage where id=?";
	       	                   	try{
	       	                		prepared=cnn.prepareStatement(sql);
	       	                 		prepared.setString(1,""+k);
	       	                 	    res=prepared.executeQuery();
	       	                	while(res.next())
	       	                		{
	       	                		   lb3.setText(res.getString("pointu"));
	                                    
	       	                      	}
	       		                } catch (SQLException e1) {
	       			            // TODO Auto-generated catch block
	       		               	e1.printStackTrace();}
	       		
	               }
	               
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	       
	
		
		//Ajout des Composants
	        //***gridpane1
			gridpane1.setTranslateY(40);
	        gridpane1.add(bonj, 1, 1);
	       gridpane1.add(lb1, 1, 2);
         gridpane1.add(lb3, 2, 2);
           gridpane1.setTranslateX(60);
           content.setStyle( "-fx-background-color: white; "+"-fx-background-radius: 50px 50px 50px 50px; ");
           content.setTranslateX(40);
           
	        
	      //  gridpane1.add(lb4, 2, 2);
	      
	      content.getChildren().add(gridpane1);
	      //boutton info*****************
	        JFXButton bt1=new JFXButton("Info");
	        bt1.setContentDisplay(ContentDisplay.TOP);
	        bt1.setAlignment(Pos.BOTTOM_CENTER);
	    //  bt1.autosize();
	       bt1.setPrefSize(125, 20);
	        bt1.setFont(new Font(17));
	        bt1.setTextFill(Color.WHITE);
	        bt1.setGraphic(new ImageView("image/infor.png"));
	      // bt1.setTranslateX(150);
	       // bt1.setTranslateY(0);
	       // bt1.setStyle("-fx-background-color: teal;");
	        bt1.setFont(new Font(17));
	        grid.getChildren().add(bt1);
	      //activation info*********************
	        bt1.setOnMouseClicked((MouseEvent me) -> {
			       Stage s=new Stage();
	        	   info a =new info(); 
		          try {
					a.start(s);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   });
		   
	        
	        
	    
	        
	  //insérer breaaak_image*****
			  Image image1 = new Image("image/btnBreak.png");
		      ImageView im=new ImageView(image1);
		      im.setTranslateX(20);
		      grid.getChildren().add(im);
			  
	        
	        
	    //boutton demande**********
	        JFXButton bt2=new JFXButton("demande");
	        bt2.setContentDisplay(ContentDisplay.TOP);
	        bt2.setAlignment(Pos.BOTTOM_CENTER);
	        bt2.setPrefSize(125, 20);
	        bt2.setTextFill(Color.WHITE);
	        bt2.setGraphic(new ImageView("image/demande2.png"));
	       // bt2.setTranslateX(150);
	      // bt2.setTranslateY(100);
	      //  bt2.setStyle("-fx-background-color: teal;");
	        bt2.setFont(new Font(17));
	        grid.getChildren().add(bt2);
	        
	        //insérer breaaak_image*****
	        ImageView im1=new ImageView(image1);
		      im1.setTranslateX(30);
		      grid.getChildren().add(im1);
		      
		 	 bt2.setOnMouseClicked((MouseEvent me) -> {
			       Stage s=new Stage();
	         	   demande_RH a =new demande_RH(); 
		          try {
					a.start(s);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   });
		      
	   //boutton Justificatif**********
	        JFXButton bt3=new JFXButton("Justificatif");
	        bt3.setContentDisplay(ContentDisplay.TOP);
	        bt3.setAlignment(Pos.BOTTOM_CENTER);
	      
	        bt3.setPrefSize(125, 20);
	        bt3.setTextFill(Color.WHITE);
	        bt3.setGraphic(new ImageView("image/justifier2.jpg"));
	     //   bt3.setTranslateX(150);
	      //  bt3.setTranslateY(200);
	        bt3.setFont(new Font(17));
	       // bt3.setStyle("-fx-background-color:  teal;");
	        grid.getChildren().add(bt3);
	        
	        //Activer justificatif
		       bt3.setOnMouseClicked((MouseEvent me) -> {
			       Stage s=new Stage();
	        	   Justificatif a =new Justificatif(); 
		          try {
					a.start(s);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   });
	        
	        //insérer breaaak_image*****
	        ImageView im2=new ImageView(image1);
		      im2.setTranslateX(30);
		      grid.getChildren().add(im2);
	        
	        //boutton Planning**********
	        JFXButton bt4=new JFXButton("Planning");
	        bt4.setContentDisplay(ContentDisplay.TOP);
	        bt4.setAlignment(Pos.BOTTOM_CENTER);
	      
	        bt4.setPrefSize(125, 20);
	        bt4.setTextFill(Color.WHITE);
	        bt4.setGraphic(new ImageView("image/pla.png"));
	       // bt4.setTranslateX(150);
	       // bt4.setTranslateY(300);
	        bt4.setFont(new Font(17));
	       // bt4.setStyle("-fx-background-color: teal;");
	        grid.getChildren().add(bt4);
	        
	      
		      
		    //Activer Planning
		       bt4.setOnMouseClicked((MouseEvent me) -> {
			       Stage s=new Stage();
	          	   Planning a =new  Planning(); 
		          try {
					a.start(s);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   });
	        
	       
	        
	        //insérer breaaak_image*****
	        ImageView im4=new ImageView(image1);
		      im4.setTranslateX(30);
		      grid.getChildren().add(im4);
	       
		      
		        //boutton loggin off**********
		        JFXButton bt5=new JFXButton("Log off");
		        bt5.setContentDisplay(ContentDisplay.TOP);
		        bt5.setAlignment(Pos.BOTTOM_CENTER);
		     
		        bt5.setPrefSize(125, 40);
		        bt5.setTextFill(Color.WHITE);  
		        bt5.setGraphic(new ImageView("image/logOut.png"));
		        //bt5.setTranslateX(150);
		        //bt5.setTranslateY(400);
		        bt5.setFont(new Font(17));
		      //  bt5.setStyle("-fx-background-color:  teal;");   
		        grid.getChildren().add(bt5);
		    
		 //activer deconnecter**************
		        
		        bt5.setOnMouseClicked((MouseEvent me) -> { 
		        	
		        	
		        	Alert dialogC= new Alert(AlertType.CONFIRMATION);
		           	dialogC.setTitle("A confirmation dialog-box");
		           	dialogC.setHeaderText(null);
		           	dialogC.setContentText("Voulez vous se déconnecter ?");
		           	Optional<ButtonType> answer= dialogC.showAndWait();
		    	if(answer.get() == ButtonType.OK){
		       			 String sql9="select id from autho where login =? ";
		 	             
		 	            	   cnn=(Connection) connecterBD.connexionBD();
		 					try {
		 						prepared=cnn.prepareStatement(sql9);
		 						prepared.setString(1,S_Authentifier.txtutilisateur.getText().toString());
		 	                    res=prepared.executeQuery();
		 					
		 				  while(res.next()){
		 	                  
		 	            	 int   k=Integer.parseInt(res.getString("id"));
		 	                 String sql6="update pointage set pointage_repas=sysdate() where id=? and day(pointage_repas) < day(sysdate()) ";
		       			  			try {
		 								prepared=cnn.prepareStatement(sql6);
		 								prepared.setString(1,""+k);
		       						    prepared.execute();
		 							} catch (SQLException e) {
		 								// TODO Auto-generated catch block
		 								e.printStackTrace();
		 							}
		 	               }	

		       						   
		     
		                } catch (SQLException e1) {
		 						// TODO Auto-generated catch block
		 						e1.printStackTrace();
		 					}
		            stage.close();
		       			    }
		      
		              	 });
	        
	        
	    
    
  ///////////////////////////////****panel_deconnecter
        Pane panel=new Pane();
        JFXButton deco=new JFXButton("Déconnecter");
        deco.setStyle("-fx-background-color: teal;");
        deco.setFont(Font.font ("arial", 15));
        deco.setTextFill(Color.WHITE);
        deco.setTranslateX(440);
        
        
       // panel.getChildren().add(deco);
        panel.setTranslateY(380);
        panel.setStyle("-fx-background-color: silver;");
        root.getChildren().add(panel);
          
       
        
        
		
    /////**inseration d'info de la BD
    	   cnn=(Connection) application.connecterBD.connexionBD();
    	          String temp=application.S_Authentifier.txtutilisateur.getText().toString();
    	         // System.out.println(temp);
        		  String sql="select nom ,prenom from autho where login=? ";
        		   
    	   //comment recuperer login et passswd
        		  try {
    					 prepared=cnn.prepareStatement(sql);
    				prepared.setString(1, temp);
    				     res=prepared.executeQuery();
    				    while(res.next())  
    				       {
    				    bonj.setText("Bonjour "+"  "+ res.getString("nom") +" "+ res.getString("prenom"));
    				    	
    			           }
        		   } catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();}
        
        
        
     //add css*****************************
        bt1.setId("button");
        bt2.setId("button");  
        bt3.setId("button");
        bt4.setId("button");
        bt5.setId("button");
      //  bt6.setId("button");
        scroll.setId("scroll"); 
        
        
        grid.setSpacing(5);    
      grid.setStyle("-fx-background-color: white;");
        root.setContent(content);

        ham.addEventHandler(MOUSE_PRESSED, e -> root.toggle(drawer));
       

        final Scene scene = new Scene(root, 550, 450);
     //   final ObservableList<String> stylesheets = scene.getStylesheets();
       /* stylesheets.addAll(Employe.class.getResource("/css/jfoenix-components.css").toExternalForm(),
                           Employe.class.getResource("/css/jfoenix-design.css").toExternalForm());*/
  	  scene.getStylesheets().add("application/application.css");
      stage.setTitle("Menu");
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}