import React, { Component } from "react";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";
import { isAuth } from "./services/auth";
import { Initial } from "../src/pages/";
import HomePatient from "./pages/HomePatient";
import { Calendar } from "./components/Calendar";
import { Profile } from './pages/Profile'

const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={(props) =>
      isAuth() ? (
        <Component {...props} />
      ) : (
        <Redirect to={{ pathname: "/", state: { from: props.location } }} />
      )
    }
  />
);

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route exact path="/" component={Initial} />
      <Route path="/home" component={HomePatient} />
      <Route path="/calendar" component={Calendar} />
      <Route path="/profile" component={Profile} />
      <PrivateRoute path="/app" component={() => <h1> App </h1>} />
      <Route path="*" component={() => <h1> Page Not Found </h1>} />
    </Switch>
  </BrowserRouter>
);

export default Routes;
