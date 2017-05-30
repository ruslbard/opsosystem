$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    $(".alert.alert-danger").hide();

    var persons = [];
    var persons_from_server;

    var editPerson;

    $.ajax({
        url: "/mainapp/operator/getAllPersons",
        success: function (data) {

            rates_from_server = data;

            $("thead.persons-table-thead").append([
                "<tr>",
                    "<th>", "Id", "</th>",
                    "<th>", "First Name", "</th>",
                    "<th>", "Last Name", "</th>",
                    "<th>", "Pass Serias", "</th>",
                    "<th>", "Pass Number", "</th>",
                    "<th>", "", "</th>",
                "</tr>"
            ].join(""));

            rates_from_server.forEach(function (person) {
                $("tbody.persons-table-tbody").append([
                    "<tr>",
                        "<td>", person.id, "</td>",
                        "<td>", person.firstName, "</td>",
                        "<td>", person.lastName, "</td>",
                        "<td>", person.passSerias, "</td>",
                        "<td>", person.passNumber, "</td>",
                        // "<td>", "<input class=\"btn btn-success btn-edit-person\" type=\"button\" id=\"", person.id, "\" value=\"Edit\"/>", "</td>",
                        "<td>", "<input class=\"btn btn-success btn-add-contract\" type=\"button\" id=\"", person.id, "\" value=\"Add Contract\"/>", "</td>",
                    "</tr>"
                ].join(""));
            });

            // $("input.btn.btn-success.btn-edit-person").click(editPerson);
            $("input.btn.btn-success.btn-add-contract").click(addContractForPerson);
        },
        error: function (error) {
            errorMessageSpan.text("Error. Please, contact with administrator.");
        }
    });

    editPerson = function(){

            rateId = $(this).attr("id");
            window.location.href = "/mainapp/operator/showEditPersonForm?"
            + "id=" + rateId;
    };

    var addContractForPerson = function(){

        personId = $(this).attr("id");
        window.location.href = "/mainapp/operator/showNewContractForm?"
            + "id=" + personId;
    };

    var addNewPerson = function () {
        window.location.href = "/mainapp/operator/showAddNewPersonForm"
    }


    $("input.btn.btn-success#addNewPersonButton").click(addNewPerson);
});