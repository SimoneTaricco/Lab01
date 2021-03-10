package it.polito.tdp.parole;

import it.polito.tdp.parole.model.*;

import java.net.URL;
import java.util.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco = new Parole();
	
	ParoleDue elencoDue = new ParoleDue();

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
    	txtTime.appendText(Objects.toString("Cancellazione parola - ArrayList [ns]: " + (fine - inizio)) + "\n");
    	
    	long inizioDue = System.nanoTime();
    	String sDue = txtResult.getSelectedText();
    	elenco.cancella(sDue);
    	
    	List listaParoleDue = elencoDue.getElenco();    	
    	String listaParoleOrdineDue = elencoDue.toString(listaParoleDue);    	
    	txtResult.setText(listaParoleOrdineDue);
    	long fineDue = System.nanoTime();
    	txtTime.appendText(Objects.toString("Cancellazione parola - LinkedList [ns]: " + (fineDue - inizioDue)) + "\n");
    }
    
    @FXML
    void doInsert(ActionEvent event) {
    	
    	long inizio = System.nanoTime();  	
    	String ts = txtParola.getText();  	
    	    	
    	if (ts == "")
    		return;

    	elenco.addParola(ts);    	
    	List listaParole = elenco.getElenco();    	
    	String listaParoleOrdine = elenco.toString(listaParole);    	
    	txtResult.setText(listaParoleOrdine); 
    	
    	long fine = System.nanoTime();    	
    	txtTime.appendText(Objects.toString("Inserimento parola - ArrayList [ns]: " + (fine - inizio)) + "\n");
    	
    	long inizioDue = System.nanoTime();  	
    	String ts2 = txtParola.getText();  	
    	    	
    	if (ts2 == "")
    		return;

    	elencoDue.addParola(ts2);    	
    	List listaParoleDue = elencoDue.getElenco();    	
    	String listaParoleOrdineDue = elencoDue.toString(listaParoleDue);    	
    	txtResult.setText(listaParoleOrdineDue); 
    	
    	long fineDue = System.nanoTime();    	
    	txtTime.appendText(Objects.toString("Inserimento parola - LinkedList [ns]: " + (fineDue - inizioDue)) + "\n");
    	
    	txtParola.setText("");
    }

    @FXML
    void doReset(ActionEvent event) { 
    	
    	long inizio = System.nanoTime();
    	elenco.reset();
    	txtResult.setText("");
    	long fine = System.nanoTime();
    	txtTime.appendText(Objects.toString("Reset elenco  - ArrayList [ns]: " + (fine - inizio)) + "\n");
    	
    	long inizioDue = System.nanoTime();
    	elencoDue.reset();
    	txtResult.setText("");
    	long fineDue = System.nanoTime();
    	txtTime.appendText(Objects.toString("Reset elenco  - LinkedList [ns]: " + (fineDue - inizioDue)) + "\n");	
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
