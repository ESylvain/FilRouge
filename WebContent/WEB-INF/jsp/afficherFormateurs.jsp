<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html data-ng-app = "formateurApp">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Liste des Formateurs</title>

<link rel="stylesheet" type="text/css"
	href='JS/jquery-ui-1.12.1/jquery-ui.min.css' />
<link href="content/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href='content/default.css' />
<link rel="stylesheet" type="text/css" href='content/petit.css' />
<link rel="stylesheet" type="text/css"
	href='content/font-awesome-4.7.0/css/font-awesome.css' />
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans"
	rel="stylesheet">

<script type="text/javascript" src=JS/jquery-3.2.1.min.js></script>
<script type="text/javascript" src=JS/jquery-ui-1.12.1/jquery-ui.js></script>
<script type="text/javascript" src=JS/test.js></script>
<script type="text/javascript"
	src=content/bootstrap-3.3.7-dist/js/bootstrap.min.js></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.5/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
	
<script type="text/javascript" src=JS/petitAngular.js></script>
</head>
<body>

	<!--Zone div modal, menu modal-->
	<div id="modal" title="Basic dialog">
		<div id="modal_content">
			<h1>Modal</h1>
			<p>fait à la main</p>
			<button id="less1">Fermer</button>
		</div>
	</div>

	<div id="menu_small_content">
		<div class="item_menu_small">
			<a href="index.html">Accueil</a>
		</div>
		<div class="item_menu_small">Formation</div>
		<div class="item_menu_small">Cours</div>
		<div class="item_menu_small">
			<form action="ListFormateurs" method="post">
				<a href="">
					<button type="submit" name="formateur" value="1" class="btn-link">Formateurs</button>
				</a>
			</form>
		</div>
	</div>
	<!--fin zone modal-->

	<header>
		<div id="logo">
			<img src="img/logoT.png" alt="logo" id="iLogo" />
		</div>
		<div id="titre">Super Formation</div>
		<nav>
			<ol id="menu">
				<li><a href="index.html">Accueil</a></li>
				<li><a>Formation</a></li>
				<li><a>Cours</a></li>
				<li><form action="ListFormateurs" method="post">
						<a>
							<button type="submit" name="formateur" value="1" class="btn-link">Formateurs</button>
						</a>
					</form></li>

			</ol>
			<div id="menu_small">
				<span class="fa fa-bars" id="ham1"></span>
			</div>
		</nav>
	</header>

	<br>
	<br>
	
	<div align="center" data-ng-controller="formateurCtrl">
		<table style="width: 600px" >
			<caption style="font-weight: bold;">
				Liste des formateurs <span style="font-size: 0.5em">(webservice + angularJS)</span> 
				<span style="float: right; margin-right: 10px"> 
				<input type="text" name="name" id="inputSearchAJS" autofocus 
						data-ng-model="inputSearchAJS" data-ng-change="appelWS(inputSearchAJS)" > <!-- my-enter="appelWS(inputSearchAJS)" -->
					<button type="button" id="btnSearchAJS" 
						style="font-weight: normal; width: 50px; font-size: 1.1em" data-ng-click="ailleurs()">
						<span class="fa fa-search"></span>
					</button>
				</span>
			</caption>

			<tr>
				<th>Prenom</th>
				<th>Nom</th>
				<th></th>
				<th></th>
			</tr>
			<tr data-ng-repeat="formateur in formateurs" class="listeFormateur">
					<td>{{formateur.prenom}}</td>
					<td>{{formateur.nom}}</td>
					<td><form action="UpdateFormateur" method="get">
							<button type="submit" name="update1" value="{{formateur.id}}">Modifier</button>
						</form></td>
					<td><form action="DeleteFormateur" method="get">
							<button type="submit" name="delete" value="{{formateur.id}}">Supprimer</button>
						</form></td>
			</tr>
		</table>

    	
	</div>
	
	<br>
	<br>

	<div align="center">
		<table style="width: 600px">
			<caption style="font-weight: bold;">
				Liste des formateurs (classique) <span style="float: right">
					<form action="AjoutFormateur" method="get">
						<button type="submit" name="ajout1" value="1"
							style="font-weight: normal; width: 50px; font-size: 1.1em">
							<span class="fa fa-plus"></span>
						</button>
					</form>
				</span> <span style="float: right; margin-right: 10px"> <input
					type="text" name="name" id="inputSearch" autofocus>
					<button type="button" id="btnSearch"
						style="font-weight: normal; width: 50px; font-size: 1.1em">
						<span class="fa fa-search"></span>
					</button>
				</span>
			</caption>

			<tr>
				<th>Prenom</th>
				<th>Nom</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="formateur" items="${formateurs}">
				<tr id="${formateur.id}" class="listeFormateur">
					<td><c:out value="${formateur.prenom}" /></td>
					<td><c:out value="${formateur.nom}" /></td>
					<td><form action="UpdateFormateur" method="get">
							<button type="submit" name="update1" value="${formateur.id}">Modifier</button>
						</form></td>
					<td><form action="DeleteFormateur" method="get">
							<button type="submit" name="delete" value="${formateur.id}">Supprimer</button>
						</form></td>

				</tr>
			</c:forEach>
		</table>
	</div> 

	

	<script>
$( function() {
    $( "#container2_small" ).accordion({
		collapsible: true,
		active:false
	});

});

$('#more1').click(function(){
	$('#modal').toggle();
});
$('#less1').click(function(){
	$('#modal').toggle();
});

$('#ham1').click(function(){
	$('#menu_small_content').toggle();
});

/*Partie Web Service*/

$('#inputSearch').keypress(function(event) {
    if (event.keyCode == 13) {
        webService();
    }
});
$('#btnSearch').click(function(){
	webService();
});

function webService() {
	var liste;
		
			$.ajax({
		        type: 'GET',
		        url: "/ProjetWeb3_JSF/rest/users/gfbnq",
		        data : {name: $("#inputSearch").val()},
		        dataType: "json",
		        success: function(data) {
		        	console.log("data:"+data);
		        	liste = data;
		        	
		        	var tmp = "";
		        	$('.listeFormateur').hide();
		        	$.each(liste, function(index, formateur) {
		        		tmp = tmp + " | " + formateur.nom;
		        		$('#'+formateur.id).show();
		        	});
					alert("resultat : "+tmp);
					console.log(JSON.stringify(liste, null, '\t'));
				}
		    });
		    
		    
	 
	/*
	on pourrait traiter la reponse et cacher toutes les lignes dont on ne connait pas l'id
	*/
	
	/*function post(path, params, method) {
	    method = method || "post"; // Set method to post by default if not specified.

	    // The rest of this code assumes you are not using a library.
	    // It can be made less wordy if you use one.
	    var form = document.createElement("form");
	    form.setAttribute("method", method);
	    form.setAttribute("action", path);

	    for(var key in params) {
	        if(params.hasOwnProperty(key)) {
	            var hiddenField = document.createElement("input");
	            hiddenField.setAttribute("type", "hidden");
	            hiddenField.setAttribute("name", key);
	            hiddenField.setAttribute("value", params[key]);

	            form.appendChild(hiddenField);
	         }
	    }

	    document.body.appendChild(form);
	    form.submit();
	}
	
	post('/ProjetWeb3_JSF/ListFormateurs', {contient:liste});*/
}

/*Fin Partie Web Service*/


</script>
</body>
</html>