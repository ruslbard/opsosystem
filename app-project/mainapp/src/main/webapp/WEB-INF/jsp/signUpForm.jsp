<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>

    <div class="container">
        <div class="well">SIGN UP</div>
        <div class="has-error has-feedback">
            <span id="errorMessage"></span>
        </div>
        <form role="form" class="addAccount">
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <div class="input-group col-xs-3">
                    <span class="input-group-addon">+7</span>
                    <input class="form-control" type="text" id="phone" required/>
                </div>
                <div class="input-group col-xs-3">
                    <label for="password">Password</label>
                    <input class="form-control" type="password" id="password" required/></p>
                </div>
                <div class="input-group col-xs-3">
                    <label for="rtpassword">Re-type password</label>
                    <input class="form-control" type="password" id="rtpassword" required/></p>
                </div>
                <br/>
                <input class="btn btn-success" id="signUpButton" type="button" value="Sign Up">

            </div>

        </form>
    </div>


</section>
<script src="static/scripts/signUpForm.js"></script>
<%@include file="/WEB-INF/jspf/footer.jspf" %>