<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>
    <div class="container">
        <div class="well">MANAGE CONTRACTS</div>
        <div class="alert alert-danger" id="errorMessage">
        </div>
        <form role="form-inline" class="allContractsList">
            <div class="form-group">
                <table class="table table-hover">
                    <thead class="rates-table-thead"></thead>
                    <tbody class="rates-table-tbody"></tbody>
                </table>
            </div>
            <%--<div class="form-group">--%>
                <%--<input class="btn btn-success" id="addNewRateButton" type="button" value="Add New">--%>
            <%--</div>--%>
        </form>
    </div>
</section>
<script src="static/scripts/allContractsForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>