package controlador;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;



public class ProcedimientoMateriaControllador {
	private File fichXML;
	private Document doc=null;
	private MateriasTipoController mat=null;
	static final String ET_PROCEDIMIENTOMATERIA_AGRUPACION="procedimiento-materia-agrupacion";
	
	public ProcedimientoMateriaControllador(File fichXML,MateriasTipoController mat) {
		super();
		this.fichXML = fichXML;
		this.mat = mat;
	}
	public ProcedimientoMateriaControllador() {
		this.mat=new MateriasTipoController();
	}
	public ProcedimientoMateriaControllador(File fichXML) {
		this.fichXML=fichXML;
		this.mat=new MateriasTipoController();
	}
	public Document recuperarXML() throws SAXException, IOException, ParserConfigurationException {
		this.doc=(Document)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.fichXML);
		this.doc.getDocumentElement().normalize();
		return this.doc;
	}
}
