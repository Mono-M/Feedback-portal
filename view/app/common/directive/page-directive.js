(function () {
    "use strict"
    angular
        .module("commonDirectivs")
        .directive("pageHeader", pageHeader);
})();

function pageHeader() {
    return {
        restrict: "EA",
        templateUrl: "templates/page-header.html"
    }
}