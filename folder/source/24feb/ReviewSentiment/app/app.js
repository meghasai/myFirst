'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [])


    .controller('View1Ctrl', function ($scope, $http) {
        $scope.venueList = new Array();
        $scope.mostRecentReview;
        $scope.getVenues = function () {
            var placeEntered = document.getElementById("txt_placeName").value;
            //var searchQuery = document.getElementById("txt_searchFilter").value;
            if (placeEntered != null && placeEntered != "") {
                document.getElementById('div_ReviewList').style.display = 'none';
                //This is the API that gives the list of venues based on the place and search query.
                var handler = $http.get("https://api.wunderground.com/api/36b799dc821d5836/conditions/q/MO/"+placeEntered+".json");

                handler.success(function (data) {

                    if (data != null) {
                            var temp = data.current_observation.temp_f;
                            $scope.fromCity = placeEntered+" : "+temp + "F";
                        }
                })
                handler.error(function (data) {
                    alert("There was some error processing your request. Please try after some time.");
                });
            }
        }
        $scope.getReviews = function (venueSelected) {
            if (venueSelected != null) {

                venueSelected = venueSelected.split(":")[0];
                venueSelected = venueSelected.trim();
               //This is the API call being made to get the reviews(tips) for the selected place or venue.


                var handler = $http.get("https://en.wikipedia.org/w/api.php?format=json&mozSystem=true&action=query&prop=extracts&exintro=&explaintext=&titles=" + venueSelected);
                handler.success(function (result) {
                    if (result != null) {
                        $scope.city = venueSelected;
                        $scope.description = result.query.pages.extract;
                    }
                })
                handler.error(function (result) {
                    alert("There was some error processing your request. Please try after some time.")
                })
            }

        }

    });
