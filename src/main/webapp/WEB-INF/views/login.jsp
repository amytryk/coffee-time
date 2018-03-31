<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:loginpage title="Sign In">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-body">
                <form:form action="/login/process" method="post">
                    <div class="form-group">
                        <h2>Sign In</h2>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="email">Email</label>
                        <input name="username" id="email" type="text" maxlength="50" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="password">Password</label>
                        <input name="password" id="password" type="password" maxlength="25" class="form-control"
                               placeholder="at least 6 characters" length="40"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success">Sign In</button>
                    </div>
                    <p></p>I'm new to Coffee Time <a href="/register">Sign Up</a></p>
                </form:form>
            </div>
        </div>
    </div>
</layout:loginpage>

