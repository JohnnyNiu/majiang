angular.module("jifanCalc", [])
    .controller("jifanCalcCtrl", function($scope, $http){

        _init_ui_data_from_httpBackend($http, $scope);

        /**
         * @param fanItemId
         * @param chnage
         */
        $scope.changeFanItem = function(fanItemId, change) {
           $scope.uiData.fanItems[fanItemId]["count"] += change;

        };

        $scope.changeWinType = function(winType){
            $scope.uiData.winTypes.forEach(function(item){
                if(item.id == winType) {
                    item.clicked = true;
                } else{
                    item.clicked = false;
                }
            });
        };

        $scope.changeMenItem = function(index) {
            $scope.uiData.menItems[index].clicked = true;
        };

        $scope.submit = function() {

            if(!validRequest($scope.uiData, $scope)) {
                return;
            }

            var requestDto = mashalToRequestDto($scope.uiData);
            $http.post("/api/jifan", requestDto).success(function(data){
                 $scope.clacResult = data;
            });
        };

        $scope.reset = function() {
            $scope.clacResult = {};
            _init_ui_data_from_httpBackend($http, $scope);
        };
});
function resetValidation($scope) {
    $scope.uiData.errors = {
        fanItems: [],
        win: [],
        menItems: []
    };
}
function _init_ui_data_from_httpBackend($http, $scope) {

    $http.get("/api/jifan/schema").success(function (httpResponseData) {
        $scope.uiData = {};

        $scope.uiData.fanItems = {};
        httpResponseData["fanItemTypes"].forEach(
            function (item) {
                item.count = 0;
                $scope.uiData.fanItems[item.id] = item;
            }
        );

        $scope.uiData.winTypes = [];
        httpResponseData["winTypes"].forEach(function (item) {
            item.clicked = false;
            $scope.uiData.winTypes.push(item);
        });
        $scope.uiData.menItems = [];
        httpResponseData["menItems"].forEach(function (item, index) {
            item.clicked = false;
            item.index = index;
            $scope.uiData.menItems.push(item);
        });
        resetValidation($scope);
    });
}

function validRequest(uiData, $scope) {
    isValid = true;
    resetValidation($scope)
    if(uiData.winTypes.filter(function (w) {
        return w.clicked;
    }).length == 0) {
        $scope.uiData.errors.win.push("需要选择和牌类型");
        isValid = false;
    }

    return isValid;
}

function mashalToRequestDto(uiData) {
    requestDto = {fanItems:[], win:null, menItems:[]};

    Object.keys(uiData.fanItems).forEach(function(itemId){
        var item = uiData.fanItems[itemId];
        requestDto.fanItems.push({"fanItemType":item.id, "number":item.count});
    });
    requestDto.win = uiData.winTypes.filter(function(item){return item.clicked})[0]["id"];
    
    uiData.menItems.forEach(function(item){
        if(item.clicked) {
            requestDto.menItems.push(item.id);
        }
    });

    return requestDto;
}
