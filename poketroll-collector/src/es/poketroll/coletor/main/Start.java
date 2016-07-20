package es.poketroll.coletor.main;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;74
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Start {
	private static final String BUSQUEDA = "pokemon-go";

	public static void main(String[] args) {

	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://www.20minutos.es/");
	        System.out.println("Titulo " + page.getTitleText());
	        
	        for(HtmlForm form : page.getForms()){
	        	String actionName = form.getAttribute("action");
	        	System.out.println(actionName);
	        	if("busqueda".equals(actionName)){
	        		
	        		HtmlInput input = (HtmlInput) form.getElementsByTagName("input");
	        		input.setValueAttribute(BUSQUEDA);
	        		
	        		
	        		
	        		System.out.println(input);
	        		HtmlAnchor link = (HtmlAnchor) form.getElementsByTagName("a");
	        		 
	        	}
	        }

//	        final String pageAsXml = page.asXml();
//	        System.out.println(pageAsXml);

//	        final String pageAsText = page.asText();
//	        System.out.println(pageAsText);
	    }catch(Exception ex){
	    	System.out.println("Error - " + ex);
	    }
	}

}
