
package application;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import jxl.Workbook;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class S_Authentifier extends Application {
 
////**********Attribut pour relier projet a BD
	   Connection cnn=null;
  	   PreparedStatement prepared=null;    
  	   ResultSet res=null;
  	 static  int i;
  	   
//Variables globales*************  	   
  	    public static JFXTextField txtutilisateur=new JFXTextField();
   
 
    @Override
    public void start(Stage stage) {
   
   //Conteneur************
    	AnchorPane p=new AnchorPane();
        p.setPrefHeight(586);
        p.setPrefWidth(389);
        Scene scene = new Scene(p);
         
  //Arrière plan ******************      
        Image image1 = new Image("image/photo-1464306208223-e0b4495a5553.jpg");
	       BackgroundImage bg1 =new BackgroundImage(image1, null, null, null, null );
			 Background img1 = new Background(bg1);	
			 p.setBackground(img1);
	//Panel*************************
			 Pane pi=new Pane();
			 pi.setLayoutX(44);
			 pi.setLayoutY(65);
			 pi.setPrefHeight(457); 
			 pi.setPrefWidth(301);
			
//loading CSS
  	      pi.setStyle("-fx-background-color: #fff;" + "-fx-background-radius: 50px" );
  	      Label lb=new Label();
  	      lb.setAlignment(Pos.CENTER);
  	      lb.setLayoutY(-2);
  	      lb.setMinHeight(64);
  	      lb.setMinWidth(260);
  	      lb.setPrefHeight(64);
  	      lb.setPrefWidth(301);
  	      lb.setStyle( "-fx-background-color: #008080; "+"-fx-background-radius: 50px 50px 0px 0px;"+  "-fx-text-fill: #FFFFFF; ");
  	      lb.setText("Bienvenu");
  	      lb.setFont(new Font(25)); 
    //username*************
  	      
  	      txtutilisateur.setMaxWidth(206);
  	      txtutilisateur.setMinWidth(192);
  	      txtutilisateur.setPromptText("user name");
  	      txtutilisateur.setLabelFloat(true);
  	      txtutilisateur.setFont(new Font(15));
  	      txtutilisateur.setTranslateX(30);
  	      txtutilisateur.setTranslateY(150);
  	      pi.getChildren().add(txtutilisateur);
  	      
   //password************** 
  	      
  	    JFXPasswordField txtmdp=new JFXPasswordField();
  	      txtmdp.setMaxWidth(206);
	      txtmdp.setMinWidth(192);
	      txtmdp.setPromptText("password");
	      txtmdp.setLabelFloat(true);
	      txtmdp.setFont(new Font(15));
	      txtmdp.setTranslateX(30);
	      txtmdp.setTranslateY(230);
	      pi.getChildren().add(txtmdp);
  	     lb.setContentDisplay(ContentDisplay.CENTER);
  	   
  //pointer******************
  	    JFXButton valider=new JFXButton("Valider");
  	    valider.setTranslateX(150);
  	    valider.setTranslateY(300);
  	    valider.setId("valider1");

  	    valider.setFont(new Font(20));
  	    
 
  
  	 
  //Activer le boutton de pointage****************
  	  valider.setOnAction(new EventHandler<ActionEvent>() {
       	 
  		public void handle(ActionEvent actionEvent)
         	 {  
  			          
  			          cnn=(Connection) connecterBD.connexionBD();
         	              Stage s=new Stage();
			           	 
     //*****S'athentifier
         		final String login2=txtutilisateur.getText().toString();
         		String passwd=txtmdp.getText().toString();
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
				            if(login1.equals(login2) && passwd2.equals(passwd))
						          {
				                ///essai enregistrer en fichier excel*****
							      String sql4="select * from pointage where id=? "   ;
							    
						               	 prepared=cnn.prepareStatement(sql4);	
						               	 prepared.setString(1, id);
					                     res= prepared.executeQuery();
							       while(res.next()){
							    	   try{
							    		  //lire i***********************
						        			InputStream ips=new FileInputStream("i.txt"); 
						        			InputStreamReader ipsr=new InputStreamReader(ips);
						        			BufferedReader br=new BufferedReader(ipsr);
						        			String ligne;
						        			while ((ligne=br.readLine())!=null){
						        			i=Integer.parseInt(ligne);
						        				
						        			}
						        			br.close(); 
						        		}		
						        		catch (Exception e){
						        			//System.out.println(e.toString());
						        		}
							           jxl.write.Label lbn=new jxl.write.Label (0,i,txtutilisateur.getText());
							           jxl.write.Label lbm=new jxl.write.Label(1, i, res.getString("pointu"));
							            String fileName="user.xls";
							            WritableWorkbook workbook = null;
							            
						            	
							            
										try {
											workbook = Workbook.createWorkbook(new File(fileName));
											WritableSheet sheet=workbook.createSheet("Sheet1", 4);
							               sheet.addCell(lbn);
							               sheet.addCell(lbm);
							               workbook.write();
							              
							               i++;
							       //Enregistrer i dans un fichier**********
							        	      String compte=String.valueOf(i);
							        	  	   try (FileOutputStream fos = new FileOutputStream("i.txt")) {
							        	     		fos.write(compte.getBytes());
							        	         
							        	     		
							        	            }catch(IOException ex){
							        	               ex.printStackTrace();
							        	               }

							               
							               workbook.close();
										} catch (IOException | WriteException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
							       }
				            	
				            	
				            	
				            	
				            	
				            	
				            	
				            	
					 //Inseration du temps dans la bd **************
				            	
				            	
				            	
				            	
							             String sql1="update pointage set pointu= sysdate() where id = ? and day(pointu) < day(sysdate())  ";
						                   try {
							               	 prepared=cnn.prepareStatement(sql1);	
						                      prepared.setString(1, id);
						                     prepared.execute();
						                    } catch (Exception e) {
 					                               // TODO Auto-generated catch block
 				            	                     e.printStackTrace();}
                   //teste de type d' entrant *************
							                  try {
								                  tro=true;
								                 String sql3="select type from autho where login =?";
								                 prepared=cnn.prepareStatement(sql3);
								                 prepared.setString(1, txtutilisateur.getText().toString());
								                 res=prepared.executeQuery();
								              while(res.next()){
								            	  stage.hide();
								                    if(res.getString("type").equals("emp"))
								                   {
								                      Outils a =new Outils();
								                      a.start(s);}
								                  if(res.getString("type").equals("admin"))
								                   {
								                      Outils_admin a =new Outils_admin();
								                      a.start(s);
								                      }
								                   if(res.getString("type").equals("RH"))
								                    {
								                      Outils_RH a =new Outils_RH();
								                      a.start(s);
								                      }
  		         			                
  		         			                     }
  		         			                 } catch (Exception e) {
  					                           // TODO Auto-generated catch block
  				                               	e.printStackTrace();}    
							                  }
				            
				    
						


				  }//while
		   if(tro==false){
			   Alert dialogW = new Alert(AlertType.WARNING);
			   dialogW.setTitle("Erreur");
			   dialogW.setHeaderText(null); // No header
			   dialogW.setContentText("Erreur d'authentification :Ressayer !");
			   dialogW.showAndWait();}
	/*1*/} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
		//txtutilisateur.setText("");
      txtmdp.setText("");
		
		
         	 } }); 
  	   //Ajout d'elements a la fenetre****************
              pi.getChildren().add(lb);
              pi.getChildren().add(valider);
              p.getChildren().add(pi);
              
      //Reglage fenetre normal************** 
              stage.setTitle("Pointer");
        stage.setScene(scene);
        scene.getStylesheets().add("application/application.css");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}