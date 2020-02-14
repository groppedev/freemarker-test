<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome ${user}! {{tomcat}}</h1>
</body>
<ul>
<#list tomcats as tomcat>
  <li>${tomcat}</li>
</#list>
</ul>
</html>