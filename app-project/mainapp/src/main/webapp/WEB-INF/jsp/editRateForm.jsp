<%@include file="/WEB-INF/jspf/header.jspf" %>

<section>
    <h2>Edit Rate</h2>
    <div>
        <span class="has-error" id="errorMessage"></span>
    </div>
    <div class="container">
        <form>
            <div class="form-group">
                <label for="rateTitle">Title</label>
                <input class="form-control" type="text" id="rateTitle" value="${rate.name}" required>
            </div>
            <div class="form-group">
                <label>Price</label>
                <input class="form-control" type="text" pattern="\d+(\.\d{2})?" value="${rate.price}" id="ratePrice" required/>
            </div>

            <div class="form-group options_list" id="${rate.id}"></div>

            <div class="form-group">
                <input class="btn btn-success" id="editRateButton" type="button" value="Save">
            </div>
        </form>
    </div>
</section>
<script src="static/scripts/editRateForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>