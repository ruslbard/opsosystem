<%@include file="/WEB-INF/jspf/header.jspf" %>

<section>
    <h2>Create New Contract</h2>
    <div class="has-error has-feedback">
        <span id="errorMessage"></span>
    </div>
    <div class="container">
        <h3>Abonent Info</h3>
        <form>
            <div class="form-group">
                <label for="abonentFirstName">Fistname</label>
                <input class="form-control" type="text" id="abonentFirstName" maxlength="50" size="50" placeholder="Enter Fistname" required>
                <span class="help-block">First name of new abonent [max 50]</span>
            </div>
            <div class="form-group">
                <label for="abonentLastName">Lastname</label>
                <input class="form-control" type="text" id="abonentLastName" maxlength="50" size="50" placeholder="Enter Lastname" required>
                <span class="help-block">Last name of new abonent [max 50]</span>
            </div>
            <div class="form-group">
                <label for="abonentBirthDate">Date Of Birth</label>
                <input class="form-control" type="date" id="abonentBirthDate" size="10" placeholder="Enter date" required>
                <span class="help-block">Date of birth new abonent</span>
            </div>
            <div class="form-group">
                <label for="abonentPassSerias">Passport Serias</label>
                <input class="form-control" type="text" pattern="????[0-9]{4}" id="abonentPassSerias" maxlength="4" size="4" placeholder="Enter Passport Serias" required>
                <span class="help-block">Serias of passport. Must contain 4 digits.</span>
            </div>
            <div class="form-group">
                <label for="abonentPassNumber">Passport Number</label>
                <input class="form-control" type="text" pattern="[0-9]{6}" id="abonentPassNumber" maxlength="6" size="6" placeholder="Enter Passport Number" required>
                <span class="help-block">Number of passport. Must contain 6 digits.</span>
            </div>
            <div class="form-group">
                <label for="abonentPassIssuedBy">Passport Issued By</label>
                <input class="form-control" type="text" id="abonentPassIssuedBy" maxlength="255" placeholder="Enter deparment info" required>
                <span class="help-block">Deparment information, which passport has been issued [max 255].</span>
            </div>
            <div class="form-group">
                <label for="abonentPassIssuedDate">Passport Issued Date</label>
                <input class="form-control" type="date" id="abonentPassIssuedDate" size="10" required>
                <span class="help-block">Date, when passport has been issued.</span>
            </div>
            <div class="form-group">
                <label for="abonentEmail">Email</label>
                <input class="form-control" type="email" id="abonentEmail" maxlength="50" size="50" placeholder="Enter email" required>
                <span class="help-block">Email information of new abonent [max 50].</span>
            </div>

            <h3>Rate Info</h3>

            <div class="form-group">
              <label for="allRatesSelect">Select Rate</label>
              <select class="form-control" id="allRatesSelect">
              </select>
            </div>

            <div class="form-group" id="allOptionsOfSelectedRate"></div>

            <h3>Phone Number Info</h3>
            <div class="form-group">
              <label for="allPhoneNumbersSelect">Select Phone Number</label>
              <select class="form-control" id="allPhoneNumbersSelect">
              </select>
            </div>


            <div class="form-group">
                <input class="btn btn-success" id="addContractButton" type="button" value="Save">
            </div>
        </form>
    </div>
</section>
<script src="static/scripts/addNewContractForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>