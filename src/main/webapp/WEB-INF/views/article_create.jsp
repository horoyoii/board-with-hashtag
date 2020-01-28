<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
      
      <!-- Stylesheet -->
		<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.3.1/flatly/bootstrap.min.css">

		<link href="/mvcexam/resources/css/tagsinput.css" rel="stylesheet" type="text/css">

		<style>
		body { background-color:#fafafa;}
		.container { margin: 150px auto; }
		form { margin:20px auto; font-size:14px; width:200px;height:100px}
		.badge { margin: 2px 5px; }
		
		
		form {display:inline; font-size:14px; width:200px;height:100px;}

		</style>
   </head>

   <body>
      <h2>Article Information</h2>
      <form:form method = "POST" action = "/mvcexam/article">
         <table>
            <tr>
               <td><form:label path = "title">title</form:label></td>
               <td><form:input path = "title" /></td>
            </tr>
            <tr>
               <td><form:label path = "content">content</form:label></td>
               <td><form:input path = "content" size="35" line-height='2em'/></td>
            </tr>
            <tr>
               <td><form:label path = "writer">writer</form:label></td>
               <td><form:input path = "writer" /></td>
            </tr>
            <tr>
				<td><form:label path = "tags">tags</form:label></td>
            	<td>
            		<form:input data-role="tagsinput" path="tags" />
            	</td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
      
	   <!-- JavaScript -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.11.1/typeahead.bundle.min.js"></script>
		<script type="text/javascript">


//			$("select").tagsinput('items')
		
		
		
		
		
		
		
		
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-36251023-1']);
		  _gaq.push(['_setDomainName', 'jqueryscript.net']);
		  _gaq.push(['_trackPageview']);

		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();

		</script>

		<script src="/mvcexam/resources/js/tagsinput.js"></script>   
   </body>
   
</html>