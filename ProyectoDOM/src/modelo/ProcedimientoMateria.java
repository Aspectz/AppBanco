package modelo;

import java.util.ArrayList;

public class ProcedimientoMateria {
	private String id;
	private String title;
	private ArrayList<ProcedimientoTramite> procedimientos=new ArrayList<ProcedimientoTramite>();
	
	
	
	public ProcedimientoMateria(String id, String title,String id1,String title1,String enLinea,String certificado) {
		super();
		this.id = id;
		this.title = title;
		this.procedimientos.add(new ProcedimientoTramite(id1, title1, enLinea, certificado));
	}
	public ProcedimientoMateria() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<ProcedimientoTramite> getProcedimientos() {
		return procedimientos;
	}
	public void setProcedimientos(ArrayList<ProcedimientoTramite> procedimientos) {
		this.procedimientos = procedimientos;
	}
	@Override
	public String toString() {
		return "ProcedimientoMateria [id=" + id + ", title=" + title + ", procedimientos=" + procedimientos + "]";
	}
	
	
}
