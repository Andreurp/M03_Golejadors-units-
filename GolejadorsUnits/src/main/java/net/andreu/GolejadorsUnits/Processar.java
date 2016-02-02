package net.andreu.GolejadorsUnits;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {
	
	private ArrayList<Equip>llistaEquips = new ArrayList<>();
	
	boolean jugador = false;
	boolean nom = false;
	boolean equip = false;
	boolean gols = false;
	
	String nomJugador;
	String nomEquip;
	int numGols;

	public void startElement(String uri, String localName, String qName, Attributes attributes){
		
		switch (qName) {
		case "jugador":
			jugador = true;
			break;
		case "nom":
			nom =true;
			break;
		case "equip":
			equip = true;
			break;
		case "gols":
			gols = true;
			break;
		}
		
	}
	public void characters(char[] ch, int start, int length) {
		
		if(jugador){
			if(nom){
				if(equip){					
					nomEquip=new String(ch, start, length);
					comprovaEquip();
				}else{
					nomJugador=new String(ch, start, length);
				}
			}else if(equip){
				if(gols){
					numGols=Integer.parseInt(new String(ch, start, length));
				}
			}
		}
		
	}
	private void comprovaEquip() {
		boolean existeix=false;
		
		for(Equip e:llistaEquips){
			if(e.getNomEquip().equals(nomEquip)){
				existeix=true;
			}
		}
		if(!existeix){
			llistaEquips.add(new Equip(nomEquip));
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		switch (qName) {
		case "jugador":
			jugador = false;
			break;
		case "nom":
			nom =false;
			break;
		case "equip":
			equip = false;
			insareixJugador();
			break;
		case "gols":
			gols = false;
			break;
		}
	}
	
	private void insareixJugador() {
		
		for(Equip e:llistaEquips){
			if(e.getNomEquip().equals(nomEquip)){
				e.afegirJugador(nomJugador, numGols);
			}
		}
	}
	
	public void endDocument() {
		
		for(Equip e:llistaEquips){
			e.print();
		}
		
	}
}
