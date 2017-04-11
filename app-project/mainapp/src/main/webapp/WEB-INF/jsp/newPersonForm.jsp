<%@include file="/WEB-INF/jspf/header.jspf" %>

<section>
    <h2>Create New Contract</h2>
    <div class="has-error has-feedback">
        <span id="errorMessage"></span>
    </div>
    <div class="container">
        <form>
            <h3>Person Info</h3>
            <div class="form-group">
                <label for="personFirstName">Fistname</label>
                <input class="form-control" type="text" id="personFirstName" maxlength="50" size="50" placeholder="Enter Person Fistname" required>
                <span class="help-block">First name of new person [max 50]</span>
            </div>
            <div class="form-group">
                <label for="personLastName">Lastname</label>
                <input class="form-control" type="text" id="personLastName" maxlength="50" size="50" placeholder="Enter Person Lastname" required>
                <span class="help-block">Last name of new abonent [max 50]</span>
            </div>
            <div class="form-group">
                <label for="personDateOfBirth">Date Of Birth</label>
                <input class="form-control" type="date" id="personDateOfBirth" size="10" placeholder="Enter Date" required>
                <span class="help-block">Date of birth new abonent</span>
            </div>
            <div class="form-group">
                <label for="personPassSerias">Passport Serias</label>
                <input class="form-control" type="text" pattern="[0-9]{4}" id="personPassSerias" maxlength="4" size="4" placeholder="Enter Passport Serias" required>
                <span class="help-block">Serias of passport. Must contain 4 digits.</span>
            </div>
            <div class="form-group">
                <label for="personPassNumber">Passport Number</label>
                <input class="form-control" type="text" pattern="[0-9]{6}" id="personPassNumber" maxlength="6" size="6" placeholder="Enter Passport Number" required>
                <span class="help-block">Number of passport. Must contain 6 digits.</span>
            </div>
            <div class="form-group">
                <label for="personPassIssuedBy">Passport Issued By</label>
                <input class="form-control" type="text" id="personPassIssuedBy" maxlength="255" placeholder="Enter deparment info" required>
                <span class="help-block">Deparment information, which passport has been issued [max 255].</span>
            </div>
            <div class="form-group">
                <label for="personPassIssuedDate">Passport Issued Date</label>
                <input class="form-control" type="date" id="personPassIssuedDate" size="10" required>
                <span class="help-block">Date, when passport has been issued.</span>
            </div>
            <div class="form-group">
                <label for="personEmail">Email</label>
                <input class="form-control" type="email" id="personEmail" maxlength="50" size="50" placeholder="Enter email" required>
                <span class="help-block">Email information of new abonent [max 50].</span>
            </div>

             <div class="form-group">
                <input class="btn btn-success" id="addNewPersonButton" type="button" value="Save">
            </div>
        </form>
    </div>
</section>
<script src="static/scripts/addNewPersonForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>