$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    $(".alert.alert-danger").hide();

    var rates = [];
    var rates_from_server;

    $.ajax({
        url: "/mainapp/getAllRates",
        success: function (data) {

            rates_from_server = data;

            $("thead.rates-table-thead").append([
                "<tr>",
                    "<th>", "Id", "</th>",
                    "<th>", "Name", "</th>",
                    "<th>", "Price", "</th>",
                    "<th>", "", "</th>",
                "</tr>"
            ].join(""));

            rates_from_server.forEach(function (rate) {
                $("tbody.rates-table-tbody").append([
                    "<tr>",
                        "<td>", rate.id, "</td>",
                        "<td>", rate.name, "</td>",
                        "<td>", rate.price, "</td>",
                        "<td>", "<input class=\"btn btn-success btn-edit-rate\" type=\"button\" id=\"", rate.id, "\" value=\"Change\"/>", "</td>",
                    "</tr>"
                ].join(""));
            });

            $("input.btn.btn-success.btn-edit-rate").click(changeRate);
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
        }
    });

    var changeRate = function(){

        var newRateId = $(this).attr("id");

        $.ajax({

            url:"/mainapp/common/changeContractRateTo",
            data: newRateId,
            contentType: "application/json",
            type: "PUT",
            success: function (data) {
                window.location.href = "/mainapp/common";
            },
            error: function (error) {
                errorMessageSpan.text(error.responseText);
                errorMessageSpan.show();
            }
        });
    };
});