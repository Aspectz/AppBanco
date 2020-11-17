package modelo;

import java.util.ArrayList;

public class ProcedimientoMateriaAgrupacion {
	private String id;
	private String title;
	private String prefLabel;
	private MateriasTipo materiasTipo;
	
	
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
	public String getPrefLabel() {
		return prefLabel;
	}
	public void setPrefLabel(String prefLabel) {
		this.prefLabel = prefLabel;
	}
	public MateriasTipo getMateriasTipo() {
		return materiasTipo;
	}
	public void setMateriasTipo(MateriasTipo materiasTipo) {
		this.materiasTipo = materiasTipo;
	}
	@Override
	public String toString() {
		return "ProcedimientoMateriaAgrupacion [id=" + id + ", title=" + title + ", prefLabel=" + prefLabel
				+ ", materiasTipo=" + materiasTipo + "]";
	}
	
	
	
}
