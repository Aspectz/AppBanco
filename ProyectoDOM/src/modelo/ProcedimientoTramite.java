package modelo;

public class ProcedimientoTramite {
	private String id;
	private String title;
	private String enLinea;
	private String certificado;
	
	
	
	public ProcedimientoTramite() {
		
	}
	public ProcedimientoTramite(String id, String title, String enLinea, String certificado) {
		super();
		this.id = id;
		this.title = title;
		this.enLinea = enLinea;
		this.certificado = certificado;
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
	public String getEnLinea() {
		return enLinea;
	}
	public void setEnLinea(String enLinea) {
		this.enLinea = enLinea;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	@Override
	public String toString() {
		return "ProcedimientoTramite [id=" + id + ", title=" + title + ", enLinea=" + enLinea + ", certificado="
				+ certificado + "]";
	}
	
	
	
}
