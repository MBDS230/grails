$(function() {
    var apiUrl = "/user/listeJoueurConnecte";
    $.ajax({
        url: apiUrl,
        type: 'GET',
        success:function(response){
            console.log(response);
            if(response.status.status === 200)
            {
                console.log(response.results);
                $("#contacts").children('ul:first').append(response.results);
            }
            else if(response.status.status === 500)
            {
                console.log(response.status.messageErreur)
                alert("mitsofoka 500");
            }
        },
        error:function(xhr, textStatus, errorThrown ){
            alert("erora");
        }
    });
});