function AppCtrl($scope, $http) {
    console.log("Hello world from controller..");

    //Get contactlist request..
    var refresh = function () {
        $http.get('/contactlist').success(function (response) {
            console.log("I got the response from server..");
            $scope.contactlist = response;
            $scope.contact = "";
        });
    };

    //Get customer list is page refresh method..
    refresh();
    //Post contact request..
    $scope.addContact = function () {
        console.log($scope.contact);
        $http.post('/contactlist', $scope.contact).success(function (response) {
            console.log(response);
            refresh();
        });
    };

    //Remove contact request..
    $scope.remove = function (id) {
        console.log("Delete contact id : " + id);
        $http.delete('/contactlist/' + id).success(function (response) {
            console.log(response);
            refresh();
        });
    };

    //Edit contact request..
    $scope.edit = function (id) {
        console.log("Edit contact id : " + id);
        $http.get('/contactlist/' + id).success(function (response) {
            $scope.contact = response;
            $scope.buttonAddDisabled = true;
            $scope.buttonUpdateDisabled = true;
        });
    };

    //Update the contact request..
    $scope.update = function () {
        console.log("Update contact id : " + $scope.contact._id);
        $http.put('/contactlist/' + $scope.contact._id, $scope.contact).success(function (response) {
            $scope.buttonAddDisabled = false;
            $scope.buttonUpdateDisabled = false;
            refresh();
        });
    };
}
