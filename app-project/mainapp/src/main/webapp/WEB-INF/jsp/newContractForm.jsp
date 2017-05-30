<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>

    <div class="container">
        <div class="well">CREATE NEW CONTRACT</div>
        <div class="alert alert-danger" id="errorMessage">
        </div>
        <form>
            <h3>Person Info</h3>
            <div class="form-group person-info" id="${person.id}"></div>

            <h3>Rate Info</h3>
            <div class="form-group">
              <label for="allRatesSelect">Select Rate</label>
              <select class="form-control" id="allRatesSelect"></select>
            </div>

            <div class="form-group" id="allOptionsOfSelectedRate"></div>

            <h3>Phone Number Info</h3>
            <div class="form-group">
              <label for="allPhoneNumbersSelect">Select Phone Number</label>
              <select class="form-control" id="allPhoneNumbersSelect">
              </select>
            </div>


            <div class="form-group">
                <input class="btn btn-success" id="saveContractButton" type="button" value="Save">
            </div>
        </form>
    </div>
</section>
<script src="static/scripts/addNewContractForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>