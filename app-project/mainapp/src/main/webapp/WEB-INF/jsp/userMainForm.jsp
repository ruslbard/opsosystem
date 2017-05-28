<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>

    <div class="container">
        <div class="well"></div>
        <div class="alert alert-danger" id="errorMessage">
        </div>
        <form>
            <div class="panel panel-success">
                <div class="panel-heading">Phone Number Info</div>
                <div class="panel-body form-group phonenumber-info"></div>
            </div>
            <div class="panel panel-success">
                <div class="panel-heading">Person Info</div>
                <div class="panel-body form-group person-info" id="${account.login}"></div>
            </div>
            <div class="panel panel-success">
                <div class="panel-heading">Rate Info</div>
                <div class="panel-body form-group rate-info"></div>
            </div>
            <div class="panel panel-success">
                <div class="panel-heading">Options Info</div>
                <div class="panel-body form-group options-info"></div>
            </div>

        </form>
    </div>
</section>
<script src="static/scripts/userMainForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>
