<%@include file="/WEB-INF/jspf/header.jspf" %>

<section>
    <h2>Add tariff</h2>
    <div style="width: 250px">
    <form role="form" class="addTariff">
        <div class="form-group">
        <p><label>Tariff Title</label>
            <input class="form-control" type="text" id="tariffTitle"></p>
        <p><label>Price per Minute</label>
            <input class="form-control" type="number" step="0.01" id="pricePerMinute"></p>

            <input class="btn btn-success" id = "addTariffButton" type="button" value="Add Tariff to Op!System">
            <div>
                <span id="errorMessage"></span>
            </div>
        </div>
    </form>
    </div>

    <p id="test_p"></p>
</section>
<script src="static/scripts/addNewTariffForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>