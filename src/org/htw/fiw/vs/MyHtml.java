package org.htw.fiw.vs;

public class MyHtml {
	
	public String getHtml(String registerdElements, String usedElements){
		 return "<head>"
			 		+ "<link rel="+"stylesheet"+"href="+"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"+">"
			 		+ "</head>"
			 
			 		+"<div class="+"row>"
			 				+ "<div class="+"col-md-6"+" "+"style="+"border:double"+">Registered Elements: "+registerdElements+"</div>"
			 				+ "<div class="+"col-md-6"+" "+"style="+"border:double"+">Clicked Buttons: "+usedElements+"</div>"
			 		+ "</div>";
		
		
	}

}
