(function () {
    "use strict"
    angular
        .module("commonRoute", ["ngRoute"])
        .config(function ($routeProvider) {
            $routeProvider
                .when("/achievement", {
                    templateUrl: "templates/achievement.html"
                })
                .when("/feedback", {
                    templateUrl: "templates/feedback.html"
                }).when("/achivement-cut", {
                    templateUrl: "templates/achievement-cut-image.html"
                });
        })
})();