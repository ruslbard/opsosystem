$(document).ready(function () {

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    $(".alert.alert-danger").hide();

    var contracts = [];
    var contracts_from_server;

    var editContract;
    var blockContract;
    var unblockContract;

    $.ajax({
        url: "/mainapp/operator/getAllContracts",
        success: function (data) {

            contracts = data;

            $("thead.rates-table-thead").append([
                "<tr>",
                "<th>", "Id", "</th>",
                "<th>", "PhoneNumber", "</th>",
                "<th>", "Person FirstName", "</th>",
                "<th>", "Person LastName", "</th>",
                "<th>", "Rate", "</th>",
                "<th>", "Blocked", "</th>",
                "<th>", "", "</th>",
                "<th>", "", "</th>",
                "</tr>"
            ].join(""));

            contracts.forEach(function (contract) {

                var blocked = "";
                var trClass = "";
                var blockedButtonLabel = "Block";
                var blockedButtonClass = "block"

                if (contract.isBlocked == 'O'){
                    blocked = "O";
                    trClass = "class=\"danger\"";
                    blockedButtonLabel = "Unblock";
                    blockedButtonClass = "unblock"
                }else if (contract.isBlocked == 'C'){
                    blocked = "C";
                    trClass = "class=\"warning\"";
                    blockedButtonLabel = "Unblock";
                    blockedButtonClass = "unblock"
                }
                $("tbody.rates-table-tbody").append([
                    "<tr ", trClass, ">",
                    "<td>", contract.id, "</td>",
                    "<td>", contract.phoneNumber.phone, "</td>",
                    "<td>", contract.person.firstName, "</td>",
                    "<td>", contract.person.lastName, "</td>",
                    "<td>", contract.rate.name, "</td>",
                    "<td>", blocked, "</td>",
                    "<td>", "<input class=\"btn btn-success btn-edit-contract\" type=\"button\" id=\"", contract.id, "\" value=\"Edit\"/>", "</td>",
                    "<td>", "<input class=\"btn btn-danger btn-", blockedButtonClass, "-contract\" type=\"button\" id=\"", contract.id, "\" value=\"", blockedButtonLabel, "\"/>", "</td>",
                    "</tr>"
                ].join(""));
            });

            $("input.btn.btn-success.btn-edit-contract").click(editContract);
            $("input.btn.btn-danger.btn-block-contract").click(blockContract);
            $("input.btn.btn-danger.btn-unblock-contract").click(unblockContract);
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
        }
    });

    editContract = function () {

        var contractId = $(this).attr("id");
        window.location.href = "/mainapp/operator/showEditContractForm?"
            + "id=" + contractId;
    };

    blockContract = function () {

        var contractId = $(this).attr("id");

        $.ajax({
            url:"/mainapp/operator/blockContract",
            data: contractId,
            contentType: "application/json",
            type: "PUT",
            success: function (data) {
                window.location.href = "/mainapp/operator/showAllContractsForm";
            },
            error: function (error) {
                errorMessageSpan.text(error.responseText);
                errorMessageSpan.show();
            }
        });
    };
    unblockContract = function () {

        var contractId = $(this).attr("id");

        $.ajax({
            url:"/mainapp/operator/unblockContract",
            data: contractId,
            contentType: "application/json",
            type: "PUT",
            success: function (data) {
                window.location.href = "/mainapp/operator/showAllContractsForm";
            },
            error: function (error) {
                errorMessageSpan.text(error.responseText);
                errorMessageSpan.show();
            }
        });
    };
});