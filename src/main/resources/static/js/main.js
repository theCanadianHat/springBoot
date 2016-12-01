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
	}
	
	
	
}