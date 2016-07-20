package es.poketroll.coletor.main;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
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
	        	if(actionName.contains("busqueda")){
	        		
	        		HtmlInput input = (HtmlInput) form.getElementsByTagName("input").get(0);
	        		
	        		input.click();
	        		input.type(BUSQUEDA);
	        		
	        		System.out.println(input);
	        		HtmlElement link = form.getElementsByTagName("a").get(0);
	        		
	        		final HtmlPage page2 = link.click();
	        		
	        		System.out.println(page2.getTitleText());
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
