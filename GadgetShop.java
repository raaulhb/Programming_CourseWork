/*The GadgetShop class represents the main application of the Gadget Shop.
 *It extends the javafx Application class and 
 *implements EventHandler to handle button interactions from the GUI.
 *
 *It provides functionality to add new Gadgets,
 *Stores the Gadgets into an ArrayList,
 *
 *It allow the user to interact with the Gadgets such as: 
 *making Phone calls, manage mobile credit, upload and delete mp3Files.
 *
 *All interactions and results are displayed in the LogArea.
 * 
 * @author Raul Barros
 * @version 1.0 2026
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class GadgetShop extends Application implements EventHandler<ActionEvent>{
    //mobile
    private final TextField mobileModelField = new TextField();
    private final TextField mobilePriceField = new TextField();
    private final TextField mobileWeightField = new TextField();
    private final TextField mobileSizeField = new TextField();
    private final TextField initalCreditField = new TextField();
    private final TextField phoneNumberField = new TextField();
    private final TextField durationOfCallField = new TextField();
    private final TextField addCreditField = new TextField();
    private final TextField selectedIndexField = new TextField();

    private Button addMobileButton = new Button("Add Mobile");
    private Button mobileButton = new Button("Mobile");
    private Button makePhoneCallButton = new Button("Make Phone Call");
    private Button addCreditButton = new Button("Add credit");
    private Button selectedIndexInfoButton = new Button ("Display Info");

    //mp3
    private final TextField mp3ModelField = new TextField();
    private final TextField mp3PriceField = new TextField();
    private final TextField mp3WeightField = new TextField();
    private final TextField mp3SizeField = new TextField();
    private final TextField memoryField = new TextField();
    private final TextField mp3FileField = new TextField();
    private final TextField mp3selectedIndexField = new TextField();

    private Button addMp3Button = new Button("Add Mp3");
    private Button mp3Button = new Button("MP3");
    private Button addMp3FileButton = new Button("Add File");
    private Button deleteMp3FileButton = new Button("Delete File");
    private Button mp3selectedIndexInfoButton = new Button("Display Info");

    //LogArea
    private final TextArea logArea = new TextArea();
    private final ArrayList<Gadget> gadgets = new ArrayList<Gadget>();

    //General Buttons
    private Button displayAllButton = new Button("Display all Gadgets");
    private Button exitButton = new Button("Exit");

    //Views
    private VBox mobileView;
    private VBox mp3View;

    @Override
    public void start(Stage stage) 
    {
        //mobile Labels
        Label mobileModelLabel = new Label("Model:");
        Label mobilePriceLabel = new Label("Gadget price:");
        Label mobileSizeLabel = new Label("Gadget size (cm):");
        Label mobileWeightLabel = new Label("Gadget weight:");
        Label initialCreditLabel = new Label("Initial Credit: ");
        Label phoneNumberLabel = new Label("Enter a Phone number to make a call:");
        Label durationOfCallLabel = new Label("Enter the duration of the call:");
        Label addCreditLabel = new Label("Enter how much credit you'd like to add:");
        Label selectedIndexLabel = new Label("Select mobile index to see information");

        //mp3 Labels
        Label mp3ModelLabel = new Label("Model:");
        Label mp3PriceLabel = new Label("Gadget price:");
        Label mp3SizeLabel = new Label("Gadget size(cm):");
        Label mp3WeightLabel = new Label("Gadget weight:");
        Label memoryLabel = new Label("Number of initial memory:");
        Label mp3FileLabel = new Label("Enter the size of your mp3 File");
        Label mp3selectedIndexLabel = new Label("Select mp3 index to see information.");

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        //Horizontal Mobile Buttons
        HBox horizontalMobileButtons = new HBox(10);
        horizontalMobileButtons.getChildren().addAll(addMobileButton,
            makePhoneCallButton);

        //Mobile View
        mobileView = new VBox();
        mobileView.setSpacing(1);
        mobileView.getChildren().addAll(
            mobileModelLabel,
            mobileModelField,
            mobilePriceLabel,
            mobilePriceField,
            mobileSizeLabel,
            mobileSizeField,
            mobileWeightLabel,
            mobileWeightField,
            initialCreditLabel,
            initalCreditField,
            phoneNumberLabel,
            phoneNumberField,
            durationOfCallLabel,
            durationOfCallField,
            horizontalMobileButtons,
            addCreditLabel,
            addCreditField,
            addCreditButton,
            selectedIndexLabel,
            selectedIndexField,
            selectedIndexInfoButton
        );

        //Mp3 Horizontal mp3Buttons
        HBox mp3FileButtons = new HBox(10);
        mp3FileButtons.getChildren().addAll(addMp3FileButton,
            deleteMp3FileButton);

        //Mp3 View
        mp3View = new VBox();
        mp3View.setSpacing(1);
        mp3View.getChildren().addAll(
            mp3ModelLabel,
            mp3ModelField,
            mp3PriceLabel,
            mp3PriceField,
            mp3SizeLabel,
            mp3SizeField,
            mp3WeightLabel,
            mp3WeightField,
            memoryLabel,
            memoryField,
            addMp3Button,
            mp3FileLabel,
            mp3FileField,
            mp3FileButtons,
            mp3selectedIndexLabel,
            mp3selectedIndexField,
            mp3selectedIndexInfoButton
        );

        //General Horizontal Buttons
        HBox buttonRow = new HBox();
        buttonRow.setSpacing(1);
        buttonRow.getChildren().addAll(
            mobileButton,
            mp3Button,
            displayAllButton
        );

        StackPane mainArea = new StackPane();
        mainArea.getChildren().addAll(
            mobileView,
            mp3View
        ); 

        mobileView.setVisible(true);
        mp3View.setVisible(true);

        TextArea textArea = new TextArea();
        textArea.setPrefWidth(300);
        textArea.setPrefHeight(200);

        //Mobile and Mp3 Tabs
        Tab mobileTab = new Tab("MOBILE");
        mobileTab.setContent(mobileView);
        mobileTab.setClosable(false);

        Tab mp3Tab = new Tab("MP3");
        mp3Tab.setContent(mp3View);
        mp3Tab.setClosable(false);

        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(
            mobileTab,
            mp3Tab
        );
        //setOnAction General Buttons
        displayAllButton.setOnAction(this);
        exitButton.setOnAction(this);

        //setOnAction Mobile Buttons
        mobileButton.setOnAction(this);
        addMobileButton.setOnAction(this);
        makePhoneCallButton.setOnAction(this);
        addCreditButton.setOnAction(this);
        selectedIndexInfoButton.setOnAction(this);

        //setOnAction Mp3 Buttons
        mp3Button.setOnAction(this);
        addMp3Button.setOnAction(this);
        addMp3FileButton.setOnAction(this);
        deleteMp3FileButton.setOnAction(this);
        mp3selectedIndexInfoButton.setOnAction(this);

        //Horizontal General Buttons
        HBox generalButtons = new HBox(10);
        generalButtons.getChildren().addAll(exitButton,
            displayAllButton);

        //mainContainer
        root.getChildren().addAll(
            tabPane,
            generalButtons,
            logArea
        );

        Scene scene = new Scene(root, 700, 500);
        stage.setTitle("GadgetShop");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent e)
    {
        if (e.getSource() == addMp3Button)
        {
            addMp3ButtonResponse();
        } else if (e.getSource() == addMobileButton)
        {
            addMobileButtonResponse();
        } else if (e.getSource() == displayAllButton)
        {
            displayAllButtonResponse();
        } else if (e.getSource() == mobileButton)
        {
            mobileButtonResponse();
        } else if (e.getSource() == mp3Button)
        {
            mp3ButtonResponse();
        } else if (e.getSource() == makePhoneCallButton)
        {
            makeCallButtonResponse();
        } else if (e.getSource() == addCreditButton)
        {
            addCreditResponse();   
        } else if (e.getSource() == selectedIndexInfoButton)
        {
            selectedIndexInfoButtonResponse();
        } else if (e.getSource() == addMp3FileButton) 
        {
            uploadMusicButtonResponse();             
        } else if (e.getSource() == deleteMp3FileButton) 
        {
            deleteMusicButtonResponse();
        } else if (e.getSource() == mp3selectedIndexInfoButton)
        {
            selectedIndexInfoButtonResponse();
        } else if (e.getSource() == exitButton)
        {
            exitButtonResponse();
        }

    }

    private void mobileButtonResponse() 
    {
        mobileView.setVisible(true);
        mp3View.setVisible(false);
    }

    private void mp3ButtonResponse()
    {
        mp3View.setVisible(true);
        mobileView.setVisible(false);
    }

    private void addMp3ButtonResponse() 
    {
        String model = mp3ModelField.getText().trim();
        String size = mp3SizeField.getText().trim();

        if (model.isEmpty() || size.isEmpty()) {
            showError("Input Error", "Model and size cannot be empty");
            return;
        }

        float price;
        int weight;
        int memory;

        // Price
        try {
            String priceText = mp3PriceField.getText().trim().replace(",", ".");
            price = Float.parseFloat(priceText);
        } catch (NumberFormatException e) {
            showError("Input Error", "Invalid price (e.g. 10.5)");
            return;
        }

        // Weight
        try {
            weight = Integer.parseInt(mp3WeightField.getText().trim());
        } catch (NumberFormatException e) {
            showError("Input Error", "Invalid weight (integer)");
            return;
        }

        // Memory
        try {
            memory = Integer.parseInt(memoryField.getText().trim());
        } catch (NumberFormatException e) {
            showError("Input Error", "Invalid memory (integer)");
            return;
        }

        Mp3 mp3 = new Mp3(model, price, weight, size, memory);
        gadgets.add(mp3);

        logArea.appendText(
            "Added: Model= " + model +
            " Price= " + price +
            " Weight= " + weight +      
            " Size= " + size +
            " Memory= " + memory +
            System.lineSeparator()
        );
        
        System.out.println("Model= " + mp3.getModel());
        System.out.println(" Price= " + mp3.getPrice());
        System.out.println("Weight= " + mp3.getWeight());
        System.out.println("Size= " + mp3.getSize());
        System.out.println("Credit= " + mp3.getMemory());

        mp3.display();
    }

    private void addMobileButtonResponse() 
    {
        String model = mobileModelField.getText().trim();
        String size = mobileSizeField.getText().trim();

        float price;
        int weight;
        int credit;

        // Validate price
        try {
            String priceText = mobilePriceField.getText().trim().replace(",", ".");
            price = Float.parseFloat(priceText);
        } catch (NumberFormatException e) {
            showError("Input Error", "Please enter a valid price (e.g. 10.5)");
            return;
        }

        // Validate weight
        try {
            weight = Integer.parseInt(mobileWeightField.getText().trim());
        } catch (NumberFormatException e) {
            showError("Input Error", "Please enter a valid weight (integer)");
            return;
        }

        // Validate credit
        try {
            credit = Integer.parseInt(initalCreditField.getText().trim());
        } catch (NumberFormatException e) {
            showError("Input Error", "Please enter a valid initial credit (integer)");
            return;
        }

        // Check empty fields
        if (model.isEmpty() || size.isEmpty()) {
            showError("Input Error", "Model and size cannot be empty");
            return;
        }

        // Create Mobile object
        Mobile mobile = new Mobile(
                model,
                price,
                weight,
                size,
                credit
            );

        gadgets.add(mobile);

        // Log output
        logArea.appendText(
            "Added: " +
            "Model= " + mobile.getModel() +
            " Price= " + mobile.getPrice() +
            " Weight= " + mobile.getWeight() +
            " Size= " + mobile.getSize() +
            " Credit= " + mobile.getInitialCredit() +
            System.lineSeparator()
        );

        System.out.println("Model= " + mobile.getModel());
        System.out.println(" Price= " + mobile.getPrice());
        System.out.println("Weight= " + mobile.getWeight());
        System.out.println("Size= " + mobile.getSize());
        System.out.println("Credit= " + mobile.getInitialCredit());

        mobile.display();

    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void displayAllButtonResponse(){
        logArea.appendText("=== Display All Gadgets ===" 
            + System.lineSeparator());
        for (int i = 0; i < gadgets.size(); i++) {
            logArea.appendText("Display Number: "
                + i 
                + System.lineSeparator()
            );

            Gadget a = gadgets.get(i);
            a.display();
            logArea.appendText(a.toString());
            logArea.appendText(System.lineSeparator()
                +"-------------------------"
                +System.lineSeparator());
            
            System.out.println("=== Display All Gadgets ===" 
            + System.lineSeparator());
            System.out.println(("Display Number: "
                + i 
                + System.lineSeparator()
            ));
            System.out.println(a.display());
        }
    }

    private void makeCallButtonResponse() {
        try {
            int phoneNumber = Integer.parseInt(phoneNumberField.getText().trim());
            int durationOfCall = Integer.parseInt(durationOfCallField.getText().trim());
            boolean foundMobile = false;
            for (int i = 0; i < gadgets.size(); i++) 
            {
                Gadget g = gadgets.get(i);
                if (g instanceof Mobile) {
                    foundMobile = true;
                    Mobile m = (Mobile) g;
                    String result = m.makePhoneCall(phoneNumber, durationOfCall);
                    logArea.appendText(result + System.lineSeparator());
                    System.out.println(result + System.lineSeparator());
                } 
            }
            if (!foundMobile) {
                logArea.appendText("No mobile gadgets found." + System.lineSeparator());
            } 
        } catch(NumberFormatException e) {
            showError("Input error","Phone number and duration of the call must be valid numbers.");
        }
    }

    private void addCreditResponse() {
        try {
            int creditValue = Integer.parseInt(addCreditField.getText().trim());
            boolean foundMobile = false;
            for (int i= 0; i < gadgets.size(); i++)
            { 
                Gadget g = gadgets.get(i);
                if (g instanceof Mobile) {
                    foundMobile = true;
                    Mobile m = (Mobile) g;
                    String result = m.addCredit(creditValue);
                    logArea.appendText(result + System.lineSeparator());
                    System.out.println(result + System.lineSeparator());
                } 
            }
        } catch (NumberFormatException e) {
            showError("Input error","Please enter a positive number to add credit.");
        }
    }

    private void selectedIndexInfoButtonResponse() {
        try {
            String mobileInput = selectedIndexField.getText().trim();
            String mp3Input = mp3selectedIndexField.getText().trim();
            String input = !mobileInput.isEmpty() ? mobileInput : mp3Input;

            int selectedIndex = Integer.parseInt(input);

            if (selectedIndex < 0 || selectedIndex > gadgets.size()) {
                showError("Input Error","No gadget found at index" + selectedIndex);
                return;
            } 

            Gadget g = gadgets.get(selectedIndex);

            if (g instanceof Mobile) {
                Mobile m = (Mobile) g;
                logArea.appendText("=== Display Mobile Details ===" + System.lineSeparator());
                logArea.appendText(m.display() + System.lineSeparator());
                System.out.println("=== Display Mobile Details ===" + System.lineSeparator());
                System.out.println(m.display() + System.lineSeparator());
            } else if  (g instanceof Mp3) {
                Mp3 mp3 = (Mp3) g;
                logArea.appendText("=== Display Mp3 Details ===" + System.lineSeparator());
                logArea.appendText(mp3.display() + System.lineSeparator());
                System.out.println("=== Display Mp3 Details ===" + System.lineSeparator());
                System.out.println(mp3.display() + System.lineSeparator());
            } 
        } catch (NumberFormatException e) {
            showError("Input Error", "Please insert the gadget display number.");
        }
    }

    private void uploadMusicButtonResponse() {
        try {
            int mp3File = Integer.parseInt(mp3FileField.getText().trim());
            boolean foundMp3 = false;

            for (int i= 0; i < gadgets.size(); i++)
            { 
                Gadget g = gadgets.get(i);
                if (g instanceof Mp3) {
                    foundMp3 = true;
                    Mp3 mp3 = (Mp3) g;
                    String result = mp3.uploadMusic(mp3File);
                    logArea.appendText(result + System.lineSeparator());
                    System.out.println(result + System.lineSeparator());
                } 
            }
        } catch (NumberFormatException e) {
            showError("Input error","Please enter the size of mp3File.");
        }
    }

    private void deleteMusicButtonResponse() {
        try {
            int mp3File = Integer.parseInt(mp3FileField.getText().trim());
            boolean foundMp3 = false;

            for (int i= 0; i < gadgets.size(); i++)
            { 
                Gadget g = gadgets.get(i);
                if (g instanceof Mp3) {
                    foundMp3 = true;
                    Mp3 mp3 = (Mp3) g;
                    String result = mp3.deleteMusic(mp3File);
                    logArea.appendText(result + System.lineSeparator()); 
                    System.out.println(result + System.lineSeparator());
                } 
            }
        } catch (NumberFormatException e) {
            showError("Input error","Please enter the size of mp3File.");
        }
    }

    private void exitButtonResponse() {
        // Mobile fields
        mobileModelField.clear();
        mobilePriceField.clear();
        mobileWeightField.clear();
        mobileSizeField.clear();
        initalCreditField.clear();
        phoneNumberField.clear();
        durationOfCallField.clear();
        addCreditField.clear();
        selectedIndexField.clear();

        // Mp3 fields
        mp3ModelField.clear();
        mp3PriceField.clear();
        mp3WeightField.clear();
        mp3SizeField.clear();
        memoryField.clear();
        mp3FileField.clear();
        mp3selectedIndexField.clear();

        // Log area
        logArea.clear();
    }

    public static void main(String[] args) { launch(); }
}