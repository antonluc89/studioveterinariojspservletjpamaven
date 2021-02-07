<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.studioveterinariojspservletmavenjpa.model.Animale"%>
<html lang="it">
<head>
<jsp:include page="../header.jsp" />
<title>Visualizza animale</title>

<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

	<div class='card'>
		<div class='card-header'>View Details</div>
		<% Animale animaleInPage = (Animale)request.getAttribute("view_animale_attr"); %>

		<div class='card-body'>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome:</dt>
				<dd class="col-sm-9"><%=animaleInPage.getNome() %></dd>
			</dl>

			<dl class="row">
				<dt class="col-sm-3 text-right">Razza:</dt>
				<dd class="col-sm-9"><%=animaleInPage.getRazza() %></dd>
			</dl>

			<dl class="row">
				<dt class="col-sm-3 text-right">Età:</dt>
				<dd class="col-sm-9"><%=animaleInPage.getEta() %></dd>
			</dl>

			<dl class="row">
				<dt class="col-sm-3 text-right">Data di Prenotazione:</dt>
				<dd class="col-sm-9"><%=animaleInPage.getDataPrenotazione()!=null? new SimpleDateFormat("dd/MM/yyyy").format(animaleInPage.getDataPrenotazione()):"N.D."  %></dd>
			</dl>
		</div>
		<div class='card-footer'>
			<a href="ListArticoliServlet" class='btn btn-outline-secondary'
				style='width: 80px'> <i class='fa fa-chevron-left'></i> Back
			</a>
		</div>
	</div>



	<!-- end main container --> </main>
	<jsp:include page="../footer.jsp" />

</body>
</html>