function fuck(){
	return "fuck";
};

function addStudent(){
	var $validation = $("#validationDiv");
	$validation.hide();
	var $studentName = $("#studentName");
	var $studentSubject = $("#studentSubject");
	
	if($studentName.val() == "" || $studentSubject.val() == ""){
		$validation.show();
		return;
	}else{
		var newName = $studentName.val();
		var newSubject = $studentSubject.val();
		var newURL = window.location.protocol + "//" + window.location.host;
		
		$.ajax({
			method: "GET",
			url: newURL + "/addStudent",
			data: {name: newName, subject: newSubject},
			success: function(){
				window.location.reload(true);
			}
		});
	}
	
}