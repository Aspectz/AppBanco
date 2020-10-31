package modelo;

import java.util.ArrayList;

public class MateriasTipo {
	private ArrayList<ProcedimientoMateria> prodecimientoMateria;

	public ArrayList<ProcedimientoMateria> getProdecimientoMateria() {
		return prodecimientoMateria;
	}

	public void setProdecimientoMateria(ArrayList<ProcedimientoMateria> prodecimientoMateria) {
		this.prodecimientoMateria = prodecimientoMateria;
	}

	@Override
	public String toString() {
		return "MateriasTipo [prodecimientoMateria=" + prodecimientoMateria + "]";
	}
	
	
}
