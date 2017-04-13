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

        url: "/mainapp/getPerson",
        type: "GET",
        data:{
            id:$(".person-info").attr("id")
        },
        success: function (data) {
            $(".person-info").append([
                "<div class=\"form-group\">", "<label>", "FirstName: ", data.firstName,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "LastName: ", data.lastName,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Date Of Birth: ", new Date(data.dateOfBirth).toDateString(),"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Serias: ", data.passSerias,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Number: ", data.passNumber,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass IssuedBy: ", data.passIssuedBy,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass IssuedDate: ", new Date(data.passIssuedDate).toDateString(),"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Email: ", data.email,"</label>", "</div>"
            ].join(""));
        },
        error:function(error){
            errorMessageSpan.text("Error. Please, contact with administrator.");
            errorMessageSpan.show();
        }
    });

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
            errorMessageSpan.text("Error. Please, contact with administrator.");
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
                errorMessageSpan.text("Error. Please, contact with administrator.");
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
                errorMessageSpan.text("Error. Please, contact with administrator.");
                errorMessageSpan.show();
            }
        });
    }

    var saveNewContract = function (){

        errorMessageSpan.hide();

        var contract = {};

        contract.personId = $(".person-info").attr("id");
        contract.rateId = $("#allRatesSelect").children(":selected").attr("id");
        contract.phoneNumberId = $("#allPhoneNumbersSelect").children(":selected").attr("id");

        var checkedOptionsForSelectedRate = $("#allOptionsOfSelectedRate").find("input:checked");
        contract.optionsIds = [];

        checkedOptionsForSelectedRate.each(function(index,element){

            contract.optionsIds.push(element.id);
        });

        $.ajax({

            url:"/mainapp/saveNewContract",
            data: JSON.stringify(contract),
            contentType: "application/json",
            type: "POST",
            dataType: 'json',
            success: function (data) {
                  alert("SUCCESS");
            },
            error: function (error) {
                  errorMessageSpan.text(error.responseText);
                  errorMessageSpan.show();
            }
        });
    };

    $("#saveContractButton").click(saveNewContract);
});