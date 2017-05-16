<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>

    <div class="container">
        <div class="well">EDIT OPTION</div>
        <div>
            <span class="has-error" id="errorMessage"></span>
        </div>
        <form class="option-edit-form" id="${option.id}">
            <div class="form-group">
                <label for="optionTitle">Title</label>
                <input class="form-control" type="text" id="optionTitle" required>
            </div>
            <div class="form-group">
                <label for="optionPrice">Price</label>
                <input class="form-control" type="text" pattern="\d+(\.\d{2})?" id="optionPrice" required/>
            </div>
            <div class="form-group">
                <label for="optionAddCoast">Price</label>
                <input class="form-control" type="text" pattern="\d+(\.\d{2})?" id="optionAddCoast" required/>
            </div>

            <div class="form-group">
                <input class="btn btn-success" id="saveOptionButton" type="button" value="Save">
            </div>
        </form>
    </div>
</section>
<script src="static/scripts/editOptionForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>