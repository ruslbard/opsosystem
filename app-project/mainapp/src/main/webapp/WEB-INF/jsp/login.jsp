<%@include file="/WEB-INF/jspf/header.jspf" %>
<%@include file="/WEB-INF/jspf/mainmenu.jspf" %>

<section>
    <div class="container">
        <div class="well">LOG IN</div>
        <div class="has-error has-feedback">
            <span id="errorMessage"></span>
        </div>
        <div class="form-group">
            <form name="login" action="<c:url value='/j_spring_security_check' />" method="post">
                <div class="input-group col-xs-3">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input class="form-control" name='j_username' type="text" id="username" placeholder="Login"
                           required>
                </div>
                <div class="input-group col-xs-3">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input class="form-control" name='j_password' type="password" id="password" placeholder="Password"
                           required>
                </div>
                <br/>
                <div class="form-group">
                    <input class="btn btn-success" id="loginButton" name="submit" type="submit" value="Log In">
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jspf/footer.jspf" %>