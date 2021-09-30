import React, { Component } from 'react';
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom';
import { isAuth } from './services/auth';
import SignUp from "./pages/SignUp"


const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route
        { ...rest }
        render={ props => isAuth() ? (
            <Component { ...props } />
        ): (
            <Redirect to = {{ pathname: "/", state: { from: props.location }}} />
        )
    }
    />
);

const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route exact path = "/" component = {() => <h1> Login </h1>}/>
            <Route path = "/signup" component = { SignUp }/>
            <PrivateRoute path = "/app" component = {() => <h1> App </h1>}/>
            <Route path = "*" component = {() => <h1> Page Not Found </h1>}/>
        </Switch>
    </BrowserRouter>
);

export default Routes;