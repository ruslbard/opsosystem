<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>

    <div class="container">
        <div class="well contract-info" id="${contractDetail.id}">EDIT CONTRACT</div>
        <div class="alert alert-danger" id="errorMessage">
        </div>
        <form>
            <h3>Person Info</h3>
            <div class="form-group person-info"></div>

            <h3>Rate Info</h3>
            <div class="form-group">
              <label for="allRatesSelect">Select Rate</label>
              <select class="form-control" id="allRatesSelect"></select>
            </div>

            <div class="form-group" id="allOptionsOfSelectedRate">
                <table class="table table-hover">
                    <thead class="options-table-thead"></thead>
                    <tbody class="options-table-tbody"></tbody>
                </table>
            </div>

            <h3>Phone Number Info</h3>
            <div class="form-group">
              <label for="PhoneNumber">Phone Number</label>
              <span class="form-control" id="PhoneNumber">
              </span>
            </div>


            <div class="form-group">
                <input class="btn btn-success" id="saveContractButton" type="button" value="Save">
            </div>
        </form>
    </div>
</section>
<script src="static/scripts/editContractForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>