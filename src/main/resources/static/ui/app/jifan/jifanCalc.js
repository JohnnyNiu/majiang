
angular.module("jifanCalc", [])
    .controller("jifanCalcCtrl", function($scope, $http){

        _init_scope_from_schema($http, $scope);

        /**
         * @param fanItemId
         * @param chnage
         */
        $scope.changeFanItem = function(fanItemId, change) {
            var existedIndex = _getIndexInArray(fanItemId, $scope.reqDto.fanItems);
            if(existedIndex == -1) {
                throw "can't find fan item: "+ fanItemId;
            } else {
                $scope.reqDto.fanItems[existedIndex]["number"] += change;
            }

        }

        $scope.changeWinType = function(winType){
            $scope.reqDto.win = winType.id;
        }

        $scope.submit = function() {
            $http.post("/api/jifan", $scope.reqDto).success(function(data){
                 $scope.result = data;
            });
        };

        $scope.reset = function() {
            $scope.result = {};
            _init_scope_from_schema($http, $scope);
        };
    });
function _getIndexInArray(fanItemId, fanItemsArray) {
    result=-1;
    $.each(fanItemsArray, function($index){
        if(fanItemsArray[$index]["fanItemType"] == fanItemId) {
            result = $index;
            return;
        }
    })
    return result;
}

function _init_scope_from_schema($http, $scope) {
//init schema
    $http.get("/api/jifan/schema").success(function (data) {
        $scope.fanItemTypes = data["fanItemTypes"];
        $scope.reqDto = _initFanItemInReqDto(data["fanItemTypes"]);
        $scope.winTypes = data["winTypes"];
        //todo:    =["闷点", "闷庄", "闷","闷", "闷"];
        $scope.menItems = data["menItems"];
    });
}

/**
 * Init fan items as 0
 * @param fanItemTypes
 * @private
 */
function _initFanItemInReqDto(fanItemTypes) {
    var result = {"fanItems":[], win:null, "menItems":{}};
    for(var i in fanItemTypes) {
        result.fanItems.push({"fanItemType":fanItemTypes[i]["id"], "number":0});
    }
    return result;
}
