package application;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Connection;

import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class horaire  extends Application{
 
	 Connection cnn=null;
	   PreparedStatement prepared=null;    
	   ResultSet res=null;
	private Button Button;
	   
	
	
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		VBox root=new VBox();
		root.setTranslateY(50);
		
		AnchorPane p=new AnchorPane();
	       p.setPrefHeight(650);
	       p.setPrefWidth(600);
	       p.setTranslateY(-35);
	       
	       Scene scene = new Scene(p);
	       
	 
				 
		//Panel*************************
				 Pane pi=new Pane();
				 pi.setLayoutX(44);
				 pi.setLayoutY(65);
				 pi.setPrefHeight(550); 
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
				  	      lb.setText("Horaire");
				  	      lb.setFont(new Font(25)); 
				  	      p.getChildren().add(lb);	
			
		
		
		//root.setPadding(new Insets(20));
		GridPane gridpane1=new GridPane();
	
		gridpane1.setHgap(20);
        gridpane1.setVgap(10);
		GridPane gridpane2=new GridPane();
		gridpane2.setHgap(20);
        gridpane2.setVgap(10);
		GridPane gridpane3=new GridPane();
		gridpane3.setHgap(20);
        gridpane3.setVgap(10);
		
        //Composants du gridpane1
        Label pointage=new Label("Infos Pointage");
        pointage.setFont(new Font(20));
        pointage.setTextFill(Color.BLUE);
        pointage.setTranslateX(20);
        pointage.setTranslateY(30);
        
       
		Label lb1=new Label("Vous avez pointé à : ");
		Label lb2=new Label("Temps écoulé : ");
		TextField lb3=new TextField();
		lb3.setDisable(true);
		TextField lb4=new TextField();
		lb4.setDisable(true);
		
		 Label repas=new Label("Repas");
	        repas.setFont(new Font(20));
	        repas.setTextFill(Color.BLUE);
	        repas.setTranslateX(20);
	        repas.setTranslateY(-5);
	        Label pointer=new Label("Pointer : ");
	        pointer.setFont(new Font(15));
	        Button rep =new Button("Pointage du repas");
	        rep.setFont(new Font(15));
	       
	     Label période=new Label("Période");
	        période.setFont(new Font(20));
	        période.setTextFill(Color.BLUE);
	        période.setTranslateX(20);
	        période.setTranslateY(-40);
		
		

			 
//modifications sur  labels et bouttons*******l
			lb1.setFont(new Font(15));
			lb2.setFont(new Font(15));
			lb3.setFont(new Font(15));
			lb4.setFont(new Font(15));
			Button retour=new Button("Retour au menu principal");
			retour.setFont(Font.font(null, FontWeight.BOLD, 25));
	        retour.setTextFill(Color.STEELBLUE); 
	        
	        
	
			 
		//Ajout des Composants
	        //***gridpane1
	        gridpane1.add(lb1, 1, 1);
	        
	        gridpane1.add(lb3, 2, 1);

	        gridpane1.add(lb2, 1, 2);
	        
	        gridpane1.add(lb4, 2, 2);
	        
	        //**gridpane2
	          gridpane2.setTranslateY(-40);
	          gridpane2.add(pointer, 2, 0);
              gridpane2.add(rep, 6, 0);
              
           //**gridpane3
               		//*** Contenu des rectangles
              
		              Label ouverture=new Label("Horaires\ntravaillées");
		              ouverture.setFont(new Font(15));
		              ouverture.setTextFill(Color.NAVY);
		              ouverture.setTranslateX(60);
		              ouverture.setTranslateY(7);
		              Label Repas=new Label("Repas");
		              Repas.setFont(new Font(15));
		              Repas.setTextFill(Color.NAVY);
		              Repas.setTranslateX(155);
		              Repas.setTranslateY(7);
		              Label Sortie=new Label("Horaires\ntravaillées");
		              Sortie.setFont(new Font(15));
		              Sortie.setTextFill(Color.NAVY);
		              Sortie.setTranslateX(230);
		              Sortie.setTranslateY(7);
		            //***les horaires
		              Label l1=new Label("08:00");
		              l1.setFont(new Font(10));
		              l1.setTranslateX(17);
		              l1.setTranslateY(-30);
		              
		              Label l2=new Label("12:00");
		              l2.setFont(new Font(10));
		              l2.setTranslateX(130);
		              l2.setTranslateY(-30);
		              
		              Label l3=new Label("13:00");
		              l3.setFont(new Font(10));
		              l3.setTranslateX(190);
		              l3.setTranslateY(-30);
		              Label l4=new Label("16:00");
		              l4.setFont(new Font(10));
		              l4.setTranslateX(330);
		              l4.setTranslateY(-30);
              
              gridpane3.setTranslateY(-55);
              gridpane3.setHgap(0);
              final Rectangle rectangle = new Rectangle(50, 50, 150, 50); 
              final LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,  
                      new Stop(0, Color.LIGHTBLUE),  
                      new Stop(1, Color.LIGHTBLUE)); 
             rectangle.setTranslateX(20);
              rectangle.setTranslateY(5);

              rectangle.setFill(gradient);
              final Rectangle rectangle1 = new Rectangle(50, 50, 70,50); 
              final LinearGradient gradient1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,  
                      new Stop(0, Color.LIGHTGREEN),  
                      new Stop(1, Color.PALEGREEN)); 
             rectangle1.setTranslateX(150);
              rectangle1.setTranslateY(5);
              rectangle1.setFill(gradient1);
              
              final Rectangle rectangle2 = new Rectangle(50, 50, 150, 50); 
              final LinearGradient gradient2 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,  
                      new Stop(0, Color.LIGHTPINK),  
                      new Stop(1, Color.LIGHTPINK)); 
              rectangle2.setTranslateX(200);
              rectangle2.setTranslateY(5);
              rectangle2.setFill(gradient2);
            
              gridpane3.getChildren().add(rectangle);
              gridpane3.getChildren().add(ouverture);
              gridpane3.getChildren().add(rectangle1);
              gridpane3.getChildren().add(Repas);
              gridpane3.getChildren().add(rectangle2);
              gridpane3.getChildren().add(Sortie);
              gridpane3.getChildren().add(l1);
              gridpane3.getChildren().add(l2);
              gridpane3.getChildren().add(l3);
              gridpane3.getChildren().add(l4);
              //gridpane3.add(rectangle,4, 2);
  	        
  	         // gridpane3.add(rectangle1, 5, 2);
  	          
  	        //  gridpane3.add(rectangle2, 6, 2);
  	          
  	        
            
  	        
              
	        
	        
			 
		//Style
			 
	        gridpane1.setStyle("-fx-padding: 10;" + 
	                "-fx-border-style: solid inside;" +  
	                "-fx-border-width: 2;" +
	                "-fx-border-insets: 40;" + 
	                "-fx-border-radius: 10;" +
	                "-fx-border-color: darkgray;");
	         gridpane2.setStyle("-fx-padding: 10;" + 
	                "-fx-border-style: solid inside;" +  
	                "-fx-border-width: 2;" +
	                "-fx-border-insets:40;" + 
	                "-fx-border-radius: 10;" +
	                "-fx-border-color: darkgray;");
             gridpane3.setStyle("-fx-padding: 10;" + 
	                "-fx-border-style: solid inside;" +  
	                "-fx-border-width: 2;" +
	                "-fx-border-insets:40;" + 
	                "-fx-border-radius: 10;" +
	                "-fx-border-color: darkgray;");
	       // pi.setStyle("-fx-background-color:  linear-gradient(lightgray,lightgray);");
	      
		
//recuperer le num du personne connecte S_Authentifier.txtutilisateur.getText().toString()
	        String sql0="select id from autho where login =? ";
	             try {
	            	   cnn=(Connection) connecterBD.connexionBD();
					prepared=cnn.prepareStatement(sql0);
					prepared.setString(1,S_Authentifier.txtutilisateur.getText().toString());
	                res=prepared.executeQuery();
	               
	               while(res.next()){
	                  
	            	   int k=Integer.parseInt(res.getString("id"));
	             
	               //recherche d'heure de pointage*****
	            	   cnn=(Connection) connecterBD.connexionBD();
	       	                   	String sql="select pointu,timediff(sysdate(),pointu) from pointage where id=?";
	       	                   	try{
	       	                		prepared=cnn.prepareStatement(sql);
	       	                 		prepared.setString(1,""+k);
	       	                 	    res=prepared.executeQuery();
	       	                	while(res.next())
	       	                		{
	       	                		   lb3.setText(res.getString("pointu"));
	                                   lb4.setText(res.getString("timediff(sysdate(),pointu)")); 
	       	                      	}
	       		                } catch (SQLException e1) {
	       			            // TODO Auto-generated catch block
	       		               	e1.printStackTrace();}
	       		
	               }
	               
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	             
	             //Button Retour
					 retour.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							primaryStage.close(); //je ferme mon premier stage 
							
						} });   

					 
					 
					 
					 rep.setOnAction(new EventHandler<ActionEvent>() {
				       	 
					  		public void handle(ActionEvent actionEvent)
					         	 {  
					  			          
					  			          cnn=(Connection) connecterBD.connexionBD();
					         	              Stage s=new Stage();
								           	 
					     //*****S'athentifier
					         		final String login2=S_Authentifier.txtutilisateur.getText().toString();
					         		
					         		String sql="select id,login,passwd from autho";
							/*1*/  try {
										prepared=cnn.prepareStatement(sql);
										res=prepared.executeQuery();
										boolean tro=false;
									//Comparaison du login avec la BD***************
								while(res.next())
										 {      String login1=res.getString("login");
										    	String id=res.getString("id");
										    	String passwd2=res.getString("passwd");
									            
										 //Inseration du temps dans la bd **************
									            	
												             String sql1="update pointage set pointage_repas= sysdate() where id = 1 and day(pointage_repas) < day(sysdate()) ";
											                   try {
												               	 prepared=cnn.prepareStatement(sql1);	
											                   //   prepared.setString(1, id);
											                     prepared.execute();
											                    } catch (Exception e) {
					 					                               // TODO Auto-generated catch block
					 				            	                     e.printStackTrace();}
											          }
											                   
											          } catch (SQLException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();}
					         	 }});
										 
	
    
		 
	
		 
		
		 
		 
		 
	/////Ajout des objets a la fenetre**** 
		root.getChildren().add(pointage);
		root.getChildren().add(gridpane1);
		root.getChildren().add(repas);
		root.getChildren().add(gridpane2);
		root.getChildren().add(période);
		root.getChildren().add(gridpane3);
		
	
		 
	/////Fenetre Principale**********	
		
//Scene scene = new Scene(root,750, 600); 
primaryStage.setTitle("	Horaire"); 
primaryStage.setScene(scene);
primaryStage.show();

	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
		// TODO Auto-generated method stub

	}

	

}
