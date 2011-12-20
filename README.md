Cambridge is a template engine for the java platform which can be used your web framework of choice. It currently supports servlets, JAX-RS, Play Framework. (Spring MVC and Struts 2.0 support is in development.)

Pure markup syntax, performance, extensibility and simplicity are the key features of Cambridge. Designed by web developers for web developers to make your life easier.

# Show me the code

`<div id="loginBox" a:if="!loggedIn">
   Username: <input type="text" name="username"/>
   Password: <input type="password" name="password"/>
</div>
<div a:else>
   <div>Hello ${user.name}!</div>
   <div>Here are your online friends</div>

   <ul>
      <li a:foreach="user.onlineFriends" a:as="friend">${friend.name}</li>
   </ul>
</div>`

## Join the mailing list and get support

[Support Mailing List](http://groups.google.com/group/cambridgetemplates)