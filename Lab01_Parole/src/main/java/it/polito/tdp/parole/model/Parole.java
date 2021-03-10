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
		this.parole.removeAll(parole);
	}
	
	public String toString(List l) {	
		String res = "";
		for (int i=0; i<l.size(); i++)
			res += l.get(i) + "\n";		
		return res;
	}
	
	public static Comparator<String> ordineAlfabetico = new Comparator<String>() {
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	};
	
	

}
