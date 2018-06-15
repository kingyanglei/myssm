var mainModule = angular.module('mainModule',[]);
mainModule.controller('mainCtrl', function ($scope, $http) {

    $scope.employees = [];

    $scope.createEmployee = function () {

    }

    function init() {
        $http({
            method: 'GET',
            url: '/rest/ssm/employees',
            dataType: 'json'
        }).success(function (data) {
            //数据绑定
            //console.log(JSON.stringify(data));
            $scope.employees = data;
        });
    }

    init();
});