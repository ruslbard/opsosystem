$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();

    var parent_element = $(".rates_list").first();
    var rates = [];
    var rates_from_server;


    $.ajax({
        url: "/mainapp/allRatesList",
        success: function (data) {

            rates_from_server = data;

            for (var i = 0; i < data.length; i++){

                rates[i] = "<div class=\"row\"><div class=\"col-sm-9\"><label>" + data[i].name + "</label></div><div class=\"col-sm-3\"><input class=\"btn btn-success btn-edit-rate\" type=\"button\" id=\"" + data[i].id + "\" value=\"Edit\"/></div></div>";
            };

            parent_element.append($(rates.join("")));
        },
        error: function (error) {
            errorMessageSpan.text(error.responseText);
        }
    });

    var editRate = function(){

        errorMessageSpan.text("");
        errorMessageSpan.text("Rate changed.");
    };

    $(".btn-edit-rate").click(editRate);

});