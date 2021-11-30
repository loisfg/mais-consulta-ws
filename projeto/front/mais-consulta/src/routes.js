import React from "react";
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect,
} from "react-router-dom";
import { isAuth } from "./services/auth";
import { Calendar, Wrapper } from "../src/components";
import { HomePatient, Initial, Profile, Schedules, UnitMaps,
        SchedulingHistory, DownloadFile} from "./pages/Patient";
import { Home, Appointment, Patients } from "./pages/Doctor";

const PrivateRoute = ({ component: Component, ...rest }) => {
  const role = localStorage.getItem("role");
  return (
    <Route
      {...rest}
      render={(props) =>
        isAuth() ? (
          <Wrapper role={role}>
            <Component {...props} />
          </Wrapper>
        ) : (
          <Redirect to={{ pathname: "/", state: { from: props.location } }} />
        )
      }
    />
  );
};

const Routes = () => {
  return (
    <Router>
      <Switch>
        <Route
          exact
          path="/"
          render={(props) =>{
            const role = localStorage.getItem("role");
            const pathname = role === 'Medico'? '/home-doctor' : 
                              role === 'Paciente'? '/home' : '/';
            return isAuth() ? (
              <Redirect
                to={{ pathname: pathname, state: { from: props.location } }}
              />
            ) : (
              <Initial {...props} />
            )}
          }
        />
        <PrivateRoute path="/home" component={HomePatient} />
        <PrivateRoute path="/calendar" component={Calendar} />
        <PrivateRoute path="/perfil" component={Profile} />
        <PrivateRoute path="/agendamento" component={Schedules} />
        {/* <PrivateRoute path="/mapa-de-unidades" component={UnitMaps} /> */}
        <PrivateRoute path="/historico-agendamentos" component={SchedulingHistory} />
       
        

        <PrivateRoute path="/home-doctor" component={Home} />
        <PrivateRoute path='/appointment' component={Appointment} />
        <PrivateRoute path='/patients' component={Patients} />
        <Route path='/download' component={DownloadFile}/>
        
        <Route
          path="*"
          render={(props) =>(
                <Redirect
                  to={{ pathname: "/", state: { from: props.location } }}
                />
              ) 
          }
        />
      </Switch>
    </Router>
  );
};

export default Routes;
