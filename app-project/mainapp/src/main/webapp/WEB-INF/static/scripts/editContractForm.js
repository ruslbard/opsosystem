$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();

    var ratesSelect = $("#allRatesSelect").first();
    var ratesFromServer;
    var phoneNumberSpan = $("#PhoneNumber").first();
    var contractDetailFromServer;
    var editOption;
    var changeRateSelect;

    $.ajax({

        url: "/mainapp/operator/getContractDetail",
        type: "GET",
        data:{
            id:$(".contract-info").attr("id")
        },
        success: function (data) {

            contractDetailFromServer = data;

            $(".person-info").append([
                "<div class=\"form-group\">", "<label>", "FirstName: ", contractDetailFromServer.person.firstName,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "LastName: ", contractDetailFromServer.person.lastName,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Date Of Birth: ", new Date(contractDetailFromServer.person.dateOfBirth).toDateString(),"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Serias: ", contractDetailFromServer.person.passSerias,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Number: ", contractDetailFromServer.person.passNumber,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass IssuedBy: ", contractDetailFromServer.person.passIssuedBy,"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass IssuedDate: ", new Date(contractDetailFromServer.person.passIssuedDate).toDateString(),"</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Email: ", contractDetailFromServer.person.email,"</label>", "</div>"
            ].join(""));

            phoneNumberSpan.append(contractDetailFromServer.phoneNumber.phone);

            $.ajax({
                url: "/mainapp/getAllRates",
                success: function (data) {

                    var rates = [];
                    ratesSelect.empty();

                    ratesFromServer = data;

                    var selectedAttribute;
                    for (var i = 0; i < ratesFromServer.length; i++){

                        selectedAttribute = "";
                        if (ratesFromServer[i].id == contractDetailFromServer.rate.id){
                            selectedAttribute = "selected"
                        }
                        rates[i] = "<option class=\"rate-option-select\" id=\"" + ratesFromServer[i].id + "\"" + selectedAttribute + ">" + ratesFromServer[i].name + "</option>";
                    };

                    ratesSelect.append($(rates.join("")));
                    ratesSelect.on("change", changeRateSelect);
                    ratesSelect.trigger("change");

                },
                error: function (error) {
                    errorMessageSpan.text("Error. Please, contact with administrator.");
                }
            });

        },
        error:function(error){
            errorMessageSpan.text("Error. Please, contact with administrator.");
            errorMessageSpan.show();
        }
    });

    changeRateSelect = function (){

        errorMessageSpan.text("");
        errorMessageSpan.hide();

        $("thead.options-table-thead").empty();
        $("tbody.options-table-tbody").empty();

        var contract = contractDetailFromServer;


        var rateId = Number($(this).children(":selected").attr("id"));
        $.ajax({
            url: "/mainapp/getAllRateOptions",
            data: {
                id: rateId
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
    };

    editOption = function () {

        var optionId = Number($(this).attr("id"));

        if ($(this).is(":checked")) {

            $.ajax({
                url:"/mainapp/operator/addContractOption",
                dataType: 'json',
                data: JSON.stringify({
                    contractId: contractDetailFromServer.id,
                    optionId: optionId
                }),
                contentType: "application/json",
                type: "PUT",
                success: function (data) {
                    ratesSelect.trigger("change");
                },
                error: function (error) {
                    errorMessageSpan.text(error.responseText);
                    errorMessageSpan.show();
                }
            });
        }
        else {

            $.ajax({
                url:"/mainapp/operator/removeContractOption",
                dataType: 'json',
                data: JSON.stringify({
                    contractId: contractDetailFromServer.id,
                    optionId: optionId
                }),
                contentType: "application/json",
                type: "PUT",
                success: function (data) {
                    ratesSelect.trigger("change");
                },
                error: function (error) {
                    errorMessageSpan.text(error.responseText);
                    errorMessageSpan.show();
                }
            });
        }
    };

    var saveEditContract = function (){

        errorMessageSpan.hide();

        var contract = {};

        contract.id = contractDetailFromServer.id;
        contract.personId = contractDetailFromServer.person.id;
        contract.rateId = $("#allRatesSelect").children(":selected").attr("id");
        contract.phoneNumberId = contractDetailFromServer.phoneNumber.id;

        var checkedOptionsForSelectedRate = $("#allOptionsOfSelectedRate").find("input:checked");
        contract.optionsIds = [];

        checkedOptionsForSelectedRate.each(function(index,element){

            contract.optionsIds.push(element.id);
        });

        $.ajax({

            url:"/mainapp/operator/saveEditContract",
            data: JSON.stringify(contract),
            contentType: "application/json",
            type: "POST",
            success: function (data) {
                  window.location.href = "/mainapp/operator/showAllContractsForm";
            },
            error: function (error) {
                  errorMessageSpan.text(error.responseText);
                  errorMessageSpan.show();
            }
        });
    };

    $("#saveContractButton").click(saveEditContract);
});