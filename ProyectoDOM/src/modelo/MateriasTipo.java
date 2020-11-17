package modelo;

import java.util.ArrayList;

public class MateriasTipo extends ArrayList<ProcedimientoMateria>{

	public ArrayList<ProcedimientoMateria> getProdecimientoMateria() {
		return this;
	}


	 @Override
	 public String toString() {
		 String result="";
		 for(int i=0;i<this.getProdecimientoMateria().size();i++) {
			 result+="\n"+this.getProdecimientoMateria().get(i);
		 }
		 return result;
	 }	
	
	
}
