$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    $(".alert.alert-danger").hide();

    var options = [];
    var options_from_server;

    var editOption;

    $.ajax({
        url: "/mainapp/getAllOptions",
        success: function (data) {

            options_from_server = data;

            $("thead.options-table-thead").append([
                "<tr>",
                    "<th>", "Id", "</th>",
                    "<th>", "Name", "</th>",
                    "<th>", "Price", "</th>",
                    "<th>", "Add Coast", "</th>",
                    // "<th>", "", "</th>",
                "</tr>"
            ].join(""));

            options_from_server.forEach(function (option) {
                $("tbody.options-table-tbody").append([
                    "<tr>",
                        "<td>", option.id, "</td>",
                        "<td>", option.name, "</td>",
                        "<td>", option.price, "</td>",
                        "<td>", option.addCoast, "</td>",
                        // "<td>", "<input class=\"btn btn-success btn-edit-rate\" type=\"button\" id=\"", option.id, "\" value=\"Edit\"/>", "</td>",
                    "</tr>"
                ].join(""));
            });

            $("input.btn.btn-success.btn-edit-option").click(editOption);
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
        }
    });

    editOption = function(){

            rateId = $(this).attr("id");
            window.location.href = "/mainapp/showEditOptionForm?"
            + "id=" + rateId;
    };

    var addNewOption = function () {
        window.location.href = "/mainapp/showAddNewOptionForm"
    }
    $("input.btn.btn-success#addNewOptionButton").click(addNewOption);
});