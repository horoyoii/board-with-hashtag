<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery &amp; Bootstrap 4 Tagsinput.js Plugin Demos</title>
<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.3.1/flatly/bootstrap.min.css">
<link href="/mvcexam/resources/css/tagsinput.css" rel="stylesheet" type="text/css">
<style>
body { background-color:#fafafa;}
.container { margin: 150px auto; }
h2 { margin:20px auto; font-size:14px;}
.badge { margin: 2px 5px; }
</style>
</head>

<body>
<div id="jquery-script-menu">
<div class="jquery-script-center">
<ul>
<li><a href="https://www.jqueryscript.net/form/Bootstrap-4-Tag-Input-Plugin-jQuery.html">Download This Plugin</a></li>
<li><a href="https://www.jqueryscript.net/">Back To jQueryScript.Net</a></li>
</ul>
<div class="jquery-script-ads"><script type="text/javascript"><!--
google_ad_client = "ca-pub-2783044520727903";
/* jQuery_demo */
google_ad_slot = "2780937993";
google_ad_width = 728;
google_ad_height = 90;
//-->
</script>
<script type="text/javascript"
src="https://pagead2.googlesyndication.com/pagead/show_ads.js">
</script></div>
<div class="jquery-script-clear"></div>
</div>
</div>
<div class="container">
<h1>jQuery & Bootstrap 4 Tagsinput.js Plugin Demos</h1>
  <h2>Basic</h2>
  
        <h2>Student Information</h2>
      <form:form method = "POST" action = "/mvcexam/article">
         <table>
            <tr>
               <td><form:label path = "title">title</form:label></td>
               <td><form:input path = "title" /></td>
            </tr>
            <tr>
               <td><form:label path = "content">content</form:label></td>
               <td><form:input path = "content" /></td>
            </tr>
            <tr>
               <td><form:label path = "writer">writer</form:label></td>
               <td><form:input path = "writer" /></td>
            </tr>
            <tr>
            	<td>tag</td>
            	<td>
            		<input type="text" data-role="tagsinput" >
			
            	</td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
      
      
  <input type="text" data-role="tagsinput" value="jQuery,Script,Net">
  <h2>Multi Select</h2>
  <select multiple data-role="tagsinput" >
    <option value="Amsterdam">Amsterdam</option>
    <option value="Washington">Washington</option>
    <option value="Sydney">Sydney</option>
    <option value="Beijing">Beijing</option>
    <option value="Cairo">Cairo</option>
  </select>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.11.1/typeahead.bundle.min.js"></script>
<script src="/mvcexam/resources/js/tagsinput.js"></script>
<script type="text/javascript">

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
</body>
</html>
