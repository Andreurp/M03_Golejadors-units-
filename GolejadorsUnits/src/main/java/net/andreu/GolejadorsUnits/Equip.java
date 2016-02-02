package net.andreu.GolejadorsUnits;

import java.util.HashMap;
import java.util.Map.Entry;

public class Equip {

	private HashMap<String, Integer>jugadors = new HashMap<String, Integer>();
	
	private String nomEquip;
	private int golsEquip;
	
	public Equip(String nom){
		this.nomEquip=nom;
		golsEquip=0;
	}
	
	public boolean afegirJugador(String nom, int gols) {
		boolean retorna=false;
		
		if(jugadors.containsKey(nom)==false){
			retorna=true;
			jugadors.put(nom, gols);
			golsEquip=golsEquip+gols;
		}
		return retorna;
	}

	public HashMap<String, Integer> getJugadors() {
		return jugadors;
	}

	public String getNomEquip() {
		return nomEquip;
	}

	public int getGolsEquip() {
		return golsEquip;
	}

	
	public void print() {
		System.out.println(nomEquip+": "+golsEquip);
		for(Entry<String, Integer> j: jugadors.entrySet()){
			System.out.println("\t"+j.getKey()+": "+j.getValue());
		}
	}
	
}
