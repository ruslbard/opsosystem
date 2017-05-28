$(document).ready(function () {

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    $(".alert.alert-danger").hide();
    var contract = {};
    var options = [];
    var editOption;

    $.ajax({
        url: "/mainapp/common/getContractDetail",
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
                        };

                        isDisabled = "";
                        for (var i = 0; i < contract.contractOptions.length; i++) {
                            for (var j = 0; j < contract.contractOptions[i].includeOptionsIds.length; j++){
                                if (option.id === contract.contractOptions[i].includeOptionsIds[j]) {
                                    isDisabled = "disabled";
                                    break;
                                }
                            }
                        };

                        option.includeOptionsIds.forEach(function (includeOption) {
                            var count = 0;
                            for (var i = 0; i < contract.contractOptions.length; i++) {
                                if (includeOption === contract.contractOptions[i].id){
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
                                if (excludeOption === contract.contractOptions[i].id){
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

                    $("input.check-option").click(editOption);
                },
                error: function (error) {
                    errorMessageSpan.text("Error. Please, contact with administrator.");
                    errorMessageSpan.show();
                }
            });
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
        }
    });

    editOption = function () {

        var optionId = $(this).attr("id");

        if ($(this).is(":checked")) {

            $.ajax({
                url:"/mainapp/common/addContractOption",
                data: optionId,
                contentType: "application/json",
                type: "PUT",
                success: function (data) {
                    window.location.href = "/mainapp/common/showChangeContractOptionsSet";
                },
                error: function (error) {
                    errorMessageSpan.text(error.responseText);
                    errorMessageSpan.show();
                }
            });
        }
        else {

            $.ajax({
                url:"/mainapp/common/removeContractOption",
                data: optionId,
                contentType: "application/json",
                type: "PUT",
                success: function (data) {
                    window.location.href = "/mainapp/common/showChangeContractOptionsSet";
                },
                error: function (error) {
                    errorMessageSpan.text(error.responseText);
                    errorMessageSpan.show();
                }
            });
        }
    };
})
;