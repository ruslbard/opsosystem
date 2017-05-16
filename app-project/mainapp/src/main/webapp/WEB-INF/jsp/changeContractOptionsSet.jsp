<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>
    <div class="container">
        <div class="well">MANAGE OPTIONS FOR ${account.login}</div>
        <div class="alert alert-danger">
            <span class="form-control" id="errorMessage"></span>
        </div>
        <form role="form-inline" class="allOptionsList">
            <div class="form-group person-info" id="${account.login}">
                <table class="table table-hover">
                    <thead class="options-table-thead"></thead>
                    <tbody class="options-table-tbody"></tbody>
                </table>
            </div>
            <%--<div class="form-group">--%>
                <%--<input class="btn btn-success" id="addNewRateButton" type="button" value="Add New">--%>
            <%--</div>--%>
        </form>
    </div>
</section>
<script src="static/scripts/changeContractOptionsSet.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>