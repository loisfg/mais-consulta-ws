import React from "react";
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect,
} from "react-router-dom";
import { isAuth } from "./services/auth";
import { Calendar, Wrapper } from "../src/components";
import {
  HomePatient,
  Initial,
  Profile,
  Schedules,
  UnitMaps,
  SchedulingHistory,
} from "./pages/Patient";
import { Home, Appointment } from "./pages/Doctor";
import {Test} from './pages/Test'

const PrivateRoutePaciente = ({ component: Component, ...rest }) => {
  const usuarioFormatoDeString = localStorage.getItem("usuario");
  const usuario = JSON.parse(usuarioFormatoDeString);

  return (
    <Route
      {...rest}
      render={(props) =>
        isAuth() ? (
          <Wrapper>
            <Component usuario={usuario} {...props} />
          </Wrapper>
        ) : (
          <Redirect to={{ pathname: "/", state: { from: props.location } }} />
        )
      }
    />
  );
};

const PrivateRouteMedico = ({ component: Component, ...rest }) => {
  const usuarioFormatoDeString = localStorage.getItem("usuario");
  const usuario = JSON.parse(usuarioFormatoDeString);

  return (
    <Route
      {...rest}
      render={(props) =>
        isAuth() ? (
          <Component usuario={usuario} {...props} />
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
          render={(props) =>
            isAuth() ? (
              <Redirect
                to={{ pathname: "/home", state: { from: props.location } }}
              />
            ) : (
              <Initial {...props} />
            )
          }
        />
        <PrivateRoutePaciente path="/home" component={HomePatient} />
        <PrivateRoutePaciente path="/calendar" component={Calendar} />
        <PrivateRoutePaciente path="/perfil" component={Profile} />
        <PrivateRoutePaciente path="/agendamento" component={Schedules} />
        <PrivateRoutePaciente path="/mapa-de-unidades" component={UnitMaps} />
        <PrivateRoutePaciente path="/historico-agendamentos" component={SchedulingHistory} />
        {/*  TODO: Privatizar rotas do medico */}

        {/* <PrivateRouteMedico path="/home-doctor" component={Home} /> */}
        <Route path="/home-doctor" component={Home} />
        <Route path='/appointment' component={Appointment} />
        <Route path='/test' component={Test}/>

        <Route
          path="*"
          render={(props) =>
            isAuth() ? (
              <Redirect
                to={{ pathname: "/home", state: { from: props.location } }}
              />
            ) : (
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
