package es.poketroll.collector.main;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import es.poketroll.collector.bean.NoticiaBean;

public class Start {
	private static final String BUSQUEDA = "pokemon-go";
	public static List<NoticiaBean> noticias = new ArrayList<NoticiaBean>();
	public static void main(String[] args) throws Exception {
		try{
			String google = "http://www.google.com/search?q=";
			String search = "inurl:xataka pokemon";
			String charset = "UTF-8";
			String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage!

			Elements links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".g>.r>a");
			
			for (Element link : links) {
			    String title = link.text();
			    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
			    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

			    if (!url.startsWith("http")) {
			        continue; // Ads/news/etc.
			    }

			    System.out.println("\n\n\nTitle Google: " + title);
			    System.out.println("URL Google: " + url);
			    
			    Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
			    String tituloResultadoBusqueda = doc.title();
			    
			    Element elementTituloNoticia = doc.select(".article-header h1 span").first();
			    String tituloNoticia = elementTituloNoticia.text();
			    
			    Element cuerpoNoticia = doc.select(".article-content .blob").first();
			    String htmlCuerpoNoticia = cuerpoNoticia.html();
			    
			    List<String> linkImagenes = new ArrayList<String>();
			    
			    Elements imagenes = cuerpoNoticia.select(".article-asset-image img");
			    for(Element imagen : imagenes){
			    	String src = imagen.attr("src");
			    	if (!"".equals(src)){
			    		linkImagenes.add(src);
			    	}
			    	
			    }
			    NoticiaBean noticia = new NoticiaBean();
			    
			    noticia.setUrl(url);
			    noticia.setTituloGoogle(title);
			    noticia.setTituloHTML(tituloResultadoBusqueda);
			    noticia.setHtmlNoticia(htmlCuerpoNoticia);
			    noticia.setTextoNoticia(cuerpoNoticia.text());
			    noticia.setImagenesNoticia(linkImagenes);
			    
			    noticias.add(noticia);
			    
			    System.out.println(noticias);
			    
			}
		}catch(Exception ex){
			throw ex;
		}
	}
}
