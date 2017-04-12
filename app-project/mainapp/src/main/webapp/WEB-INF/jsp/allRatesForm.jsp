<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>
    <h2>All Rates</h2>
    <div class="has-error has-feedback">
        <span class="form-control" id="errorMessage"></span>
    </div>
    <form role="form-inline" class="allRatesList">
        <div class="form-group">
            <div class="container rates_list"></div>
        </div>
    </form>
</section>
<script src="static/scripts/allRatesForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>