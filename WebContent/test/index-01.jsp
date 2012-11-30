<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="clib" uri="http://www.github.com/ledlogic/clib/tag/1.0" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <clib:link rel="stylesheet" href="../css/normalize.css" />
        <clib:link rel="stylesheet" href="../css/main.css" />
        <clib:script src="../js/vendor/modernizr-2.6.2.min.js"></clib:script>
        <clib:style-render />
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

		<h1>Test</h1>
		
        <!-- Add your site or application content here -->
        <p>Hello world! This is HTML5 Boilerplate.</p>

        <clib:script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></clib:script>
        <clib:script>window.jQuery || document.write('<' + 'script src="../js/vendor/jquery-1.8.2.min.js"><\/script>' + '>');</clib:script>
        <clib:script src="../js/plugins.js"></clib:script>
        <clib:script src="../js/main.js"></clib:script>
        <clib:script-render />
    </body>
</html>
