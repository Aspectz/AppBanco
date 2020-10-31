package modelo;

public class ProcedimientoTramite {
	private int id;
	private String title;
	private String enLinea;
	private String certificado;
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
