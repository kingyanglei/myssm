var mainModule = angular.module('mainModule',[]);
mainModule.controller('createEmployeeCtrl', function ($scope, $http) {
    $scope.employee ={
        empName: 'yanglei',
        gender: 'man',
        email: 'asd@123.com',
        dId: 2
    };
    function init() {
         $http({
             method: 'POST',
             url: '/rest/ssm/employee',
             data: $scope.employee,
             contentType: 'application/json',
             dataType: 'json'
         }).success(function (data) {
             //数据绑定
             //console.log(JSON.stringify(data));
             $scope.employee = data;
         });
     }

     init();
});