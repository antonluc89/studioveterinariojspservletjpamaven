<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.studioveterinariojspservletmavenjpa.model.Animale"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
<title>Insert title here</title>
<!-- style per le pagine diverse dalla index -->
<link href="./assets/css/global.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">

		<%
			Animale animaleInPage =  (Animale) request.getAttribute("elimina_animale_attr");
		%>

		<div class="card">
			<h5 class="card-header">ELIMINAZIONE</h5>
			<div class="card-body">
				<form method="post"
					action="ExecuteDeleteAnimaleServlet?idAnimale=<%=animaleInPage.getId()%>">
					<h5 class="card-title">
						Stai eliminando l'animale con id: <%=animaleInPage.getId()%></h5>
					<p class="card-text">Sicuro dell'eliminazione?</p>
					<button type="submit" name="submit" id="submit"
						class="btn btn-danger">Delete</button>
				</form>
			</div>
		</div>

	</main>

	<jsp:include page="../footer.jsp" />
</body>
</html>