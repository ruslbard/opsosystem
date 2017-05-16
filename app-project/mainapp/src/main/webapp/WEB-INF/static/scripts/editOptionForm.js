$(document).ready(function(){

        var errorMessageSpan = $("#errorMessage");
        errorMessageSpan.text("");
        errorMessageSpan.hide();

        $.ajax({
            url: "/mainapp/getOption",
            data:{
                id:$(".option-edit-form").attr("id")
            },
            success: function (data) {

                $("#optionTitle").val(data.name);
                $("#optionPrice").val(data.price);
                $("#optionAddCoast").val(data.addCoast);
            },
            error: function (error) {
                errorMessageSpan.text("Error. Please, contact with administrator.");
                errorMessageSpan.show();
            }
        });

        var saveEditOption = function(){

            errorMessageSpan.text("");
            errorMessageSpan.hide();


            if ($("#optionTitle").val().length === 0){

                $("#optionTitle").addClass("has-error");
                errorMessageSpan.text("Enter option title.");
            }
            else if ($("#optionPrice").val() < 0){

                errorMessageSpan.text("Enter valid price.");
            }
            else {

                var option = {};

                option.id = $(".option-edit-form").attr("id");
                option.name = $("#optionTitle").val();
                option.price = $("#optionPrice").val();
                option.inclOptionsIds = [];
                option.exclOptionsIds = [];

                errorMessageSpan.text("");

                $.ajax({

                    url:"/mainapp/operator/saveEditOption",
                    data: JSON.stringify(option),
                    contentType: "application/json",
                    type: "POST",
                    success: function (data) {
                        window.location.href = "/mainapp/operator/showAllOptionsForm";
                    },
                    error: function (error) {
                        errorMessageSpan.text("Error. Please, contact with administrator.");
                        errorMessageSpan.show();
                    }
                });
            };
        };

        $("#saveOptionButton").click(saveEditOption);
});