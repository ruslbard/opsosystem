$(document).ready(function () {

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    $(".alert.alert-danger").hide();
    var contract = {};

    var options = [];
    var all_options_from_server;

    var editOption;


    $.ajax({
        url: "/mainapp/common/getContractDetailForPhoneNumber",
        data: {
            phoneNumber: $(".person-info").attr("id")
        },
        contentType: "application/json",
        type: "GET",
        success: function (data) {
            contract = data;
            $.ajax({
                url: "/mainapp/getAllRateOptions",
                data: {
                    id: contract.rate.id
                },
                contentType: "application/json",
                type: "GET",
                success: function (options) {


                    $("thead.options-table-thead").append([
                        "<tr>",
                        "<th>", "Id", "</th>",
                        "<th>", "Name", "</th>",
                        "<th>", "Price", "</th>",
                        "<th>", "Add Coast", "</th>",
                        "<th></th>",
                        "</tr>"
                    ].join(""));

                    var isChecked;
                    var isDisabled;

                    options.forEach(function (option) {

                        isChecked = "";

                        for (var i = 0; i < contract.contractOptions.length; i++) {
                            if (option.id === contract.contractOptions[i].id) {
                                isChecked = "checked";
                                break;
                            }
                        }
                        ;
                        isDisabled = "";
                        option.includeOptionsIds.forEach(function (includeOption) {
                            var count = 0;
                            for (var i = 0; i < contract.contractOptions.length; i++) {
                                if (includeOption.id === contract.contractOptions[i].id){
                                    count++;
                                }
                            }
                            if (count === 0){
                                isDisabled = "disabled";
                                return;
                            }
                        });

                        option.excludeOptionsIds.forEach(function (excludeOption) {
                            var count = 0;
                            for (var i = 0; i < contract.contractOptions.length; i++) {
                                if (excludeOption.id === contract.contractOptions[i].id){
                                    count++;
                                }
                            }
                            if (count > 0){
                                isDisabled = "disabled";
                                return;
                            }
                        });

                        $("tbody.options-table-tbody").append([
                            "<tr>",
                            "<td>", option.id, "</td>",
                            "<td>", option.name, "</td>",
                            "<td>", option.price, "</td>",
                            "<td>", option.addCoast, "</td>",
                            "<td>",
                            "<label class=\"switch\">",
                            "<input class=\"check-option\" type=\"checkbox\" id=\"", option.id, "\"", isChecked, " ",isDisabled, "/>",
                            "<div class=\"slider round\"></div>",
                            "</label>",
                            "</td>",
                            "</tr>"
                        ].join(""));
                    })
                },
                error: function (error) {
                    errorMessageSpan.text("Error. Please, contact with administrator.");
                    errorMessageSpan.show();
                }
            });

            $("input.btn.btn-success.btn-edit-option").click(editOption);
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
        }
    });

    editOption = function () {
        if ($(this).is(":checked")) {
            optionId = $(this).attr("id");
            window.location.href = "/mainapp/common/addContractOption?"
                + "id=" + optionId;
        }
        else {
            optionId = $(this).attr("id");
            window.location.href = "/mainapp/common/removeContractOption?"
                + "id=" + optionId;
        }
    };

    var addNewOption = function () {

    }
    $("input.btn.btn-success#addNewOptionButton").click(addNewOption);
})
;