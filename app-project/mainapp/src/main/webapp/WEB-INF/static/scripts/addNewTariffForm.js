$(document).ready(function(){

        var errorMessageSpan = $("#errorMessage");
        errorMessageSpan.text("");

        var parent_element = $(".options_list").first();
        var options = [];
        var options_from_server;
            $.ajax({
                url: "/mainapp/listOptions",
                success: function (data) {

                    options_from_server = data;

                    for (var i = 0; i < data.length; i++){

                        options[i] = "<div><input type=\"checkbox\" id=\"" + data[i].id + "\"/><label>" + data[i].name + "</label></div>";
                    };

                    parent_element.append($(options.join("")));
                },
                error: function (error) {
                    errorMessageSpan.text(error.responseText);
                }
            });

            var addTariff = function(){

                var tariff = {};

                tariff.name = $("#tariffTitle").val();
                tariff.price = $("#price").val();
                tariff.optionsIds = [];
                var checked_options = parent_element.find("input:checked");

                checked_options.each(function(index,element){

                    tariff.optionsIds.push(element.id);
                });

                errorMessageSpan.text("");



                $.ajax({

                    url:"/mainapp/addTariff",
                    data: JSON.stringify(tariff),
                    contentType: "application/json",
                    type: "POST",
                    dataType: 'json',
                    success: function (data) {
                        alert("SUCCESS");
                    },
                    error: function (error) {
                        errorMessageSpan.text(error.responseText);
                    }
                });
            };

            $("#addTariffButton").click(addTariff);
});