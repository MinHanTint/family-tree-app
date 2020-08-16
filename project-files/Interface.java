/*
Title: Assignment 2 Interface class
Author: Min Han Tint
Date: 27/07/2019
Filename: Interface.java
Purpose: This is a main class and user interface class for this program. This class contains functions to generate user interface to create family tree application. It will store and display the 
        the root member of the family and his relatvie with tree structure by using the instances of the other classes
Assumption: The user is going to input the data via the user interface created for family tree. All the data will be stored and displayed clearly for the user with a list of functions of this class.
        The user can create, save and load the family tree with the buttons provided and also can add relatives to the family member
*/
package assignment2;
//list of imports
import java.io.*;
import java.util.*;
import javafx.application.Application; 
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interface extends Application //this class extends java application class to execute application-specific code and use the framework for javaFx
{
    public static void main(String[] args)//main methods to launch the application
    {
        Application.launch(args);
        
    }
    
    //declare variables
    private Stage window;
    private Address address = new Address();
    private Member member = new Member();
    private Family family = new Family();
    
    Label heading = new Label("Family Tree Application");//label for heading of the application
    
    //create view and edit buttons
    Button view = new Button("View Mode");
    Button edit = new Button("Edit Mode");
    HBox mode = new HBox(view, edit); //horizontal box for view and edit buttons
    
    //buttons to create,save and load family tree
    Button create = new Button("Create New Family Tree");
    Button save = new Button("Save Family Tree");
    Button load = new Button("Load Family Tree");
    VBox viewB = new VBox(create, save, load); //horizontal box for buttons
    
    //create buttons to add family members
    Button addFather = new Button("Add Father");
    Button addMother = new Button("Add Mother");
    Button addSpouse = new Button("Add Spouse");
    Button addChild = new Button("Add Child");
    Button update = new Button("Update Info");//button to update member info
    //VBox updateB = new VBox(update);//vertical box for update button
    VBox addMember = new VBox(addFather, addMother, addSpouse, addChild, update);//vertical box for add relatvie buttons
    
    //create tree view for family members
    Label memberL = new Label("Member");
    TreeItem rootTI = new TreeItem("Create new or Load existing family!");//store as an item in tree
    TreeView<String> tView = new TreeView<String>();//to display treeview
    ScrollPane treeSP = new ScrollPane();//make scrollable view for tree
    VBox treeVB = new VBox(tView);
    VBox memberVB = new VBox(memberL, treeVB);
    
    //create personal inputs for user
    Label personal = new Label("Personal");
    HBox personalB = new HBox(personal);
    Label fNameL = new Label("First Name:");
    TextField fNameText = new TextField();
    Label sNameL = new Label("Surname:");
    TextField sNameText = new TextField();
    Label aftSNameL = new Label("Surname(After Marriage):");
    TextField aftSNameText = new TextField();
    Label genderL = new Label("Gender:");
    ChoiceBox genderText = new ChoiceBox();
    Label lifeDescL = new Label("Life Description:");
    TextField lifeDescText = new TextField();
    
    //create address inputs
    Label addressL = new Label("Address");
    HBox addressB = new HBox(addressL);
    Label stNumberL = new Label("Street Number:");
    TextField stNumberText = new TextField();
    Label stNameL = new Label("Street Name:");
    TextField stNameText = new TextField();
    Label suburbL = new Label("Suburb:");
    TextField suburbText = new TextField();
    Label postcodeL = new Label("Postcode:");
    TextField postcodeText = new TextField();
    
    //create relative inputs
    Label relative = new Label("Relative");
    HBox relativeB = new HBox(relative);
    Label fatherL = new Label("Father:");
    TextField fatherText = new TextField();
    Label motherL = new Label("Mother:");
    TextField motherText = new TextField();
    Label spouseL = new Label("Spouse:");
    TextField spouseText = new TextField();
    Label childrenL = new Label("Children:");
    TextField childrenText = new TextField();
    Label grandChildrenL = new Label("Grand children:");
    TextField grandChildrenText = new TextField();
    
    //create vertical box for user inputs labels
    VBox personalLV = new VBox(fNameL, sNameL, aftSNameL, genderL, lifeDescL);
    VBox addressLV = new VBox(stNumberL, stNameL, suburbL, postcodeL);
    VBox relativeLV = new VBox(fatherL, motherL, spouseL, childrenL, grandChildrenL);
    
    //create vertical box for user inputs textfield
    VBox personalTV = new VBox(fNameText, sNameText, aftSNameText, genderText, lifeDescText);
    VBox addressTV = new VBox(stNumberText, stNameText, suburbText, postcodeText);
    VBox relativeTV = new VBox(fatherText, motherText, spouseText, childrenText, grandChildrenText);
    
    //create horizontal box for user inputs vertical boxes
    HBox personalH = new HBox(personalLV, personalTV);
    HBox addressH = new HBox(addressLV, addressTV);
    HBox relativeH = new HBox(relativeLV, relativeTV);
    VBox personalVB = new VBox(personal, personalH);
    VBox addressVB = new VBox(addressL, addressH);
    VBox relativeVB = new VBox(relative, relativeH);
    VBox leftVB = new VBox(personalVB, addressVB);
    
    VBox rightVB = new VBox(relativeVB, addMember);
    
    //create vertical box and horizontal box for all created boxes
    HBox info1B = new HBox(leftVB, rightVB);
    //VBox info2B = new VBox(info1B, updateB);
    HBox topB = new HBox(memberVB, viewB);
    HBox btmB = new HBox(info1B, addMember);
    //VBox familyB = new VBox(memberVB, infoB);
    //HBox allHB = new HBox(familyB, addMember);
    VBox allB = new VBox(heading, mode, topB, btmB);
    Scene s1 = new Scene(allB, 800, 900);
    
    //create new window for adding member
    Label newL = new Label();
    GridPane addMemberG = new GridPane();
    Label addFNameL = new Label("First Name:");
    TextField addFNameText = new TextField();
    Label addSNameL = new Label("Surname:");
    TextField addSNameText = new TextField();
    Label addAftSNameL = new Label("Surname(After marriage):");
    TextField addAftSNameText = new TextField();
    Label addGenderL = new Label("Gender:");
    ChoiceBox addGenderText = new ChoiceBox();
    Label addLifeDescL = new Label("Life Description:");
    TextField addLifeDescText = new TextField();
    Label addStNumberL = new Label("Street Number;");
    TextField addStNumberText = new TextField();
    Label addStNameL = new Label("Street Name:");
    TextField addStNameText = new TextField();
    Label addSuburbL = new Label("Suburb:");
    TextField addSuburbText = new TextField();
    Label addPostcodeL = new Label("Postcode:");
    TextField addPostcodeText = new TextField();
    
    Button confirmB = new Button("Confirm");
    StackPane addMemberSP = new StackPane(confirmB);
    VBox addMemberV = new VBox(newL, addMemberG, addMemberSP);
    Stage newWindow = new Stage();
    Scene newScene = new Scene(addMemberV, 370, 370);
    
    //save family tree
    Label saveFile = new Label("Filename: ");
    TextField saveFileText = new TextField();
    Button saveFileB = new Button("Save");
    StackPane saveFileSP = new StackPane(saveFileB);
    VBox saveFileVB = new VBox(saveFile, saveFileText, saveFileSP);
    Stage saveWindow = new Stage();
    Scene saveScene = new Scene(saveFileVB, 300,100);
    
    //method to set up font style for interface
    public void designFont()
    {
        //set the font for all labels as Helvetica with suitable size
        heading.setFont(new Font("Helvetica",36));
        memberL.setFont(Font.font("Helvetica",FontWeight.BOLD,20));
        personal.setFont(Font.font("Helvetica",FontWeight.BOLD,20));
        fNameL.setFont(Font.font("Helvetica",14));
        sNameL.setFont(Font.font("Helvetica",14));
        aftSNameL.setFont(Font.font("Helvetica",14));
        genderL.setFont(Font.font("Helvetica",14));
        lifeDescL.setFont(Font.font("Helvetica",14));
        genderText.getItems().add("Male");
        genderText.getItems().add("Female");
        genderText.getSelectionModel().selectFirst();
        lifeDescText.setPrefWidth(20);
        addressL.setFont(Font.font("Helvetica",FontWeight.BOLD,20));
        stNumberL.setFont(Font.font("Helvetica",14));
        stNameL.setFont(Font.font("Helvetica",14));
        suburbL.setFont(Font.font("Helvetica",14));
        postcodeL.setFont(Font.font("Helvetica",14));
        relative.setFont(Font.font("Helvetica",FontWeight.BOLD,20));
        fatherL.setFont(Font.font("Helvetica",14));
        motherL.setFont(Font.font("Helvetica",14));
        spouseL.setFont(Font.font("Helvetica",14));
        childrenL.setFont(Font.font("Helvetica",14));
        grandChildrenL.setFont(Font.font("Helvetica",14));
    }
    
    //method to make adjustments to the size and location of the boxes
    public void designCss()
    {
        //set the width and height of the label and textfields
        memberVB.setPrefHeight(400);
        memberVB.setPrefWidth(600);
        memberVB.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" +
                    "-fx-border-width: 1;" + "-fx-border-insets: 5;" +
                    "-fx-border-color: black;");
        viewB.setStyle("-fx-padding: 5;");
        addMember.setStyle("-fx-padding: 5;");
        rightVB.setPadding(new Insets(0,10,0,0));
        personalH.setSpacing(30);
        addressH.setSpacing(30);
        relativeH.setSpacing(30);
        personalLV.setPrefHeight(70);
        addressLV.setPrefHeight(70);
        relativeLV.setPrefHeight(70);
        personalLV.setPrefWidth(160);
        addressLV.setPrefWidth(160);
        relativeLV.setPrefWidth(160);
        personalLV.setSpacing(17);
        addressLV.setSpacing(17);
        relativeLV.setSpacing(17);
        personalTV.setPrefHeight(50);
        addressTV.setPrefHeight(50);
        relativeTV.setPrefHeight(50);
        personalTV.setPrefWidth(150);
        addressTV.setPrefWidth(150);
        relativeTV.setPrefWidth(150);
        personalTV.setSpacing(5);
        addressTV.setSpacing(5);
        relativeTV.setSpacing(5);
        info1B.setPrefHeight(300);
        info1B.setPrefWidth(600);
        info1B.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + 
                    "-fx-border-width: 1;" +"-fx-border-insets: 5;" +
                    "-fx-border-color: black;"); 
        info1B.setSpacing(10);
        viewB.setSpacing(5);
        addMember.setSpacing(5);
    }
    
    //method to design for adding new member window
    public void designNewWindow()
    {
        //place the label and textfields in correct order
        addMemberG.add(addFNameL, 0, 0);
        addMemberG.add(addFNameText, 2, 0);
        addMemberG.add(addSNameL, 0, 1);
        addMemberG.add(addSNameText, 2, 1);
        addMemberG.add(addAftSNameL, 0, 2);
        addMemberG.add(addAftSNameText, 2, 2);
        addMemberG.add(addGenderL, 0, 3);
        addMemberG.add(addGenderText, 2, 3);
        addMemberG.add(addLifeDescL, 0, 5);
        addMemberG.add(addLifeDescText, 2, 5);
        addMemberG.add(addStNumberL, 0, 6);
        addMemberG.add(addStNumberText, 2, 6);
        addMemberG.add(addStNameL, 0, 7);
        addMemberG.add(addStNameText, 2, 7);
        addMemberG.add(addSuburbL, 0, 8);
        addMemberG.add(addSuburbText, 2, 8);
        addMemberG.add(addPostcodeL, 0, 9);
        addMemberG.add(addPostcodeText, 2, 9);
        addMemberG.setPadding(new Insets(5,5,5,5));
        addGenderText.getItems().add("Male");
        addGenderText.getItems().add("Female");
        addGenderText.getSelectionModel().selectFirst();
        addMemberSP.setPadding(new Insets(5,5,5,5));
    }
    
    //method to start user interface
    @Override
    public void start(Stage stage)throws Exception
    {
        stage.setTitle("Family Tree Application"); 
        //call the methods to design interface
        designFont(); 
        designCss();
        designNewWindow();
        
        //set up as tree view and tree item
        tView.setRoot(rootTI);
        treeSP.setContent(tView);
        
        //set up modality and owner set for new window 
        newWindow.setScene(newScene);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(window);
     
        //save pop-up window
        saveWindow.setTitle("Save Family Tree");
        saveWindow.setScene(saveScene);
        
        //set actions on button click
        create.setOnAction(e ->  //create button
        {
            addMember("Root");
            switchView(true);
        });
        save.setOnAction(e ->   //save button
        {
            saveFTWin();
            switchView(true);
        });
        load.setOnAction(e ->   //load button
        {
            loadFT();
            switchView(true);
        });
        addFather.setOnAction(e ->{addMember("Father");}); //add father button
        addMother.setOnAction(e ->{addMember("Mother");}); //add mother button
        addSpouse.setOnAction(e ->{addMember("Spouse");}); //add spouse button
        addChild.setOnAction(e ->{addMember("Child");}); //add child button  
        update.setOnAction(e ->{updateM();}); //update member information button
        edit.setDisable(true); //disable to edit button
        view.setOnAction(e ->{switchView(true);}); //viewbutton
        edit.setOnAction(e ->{switchView(false);}); //edit button
        
        //set up interface for application
        stage.setScene(s1);
        stage.setResizable(true);
        this.window=stage;
        stage.show();
    }
    
    //method to save family tree with 1 argument
    public void saveFT(String sf)
    {
        if(sf.trim().equals(""))//if there is no input
        {
            Alert inputError = new Alert(AlertType.INFORMATION); //display error
            inputError.setContentText("Please enter a filename!");
            inputError.showAndWait();
        }
        else    
        {
            //declear variables for file and object output stream
            String filename = sf;
            FileOutputStream fileOut; 
            ObjectOutputStream objOut;
            try
            {
                File dir = new File("Family Tree"); //create new file
                if(!dir.exists()) //if file directory doesn't exist
                {
                    if(dir.mkdir())
                    {
                        
                    }
                }
                else//directory already exists
                {
                    
                }
                fileOut = new FileOutputStream("Family Tree/" + filename + ".ftree");//save the output file in created file directory with .ftree extension
                objOut = new ObjectOutputStream(fileOut);
                objOut.writeObject(family);
                Alert saveInfo = new Alert(AlertType.INFORMATION); //diplay information after file is created
                saveInfo.setContentText("File is created in local directory!");
                saveInfo.showAndWait();
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File not found!");
            }
            catch(IOException io)
            {
                System.out.println("Error in file!");
            }
            saveWindow.close(); //close window for save function
            saveFileText.setText("");
        }
    }
    
    //method to save family tree window
    public void saveFTWin()
    {
        if(family.getRootMember().getFName() != "") //if root member exists
        {
            saveWindow.show(); //show save window
            saveFileB.setOnAction(e -> //when click, get the file name and use it to save
            {
                String filename = saveFileText.getText();
                saveFT(filename);
            });
        }
        else
        {
            Alert inputError = new Alert(AlertType.INFORMATION); //display errro message
            inputError.setContentText("Nothing to save!");
            inputError.showAndWait();
        }
    }
    
    //method to load family tree
    public void loadFT()
    {
        //declear variables for file and object input stream
        String filename;
        FileInputStream fileInput;
        ObjectInputStream objectInput;
        FileChooser chfile = new FileChooser(); //create new file chooser
        chfile.setInitialDirectory(new File(System.getProperty("user.dir")+"/Family Tree")); //set initial directory for file chooser
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Family Tree","ftree"); //set the default filter to .ftree
        chfile.setSelectedExtensionFilter(filter); //set the filter
        File selFile = chfile.showOpenDialog(window); //display diaglog
        filename = selFile.getPath(); //get the file path
        try
        {
            fileInput = new FileInputStream(filename);
            objectInput = new ObjectInputStream(fileInput);
            family = (Family)objectInput.readObject();//read the input object with family instance
            updateFT(); //call method to update family tree
            objectInput.close(); //close input object
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch(IOException io)
        {
            Alert error = new Alert(AlertType.INFORMATION);//display error message
            error.setContentText("Cannot load family tree!");
            error.showAndWait();
            
        }
        catch(ClassNotFoundException ce)
        {
           System.out.println("Class not found");
        }
    }
    
    //method to set disable to textfield with 1 argument
    public void setDis(boolean flag)
    {
        fNameText.setDisable(flag);
        sNameText.setDisable(flag);
        aftSNameText.setDisable(flag);
        genderText.setDisable(flag);
        lifeDescText.setDisable(flag);
        stNumberText.setDisable(flag);
        stNameText.setDisable(flag);
        suburbText.setDisable(flag);
        postcodeText.setDisable(flag);
        fatherText.setDisable(flag);
        motherText.setDisable(flag);
        spouseText.setDisable(flag);
        childrenText.setDisable(flag);
        grandChildrenText.setDisable(flag);
        addFather.setDisable(flag);
        addMother.setDisable(flag);
        addSpouse.setDisable(flag);
        addChild.setDisable(flag);
        update.setDisable(flag);
    }
    
    //method to disable suitable textfield and buttons when switching modes
    public void switchView(boolean vFlag)
    {
        if(vFlag)
        {
            vFlag = true;
            create.setDisable(false);
            save.setDisable(false);
            load.setDisable(false);
            view.setDisable(true);
            edit.setDisable(false);
            setDis(vFlag);
        }
        else
        {
            setDis(!vFlag);
            vFlag = false;
            create.setDisable(true);
            save.setDisable(true);
            load.setDisable(true);
            view.setDisable(false);
            edit.setDisable(true);
            setDis(vFlag);
        }
    }
    
    //method to check the user input whether it is empty
    public boolean inputCheck()
    {
        if(addFNameText.getText().trim().equals(""))
        {
            return false;
        }
        if(addSNameText.getText().trim().equals(""))
        {
            return false;
        }
        if(addStNumberText.getText().trim().equals(""))
        {
            return false;
        }
        if(addStNameText.getText().trim().equals(""))
        {
            return false;
        }
        if(addSuburbText.getText().trim().equals(""))
        {
            return false;
        }
        if(addPostcodeText.getText().trim().equals(""))
        {
            return false;
        }
        for(int i = 0; i < family.familyList.size(); i++)//loop through family list
        {
            String tempGet = family.familyList.get(i).getFName()+ " " + family.familyList.get(i).getSName(); //get the name of family member
            String tempSearch = addFNameText.getText().trim() + " " + addSNameText.getText().trim(); //get the user input
            if(tempGet.equals(tempSearch)) //if user input is same as person existed
            {
                return false;
            }
        }
        return !addLifeDescText.getText().trim().equals("");
    }
    
    //methods to check the text field 
    public boolean textFieldCheck()
    {
        if(fNameText.getText().trim().equals(""))
        {
            return false;
        }
        if(sNameText.getText().trim().equals(""))
        {
            return false;
        }
        if(aftSNameText.getText().trim().equals(""))
        {
            return false;
        }
        if(genderText.getValue().toString().trim().equals(""))
        {
            return false;
        }
        if(lifeDescText.getText().trim().equals(""))
        {
            return false;
        }
        if(stNumberText.getText().trim().equals(""))
        {
            return false;
        }
        if(stNameText.getText().trim().equals(""))
        {
            return false;
        }
        if(suburbText.getText().trim().equals(""))
        {
            return false;
        }
        return !postcodeText.getText().trim().equals("");
    }
    
    //methods to update family tree
    public void updateFT()
    {
        tView = null; 
        tView = new TreeView(); // create new tree view
        TreeItem rootTITI = new TreeItem(family.getRootMember().getFName()+ " " + family.getRootMember().getSName());//call the root member
        tView.setRoot(rootTITI); //set root member as root of family tree
        Member mainM = family.getRootMember(); //call the root member in the family
        if(mainM.getMother() != null || mainM.getFather() != null)//if father and mother of root member exists
        {
            TreeItem mainMParents = new TreeItem("Parents"); //create tree items for parents
            //get the name of father and mother
            if(mainM.getFather() != null)
            {
                mainMParents.getChildren().add(new TreeItem(mainM.getFather().getFName()+ " " + mainM.getFather().getSName()));
            }
            if(mainM.getMother() != null)
            {
                mainMParents.getChildren().add(new TreeItem(mainM.getMother().getFName()+ " " + mainM.getMother().getSName()));
            }
            rootTITI.getChildren().add(mainMParents);//add father and mother to tree
        }
        updateSpouse(mainM, rootTITI); //call method to update spouse
        updateChildren(mainM, rootTITI); //call method to update children
        treeVB.getChildren().set(0, tView); //set children in family tree 
        tView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updatePanel(newValue)); //make tree view to act according to update panel
    }
    
    //methods to update spouse with 2 arguments
    public void updateSpouse(Member m, TreeItem t)
    {
        if(m.getSpouse()!=null) //if spouse exists
        {
            //get the details for the spouse and add it to treeview
            TreeItem spouseTI = new TreeItem("Spouse");
            spouseTI.getChildren().add(new TreeItem(m.getSpouse().getFName()+ " " + m.getSpouse().getSName()));
            t.getChildren().add(spouseTI);
        }
    }
    
    //methods to update children with 2 arguments
    public void updateChildren(Member m, TreeItem t)
    {
        if(m.getChildren().size()>0) //if child exists
        {
            TreeItem childTI = new TreeItem("Children"); //create new tree item for child
            t.getChildren().add(childTI); //add child tree item to tree view
            for(int i = 0; i < m.getChildren().size(); i++) //loop through list of children
            {
                //get the detials for the child and his relationship to other members
                TreeItem child = new TreeItem(m.getChildren().get(i).getFName()+ " " + m.getChildren().get(i).getSName());
                childTI.getChildren().add(child);
                if(m.getChildren().get(i).getChildren().size()>0 || m.getChildren().get(i).getSpouse()!=null)
                {
                    Member current = m.getChildren().get(i);
                    updateChildren(current, child);
                }
            }
        }
    }
    
    //methods to update panel for family tree with 1 argument
    public void updatePanel(TreeItem t)
    {
        String selectedName = t.getValue().toString();//get the value of selected member
        Address a = new Address();
        Member m = new Member();
        for(int i = 0; i < family.familyList.size(); i++) //loop through the family list
        {
            String search = family.familyList.get(i).getFName()+ " " + family.familyList.get(i).getSName(); //get the member name
            if(search.equals(selectedName)) //if names are the same
            {
                m = family.familyList.get(i);//choose the current member
            }
        }
        //set the details of the member in text field
        fNameText.setText(m.getFName());
        sNameText.setText(m.getSName());
        aftSNameText.setText(m.getAftSName());
        if(m.getGender().equals("Male"))
        {
            genderText.getSelectionModel().select(0);
        }
        else
        {
            genderText.getSelectionModel().select(1);
        }
        lifeDescText.setText(m.getLifeDesc());
        stNumberText.setText(m.getAddress().getStNumber());
        stNameText.setText(m.getAddress().getStName());
        suburbText.setText(m.getAddress().getSuburb());
        postcodeText.setText(m.getAddress().getPostcode());
        if(m.getFather()!=null) //if father exists
        {
            fatherText.setText(m.getFather().getFName()+ " " + m.getFather().getSName());
        }
        else
        {
            fatherText.setText("NA");
        }
        if(m.getMother()!=null)//if mother exists
        {
            motherText.setText(m.getMother().getFName()+ " " + m.getMother().getSName());
        }
        else
        {
            motherText.setText("NA");
        }
        if(m.getSpouse()!=null)//if spouse exists
        {
            spouseText.setText(m.getSpouse().getFName()+ " " + m.getSpouse().getSName());
        }
        else
        {
            spouseText.setText("NA");
        }
        if(m.getChildren()!=null)//if children exists
        {
            String child = "";
            String gChild = "";
            for(int i = 0; i<m.getChildren().size();i++)//loop through the list of children
            {
                child += m.getChildren().get(i).getFName() + ",";
                if(m.getChildren().get(i).getChildren().size() > 0) //if child has children
                {
                    for(int j=0; j<m.getChildren().get(i).getChildren().size(); j++)//loop thought the children list of the child
                    {
                        gChild += m.getChildren().get(i).getChildren().get(j).getFName() + ",";
                    }
                        
                }
                else
                {
                    grandChildrenText.setText("NA");
                }
                
            }
            //set the name for children and grand children text field
            childrenText.setText(child); 
            grandChildrenText.setText(gChild);
        }
        else
        {
            childrenText.setText("NA");
            grandChildrenText.setText("NA");
        }
    }
    
    //method to create text of the text field
    public void clearText()
    {
        addFNameText.clear();
        addSNameText.clear();
        addAftSNameText.clear();
        addGenderText.getSelectionModel().selectFirst();
        addLifeDescText.clear();
        addStNumberText.clear();
        addStNameText.clear();
        addSuburbText.clear();
        addPostcodeText.clear();
    }
    
    
    
    //method to add member to family tree with 1 argument
    public void addMember(String t)
    {
        clearText();
        newL.setText("Add " + t);
        newL.setFont(Font.font("Helvetica",FontWeight.BOLD,18));
        newWindow.setTitle("Add " + t);
        confirmB.setOnAction(e -> saveMember(t));
        newWindow.setResizable(false);
        newWindow.show();
    }
    
    //method to save new member with 1 argument
    public void saveMember(String type)
    {
        if(inputCheck())//if 
        {
            try
            {
                Address newAdd = new Address(addStNumberText.getText(), addStNameText.getText(), addSuburbText.getText(), addPostcodeText.getText());
                Member newM = new Member(addFNameText.getText(), addSNameText.getText(), addAftSNameText.getText(), addGenderText.getValue().toString(), addLifeDescText.getText(), newAdd);
                if(type.equals("Root")) //if member is root
                {
                    family = null;
                    family = new Family(newM); //create new family tree
                    family.familyList.add(newM); //add the new member to family list
                }
                else
                {
                    TreeItem selected = tView.getSelectionModel().getSelectedItem(); //choose the current selected item in tree
                    if(selected == null || selected == tView.getRoot()) //if there is nothing or root is selected
                    {
                        family.addRootMember(newM, type); //add the new member as root member family
                    }
                    else
                    {
                        Object value = selected.getValue();
                        String search = value.toString(); //get the value of selected person
                        family.addNewMember(newM, type, search); //add the new member as relative
                    }
                }
                newWindow.close(); //close new add member window
                updateFT(); //call the method to update family tree
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            Alert error = new Alert(AlertType.INFORMATION); //display error message
            error.setContentText("Please input all data or the person is already existed!");
            error.showAndWait();
        }
    }
    
    //method to update member
    public void updateM()
    {
        TreeItem selected = tView.getSelectionModel().getSelectedItem(); //get the selected item in tree
        String get = selected.getValue().toString(); //get the value of selected item
        if(textFieldCheck()) //call method to check text field
        {
            try
            {
                for(int i = 0; i < family.familyList.size(); i++) //loop through family list
                {
                    String person = family.familyList.get(i).getFName() + " " + family.familyList.get(i).getSName(); //get the person name
                    if(person.equals(get))//if the names are the same
                    {
                        //get the details of the person
                        family.familyList.get(i).setFName(fNameText.getText());
                        family.familyList.get(i).setSName(sNameText.getText());
                        family.familyList.get(i).setAftSName(aftSNameText.getText());
                        family.familyList.get(i).setGender(genderText.getValue().toString());
                        family.familyList.get(i).setLifeDesc(lifeDescText.getText());
                        family.familyList.get(i).getAddress().setStNumber(stNumberText.getText());
                        family.familyList.get(i).getAddress().setStName(stNameText.getText());
                        family.familyList.get(i).getAddress().setSuburb(suburbText.getText());
                        family.familyList.get(i).getAddress().setPostcode(postcodeText.getText());
                    }
                }
                updateFT();//call method to update tree
            }
            catch(Exception e)
            {
                Alert error = new Alert(AlertType.INFORMATION);//display error message
                error.setContentText("Input data correctly!");
                error.showAndWait();
            }
        }
    }
}

