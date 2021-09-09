<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="newpackage.bean.Courses"%>
    <%@ page import="newpackage.dao.CourseDao"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>E-Learning</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/feather/feather.css">
  <link rel="stylesheet" href="vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- Plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
</head>

<body>
<%String userid=(String)request.getAttribute("userid");
request.setAttribute("userid", userid);%>
<%
 ArrayList<Courses> courseList = (ArrayList<Courses>)request.getAttribute("result");
%>
  <div class="container-scroller">
    <!-- header start -->
    <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
        <a class="navbar-brand brand-logo mr-5" href="userhome.jsp"><img src="" class="mr-2" alt="eLearning"/></a>
        <a class="navbar-brand brand-logo-mini" href="userhome.jsp"><img src="" alt="eLearning"/></a>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
        <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
          <span class="icon-menu"></span>
        </button>
        <ul class="navbar-nav mr-lg-2">
          <li class="nav-item nav-search d-none d-lg-block">
            <div class="input-group">
              <div class="input-group-prepend hover-cursor" id="navbar-search-icon">
                <span class="input-group-text" id="search">
                  <i class="icon-search"></i>
                </span>
              </div>
              <input type="text" class="form-control" id="navbar-search-input" placeholder="Search now" aria-label="search" aria-describedby="search">
            </div>
          </li>
        </ul>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item dropdown">
            <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
              <i class="icon-bell mx-0"></i>
              <span class="count"></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
              <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
            </div>
          </li>
          <li class="nav-item nav-profile dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
              <img src="images/faces/face28.jpg" alt="profile"/>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
              <a class="dropdown-item">
                <i class="ti-settings text-primary"></i>
                Settings
              </a>
              <a class="dropdown-item" href="UserLogout">
                <i class="ti-power-off text-primary"></i>
                Logout
              </a>
            </div>
          </li>
        </ul>
        
      </div>
    </nav>
    
    <!-- header close -->
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      
      <!-- sidebar start -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="userhome.jsp">
              <i class="icon-grid menu-icon"></i>
              <span class="menu-title">Dashboard</span>
            </a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="ViewCourse?userid=${user.id }">
              <i class="icon-grid-2 menu-icon"></i>
              <span class="menu-title">View Course</span>
            </a>
           </li>
           <li class="nav-item">
            <a class="nav-link" href="userenrolledview.jsp">
              <i class="icon-grid-2 menu-icon"></i>
              <span class="menu-title">Enrolled Course</span>
            </a>
           </li>
            
          <li class="nav-item">
            <a class="nav-link" href="userfeedback.jsp">
              <i class="icon-columns menu-icon"></i>
              <span class="menu-title">Feedback</span>
            </a>
          </li>
       
        </ul>
      </nav>
      <!-- sidebar close -->
      
          
     
    
    
    
      
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Courses</h4>
                  
                  <div class="table-responsive">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th>
                            Course ID
                          </th>
                          <th>
                            Course Name
                          </th>
                          <th>
                            Course Fee
                          </th>
                          <th>
                            Course Desc
                          </th>
                          <th>
                            Enroll
                          </th>
                        </tr>
                      </thead>
                      
 <%
for (Courses course : courseList) {
%>

                       <tr><td><%=course.getCourseid()%></td>
						<td><%=course.getCoursename()%></td>
						<td><%=course.getCoursefee()%></td>
						<td><%=course.getCoursedesc() %></td>
						<td>
						<a href="EnrollCourse?courseid=<%=course.getCourseid()%>&userid=<%=(String)request.getAttribute("userid")%>">Enroll</a>
						
						</td>

						</tr>
<%
}

%>
                             </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2021.   <a href="#" target="_blank">E-Learning</a> </span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Design by Vishal Gupta <i class="ti-heart text-danger ml-1"></i></span>
          </div>
        </footer>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page -->
  <!-- End plugin js for this page -->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>
  <script src="js/settings.js"></script>
  <script src="js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>

</html>
