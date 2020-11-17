package controlador;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelo.ProcedimientoMateria;
import modelo.ProcedimientoTramite;

public class ProcedimientoMateriaController {
	static final String ET_ID="id";
	static final String ET_TITLE="title";
	static final String ET_PROCEDIMIENTOS="procedimiento-tramite";
	
	public static ProcedimientoMateria leerProcedimientoMateria(Element elProcedimiento) {
		ProcedimientoMateria procMat=new ProcedimientoMateria();
		String id=getValorEtiqueta(ET_ID, elProcedimiento);
		String title=getValorEtiqueta(ET_TITLE, elProcedimiento);
		NodeList procedimientos=elProcedimiento.getElementsByTagName(ET_PROCEDIMIENTOS);
		for(int i=0;i<procedimientos.getLength();i++) {
			if(procedimientos.item(i).getNodeType()==Node.ELEMENT_NODE) {
				procMat.getProcedimientos().add(ProcedimientoTramiteController.leerTramite((Element)procedimientos.item(i)));
			}
		}
		procMat.setId(id);
		procMat.setTitle(title);
		return procMat;
	}
	
	public static String getValorEtiqueta(String etiqueta, Element element) {
		Node nValue=element.getElementsByTagName(etiqueta).item(0);
		return nValue.getChildNodes().item(0).getNodeValue();
	}
	
}
