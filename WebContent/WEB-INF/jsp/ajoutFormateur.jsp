<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
   	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ajout Formateur</title>

	<link rel="stylesheet" type="text/css" href='JS/jquery-ui-1.12.1/jquery-ui.min.css' />
	<link href="content/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href='content/default.css' />
	<link rel="stylesheet" type="text/css" href='content/petit.css' />
	<link rel="stylesheet" type="text/css" href='content/font-awesome-4.7.0/css/font-awesome.css' />
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">	

	<script type="text/javascript" src=JS/jquery-3.2.1.min.js></script>
	<script type="text/javascript" src=JS/jquery-ui-1.12.1/jquery-ui.js></script>
   	<script type="text/javascript" src=JS/test.js></script>
	<script type="text/javascript" src=content/bootstrap-3.3.7-dist/js/bootstrap.min.js></script>
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
				<div class="item_menu_small">
					Formation
				</div>
				<div class="item_menu_small">
					Cours
				</div>
				<div class="item_menu_small">
					<form action="ListFormateurs" method="post"><a href="">
						<button type="submit" name="formateur" value="1" class="btn-link">Formateurs</button>
						</a></form>
				</div>
		</div>
	<!--fin zone modal-->

<header>
			<div id="logo">
				<img src="img/logoT.png" alt="logo" id="iLogo"/>
			</div>
			<div id="titre">Super Formation</div>
			<nav>
				<ol id="menu">
					<li><a href="index.html">Accueil</a></li>
					<li><a>Formation</a></li>
					<li><a>Cours</a></li>
					<li><form action="ListFormateurs" method="post"><a>
						<button type="submit" name="formateur" value="1" class="btn-link">Formateurs</button>
						</a></form></li>
					
				</ol>
				<div id="menu_small">
					<span class="fa fa-bars" id="ham1"></span>
				</div>
			</nav>
		</header>

<br>
<br>


<div align="center">

	<form action="AjoutFormateur" method="get">
        <table >
            <caption style="font-weight:bold;">Ajout Formateur</caption>
                <tr>
                    <td>Prenom : </td>
                    <td><input name="prenom"  /> </td>
                </tr>
                <tr>
                    <td>Nom : </td>
                    <td><input name="nom"  /></td>
                </tr>
                <tr>
                    <td> </td>
                    <td><button type="submit" name="ajout2" value="1" style="font-size: 1em">Valider</button></td>
                </tr>
        </table>
	</form>
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

</script>
</body>
</html>