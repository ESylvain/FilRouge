var app = angular.module('formateurApp', []);

app.controller('formateurCtrl', function($scope, $http) {

	if (typeof $scope.inputSearchAJS == 'undefined') {
		$scope.inputSearchAJS = "";
	}
	

	function getFormateursByName(name) {
		$http.get(
				"/ProjetWeb3_JSF/rest/users/gfbnq?name="
						+ $scope.inputSearchAJS).then(function(response) {

			console.log("Appel controleur : " + name);
			console.log(JSON.stringify(response.data, null, '\t'));

			$scope.formateurs = response.data;
		});
	}
	//appel lorsque la page est chargée
	getFormateursByName($scope.inputSearchAJS);
	//appel à chaque lettres tapées
	$scope.appelWS = function appelWS(name) {
		getFormateursByName(name);
	}
	//webservice ailleurs
	$scope.ailleurs = function ailleurs() {
		$http.get(
				"http://192.168.200.60:8080/LearningCenter/rest/formateurs"
						).then(function(response) {

			console.log("Appel controleur 2: ailleurs");
			console.log(JSON.stringify(response.data, null, '\t'));

			$scope.formateurs = response.data;
		});
	}
	

});

app.directive('myEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.myEnter);
                });

                event.preventDefault();
            }
        });
    };
});