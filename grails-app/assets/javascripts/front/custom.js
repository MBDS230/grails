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
                console.log(response);
                if(response.status.status === 200)
                {
                    window.location.href = response.status.redirectUrl;
                }
                else if(response.status.status === 500)
                {
                    $("#buttonInscription").removeAttr("disabled");
                    $("#errorConnexion").empty();
                    $("#errorConnexion").append(response.status.messageErreur);
                }
            },
            error:function(error){
                console.log(error);
            }
        });
    });

    $(document).on("click",".boutonScore",function(){

        $(".contact.active").removeClass("active");
        $(this).parents('.contact').addClass("active");
        var idAdversaire = $(this).attr("data-id");
        var apiUrl = "/match/resultatMatch"
        $.ajax({
            url: apiUrl,
            type: 'POST',
            data: {
                idAutreJoueur : idAdversaire
            },
            success:function(response){
                console.log(response);
                if(response.status.status === 200)
                {
                    console.log(response.results);
                    $(".contentScore").empty();
                    $(".contentScore").append(response.results);
                }
                else if(response.status.status === 500)
                {
                    $(".messageErreur").empty();
                    $(".messageErreur").append(response.status.messageErreur);
                }
            },
            error:function(xhr, textStatus, errorThrown ){
                alert("Erreur Ajax");
            }
        });

        $(".contentScore").removeClass("hide");
        $(".contentScore").addClass("show");

        $(".contentMessage").removeClass("show");
        $(".contentMessage").addClass("hide");
    });

    $(document).on("click",".boutonDemander",function(){

        var formUrl = $(this).attr("data-url-demande");
        var idAutreJoueur = $(this).attr("data-id");
        $.ajax({
            url: formUrl,
            type: 'POST',
            data: {
                idAutreJoueur : idAutreJoueur,
                duree : 3
            },
            success:function(response){
                console.log(response);
                if(response.status.status === 200)
                {
                    console.log(response.results);
                    $(".mesDemandes tbody").append(response.results);
                }
                else if(response.status.status === 500)
                {
                    $(".messageErreur").empty();
                    $(".messageErreur").append(response.status.messageErreur);
                }
            },
            error:function(xhr, textStatus, errorThrown ){
                alert("Erreur Ajax");
            }
        });
    });


    $(document).on("click",".checkbox-cron",function(){

        var cronValue = $(".checkbox-cron").val();
        //activer cron
        if(cronValue === "0")
        {
            var formUrl="/message/activeCron";
            var idAutreJoueur = $(".contentMessage").attr("data-id-recepteur");

            $.ajax({
                url: formUrl,
                type: 'POST',
                data: {
                    idAutreJoueur : idAutreJoueur
                },
                success:function(response){
                    console.log(response);
                    if(response.status.status === 200)
                    {
                        $(".checkbox-cron").val("1");
                        console.log("success");
                    }
                    else if(response.status.status === 500)
                    {
                        $(".messageErreur").append(response.status.messageErreur);
                    }
                },
                error:function(xhr, textStatus, errorThrown ){
                    alert("Erreur Ajax");
                }
            });
        }
        //desactiver cron
        else
        {
            var formUrl="/message/desactiveCron";
            var idAutreJoueur = $(".contentMessage").attr("data-id-recepteur");
            $.ajax({
                url: formUrl,
                type: 'POST',
                data: {
                    idAutreJoueur : idAutreJoueur
                },
                success:function(response){
                    console.log(response);
                    if(response.status.status === 200)
                    {

                        $(".checkbox-cron").val("0");
                        console.log("success");
                    }
                    else if(response.status.status === 500)
                    {
                        alert("erreur " + response.status.messageErreur);
                    }
                },
                error:function(xhr, textStatus, errorThrown ){
                    alert("Erreur Ajax");
                }
            });
        }
    });

    $(document).on("click",".boutonMessage",function(){

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

        $(".contentScore").removeClass("show");
        $(".contentScore").addClass("hide");

    });

    $(document).on("click",".boutonJouer",function(){
        var apiUrl = "/match/jouer";
        var idDemande = $(this).attr("data-id-demande");
        $.ajax({
            url: apiUrl,
            type: 'POST',
            data:{
                idDemandeMatch : idDemande
            },
            success:function(response){
                console.log(response);
                if(response.status.status === 200)
                {
                    window.location.href = response.status.redirectUrl;
                }
                else if(response.status.status === 500)
                {
                    $(".messageErreur").empty();
                    $(".messageErreur").append(response.status.messageErreur);
                }
            },
            error:function(xhr, textStatus, errorThrown ){

                console.log(xhr);
            }
        });
    });

});
