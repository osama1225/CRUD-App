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
	
	$(".editBtn").on("click", function(){
		window.location = $(this).attr("data-url");
	});
	
	$(".backBtn").on("click", function(){
		window.location = $(this).attr("data-url");
	});
	
	showUpdatedMessageIfExist();
});

function showUpdatedMessageIfExist(){
	var updated = $("input[name='updated']").val();
	if (updated.length > 0){
		$("#updatedDiv").css("disaply","block").fadeIn(2000).fadeOut(3000);
	}
}