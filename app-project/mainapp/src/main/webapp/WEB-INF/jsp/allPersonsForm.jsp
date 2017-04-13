<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>
    <div class="container">
        <div class="well">MANAGE PERSONS</div>
        <div class="alert alert-danger">
            <span class="form-control" id="errorMessage"></span>
        </div>
        <form role="form-inline" class="allPersonsList">
            <div class="form-group">
                <table class="table table-hover">
                    <thead class="persons-table-thead"></thead>
                    <tbody class="persons-table-tbody"></tbody>
                </table>
            </div>
            <div class="form-group">
                <input class="btn btn-success" id="addNewPersonButton" type="button" value="Add New">
            </div>
        </form>
    </div>
</section>
<script src="static/scripts/allPersonsForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>