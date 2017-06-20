$(document).ready(function() {
	
	$(".deleteBtn").on("click", function(){
		var itemId =  $(this).attr("data-id");
		$.ajax({
		    type : "POST",
		    url : "http://localhost:8080/crudapp/delete",
		    data : {
		    "id" : itemId
		    },
		    success: function(data){
		    	if (data == true){
		    		location.reload();
		    	}else {
		    		$("#errorDiv").text("Error in deleting item").css("display","block").fadeIn(2000).fadeOut(3000);	
		    	}
		    }
		});
	});
});