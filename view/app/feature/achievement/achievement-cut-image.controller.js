(function () {
    "use strict"
    angular
        .module("feature")
        .controller("AchievementCutImageController", AchievementCutImageController);

    AchievementCutImageController.$inject = [];

    function AchievementCutImageController() {
        let $ctrl = this;
        let defaultHeaderImg = 'img/background/default-background.jpg';
        let defaultAchievementImg = 'img/icon/default-icon.png';

        $ctrl.getHeaderImg = getHeaderImg;
        $ctrl.getAchievementImg = getAchievementImg;

        function getHeaderImg() {
            return defaultHeaderImg;
        }

        function getAchievementImg() {
            return defaultAchievementImg;
        }
    }
})();