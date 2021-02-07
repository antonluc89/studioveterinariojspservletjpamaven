<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
 <%@page import="it.studioveterinariojspservletmavenjpa.model.Animale"%>
<html>
<head>
<jsp:include page="../header.jsp" />
<title>Insert title here</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
	<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Update animale</h5> 
		    </div>
		    
		    <% Animale animaleInPage = (Animale)request.getAttribute("update_animale_attr"); %>
		    
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteUpdateAnimaleServlet?idAnimale=<%=animaleInPage.getId() %>novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Nome <span class="text-danger">*</span></label>
								<input type="text" name="nome" id="nome" class="form-control" value="<%=animaleInPage.getNome() %>" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>razza <span class="text-danger">*</span></label>
								<input type="text" name="razza" id="razza" class="form-control" value="<%=animaleInPage.getRazza() %>" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Età <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="eta" id="eta" value="<%=animaleInPage.getEta() %>" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di Prenotazione<span class="text-danger">*</span></label>
                        		<input class="form-control" id="dataPrenotazione" type="date" value="<%=animaleInPage.getDataPrenotazione()!=null? new SimpleDateFormat("dd/MM/yyyy").format(animaleInPage.getDataPrenotazione()):"N.D."  %>"
                            		title="formato : gg/mm/aaaa"  name="dataPrenotazione" required>
							</div>	
						</div>	
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Confirm</button>
					

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>
		
		</main>
	<jsp:include page="../footer.jsp" />	

</body>
</html>