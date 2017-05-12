


$( "#add_spec" ).click(function() {

  j++;
 $("#numOfSpec").val(''+j);
if(j> 9){
$( "#add_spec" ).prop( "disabled", true );
}
if( j> 10){
return false;
}

 $( "#del_spec" ).prop( "disabled", false );



 $( "#spec_div" ).append('<div class="input-group" style="margin-top:10px;">'
                           + '<input name="key'+j+'" type="text" class="form-control" placeholder="Key'+j+'"/>'
                           + '<span class="input-group-addon">-</span>'
                           + '<input name="value'+j+'" type="text" class="form-control" placeholder="Value'+j+'"/>'
                           + '</div>');

return false;

});

$( "#del_spec" ).click(function() {
j--;
$("#numOfSpec").val(''+j);

if(j == 1){
$('#spec_div div').last().remove();
$( "#del_spec" ).prop( "disabled", true );
return false;
}

if(j<= 10){
$( "#add_spec" ).prop( "disabled", false );
}


$('#spec_div div').last().remove();
return false;
});