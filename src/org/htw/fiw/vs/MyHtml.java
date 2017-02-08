package org.htw.fiw.vs;

public class MyHtml {
	
	public String getHtml(String registerdElements){
		 return "<html>"
				+ "<head>"
			 	+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
			 	+ "</head>"
			 	+ "<body>"
			 	+ "<div class=\"container\">"
			 	+ "<h1>Components</h1>"
			 	+ "<div class=\"row\">"
			 	+ "<form action=\"registry\" method=\"GET\">"
	 			+ "<div class=\"col-md-6\""+">Registered Elements: "+ registerdElements +"</div>"
	 			+ "</form>"
	 			+ "</div>"
	 			+ "</div>"
			 	+ "</body>"
	 			+ "</html>";
		
		
	}

}
