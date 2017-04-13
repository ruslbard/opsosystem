<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>
    <div class="well">WELLCOM, ${person.firstName}!</div>
    <div class="has-error has-feedback">
        <span id="errorMessage"></span>
    </div>
    <div class="container">
        <form>
            <div class="panel panel-default">
                <div class="panel-heading">Person Info</div>
                <div class="panel-body form-group person-info" id="${person.id}"></div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Rate Info</div>
                <div class="panel-body form-group rate-info"></div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Options Info</div>
                <div class="panel-body form-group options-info"></div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Phone Number Info</div>
                <div class="panel-body form-group phonenumber-info"></div>
            </div>
        </form>
    </div>
</section>
<script src="static/scripts/userMainForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>
