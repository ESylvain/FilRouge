st1={
    nom:"Martin",
    prenom:"Jean",
    dateNaissance:"13/09/1975",
    formation:"formation"
}
st2={
    nom:"Trei",
    prenom:"Helmut",
    dateNaissance:"05/12/1875",
    formation:"hehe"
}

mesStagiairesTab = [];


monController = function ($scope){
    $scope.mesStagiaires = mesStagiairesTab;
    $scope.ajout = function(){
       
        // if ($scope.nom != "") {
        //   stagiaire = {
        //       nom : $scope.nom,
        //       prenom : $scope.prenom,
        //       dateNaissance : $scope.dateNaissance, 
        //       formation : $scope.formation  
        //   } ;
        //     $scope.mesStagiaires.push(stagiaire);
        // } 
        if ($scope.nom != "") {
            $scope.mesStagiaires.push($scope.stagiaire);
            $scope.stagiaire = null;
        } 
    }
}
