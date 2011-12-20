# Simple is the keyword

Cambridge is a template engine for the java platform which can be used with your web framework of choice. It currently supports servlets, JAX-RS, Play Framework. (Spring MVC and Struts 2.0 support is in development.)

Pure markup syntax, performance, extensibility and simplicity are the key features of Cambridge. Designed by web developers for web developers to make your life easier.

## Show me the code

    <div id="loginBox" a:if="!loggedIn">
       Username: <input type="text" name="username"/>
       Password: <input type="password" name="password"/>
       <input type="button" onclick="login();" value="Sign in"/>
    </div>
    <div a:else>
       <div>Hello ${user.name}!</div>
       <div>Here are your online friends:</div>

       <ul>
          <li a:foreach="user.onlineFriends" a:as="friend">${friend.name}</li>
       </ul>
    </div>

If you're wondering what the html code above means, here is what it tells Cambridge to do.
The first div #loginBox will be displayed only if the loggedIn variable in the data model is false. Otherwise,
the immediately following div will be rendered instead. If you look at the `${user.name}` syntax, that is how you
render expressions in Cambridge. In this case it is printing the name property of a User object. Finally if the user
is already logged in, we want to display online friends of the current user as a bunch of `<li>` elements.
You don't need to wrap the `<li>` tags with some looping code in cambridge. All you need to do is to define an
`a:foreach` attribute which will iterate over the onlineFriends property of the user object and render a
separate `<li>` for every online friend of `user`.

The attributes like `a:if`, `a:foreach` are called Behaviors in Cambridge. You can attach behaviors to your markup
tags by adding these attributes which themselves will not be displayed in the rendered output.

## Overview of features

### Pure markup syntax
You don't need to pollute your html/xml template file with any server side code, tons of external tags or scripts. Everything
can be achieved by just adding custom attributes to your existing tags.

### Template inheritance
Cambridge template files can extend other template files and override certain parts of the parent template. This makes maintaining
your templates much easier with project wide skeleton templates that you can re-use.

### Extensibility
Cambridge is designed from ground up with modularity and extensibility in mind. The internal API which is used to build
all the built-in behaviors, functions, filters and custom tags is very available to anyone using Cambridge so you can
easily add new features to Cambrige. Cambridge also allows you to plug-in your expression language of choice such as MVEL, OGNL or JEXL
if you want more features then what the built-in expression language provides.

### Performance
Cambridge is optimized for web-scale. Our benchmarks show that Cambridge outperforms its alternatives like Freemarker, Velocity and
Play Framework. Once parsed, Cambridge templates get converted to highly efficient reusable/immutable objects.

### Rich web framework support
Cambridge comes with out of the box support for many of the MVC style popular web frameworks.

## Join the mailing list and get support

[Support Mailing List](http://groups.google.com/group/cambridgetemplates)