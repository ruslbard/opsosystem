<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>
    <div class="well">ADD NEW RATE</div>
                <div>
                    <span class="has-error" id="errorMessage"></span>
                </div>
    <div style="width: 250px">
    <form role="form" class="addRate">
        <div class="form-group">
            <div>
                <label>Title</label>
                <input class="form-control" type="text" id="rateTitle" required>
            </div>
        <p><label>Price</label>
            <input class="form-control" type="number" pattern="\d+(\.\d{2})?" value="0.00" step="0.01" id="ratePrice" required></p>

            <div class="options_list"></div>

            <input class="btn btn-success" id="addRateButton" type="button" value="Save">

        </div>

    </form>
    </div>



</section>
<script src="static/scripts/addNewRateForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>