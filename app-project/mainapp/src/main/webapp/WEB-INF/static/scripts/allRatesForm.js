$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();

    var parent_element = $(".rates_list").first();
    var rates = [];
    var rates_from_server;

    var editRate;

    $.ajax({
        url: "/mainapp/getAllRates",
        success: function (data) {

            rates_from_server = data;

            for (var i = 0; i < data.length; i++){

                rates[i] = "<div class=\"form-group\"><div class=\"row\"><div class=\"col-sm-9\"><label>" + data[i].name + "</label></div><div class=\"col-sm-3\"><input class=\"btn btn-success btn-edit-rate\" type=\"button\" id=\"" + data[i].id + "\" value=\"Edit\"/></div></div></div>";
            };
            parent_element.append($(rates.join("")));

            $("input.btn.btn-success.btn-edit-rate").click(editRate);
        },
        error: function (error) {
            errorMessageSpan.text(error.responseText);
        }
    });

    editRate = function(){

            rateId = $(this).attr("id");
            window.location.href = "/mainapp/showEditRateForm?"
            + "id=" + rateId;
    };
});