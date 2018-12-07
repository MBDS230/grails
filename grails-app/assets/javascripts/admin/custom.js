jQuery(document).ready(function($) {
    $("#formConnexion").submit(function (e) {

        e.preventDefault();
        var username = $('input[name="username"]').val();
        var motDePasse = $('input[name="motDePasse"]').val();
        var formAction = $(this).attr("action");

        if ((username === null || username === '') || (motDePasse === null || motDePasse === '')) {
            $("#errorFormLogin").empty();
            $("#errorFormLogin").append("Veuillez remplir les champs");
            return;
        }

        $.ajax({
            url: formAction,
            type: 'POST',
            data: {
                username : username,
                motDePasse : motDePasse
            },
            success:function(response){
                console.log(response);
                if(response.status.status === 200)
                {
                    window.location.href = response.status.redirectUrl;
                }
                else if(response.status.status === 500)
                {
                    $("#errorFormLogin").empty();
                    $("#errorFormLogin").append(response.status.messageErreur);
                }
            },
            error:function(xhr, textStatus, errorThrown ){
                $("#errorFormLogin").empty();
                $("#errorFormLogin").append("Error in ajax request");
            }
        });
    });
});