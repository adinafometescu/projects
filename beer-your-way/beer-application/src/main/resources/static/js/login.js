$(function() {
   $("#logout-link").click(function(e){
        e.preventDefault();
        $("#logoutForm").submit();
   });
});