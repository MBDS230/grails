$(function() {
    $("#buttonConnexion").click(function(e){

        e.preventDefault();
        var username = $('input[name="usernameConnexion"]').val();
        var motDePasse = $('input[name="motDePasseConnexion"]').val();
        var form = $(this).parents('form:first');
        var formAction = form.attr("action");

        if((username === null || username === '') || (motDePasse === null || motDePasse === ''))
        {
            $("#errorConnexion").empty();
            $("#errorConnexion").append("Veuillez remplir les champs");
            alert("error");
            return;
        }
        $.ajax({
            url: "/user/login",
            type: 'POST',
            data: {
                username : username,
                motDePasse : motDePasse
            },
            success:function(response){
                console.log(response);
                if(response.status.status === 200)
                {
                    alert("mistofoka 200");
                    window.location.href = "/game/index";
                }
                else if(response.status.status === 500)
                {
                    alert("mitsofoka 500");
                    $("#errorConnexion").empty();
                    $("#errorConnexion").append(response.status.messageErreur);
                }
            },
            error:function(xhr, textStatus, errorThrown ){
                $("#errorConnexion").empty();
                $("#errorConnexion").append("Error in ajax request");
            }
        });
    });

    $("#buttonInscription").click(function(){
        var username = $('input[name="usernameInscription"]').val();
        var password = $('input[name="motDePasseInscription"]').val();
        var formData = new FormData($("#formInscription"));
        console.log(formData);
        //fd.append("CustomField", "This is some extra data");
        $.ajax({
            url: '/user/inscription',
            type: 'POST',
            data: formData,
            success:function(response){
                console.log(response);
                if(response.status === 200)
                {
                    // Asia messsage hoe success inscription
                    window.location.href = "/game/index";
                }
                else if(response.status === 500)
                {
                    $("#errorConnexion").empty();
                    $("#errorConnexion").append(response.messageErreur);
                }
            },
            cache: false,
            contentType: false,
            processData: false
        });
    });

    $(".boutonJouer").click(function(){

        $(".contact.active").removeClass("active");
        $(this).parents('.contact').addClass("active");
        var idAdversaire = $(this).attr("data-id");
        $(".contentJouer").removeClass("hide");
        $(".contentJouer").addClass("show");

        $(".contentMessage").removeClass("show");
        $(".contentMessage").addClass("hide");


    });

    $(".boutonMessage").click(function(){

        $(".contact.active").removeClass("active");
        $(this).parents('.contact').addClass("active");
        var idAdversaire = $(this).attr("data-id");
        $(".contentMessage").removeClass("hide");
        $(".contentMessage").addClass("show");

        $(".contentJouer").removeClass("show");
        $(".contentJouer").addClass("hide");

    });
});
