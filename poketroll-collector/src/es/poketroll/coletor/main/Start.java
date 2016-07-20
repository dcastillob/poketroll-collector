package es.poketroll.coletor.main;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Start {

	public static void main(String[] args) {

	    try (final WebClient webClient = new WebClient()) {
	        final HtmlPage page = webClient.getPage("http://www.20minutos.es/");
	        System.out.println("Titulo " + page.getTitleText());
	        
	        for(HtmlForm form : page.getForms()){
	        	System.out.println(form.getAttribute("action"));
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
