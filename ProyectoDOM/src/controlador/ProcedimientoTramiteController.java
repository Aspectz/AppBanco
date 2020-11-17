package controlador;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import modelo.ProcedimientoTramite;

public class ProcedimientoTramiteController {
	static final String ET_ID="id";
	static final String ET_TITLE="title";
	static final String ET_ENLINEA="enLinea";
	static final String ET_CERTIFICADO="certificado";
	
	
	public static ProcedimientoTramite leerTramite(Element elTramite) {
		ProcedimientoTramite proTramite=new ProcedimientoTramite();
		String id=getValorEtiqueta(ET_ID, elTramite);
		String title=getValorEtiqueta(ET_TITLE, elTramite);
		String certificado=getValorEtiqueta(ET_CERTIFICADO, elTramite);
		String enLinea=getValorEtiqueta(ET_ENLINEA, elTramite);
		proTramite.setId(id);
		proTramite.setCertificado(certificado);
		proTramite.setEnLinea(enLinea);
		proTramite.setTitle(title);
		
		return proTramite;
		
	}
	
	public static String getValorEtiqueta(String etiqueta, Element element) {
		Node nValue=element.getElementsByTagName(etiqueta).item(0);
		return nValue.getChildNodes().item(0).getNodeValue();
	}
}
	
