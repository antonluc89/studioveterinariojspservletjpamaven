<!doctype html>
<html lang="it">
  <head>
    
    <jsp:include page="./header.jsp" />
    
    <!-- Custom styles for this template -->
    <link href="./assets/css/global.css" rel="stylesheet">
    <style type="text/css">
    	body {
		  padding-top: 3.5rem;
		}	
    </style>
    
    <title>Gestione studio veterinario</title>
  </head>
  <body>
  
	<jsp:include page="./navbar.jsp"></jsp:include>
  
  
	<main role="main">
	
		

	  <!-- Main jumbotron for a primary marketing message or call to action -->
	  <div class="jumbotron" >
	    <div class="container">
	      <h1 class="display-3">Benvenuto nello gestione dello studio veterinario</h1>
	      <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
	      <p><a class="btn btn-primary btn-lg" href="ListaAnimaliServlet" role="button">Vai alla lista degli animali dello studio veterinario &raquo;</a></p>
	    </div>
	  </div>
	  
	  <div class="container">
	  
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	    <hr>
	  </div> <!-- /container -->
	</main>
	
	<jsp:include page="./footer.jsp" />
  </body>
</html>