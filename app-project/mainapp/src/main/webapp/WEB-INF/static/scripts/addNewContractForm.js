$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();

    var parent_element = $("#allRatesSelect").first();
    var rates_from_server;
    var rates = [];

    $.ajax({
        url: "/mainapp/getAllRates",
        success: function (data) {

            rates_from_server = data;

            for (var i = 0; i < data.length; i++){

                rates[i] = "<option class=\"rate-option-select\" id=\"" + data[i].id + "\">" + data[i].name + "</option>";
            };

            parent_element.append($(rates.join("")));
        },
        error: function (error) {
            errorMessageSpan.text(error.responseText);
        }
    });
});