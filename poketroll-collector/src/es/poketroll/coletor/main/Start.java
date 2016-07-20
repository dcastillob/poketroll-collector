package es.poketroll.coletor.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;






import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Start {
	private static final String BUSQUEDA = "pokemon-go";

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
			    	linkImagenes.add(imagen.attr("src"));
			    }			    
			    System.out.println("\n\n\nTitulo Pagina  - "+tituloResultadoBusqueda);
			    System.out.println("\tTitulo Noticia - "+tituloNoticia);
			    System.out.println("\t\tTexto cuerppo   - "+cuerpoNoticia.text());
			   // System.out.println("--- HTML cuerppo   - "+htmlCuerpoNoticia);
			    System.out.println("\t\t\tImagenes cuerppo   - "+linkImagenes);
			    
			}
		}catch(Exception ex){
			throw ex;
		}
	}
}
