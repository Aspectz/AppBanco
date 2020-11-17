package controlador;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modelo.MateriasTipo;
import modelo.ProcedimientoMateria;
import modelo.ProcedimientoMateriaAgrupacion;



public class ProcedimientoMateriaAgrupacionControllador {
	private File ficXML=null;
	private MateriasTipo matTipo=null;
	private ProcedimientoMateriaAgrupacion matAgrupacion=null;
	private Document doc=null;
	static final String ET_ID="id";
	static final String ET_TITLE="title";
	
	public  ProcedimientoMateriaAgrupacionControllador() {
		this.matTipo=matTipo;
	}
	
	public ProcedimientoMateriaAgrupacionControllador(File ficXML, MateriasTipo matTipo,ProcedimientoMateriaAgrupacion matAgrupacion) {
		this.ficXML = ficXML;
		this.matTipo = matTipo;
		this.matAgrupacion=matAgrupacion;
	}
	public ProcedimientoMateriaAgrupacionControllador(File ficXML) {
		this.ficXML = ficXML;
		this.matTipo = new MateriasTipo();
		this.matAgrupacion=new ProcedimientoMateriaAgrupacion();
	}
	public Document recuperarXML() throws SAXException, IOException, ParserConfigurationException {
		this.doc=(Document)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.ficXML);
		this.doc.getDocumentElement().normalize();
		return this.doc;
		
	}
	
	public ProcedimientoMateriaAgrupacion leerDOM() {
		ProcedimientoMateriaAgrupacion prMA=new ProcedimientoMateriaAgrupacion();
		Element procedimientoMateria=this.doc.getDocumentElement();
		NodeList listaProcedimientos=procedimientoMateria.getChildNodes();
		
		this.matTipo.clear();
		String id=getValorEtiqueta(ET_ID, procedimientoMateria);
		String title=getValorEtiqueta(ET_TITLE, procedimientoMateria);
		String prefLabel=getValorEtiqueta(ET_TITLE, procedimientoMateria);
		for(int i=0;i<listaProcedimientos.getLength();i++) {
			for(int j=0;j<listaProcedimientos.item(i).getChildNodes().getLength();j++) {
				if(listaProcedimientos.item(i).getChildNodes().item(j).getNodeType()==Node.ELEMENT_NODE) {
					this.matTipo.add(ProcedimientoMateriaController.leerProcedimientoMateria((Element)listaProcedimientos.item(i).getChildNodes().item(j)));
			}
			}
		}
		prMA.setId(id);
		prMA.setTitle(title);
		prMA.setPrefLabel(prefLabel);
		prMA.setMateriasTipo(this.matTipo);
		return prMA;
	}

	
	public static String getValorEtiqueta(String etiqueta, Element element) {
		Node nValue=element.getElementsByTagName(etiqueta).item(0);
		return nValue.getChildNodes().item(0).getNodeValue();
	}
}
