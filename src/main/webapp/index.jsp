<html>
   <body>
   
   	  <script type="text/javascript">
         function validateform(){  
        
        	 var name=document.loginfrom.user.value;  
        	 var password=document.loginfrom.pwd.value;
        	       	        	   <html>
<body>
<h2>Hello World!</h2>
</body>
</html>
        	 if (name==null || password==""){  
        	   alert("User Name and Password can't be blank");  
        	   return false;  
        	 }else if(password.length<6){  
        	   alert("Password must be at least 6 characters long.");  
        	   return false;  
        	   }  
         }  
               
       </script>
   		
      <form  name="loginfrom" action="login"  method="get" onsubmit="return validateform()">
         <br>
         <br>
         <br>
         <br>
         <br>
          <div align="center">
              <% 
				
	        	String name=(String)request.getAttribute("loginFailedMsg");
	            if(name!=null){
	            	out.print(name); 
	            }
				 
	          %>  
         </div>
         <br>
         <br>
         <div align="center">
		         <table>
		             <tr><td>State Bank of India</td></tr>
			         <tr><td><label>User Name</label></td><td><input name="user" type="text"/></td></tr>
			         <tr><td><label>Password</label></td><td><input name="pwd" type="password"/></td></tr>
			         <!-- <tr align="center"><td><input type="submit" value="login"/></td></tr> -->
			     </table> 
	     </div>
	     <br>
	     <div align="center">
	     	<input type="submit" value="login"/>
	     </div>
      </form>
   </body>
</html>
