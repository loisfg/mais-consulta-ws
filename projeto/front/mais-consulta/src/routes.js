import React from 'react';
import { BrowserRouter as Router, Route, Switch, Redirect } from "react-router-dom";
import { isAuth } from './services/auth';
import { Calendar, Menu, Hours } from "../src/components"
import { HomePatient, Initial, Profile, Scheduling, Schedules } from "../src/pages"

const PrivateRoute = ({component: Component, ...rest}) => (
  <Route 
    {...rest}
    render = { props => 
      isAuth() ? (
        <Component {...props}/>
      ) : (
        <Redirect to={ {pathname: '/', state: { from: props.location} }} />
      )
    }
  
  />
);
const Routes =  () => {
  return (
    <Router>
      <div className='wrapper'>
          {window.location?.pathname !== '/' &&  <Menu/>}
          <Switch>
              <Route exact path="/" render = { props => 
                isAuth() ? (
                  <Redirect to={ {pathname: '/home', state: { from: props.location} }} />
                  ) : (<Initial {...props}/>)
              } />
              <PrivateRoute path="/home" component={HomePatient} />
              <PrivateRoute path="/calendar" component={Calendar} />
              <PrivateRoute path="/perfil" component={Profile} />
              <PrivateRoute path="/agendamento" component={Schedules} />
              
              <Route path="*" render = { props => 
                  isAuth() ? (
                    <Redirect to={ {pathname: '/home', state: { from: props.location} }} />
                    ) : (<Redirect to={ {pathname: '/', state: { from: props.location} }} />)
                }/>
          </Switch>
      </div>
    </Router>
  );
}

export default Routes;
