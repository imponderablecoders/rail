
var i =1;

$( document ).ready(function() {
    $( "#del_spec" ).prop( "disabled", true );
});

$( "#add_spec" ).click(function() {

  i++;
 $("#numOfSpec").val(''+i);
if(i> 9){
$( "#add_spec" ).prop( "disabled", true );
}
if( i> 10){
return false;
}

 $( "#del_spec" ).prop( "disabled", false );



 $( "#spec_div" ).append('<div class="input-group" style="margin-top:10px;">'
                           + '<input name="key'+i+'" type="text" class="form-control" placeholder="Key'+i+'"/>'
                           + '<span class="input-group-addon">-</span>'
                           + '<input name="value'+i+'" type="text" class="form-control" placeholder="Value'+i+'"/>'
                           + '</div>');

return false;

});

$( "#del_spec" ).click(function() {
i--;
$("#numOfSpec").val(''+i);

if(i == 1){
$('#spec_div div').last().remove();
$( "#del_spec" ).prop( "disabled", true );
return false;
}

if(i<= 10){
$( "#add_spec" ).prop( "disabled", false );
}


$('#spec_div div').last().remove();
return false;
});
