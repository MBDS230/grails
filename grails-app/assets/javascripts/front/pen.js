$(".messages").animate({ scrollTop: $(document).height() }, "fast");

$("#profile-img").click(function() {
	$("#status-options").toggleClass("active");
});

$(".expand-button").click(function() {
  $("#profile").toggleClass("expanded");
	$("#contacts").toggleClass("expanded");
});

$("#status-options ul li").click(function() {
	$("#profile-img").removeClass();
	$("#status-online").removeClass("active");
	$("#status-away").removeClass("active");
	$("#status-busy").removeClass("active");
	$("#status-offline").removeClass("active");
	$(this).addClass("active");
	
	if($("#status-online").hasClass("active")) {
		$("#profile-img").addClass("online");
	} else if ($("#status-away").hasClass("active")) {
		$("#profile-img").addClass("away");
	} else if ($("#status-busy").hasClass("active")) {
		$("#profile-img").addClass("busy");
	} else if ($("#status-offline").hasClass("active")) {
		$("#profile-img").addClass("offline");
	} else {
		$("#profile-img").removeClass();
	};
	
	$("#status-options").removeClass("active");
});

function newMessage() {
	message = $(".message-input input").val();
	if($.trim(message) == '') {
		return false;
	}
    var apiUrl = "/message/envoyerMessage";
    var idRecepteur = $(".contentMessage").attr("data-id-recepteur");
	$.ajax({
        url: apiUrl,
        type: 'POST',
        data:{
        	message : message,
            idAutreJoueur : idRecepteur
        },
        success:function(response){
            console.log(response);
            if(response.status.status === 200)
            {
                console.log(response.results);
                $('.messages ul').append(response.results);
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
	$('.message-input input').val(null);
	$(".messages").animate({ scrollTop: $(document).height() }, "fast");
};

$(document).on("click",".submit",function() {
  newMessage();
});

$(window).on('keydown', function(e) {
  if (e.which == 13) {
    newMessage();
    return false;
  }
});
//# sourceURL=pen.js	