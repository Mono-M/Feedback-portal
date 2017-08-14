(function () {
    "use strict"
    angular
        .module('commonServices')
        .factory("demoService", demoService);

})();

demoService.$inject = [];

function demoService() {
    
    return {
        getText
    }    
    
    function getText() {
        return "TEXT SERVICE";
    }
    
    
}