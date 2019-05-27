
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%-- <link rel='stylesheet' href='<c:url value="/webapp/resources/css/style.css" />' type='text/css' media='all' /> 
<script type="text/javascript" src='<c:url value="/resources/js/app.js" />' ></script> --%>
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>
<style>
body {
  margin: 0;
  font-family:sans-serif;

}
 #map {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
.hero-image {
  background-image: url("http://www.starweddings.in/assets/images/home/perfect-wedding.jpg");
  background-color: #cccccc;
  height: 500px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.hero-text {
  text-align: center;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
}

  .custom {
    width: 14em !important;
    height: 6em !important;
    border-color: ivory !important;
    background-color:black !important;
    margin-left:2em !important;
} 
button:hover{
background-color:brown !important;
}
</style>
<title>Spring </title>
</head>
<body>
 
<div class="hero-image">
  <div class="hero-text">
    <h1 style="font-size:90px;font-style:italic;">J&nbsp;&nbsp;A&nbsp;&nbsp;R&nbsp;&nbsp;V&nbsp;&nbsp;I&nbsp;&nbsp;S</h1>
    <hr>
    <h3 style="font-size:20px">THE BEST</h3>
   
  </div>
</div>

<div style="padding:20px 20px 20px 20px">
<button class="btn btn-info btn-outline btn-lg custom" data-toggle="modal" data-target="#myModalTC">Terms and Conditions</button>
<button class="btn btn-info btn-outline btn-lg custom">Gallery</button>
<button class="btn btn-info btn-outline btn-lg custom" data-toggle="modal" data-target="#myModalLoc">Location</button>
<button class="btn btn-info btn-outline btn-lg custom">Bookings</button>
<button class="btn btn-info btn-outline btn-lg custom" data-toggle="modal" data-target="#myModalFaq">FAQs</button>

</div>
 
 <div class="modal fade" id="myModalTC" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Terms and Conditions</h4>
        </div>
        <div class="modal-body">
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  <div class="modal fade" id="myModalLoc" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Location</h4>
        </div>
        <div class="modal-body">
          <div id="map"></div>
    <script>
// Initialize and add the map
function initMap() {
  // The location of Uluru
  var uluru = {lat: -25.344, lng: 131.036};
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 4, center: uluru});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: uluru, map: map});
}
    </script>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
   <div class="modal fade" id="myModalFaq" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">FAQs</h4>
        </div>
        <div class="modal-body">
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
</body>
</html>