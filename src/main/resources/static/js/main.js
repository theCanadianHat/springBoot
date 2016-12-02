var context = window.location.protocol + "//" + window.location.host;

var addStudent = function(){
	var $validation = $("#addStudentValidationDiv");
	var $studentName = $("#studentName");
	var $studentSubject = $("#studentSubject");
	
	if($studentName.val() == "" || $studentSubject.val() == ""){
		$validation.removeClass("hidden");
		$validation.attr("style","display: block");
		return;
	}else{
		var newName = $studentName.val();
		var newSubject = $studentSubject.val();
				
		$.ajax({
			method: "GET",
			url: context + "/addStudent",
			data: {name: newName, subject: newSubject},
			success: function(data){
				window.location.reload(true);
			},
			error: function(data){
				alert("ajax error method hit");
			}
		});
	}	
}

var removeStudent = function(){
	var $validation = $("#removeStudentValidationDiv");
	var $studentId = $("#studentId");
	
	if($studentId.val() == ""){
		$validation.removeClass("hidded");
		$validation.attr("style","display: block");
	}else{
		var removeId = $studentId.val();
		
		$.ajax({
			method: "GET",
			url: context + "/removeStudent",
			data: {id: removeId},
			success: function(){
				window.location.reload(true);
			}
		});
	}
}