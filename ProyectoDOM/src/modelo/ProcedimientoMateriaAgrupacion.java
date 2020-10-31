package modelo;

import java.util.ArrayList;

public class ProcedimientoMateriaAgrupacion {
	private int id;
	private String title;
	private String prefLabel;
	private ArrayList<MateriasTipo> materiasTipo;
	
	
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
	public String getPrefLabel() {
		return prefLabel;
	}
	public void setPrefLabel(String prefLabel) {
		this.prefLabel = prefLabel;
	}
	public ArrayList<MateriasTipo> getMateriasTipo() {
		return materiasTipo;
	}
	public void setMateriasTipo(ArrayList<MateriasTipo> materiasTipo) {
		this.materiasTipo = materiasTipo;
	}
	@Override
	public String toString() {
		return "ProcedimientoMateriaAgrupacion [id=" + id + ", title=" + title + ", prefLabel=" + prefLabel
				+ ", materiasTipo=" + materiasTipo + "]";
	}
	
	
	
}
