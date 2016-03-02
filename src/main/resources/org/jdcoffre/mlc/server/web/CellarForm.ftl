<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Little Cellar</title>

    <!-- Bootstrap -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

      <h1>Cellar</h1>
      <div id="cellarContent"></div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
         $.ajax({
             type: "GET",
             url: "/bottles",
             data: {},
             dataType: "json",
             success: function(data, textStatus) {
                 var html = "<ul><br/>\n";
                 $.each(data, function(i,bottle) {
                     html += "<li>" + bottle.name + "</li>\n";
                 });
                 html += "</ul><br/>\n";

                 $("#cellarContent").empty().append(html);
             }
         }).done(function(){
                 alert("ok");
         });
    </script>
  </body>
</html>