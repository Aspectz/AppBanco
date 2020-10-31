package modelo;

import java.util.ArrayList;

public class ProcedimientoMateria {
	private int id;
	private String title;
	private ArrayList<ProcedimientoTramite> procedimientos;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
