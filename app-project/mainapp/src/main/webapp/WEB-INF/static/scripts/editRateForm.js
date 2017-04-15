$(document).ready(function(){

        var errorMessageSpan = $("#errorMessage");
        errorMessageSpan.text("");

        var parent_element = $(".options_list").first();
        var options = [];
        var options_from_server;
        $.ajax({
            url: "/mainapp/getAllOptions",
            success: function (data) {

                options_from_server = data;

                for (var i = 0; i < data.length; i++){

                    options[i] = "<div class=\"checkbox\"><label><input type=\"checkbox\" id=\"" + data[i].id + "\"/>" + data[i].name + "</label></div>";
                };

                parent_element.append($(options.join("")));
            },
            error: function (error) {
                errorMessageSpan.text("Error. Please, contact with administrator.");
            }
        });

        var saveEditRate = function(){

            errorMessageSpan.text("");


            if ($("#rateTitle").val().length === 0){

                $("#rateTitle").addClass("has-error");
                errorMessageSpan.text("Enter rate title.");
            }
            else if ($("#ratePrice").val() < 0){

                errorMessageSpan.text("Enter valid price.");
            }
            else {

                var rate = {};

                rate.id = $(".options_list").attr("id");
                rate.name = $("#rateTitle").val();
                rate.price = $("#ratePrice").val();
                rate.optionsIds = [];
                var checked_options = parent_element.find("input:checked");

                checked_options.each(function(index,element){

                    rate.optionsIds.push(element.id);
                });

                errorMessageSpan.text("");



                $.ajax({

                    url:"/mainapp/saveEditRate",
                    data: JSON.stringify(rate),
                    contentType: "application/json",
                    type: "POST",
                    dataType: 'json',
                    success: function (data) {
                        window.location.href = "/mainapp/showAllRatesForm";
                    },
                    error: function (error) {
                        errorMessageSpan.text("Error. Please, contact with administrator.");
                    }
                });
            };
        };

        $("#editRateButton").click(saveEditRate);
});