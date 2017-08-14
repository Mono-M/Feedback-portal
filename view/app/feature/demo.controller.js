(function () {
    "use strict"
    angular
        .module("feature")
        .controller("DemoController", DemoController);

    DemoController.$inject = [];

    function DemoController() {
        let $ctrl = this;
        $ctrl.demo = "TEST!!"
    }
})();