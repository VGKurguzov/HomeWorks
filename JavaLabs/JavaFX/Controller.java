package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


public class Controller implements Initializable {

    private ObservableList<StrPhoneBook> listPhoneBook = FXCollections.observableArrayList();
    private int countId = 0;
    public Integer setupId(){
        return ++countId;
    }

    private Label label;
    @FXML
    private AnchorPane anchor;
    @FXML
    private TableView<StrPhoneBook> table;
    @FXML
    private TableColumn<StrPhoneBook, Integer> id;
    @FXML
    private TableColumn<StrPhoneBook, String> from;
    @FXML
    private TableColumn<StrPhoneBook, String> to;
    @FXML
    private TableColumn<StrPhoneBook, String> date;
    @FXML
    private TableColumn<StrPhoneBook, String> time;
    @FXML
    private HBox boxBtn;
    @FXML
    private Label labelF;
    @FXML
    private HBox boxField1;
    @FXML
    private TextField fieldLine;
    @FXML
    private TextField fieldFrom;
    @FXML
    private TextField fieldTo;
    @FXML
    private HBox boxField2;
    @FXML
    private TextField fieldDate;
    @FXML
    private TextField fieldTime;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDel;

    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnAdd){
            listPhoneBook.add(new StrPhoneBook(setupId(),fieldFrom.getText(),fieldTo.getText(),fieldDate.getText(),fieldTime.getText()));
            fieldFrom.clear();
            fieldTo.clear();
            fieldDate.clear();
            fieldTime.clear();
        }
        if (event.getSource() == btnDel && listPhoneBook.isEmpty() == false){
            int line = Integer.parseInt(fieldLine.getText());

            if(line >= 1 && line <= listPhoneBook.size()){
                listPhoneBook.remove(line-1);
                fieldLine.clear();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAdd.setOnAction(this::handleButtonAction);
        btnDel.setOnAction(this::handleButtonAction);
        id.setCellValueFactory(new PropertyValueFactory<StrPhoneBook, Integer>("id"));
        from.setCellValueFactory(new PropertyValueFactory<StrPhoneBook, String>("from"));
        to.setCellValueFactory(new PropertyValueFactory<StrPhoneBook, String>("to"));
        date.setCellValueFactory(new PropertyValueFactory<StrPhoneBook, String>("date"));
        time.setCellValueFactory(new PropertyValueFactory<StrPhoneBook, String>("time"));

        table.setItems(listPhoneBook);



    }



}


