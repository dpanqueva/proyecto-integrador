$(document).ready(function () {

  $( "#hola" ).on( "click", function() {
    console.log( $( this ).text() );
//      debugger;
    $.ajax({

      type: "GET",
      //data: {"cddepartamento": 104},
    /*  headers: {
       'Authorization':'Bearer eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NjI2NDU1OTAsImV4cCI6MTY2MjY0Njc5MCwiaWQiOjIsImVtYWlsIjoiZHBhbnF1ZXZAZW1lYWwubnR0ZGF0YS5jb20iLCJsYXN0TmFtZSI6InBydWViYSJ9.iq3etzZvTxX4D1NrxlilBimGS1WbCf48baFSmK-RSUY'},*/
      url: "http://localhost:8087/api/v1/product",
      dataType: 'json',
      success: function (d) {
          //$('#cdmunicipio').html(d);
          $.each(d, function(i, data) {
           //$('#cdmunicipio').append("<option value='" + data.cdlista + "'>" + data.dsnombre + "</option>");
           console.log(data);
           });
      },
      error: function () {
          alert('error');
      }
    });
  });
});
