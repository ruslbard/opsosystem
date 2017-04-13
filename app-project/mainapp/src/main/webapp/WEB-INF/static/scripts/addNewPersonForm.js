$(document).ready(function(){

    var errorMessageSpan = $("#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();

    var addNewPerson = function (){

        errorMessageSpan.hide();

        var person = {};

        person.firstName = $("#personFirstName").val();
        person.lastName = $("#personLastName").val();
        person.dateOfBirth = $("#personDateOfBirth").val();
        person.passSerias = $("#personPassSerias").val();
        person.passNumber = $("#personPassNumber").val();
        person.passIssuedBy = $("#personPassIssuedBy").val();
        person.passIssuedDate = $("#personPassIssuedDate").val();
        person.email = $("#personEmail").val();

        $.ajax({

            url:"/mainapp/addNewPerson",
            data: JSON.stringify(person),
            contentType: "application/json",
            type: "POST",
            dataType: 'json',
            success: function (data) {
                  alert("SUCCESS");
            },
            error: function (error) {
                  errorMessageSpan.text("Error. Please, contact with administrator.");
                  errorMessageSpan.show();
            }
        });
    };

    $("#addNewPersonButton").click(addNewPerson);
});