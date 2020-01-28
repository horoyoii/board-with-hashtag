<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Blog Post - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="/mvcexam/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/mvcexam/resources/css/blog-post.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Hello world</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/mvcexam/board">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container" id="a_content" name="${article.aid}">

    <div class="row">

      <!-- Post Content Column -->
      <div class="col-lg-8">

        <!-- Title -->
        <h1 class="mt-4">${article.title}</h1>

        <!-- Author -->
        <p class="lead">
          by
          <a href="#">${article.writer}</a>
        </p>

        <hr>

        <!-- Date/Time -->
        <p>posted at ${article.regDate}</p>

        <hr>

        <!-- Preview Image -->
        <img class="img-fluid rounded" src="/mvcexam/resources/img/download.gif" alt="">

        <hr>

        <!-- Post Content -->
        <p class="lead">${article.content}</p>


        <!-- Show tags -->
        <c:forEach var="tag" items="${article.tags}">
				<a href="/mvcexam/board?search=${tag}">#${tag}</a>
        </c:forEach>



        <hr>
		<button onClick="deleteFunc(${article.aid})" class="btn btn-primary">Delete</button>
        
        <!-- Comments Form -->
        <div class="card my-4">
          <h5 class="card-header">Leave a Comment:</h5>
          <div class="card-body">
            <form id ='comment_form'>
              <div class="form-group">
                <input type='hidden' name='cid' value=''>
                <textarea class="form-control" rows="3" name='content' id='comment_content'></textarea>
                <input type='hidden' name='regdate' value=''>
                <input type='hidden' name='aid' value='${article.aid}'>
              </div>
              <button id='comment_btn' type='button' class="btn btn-primary">Submit</button>
            </form>
          </div>
        </div>

		<div class="comment">
		

		</div>

      </div>

      <!-- Sidebar Widgets Column -->
      <div class="col-md-4">

        <!-- Search Widget -->
        <div class="card my-4">
          <h5 class="card-header">Search</h5>
          <div class="card-body">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Search for...">
              <span class="input-group-btn">
                <button class="btn btn-secondary" type="button">Go!</button>
              </span>
            </div>
          </div>
        </div>

        <!-- Categories Widget -->
        <div class="card my-4">
          <h5 class="card-header">Categories</h5>
          <div class="card-body">
            <div class="row">
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#">Web Design</a>
                  </li>
                  <li>
                    <a href="#">HTML</a>
                  </li>
                  <li>
                    <a href="#">Freebies</a>
                  </li>
                </ul>
              </div>
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#">JavaScript</a>
                  </li>
                  <li>
                    <a href="#">CSS</a>
                  </li>
                  <li>
                    <a href="#">Tutorials</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>

        <!-- Side Widget -->
        <div class="card my-4">
          <h5 class="card-header">Side Widget</h5>
          <div class="card-body">
            You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
          </div>
        </div>

      </div>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="/mvcexam/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/mvcexam/resources/vendor/jquery/jquery.serialize-object.min.js"></script>
  <script src="/mvcexam/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
<script>
	
	$(document).ready(function(){
		var aid = $('#a_content').attr('name');
		var url = '/mvcexam/api/v1/article/'+aid+'/comment';
		
		$.ajax({
			url : url,
			method: "GET",
		}).done(function(response){
			$.each(response['result'], function(index, value){
				var writer = 'anoymous'
				var regdate = 'commented at '+value['regdate'];
				
				$('<div>',{
					'class' : 'media mb-4',
					'html' : $('<img>',{
						'class' : 'd-flex mr-3 rounded-circle',
						'src' : 'http://placehold.it/50x50'
						}).add($('<div>', {
							'class' : 'media-body',
							'html' : $('<h5>', {
								'class' : 'mt-0'
							}).text(writer)
							.add($('<div>').text(regdate))
							.add($('<span>').text(value['content']))
						}))
					}).appendTo('.comment');
					
				}); // end each
			}); // done
		});
	
	function deleteFunc(aid){
   		var url = '/mvcexam/article/'+aid;
		
   		$.ajax({
            url: url,
            method: "DELETE",
        }).done(function(response){
    		window.location.href = "/mvcexam/board";
        });
	}

	$('#comment_btn').click(function(){
		var aid = $('#a_content').attr('name');
		var url = '/mvcexam/api/v1/article/'+aid+'/comment';
		
		var body = $('#comment_form').serializeJSON();
		console.log(body);
		$.ajax({
			url: url,
			method : 'POST',
			contentType: "application/json",
			data : body
		}).done(function(response){
			console.log("success");
			
			// clean the text area after submit
			$('#comment_content').val('');
			
			$('<div>',{
				'class' : 'media mb-4',
				'html' : $('<img>',{
					'class' : 'd-flex mr-3 rounded-circle',
					'src' : 'http://placehold.it/50x50'
					}).add($('<div>', {
						'class' : 'media-body',
						'html' : $('<h5>', {
							'class' : 'mt-0'
						}).text('anoymous')
						.add($('<div>').text(body['content']))
						.add($('<span>').text(body['content']))
					}))
				}).appendTo('.comment');
			
		})
	});	
	
</script>
</html>
