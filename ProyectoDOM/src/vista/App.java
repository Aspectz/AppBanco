package vista;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


import controlador.ProcedimientoMateriaAgrupacionControllador;
import modelo.MateriasTipo;
import modelo.ProcedimientoMateriaAgrupacion;


public class App {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		String nomFich="zaragozaxml.xml";
		File f1=new File(nomFich);
		Document doc=null;
		ProcedimientoMateriaAgrupacionControllador procedimientoMateriaAgrupacion=new ProcedimientoMateriaAgrupacionControllador(f1);
		doc=procedimientoMateriaAgrupacion.recuperarXML();
		
		ProcedimientoMateriaAgrupacion materiasTipo=null;
		materiasTipo=procedimientoMateriaAgrupacion.leerDOM();
		
		System.out.println(materiasTipo);
	}

}
