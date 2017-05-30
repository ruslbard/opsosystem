/**
 * Created by ruslbard on 20.04.2017.
 */
$(document).ready(function () {

    var errorMessageSpan = $(".alert.alert-danger#errorMessage");
    errorMessageSpan.text("");
    errorMessageSpan.hide();
    var addAccount;

    addAccount = function () {
        var newAccountData = {};

        newAccountData.login = $(".form-control#phone").val();
        newAccountData.password = $(".form-control#password").val();
        newAccountData.retypePassword = $(".form-control#rtpassword").val();

        $.ajax({
            url: "/mainapp/addNewCommonAccount",
            dataType: 'json',
            data: JSON.stringify(newAccountData),
            contentType: "application/json",
            type: "PUT",
            success: function (data) {
                window.location.href = "/mainapp/login";
            },
            error: function (error) {
                errorMessageSpan.text(error.responseText);
                errorMessageSpan.show();
            }
        });

    };
    $(".btn.btn-success#signUpButton").click(addAccount);
});