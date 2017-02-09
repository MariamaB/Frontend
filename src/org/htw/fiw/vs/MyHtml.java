package org.htw.fiw.vs;

public class MyHtml {
	
	public String getHtml(String registeredElements){
		System.out.println(registeredElements);
		 return "<html>"
				+ "<head>"
			 	+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
			 	+ "<style>h1 {margin-bottom: 3%;} .select {margin-left: 2%; margin-right: 2%; border: 2px solid #9B9B9B; border-radius: 4px; height: 37px; width: 117px; font-size: 16px;}</style>"
			 	+ "</head>"
			 	+ "<body>"
			 	+ "<div class=\"container\">"
			 	+ "<h1>Registered Components</h1>"
			 	+ "<div class=\"row\">"
	 			+ "<div class=\"col-md-12\">"
	 			+ "<table class=\"table table-striped table-bordered\">"
	 			+ registeredElements 
	 			+ "</table>"
	 			+"</div>"
	 			+ "</div>"
	 			+ "</div>"
			 	+ "</body>"
	 			+ "</html>";
	}

}
