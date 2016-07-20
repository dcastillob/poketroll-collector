package es.poketroll.collector.bean;

import java.util.List;

public class NoticiaBean {
	private String url;
	private String tituloGoogle;
	private String tituloHTML;
	private String tituloNoticia;
	private String htmlNoticia;
	private String textoNoticia;
	private List<String> imagenesNoticia;
	
	public NoticiaBean (){}

	public String getUrl() {
		return url;
	}

	public String getTituloGoogle() {
		return tituloGoogle;
	}

	public String getTituloHTML() {
		return tituloHTML;
	}

	public String getTituloNoticia() {
		return tituloNoticia;
	}

	public String getHtmlNoticia() {
		return htmlNoticia;
	}

	public String getTextoNoticia() {
		return textoNoticia;
	}

	public List<String> getImagenesNoticia() {
		return imagenesNoticia;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setTituloGoogle(String tituloGoogle) {
		this.tituloGoogle = tituloGoogle;
	}

	public void setTituloHTML(String tituloHTML) {
		this.tituloHTML = tituloHTML;
	}

	public void setTituloNoticia(String tituloNoticia) {
		this.tituloNoticia = tituloNoticia;
	}

	public void setHtmlNoticia(String htmlNoticia) {
		this.htmlNoticia = htmlNoticia;
	}

	public void setTextoNoticia(String textoNoticia) {
		this.textoNoticia = textoNoticia;
	}

	public void setImagenesNoticia(List<String> imagenesNoticia) {
		this.imagenesNoticia = imagenesNoticia;
	}

	@Override
	public String toString() {
		return "NoticiaBean [url=" + url + ", tituloGoogle=" + tituloGoogle
				+ ", tituloHTML=" + tituloHTML + ", tituloNoticia="
				+ tituloNoticia + ", htmlNoticia=" + htmlNoticia
				+ ", textoNoticia=" + textoNoticia + ", imagenesNoticia="
				+ imagenesNoticia + "]";
	}

}
