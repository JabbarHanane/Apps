package application;

import java.awt.Component;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
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

public class demande extends Application{
/////***variable de connexion
	   Connection cnn=null;
	   PreparedStatement prepared=null;    
	   ResultSet res=null;
	   public static int cmp1;
    
  @SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {

	  TableView<employe_d> table = new TableView<employe_d>();
		// TODO Auto-generated method stub
		VBox root=new VBox();
		HBox hb=new HBox();
		
		
//*****************************************************************
		 //Conteneur************	
		
		root.setTranslateY(60);
		 root.setPrefHeight(580); 
		 root.setPrefWidth(650);
   	AnchorPane p=new AnchorPane();
       p.setPrefHeight(700);
       p.setPrefWidth(710);
       p.setTranslateY(-35);
       
       Scene scene = new Scene(p);

	//Panel*************************
		 Pane pi=new Pane();
			 pi.setLayoutX(44);
			 pi.setLayoutY(65);
			 pi.setPrefHeight(580); 
			 pi.setPrefWidth(650);
			 p.getChildren().add(pi);
			 pi.getChildren().add(root);
			 
			
//loading CSS
			  	     pi.setStyle("-fx-background-color: #fff;" + "-fx-background-radius: 50px" );
			  	      Label lb=new Label();
			  	      lb.setAlignment(Pos.CENTER);
			  	      lb.setLayoutY(60);
			  	      lb.setLayoutX(45);
			  	      lb.setMinHeight(64);
			  	      lb.setMinWidth(650);
			  	      lb.setPrefHeight(64);
			  	      lb.setPrefWidth(301);
			  	      lb.setStyle( "-fx-background-color: #008080; "+"-fx-background-radius: 50px 50px 0px 0px;"+  "-fx-text-fill: #FFFFFF; ");
			  	      lb.setText("Demande");
			  	      lb.setFont(new Font(25)); 
			  	      p.getChildren().add(lb);	
		
		
		
		//ADD THE MENU
		TabPane tabPane = new TabPane();
		Tab tab1 = new Tab("Nouvelle demande");
		Tab tab2 = new Tab("Etat  des demandes ");
		
		 primaryStage.setTitle("Demande");
		 //Adding root
		 VBox bp = new VBox();
		 VBox root1 = new VBox();
		 Button valider=new Button("Valider");
		 Button annuler=new Button("Annuler");
		 Button menu =new Button("Menu Principale");
		 Label info=new Label("infos");
		 Label demand=new Label("Demande");
		 Label période=new Label("Période");
	     bp.setPadding(new Insets(30,30,30,30));
	     
	     
	     
	
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

	        //Adding GridPane1
	        GridPane gridPane1 = new GridPane();
	        gridPane1.setPadding(new Insets(10,0,10,10));
	    
	        gridPane1.setHgap(20);
	        gridPane1.setVgap(10);
	       //Adding GridPane2
	        GridPane gridPane2 = new GridPane();
	        gridPane2.setPadding(new Insets(50,50,10,50));
	    
	        gridPane2.setHgap(20);
	        gridPane2.setVgap(10);
	       //Adding GridPane3
	        GridPane gridPane3 = new GridPane();
	        gridPane3.setPadding(new Insets(10,10,10,10));
	    
	        gridPane3.setHgap(20);
	        gridPane3.setVgap(10);
	        
	        
	        
	        
	      //Implementing Nodes for GridPane1
	        
	        Label name = new Label("Nom :");
	  
	        final TextField txtNom = new TextField();
	        
	        Label prénom = new Label("Prénom :");

	        final TextField txtPrénom = new TextField();
	        
	        Label ci = new Label("CIN :");

	        final TextField txtCin = new TextField();
	        
	        Label empl = new Label("Emploi :");

	        final TextField txtEmploi = new TextField();
	      //Implementing Nodes for GridPane2
		        Label deman=new Label("Demande :");
		        ChoiceBox<String> selectionner = new ChoiceBox<String>();
		      //**add in ChoiceBox
		        selectionner.getItems().addAll("Congé", "Abscence");

		        
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
		        
	        
	        //Adding Nodes to GridPane1 layout
	        
	        	        gridPane1.add(name, 0, 1);
	        
	        	        gridPane1.add(txtNom, 2, 1);
	        	        
	        	        gridPane1.add(ci, 4, 1);
	        	       
	        	        gridPane1.add(txtCin, 6, 1);
	        
	        	        gridPane1.add(prénom, 0, 2);
	        	        
	        	        gridPane1.add(txtPrénom, 2, 2);
	        	        
	        	        gridPane1.add(empl, 4, 2);
	        	        
	        	        gridPane1.add(txtEmploi, 6, 2);
	        //Adding Nodes to GridPane3 layout
	        	   gridPane2.add(deman, 0, 1);     
	        	   gridPane2.add(selectionner, 1, 1);     
	        	        
	        //Adding Nodes to GridPane3 layout
	        	        gridPane2.add(de, 0, 2);
	        	        gridPane2.add(cal, 1, 2);
	        	        gridPane2.add(au, 0, 3);
	        	        gridPane2.add(cal2, 1, 3);
	        	        
	        
	        	        	        
	       //Add HBox and GridPane layout to BorderPane Layout
	        	        
	        	        bp.getChildren().add(gridPane1);
	        	        bp.getChildren().add(gridPane2);
	        	       // bp.setCenter(gridPane3); 
	        	        bp.getChildren().add(annuler);
	        	        bp.getChildren().add(valider);
	        	        
	      //Contenu du bp1
	        	        
	        	        
	        	  	 // final Label label = new Label("Nouvelle demande:");
	        	     //   label.setFont(new Font("Arial", 20));
	        	          table.setEditable(true);
	        	         
	        	          TableColumn<employe_d, String> nom = new TableColumn<employe_d, String>("Nom");
	        	          TableColumn<employe_d, String> prenom = new TableColumn<employe_d, String>("Prénom");
	        	          TableColumn<employe_d, String> cin = new TableColumn<employe_d, String>("cin");
	        	          TableColumn<employe_d, String> emploi = new TableColumn<employe_d, String>("emploi");
	        	          TableColumn<employe_d, String> demande = new TableColumn<employe_d, String>("demande");
	        	          TableColumn<employe_d, String> date_debut= new TableColumn<employe_d, String>("date_debut");
	        	          TableColumn<employe_d, String> date_fin = new TableColumn<employe_d, String>("date_fin");
	        	          TableColumn<employe_d, String> reponse = new TableColumn<employe_d, String>("reponse");
	        	       // TableColumn<employe_d, Color> col = new TableColumn<employe_d, Color>("col");
	        	          
	        	          
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
	        	      			String sql = "select * from demande where nom=? ";
	        	      		
	        	      			 prepared=cnn.prepareStatement(sql);
	        	      			 prepared.setString(1,S_Authentifier.txtutilisateur.getText().toString());
	        	  	             res=prepared.executeQuery();
	        	      			while (res.next()) {
	        	      			     data.add(new employe_d(res.getString("nom"),res.getString("prenom"),res.getString("demande"),
	        	      			    		 res.getString("cin"),res.getString("emploi"),res.getString("date1"),res.getString("date2"),res.getString("reponse")));
	        	      			   
	        	      			}
	        	             } catch (SQLException e) {
	        	      			// TODO Auto-generated catch block
	        	      			e.printStackTrace();
	        	      		}
	        	      	  //insérer les elements dans le tableview **********************		
	        	    		nom.setCellValueFactory(new PropertyValueFactory<employe_d,String>("nom"));
	        	    		prenom.setCellValueFactory(new PropertyValueFactory<employe_d,String>("prenom"));
	        	    		demande.setCellValueFactory(new PropertyValueFactory<employe_d,String>("demande"));
	        	    		date_debut.setCellValueFactory(new PropertyValueFactory<employe_d,String>("date_debut"));
	        	    		date_fin.setCellValueFactory(new PropertyValueFactory<employe_d,String>("date_fin"));
	        	    		cin.setCellValueFactory(new PropertyValueFactory<employe_d,String>("cin"));
	        	    		emploi.setCellValueFactory(new PropertyValueFactory<employe_d,String>("emploi"));
	        	    		reponse.setCellValueFactory(new PropertyValueFactory<employe_d,String>("reponse"));
	        	    		
	        	    		table.setItems(data);
	        	    		root.setSpacing(5);
		        	   	    root1.setPadding(new Insets(10, 0, 0, 10));
		        	   	    root1.getChildren().add( table);
	        	        
	        	        
	       //Alignement compo in root
	        	         info.setFont(new Font(20));
	        	         info.setTranslateX(50);
	        			 info.setTranslateY(-146);
	        			 demand.setFont(new Font(20));
	        			 demand.setTranslateX(50);
	        			 demand.setTranslateY(-20);
	        			 demand.setFont(new Font(20));
	        			 période.setTranslateX(50);
	        			 période.setTranslateY(150);
	        	         
	        			 menu.setTranslateX(600);
	        			 menu.setTranslateY(-10);

	        			
	      //add in TabPanne 
	        			 tab1.setContent(bp); // Ajout du contenu é l'onglet 1
	        			 tab2.setContent(root1);
	        			 tabPane.getTabs().addAll(tab1, tab2);
	      //add in hbox
	        			
	        			valider.setFont(new Font(20));
	        			annuler.setFont(new Font(20));
	        			valider.setId("valider1");
	        			annuler.setId("valider1");
	        			annuler.setTranslateX(400);
	        			annuler.setTranslateY(50);
	        			valider.setTranslateX(300);
	        			/*hb.getChildren().addAll(valider,annuler);
	        			hb.setPadding(new Insets(100,0, 50, 80));*/
	        			
	        			/////**insertion d'info de la BD
	        			
	        			//comment recuperer login et passswd
	      	          String temp=S_Authentifier.txtutilisateur.getText().toString();
	     	         
	         		  String sql="select login,nom,prenom,cin,adresse,emploi from autho ";
	         		 cnn=(Connection) connecterBD.connexionBD();
	     	  
	         		  try {
	         			 
	     					 prepared=cnn.prepareStatement(sql);
	     				     res=prepared.executeQuery();
	     				    while(res.next())  
	     				       { 
	     				    	
	     				    	if(res.getString("login").equals(temp))
	     				    		
	     				            {
	     				    
	     				    		   txtNom.setText(res.getString("nom"));	
	     			                   txtPrénom.setText(res.getString("prenom"));	
	     			                   txtCin.setText(res.getString("cin"));
	     			                   txtEmploi.setText(res.getString("emploi"));
	     				           } 
	    			           }
	        		   } catch (SQLException e1) {
	    					// TODO Auto-generated catch block
	    					e1.printStackTrace();}
	        			
	        	        
	     //adding to root
	        		/*	root.getChildren().add(info);
	        			root.getChildren().add(demand);
		        	    root.getChildren().add(période);*/
	        			root.getChildren().add(menuBar);
	        			root.getChildren().add(tabPane);
	        	        
	        	
	        	        
	        	      //Adding BorderPane to the scene and loading CSS
	        	       gridPane1.setStyle("-fx-padding: 20;" + 
	        	                "-fx-border-style: solid inside;" +  
	        	                "-fx-border-width: 2;" +
	        	                "-fx-border-insets: 5;" + 
	        	                "-fx-border-radius: 10;" +
	        	                "-fx-border-color: black;");
	        	       gridPane2.setStyle("-fx-padding: 20;" + 
	        	                "-fx-border-style: solid inside;" +  
	        	                "-fx-border-width: 2;" +
	        	                "-fx-border-insets: 5;" + 
	        	                "-fx-border-radius: 10;" +
	        	                //"-fx-background-color:  linear-gradient(bisque,moccasin);"+
	        	                "-fx-border-color: black;");
	        	       gridPane3.setStyle("-fx-padding: 40;" + 
	        	                "-fx-border-style: solid inside;" +  
	        	                "-fx-border-width: 2;" +
	        	                "-fx-border-insets: 3;" + 
	        	                "-fx-border-radius: 10;" +
	        	               // "-fx-background-color:  linear-gradient(bisque,moccasin);"+
	        	                "-fx-border-color: black;");
	        	     //  root.setStyle("-fx-background-color:  linear-gradient(lightgrey,lightgrey);");
	        	       menu.setStyle(  
	        	                "-fx-border-width: 1;" +
	        	                "-fx-border-insets: 2;" + 
	        	                "-fx-border-radius: 10;" +
	        	               "-fx-background-color:  linear-gradient(darkgray,darkgray);"+
	        	                "-fx-border-color: black;");
	        	     p.setStyle("-fx-background-color:  linear-gradient(lightgray,lightgray);");
	        	      
 
	        	       
	        	       //Action of Button menu
	  					 menu.setOnAction(new EventHandler<ActionEvent>() {
	  					

	  						@Override
	  						public void handle(ActionEvent arg0) {
	  							// TODO Auto-generated method stub
	  							//utilser n'importe quel composant annoté par @FXML pour obtenir la scene puis le stage:
	  					        Stage stage = (Stage)menu.getScene().getWindow();// je crée un nouveau stage
	  					        primaryStage.close(); //je ferme mon premier stage 
	  							
	  						} });
	  					//Action of Button annuler
	  					 annuler.setOnAction(new EventHandler<ActionEvent>() {
	  					

	  						@Override
	  						public void handle(ActionEvent arg0) {
	  							// TODO Auto-generated method stub
	  							primaryStage.close();
	  						} });
	  					//Action of Button valider 
	  					valider.setOnAction(new EventHandler<ActionEvent>() {
	  						public void handle(ActionEvent actionEvent)
	  						{ 
	  						//Activer boutton Valider *****
	  							 Alert  dialogC= new Alert(AlertType.CONFIRMATION);
		    					 dialogC.setTitle("Confirmer la demande");
		    					 dialogC.setHeaderText(null);
		    					 dialogC.setContentText("Voulez vous envoyer cette demande ? ");
		    					 Optional<ButtonType> answer= dialogC.showAndWait();
		    					 if(answer.get() == ButtonType.OK){
		    					
	  		  					 
 
	  			  		    		  
	  			  					     String sql1="insert into demande values (null,?,?,?,?,?,'en cours',?,?)";
	  			  					     
	  			  					     try {
	  			  					      cnn=(Connection) connecterBD.connexionBD();
	  										prepared=cnn.prepareStatement(sql1);
	  										prepared.setString(1,txtNom.getText().toString() );
	  										prepared.setString(2,txtPrénom.getText().toString() );
	  										prepared.setString(3,selectionner.getSelectionModel().getSelectedItem().toString());
	  										prepared.setString(4, cal.getValue().toString());
	  										prepared.setString(5, cal2.getValue().toString());
	  										prepared.setString(6, txtCin.getText().toString());
	  										prepared.setString(7, txtEmploi.getText().toString());
	  										
	  										
	  										
	  										prepared.execute();
	  									} catch (SQLException e) {
	  										// TODO Auto-generated catch block
	  										e.printStackTrace();
	  									}
		    					 }
	  			  				///
	  			  					  
	  			   							
	  			   						
	  						/*	txtNom.setText("");
	  							txtPrénom.setText("");
	  							cal.setAccessibleText("");*/
	  						}
	  						
	  						
	  					});
	        	       
        	       
	        	        
	       //add in frame
	  				  scene.getStylesheets().add("application/application.css");
	        	
               // Scene scene = new Scene(root,880,425);
                primaryStage.setScene(scene);
	            //primaryStage.setResizable(false);
	            primaryStage.show();
	           }
	public static void main(String []args)
	{
		launch(args);
	}
	        
		
	}


