

// monController = function ($scope){
//     $scope.message = "Bonjour Rennes";
// }


function monControl($scope,$http) {
    $scope.affichage=function () {
        $http.get('/api/affiche').success(function(data){
            $scope.listePerso=data;
        })
    }
}