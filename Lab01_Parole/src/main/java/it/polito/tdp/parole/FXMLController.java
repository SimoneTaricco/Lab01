package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco = new Parole();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTime;

    @FXML
    void doCancella(ActionEvent event) {
    	long inizio = System.nanoTime();
    	String s = txtResult.getSelectedText();
    	elenco.cancella(s);
    	
    	List listaParole = elenco.getElenco();    	
    	String listaParoleOrdine = elenco.toString(listaParole);    	
    	txtResult.setText(listaParoleOrdine);
    	long fine = System.nanoTime();
    	txtTime.appendText(Objects.toString("Cancellazione parola [ns]: " + (fine - inizio)) + "\n");
    }
    
    @FXML
    void doInsert(ActionEvent event) {
    	
    	long inizio = System.nanoTime();  	
    	String ts = txtParola.getText();  	
    	txtParola.setText("");
    	    	
    	if (ts == "")
    		return;

    	elenco.addParola(ts);    	
    	List listaParole = elenco.getElenco();    	
    	String listaParoleOrdine = elenco.toString(listaParole);    	
    	txtResult.setText(listaParoleOrdine); 
    	
    	long fine = System.nanoTime();    	
    	txtTime.appendText(Objects.toString("Inserimento parola [ns]: " + (fine - inizio)) + "\n");
    }

    @FXML
    void doReset(ActionEvent event) { 
    	
    	long inizio = System.nanoTime();
    	elenco.reset();
    	txtResult.setText("");
    	long fine = System.nanoTime();
    	txtTime.appendText(Objects.toString("Reset elenco [ns]: " + (fine - inizio)) + "\n");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
