/**
 * Created by ruslbard on 12.04.2017.
 */
$(document).ready(function () {

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();

    var login = $(".person-info").attr("id");

    $.ajax({

        url: "/mainapp/common/getContractDetailForPhoneNumber",
        type: "GET",
        data: {
            phoneNumber: login
        },
        success: function (data) {

            var contractDetailFromServer = data;

            $("#loginPersonInfo").append([
                " ", contractDetailFromServer.person.firstName, " ", contractDetailFromServer.person.lastName
            ].join(""));

            $(".person-info").append([
                "<div class=\"form-group\">", "<label>", "FirstName: ", contractDetailFromServer.person.firstName, "</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "LastName: ", contractDetailFromServer.person.lastName, "</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Date Of Birth: ", new Date(contractDetailFromServer.person.dateOfBirth).toDateString(), "</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Serias: ", contractDetailFromServer.person.passSerias, "</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Number: ", contractDetailFromServer.person.passNumber, "</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass IssuedBy: ", contractDetailFromServer.person.passIssuedBy, "</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass IssuedDate: ", new Date(contractDetailFromServer.person.passIssuedDate).toDateString(), "</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Pass Email: ", contractDetailFromServer.person.email, "</label>", "</div>"
            ].join(""));


            $(".rate-info").append([
                "<div class=\"form-group\">", "<label>", "Rate Name: ", contractDetailFromServer.rate.name, "</label>", "</div>",
                "<div class=\"form-group\">", "<label>", "Rate Price: ", contractDetailFromServer.rate.price, "</label>", "</div>"
            ].join(""));

            if (contractDetailFromServer.contractOptions.length === 0) {
                $(".options-info").append([
                    "<div class=\"form-group\">", "<label>", "No options found.", "</label>", "</div>"
                ].join(""));
            } else {
                contractDetailFromServer.contractOptions.forEach(function (option) {
                    $(".options-info").append([
                        "<div class=\"form-group\">", "<label>", option.name, "</label>", "</div>"
                    ].join(""));
                });
            }
            ;

            $(".phonenumber-info").append([
                "<div class=\"form-group\">", "<label>", contractDetailFromServer.phoneNumber.phone, "</label>", "</div>"
            ].join(""));
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
            errorMessageSpan.show();
        }
    })
    ;

})
;