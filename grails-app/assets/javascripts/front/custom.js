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
                alert("tafiditra");
                window.location.href = "/game/index";
                //alert("Data: " + data + "\nStatus: " + status);
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
            url: 'upload.php',
            type: 'POST',
            data: formData,
            success:function(data){
                //$('#output').html(data);
                alert("Data: " + data + "\nStatus: " + status);
            },
            cache: false,
            contentType: false,
            processData: false
        });
    });
});
