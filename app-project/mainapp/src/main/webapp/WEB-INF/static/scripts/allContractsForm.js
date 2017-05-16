$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    $(".alert.alert-danger").hide();

    var rates = [];
    var rates_from_server;

    var editRate;

    $.ajax({
        url: "/mainapp/getAllRates",
        success: function (data) {

            rates_from_server = data;

            // for (var i = 0; i < data.length; i++){
            //
            //     rates[i] = "<div class=\"form-group\"><div class=\"row\"><div class=\"col-sm-9\"><label>" + data[i].name + "</label></div><div class=\"col-sm-3\"><input class=\"btn btn-success btn-edit-rate\" type=\"button\" id=\"" + data[i].id + "\" value=\"Edit\"/></div></div></div>";
            // };

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
                        "<td>", "<input class=\"btn btn-success btn-edit-rate\" type=\"button\" id=\"", rate.id, "\" value=\"Edit\"/>", "</td>",
                    "</tr>"
                ].join(""));
            });

            $("input.btn.btn-success.btn-edit-rate").click(editRate);
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
        }
    });

    editRate = function(){

            rateId = $(this).attr("id");
            window.location.href = "/mainapp/operator/showEditRateForm?"
            + "id=" + rateId;
    };

    var addNewRate = function () {
        window.location.href = "/mainapp/operator/showAddNewRateForm"
    }
    $("input.btn.btn-success#addNewRateButton").click(addNewRate);
});