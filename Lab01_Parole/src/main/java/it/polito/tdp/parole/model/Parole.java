package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parole {
	
	private ArrayList<String> parole = new ArrayList<String>();
		
	public Parole() {
		
	}
	
	public void addParola(String p) {		
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole,ordineAlfabetico);		
		return parole;
	}
	
	public void reset() {	
		for (int i=0; i<this.parole.size(); i++)
			this.parole.remove(i);
	}
	
	public static Comparator<String> ordineAlfabetico = new Comparator<String>() {
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	};
	
	

}
