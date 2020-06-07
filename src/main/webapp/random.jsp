<!-- Este representa a interface com o implememtado Java Server Page que apresentará os resultados dos números gerados -->

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>PRN</title>
    <meta charset="utf-8">    
    <style>
    	.bgNv{
    		background-color: #e60002;
    	}
    	h6{
    		color:white;
    	}
    	.footer {
		    position:absolute;
		    bottom:0;
		    width:100%;
		}
		    	
    </style>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">    
  </head>
  <body>    
    <nav class="bgNv navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="#"><h1 class="display-4" href="#"><img src="img/VM.jpeg" alt="logotipo" height="75"></img></h1></a>
            <div class="ml-auto">
                <ul class="navbar-nav">                    
                	<a class="nav-link" href="#"><h6>Judelson Panzeca</h6></a>                       
                </ul>
            </div>
        </div>
    </nav>    
    <h1 style="text-align:center;">Pseudo-Random Numbers</h1>
    <div class="col-sm-12 row">
    	<form class="form-inline my-3 offset-md-2 col-sm-8 justify-content-center" action="http://localhost:8080/WebServiceRest/">	    	
	        <div class="form-row align-items-center">	        	
	    		<button class="btn btn-danger" type="submit">Form</button>
	        </div>    		
    	</form>
    	<%@page isELIgnored ="false" %> 
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<table style="width:100%" class="table table-striped table-hover offset-md-2 col-sm-8">
		  <tr>
		    <th>#</th>
		    <th>Random Number</th>
		    <th>Duration</th>
		  </tr>	
		  <c:forEach var="item" items="${numbers}">		  	
		  	<tr>
		       <td>${item.nr}</td>
		       <td>${item.pnR}</td>
		       <td>${item.tm}</td>
		   </tr>
		  </c:forEach>  		 
		</table>
    </div>   
	<footer class="container-fluid text-center bg-light footer">
	    <div class="row justify-content-center mt-1">
	
	        <div class="col-sm-3 mx-0" align="left">
	            <p align="left"><b>Adress: </b> Av. </p>
	        </div>
	        <div class="col-sm-3 mx-0">
	            <p align="left"><b><i class="fa fa-cell"></i>Contacts: </b>+258842422976</p>
	        </div>
	        <div class="col-sm-3 mx-0">
	            <p><b>E-mail: </b>vodacom@vm.co.mz</p>
	        </div>
	    </div>
	    <div class="row justify-content-center">
	        <div class=""></div>
	        <blockquote class="blockquote text-center ">
	            <p class="mb-0">The future is exciting. Ready?</p>
	            <hr>
	            <footer class="blockquote-footer">Judelson Panzeca <cite title="Titulo">IT</cite></footer>
	        </blockquote>
	        <div class=""></div>
	    </div>
	</footer>    
  </body>
</html>