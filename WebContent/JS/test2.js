
mesFruitsTab = ["Banane", "Pommes", "Poires", "Tomate"];


monController = function ($scope){
    $scope.visible = false;
    
    $scope.creer = function () {
        $scope.mesFruits = mesFruitsTab;
    };
    $scope.effacer = function () {
        $scope.mesFruits = null;
        mesFruitsTab = [];
    };
    $scope.afficher = function () {
         $scope.visible = !($scope.visible);
    };
    
    $scope.ajout = function(){
        $scope.mesFruits = mesFruitsTab;
        if ($scope.monFruit != "") {
            $scope.mesFruits.push($scope.monFruit);
            $scope.monFruit = "";
        } 
    }
}
