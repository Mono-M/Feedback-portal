(function () {
    "use strict"
    angular
        .module("feature")
        .controller("AchievementListController", AchievementListController);

    AchievementListController.$inject = [];

    function AchievementListController() {
        let $ctrl = this;
        $ctrl.getAllAchievements = getAllAchievements;

        function getAllAchievements() {
            let achievements = [];
            achievements.push({
                'id': '9',
                'headerImg': 'img/background/background9.jpg',
                'achievementImg': 'img/icon/icon2.png',
                'achievementLabel': 'Achievement label9',
                'achievementDescription': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
                'senderImg': 'img/background/background9.jpg',
                'senderName': 'vladyslav dubinin'
            });

            return achievements;
        }
    }
})();