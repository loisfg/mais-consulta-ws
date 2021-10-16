import React from 'react';
import { BrowserRouter as Router, Route, Switch, Redirect } from "react-router-dom";
import { Calendar, Menu } from "../src/components"
import { HomePatient, Initial, Profile, Scheduling } from "../src/pages"

 const Routes =  () => {
  return (
    <Router>
      <div className='wrapper'>
          <Menu/>
          <Switch>
              <Route exact path="/" component={Initial} />
              <Route path="/home" component={HomePatient} />
              <Route path="/calendar" component={Calendar} />
              <Route path="/perfil" component={Profile} />
              <Route path="/agendamento" component={Scheduling} />
              <Route path="*" component={() => <h1> Page Not Found </h1>} />
          </Switch>
      </div>
    </Router>
  );
}

export default Routes;
