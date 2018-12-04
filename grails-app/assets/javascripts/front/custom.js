$(function() {
    $("#buttonConnexion").click(function(e){
        $(this).attr('disabled', "disabled");
        e.preventDefault();

        var username = $('input[name="usernameConnexion"]').val();
        var motDePasse = $('input[name="motDePasseConnexion"]').val();
        var form = $(this).parents('form:first');
        var formAction = form.attr("action");

        if((username === null || username === '') || (motDePasse === null || motDePasse === ''))
        {

            $(this).removeAttr("disabled");
            $("#errorConnexion").empty();
            $("#errorConnexion").append("Veuillez remplir les champs");
            alert("error");
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
                    $("#buttonConnexion").removeAttr("disabled");
                    window.location.href = response.status.redirectUrl;
                }
                else if(response.status.status === 500)
                {
                    $("#errorConnexion").empty();
                    $("#errorConnexion").append(response.status.messageErreur);
                    $("#buttonConnexion").removeAttr("disabled");
                }
            },
            error:function(xhr, textStatus, errorThrown ){

                $("#buttonConnexion").removeAttr("disabled");
                $("#errorConnexion").empty();
                $("#errorConnexion").append("Error in ajax request");
            }
        });
    });


    $('#formInscription').submit(function(e) {
        e.preventDefault();
        $(this).attr('disabled', "disabled");
        var username = $('input[name="username"]').val();
        var motDePasse = $('input[name="motDePasse"]').val();
        var formAction = $(this).attr("action");

        var file = $('#file').val();
        var jForm = new FormData();
       //jForm.append("file", $('#file').get(0).files[0],file);
        jForm.append("username", username);
        jForm.append("motDePasse",motDePasse);
        $.ajax({
            url: formAction,
            type: "POST",
            data: jForm,
            mimeType: "multipart/form-data",
            contentType: false,
            cache: false,
            processData: false,
            success: function(response) {
                alert("200");
                console.log(response);
                if(response.status.status === 200)
                {
                    alert("mistofoka 200");
                    window.location.href = response.status.redirectUrl;
                }
                else if(response.status.status === 500)
                {
                    alert("mitsofoka 500");
                    $("#buttonInscription").removeAttr("disabled");
                    $("#errorConnexion").empty();
                    $("#errorConnexion").append(response.status.messageErreur);
                }
            },
            error:function(error){
                console.log(error);
                alert("error");
            }
        });
    });

    $(document).on("click",".boutonJouer",function(){
        alert("jouer");
        $(".contact.active").removeClass("active");
        $(this).parents('.contact').addClass("active");
        var idAdversaire = $(this).attr("data-id");
        $(".contentJouer").removeClass("hide");
        $(".contentJouer").addClass("show");

        $(".contentMessage").removeClass("show");
        $(".contentMessage").addClass("hide");


    });

    $(document).on("click",".boutonMessage",function(){
        alert("message");
        $(".contentMessage").remove();
        var apiUrl = "/message/listeMessage";
        var idAutreJoueur = $(this).attr("data-id");
        console.log(idAutreJoueur);
        $.ajax({
            url: apiUrl,
            type: 'POST',
            data:{
                idAutreJoueur : idAutreJoueur
            },
            success:function(response){
                console.log(response);
                if(response.status.status === 200)
                {
                    console.log(response.results);

                    $(".frameChat").append(response.results);
                }
                else if(response.status.status === 500)
                {
                    console.log(response.status.messageErreur);
                }
            },
            error:function(xhr, textStatus, errorThrown ){

                console.log(xhr);
            }
        });

        $(".contact.active").removeClass("active");
        $(this).parents('.contact').addClass("active");
        var idAdversaire = $(this).attr("data-id");
        $(".contentMessage").removeClass("hide");
        $(".contentMessage").addClass("show");

        $(".contentJouer").removeClass("show");
        $(".contentJouer").addClass("hide");



    });
});
