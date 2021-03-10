package it.polito.tdp.parole.model;

import java.util.*;

public class ParoleDue {
	
	private LinkedList<String> parole = new LinkedList<String>();
		
	public ParoleDue() {
		
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
	
	public void cancella(String s) {
		for (String st:parole) {
			if (st.equals(s)) {
				this.parole.remove(st);
				return;
			}
		}
	}
	
	public static Comparator<String> ordineAlfabetico = new Comparator<String>() {
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	};
	
	

}

