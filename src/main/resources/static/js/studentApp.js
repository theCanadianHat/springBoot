angular.module('studentApp', [])
.controller('StudentController', ['$scope', function($scope){
	$scope.angStudents = [
		{id:"0", name: "Noah", subject: "Science"}	
	];
}])
.directive('myDirective', function(){
	var temp = 1;
	return{
		template: function(elem, attr){
			return "trying to get data off of attributes: " + attr.myDirective;
		}
			
	};
});