/**
 * Created by ruslbard on 12.04.2017.
 */
$(document).ready(function () {

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();

    var blockContract;
    var unblockContract;
    var contractDetailFromServer;


    var login = $(".person-info").attr("id");

    $.ajax({

        url: "/mainapp/common/getContractDetail",
        type: "GET",
        success: function (data) {

            contractDetailFromServer = data;

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

            var errorMesageClass = "";
            var blockedButtonLabel = "Block";
            var blockedButtonClass = "block"
            var disableButton = "";

            if (contractDetailFromServer.isBlocked == 'O'){
                errorMessageSpan.text("Contract is blocked by operator.");
                errorMessageSpan.show();
                disableButton = "disabled";
            }else if (contractDetailFromServer.isBlocked == 'C'){
                errorMessageSpan.text("Contract is blocked by yourself.");
                errorMessageSpan.show();
                blockedButtonLabel = "Unblock";
                blockedButtonClass = "unblock"
            }

            $(".phonenumber-info").append([
                "<div class=\"form-group\">", "<label>", contractDetailFromServer.phoneNumber.phone, "</label>", "</div>",
                "<div>", "<input class=\"btn btn-danger btn-", blockedButtonClass, "-contract\" type=\"button\" value=\"", blockedButtonLabel, "\"", disableButton, "/>", "</div>"
            ].join(""));

            $("input.btn.btn-danger.btn-block-contract").click(blockContract);
            $("input.btn.btn-danger.btn-unblock-contract").click(unblockContract);
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
            errorMessageSpan.show();
        }
    });

    blockContract = function () {

        $.ajax({
            url:"/mainapp/common/blockContract",
            success: function (data) {
                window.location.href = "/mainapp/common";
            },
            error: function (error) {
                errorMessageSpan.text(error.responseText);
                errorMessageSpan.show();
            }
        });
    };
    unblockContract = function () {

        $.ajax({
            url:"/mainapp/common/unblockContract",
            success: function (data) {
                window.location.href = "/mainapp/common";
            },
            error: function (error) {
                errorMessageSpan.text(error.responseText);
                errorMessageSpan.show();
            }
        });
    };
})
;