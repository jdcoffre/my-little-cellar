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
      <div>
        <label>Name *</label>
        <input type="text" class="form-control" id="bottle_name" placeholder="Bottle Name">
        <label>Type</label>
        <select class="form-control" id="wine_type" placeholder="Type of Wine">
            <#list getWineTypes() as wineType>
                <option>${wineType}</option>
            </#list>
        </select>
        <label>Grapes</label>
        <select multiple class="form-control" id="grapes" placeholder="Grapes">
            <#list getGrapes() as grape>
                <option>${grape}</option>
            </#list>
        </select>
        <label>Year</label>
        <input type="text" class="form-control" id="year" placeholder="Year">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="vintage" value="">
            Vintage
          </label>
        </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="grandCru" value="">
            Grand Cru
          </label>
        </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="bio" value="">
            Bio
          </label>
        </div>
        <label>Country</label>
        <input type="text" class="form-control" id="country" placeholder="Country">
        <label>Area</label>
        <input type="text" class="form-control" id="area" placeholder="Area">
        <label>Appellation</label>
        <input type="text" class="form-control" id="appellation" placeholder="Appellation">
        <label>Size</label>
        <input type="text" class="form-control" id="size" placeholder="Size">
        <label>Castle</label>
        <input type="text" class="form-control" id="castle" placeholder="Castle">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="gift" value="">
            Gift
          </label>
        </div>
        <label>Gift from</label>
        <input type="text" class="form-control" id="giftFrom" placeholder="Gift from" disabled>
        <label>Acquisition Date</label>
        <input type="text" class="form-control" id="acquisitionDate" placeholder="Acquisition Date">
        <label>Comment</label>
        <textarea class="form-control" id="comment" placeholder="Comment" rows="3"></textarea>
        <label>Tasting Date</label>
        <input type="text" class="form-control" id="tastingDate" placeholder="Tasting Date">
        <label>Tasting Comment</label>
        <textarea class="form-control" id="tastingComment" placeholder="Comment" rows="3"></textarea>
      </div>
      <button class="btn btn-default" onclick="postBottle()">Create</button>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
         $('#gift').change(function()  {
            if ($(this).is(':checked')) {
                $('#giftFrom').prop('disabled', false);
            } else {
                $('#giftFrom').prop('disabled', true);
            }
         })
    </script>
     <script type="text/javascript">
        function postBottle(){
            var grapesValues = [];
            $('#grapes :selected').each(function(i, selected){
               grapesValues.push('"' + $(selected).text().toUpperCase() + '"');
             });
            var bottle = '{'
                   +'"name" : "' + $("#bottle_name").val() + '",'
                   +'"type" : "' + $("#wine_type").val().toUpperCase() + '",'
                   +'"grapes" : [' + grapesValues + '],'
                   +'"year" : "' + $("#year").val() + '",'
                   +'"vintage" : "' + $("#vintage").is(":checked")   + '",'
                   +'"grandCru" : "' + $("#grandCru").is(":checked")   + '",'
                   +'"bio" : "' + $("#bio").is(":checked")   + '",'
                   +'"country" : "' + $("#country").val() + '",'
                   +'"area" : "' + $("#area").val() + '",'
                   +'"appellation" : "' + $("#appellation").val() + '",'
                   +'"size" : "' + $("#size").val() + '",'
                   +'"castle" : "' + $("#castle").val() + '",'
                   +'"gift" : "' + $("#gift").is(":checked")   + '",'
                   +'"giftFrom" : "' + $("#giftFrom").val() + '",'
                   +'"acquisitionDate" : "' + $("#acquisitionDate").val() + '",'
                   +'"comment" : "' + $("#comment").val() + '",'
                   +'"tastingDate" : "' + $("#tastingDate").val() + '",'
                   +'"tastingComment" : "' + $("#tastingComment").val() + '"'

                   +'}';
            $.ajax({
                url: "/bottles",
                method: 'POST',
                contentType: 'application/json',
                data: bottle,
                error: function(xhr, error){
                    alert("Failed to create new bottle: status " + xhr.status);
                }
            }).done(function(){
                    alert("ok");
            });
        }
    </script>
  </body>
</html>