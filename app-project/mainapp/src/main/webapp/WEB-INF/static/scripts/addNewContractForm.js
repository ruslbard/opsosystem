$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();

    var ratesSelect = $("#allRatesSelect").first();
    var ratesFromServer;
    var rateOptionsFromServer;
    var phoneNumbersSelect = $("#allPhoneNumbersSelect").first();
    var phoneNumbersFromServer;

    $.ajax({
        url: "/mainapp/getAllRates",
        success: function (data) {

            var rates = [];
            ratesSelect.empty();

            ratesFromServer = data;

            for (var i = 0; i < ratesFromServer.length; i++){

                rates[i] = "<option class=\"rate-option-select\" id=\"" + ratesFromServer[i].id + "\">" + ratesFromServer[i].name + "</option>";
            };

            ratesSelect.append($(rates.join("")));

            ratesSelect.on("change", changeRateSelect);

        },
        error: function (error) {
            errorMessageSpan.text(error.responseText);
        }
    });

    $.ajax({
            url: "/mainapp/getAllPhoneNumbers",
            success: function (data) {

                var phoneNumbers = [];
                phoneNumbersSelect.empty();

                phoneNumbersFromServer = data;

                for (var i = 0; i < phoneNumbersFromServer.length; i++){

                    phoneNumbers[i] = "<option class=\"phone-number-select\" id=\"" + phoneNumbersFromServer[i].id + "\">" + phoneNumbersFromServer[i].phoneNumber + "</option>";
                };

                phoneNumbersSelect.append($(phoneNumbers.join("")));

            },
            error: function (error) {
                errorMessageSpan.text(error.responseText);
                errorMessageSpan.show();
            }
    });

    var changeRateSelect = function (){

        errorMessageSpan.text("");
        errorMessageSpan.hide();

        var rateId = $(this).children(":selected").attr("id");
        $.ajax({
            url: "/mainapp/getAllRateOptions",
            type: "GET",
            data:{
                id:rateId
            },
            success: function(data){

                var options = [];

                $("#allOptionsOfSelectedRate").empty();

                rateOptionsFromServer = data;

                for (var i = 0; i < rateOptionsFromServer.length; i++){

                    options[i] = "<div class=\"checkbox\"><label><input type=\"checkbox\" id=\"" + rateOptionsFromServer[i].id + "\"/>" + rateOptionsFromServer[i].name + "</label></div>";
                };

                if (options && options.length){

                    $("#allOptionsOfSelectedRate").append($(options.join("")));
                }
                else {

                    errorMessageSpan.text("");
                    errorMessageSpan.text("No options found for selected rate.");
                    $("#allOptionsOfSelectedRate").append(errorMessageSpan);
                    errorMessageSpan.show();
                }

            },
            error: function(error){
                errorMessageSpan.text("");
                errorMessageSpan.text(error.responseText);
                errorMessageSpan.show();
            }
        });
    }
});