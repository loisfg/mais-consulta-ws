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
} from "./pages/Patient";
import { Home } from "./pages/Doctor";

const PrivateRoute = ({ component: Component, username, ...rest }) => (
  <Route
    {...rest}
    render={(props) =>
      isAuth() ? (
        <Wrapper>
          <Component username={username} {...props} />
        </Wrapper>
      ) : (
        <Redirect to={{ pathname: "/", state: { from: props.location } }} />
      )
    }
  />
);
const Routes = () => {
  const usuarioFormatoDeString = localStorage.getItem("usuario");
  const usuario = JSON.parse(usuarioFormatoDeString);

  const username = usuario.paciente.nome;

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
        <PrivateRoute
          path="/home"
          component={HomePatient}
          username={username}
        />
        <PrivateRoute
          path="/calendar"
          component={Calendar}
          username={username}
        />
        <PrivateRoute 
          path="/perfil" 
          component={Profile} 
          username={username} 
        />
        <PrivateRoute
          path="/agendamento"
          component={Schedules}
          username={username}
        />
        <PrivateRoute
          path="/mapa-de-unidades"
          component={UnitMaps}
          username={username}
        />

        {/*  TODO: Privatizar rotas do medico */}
        <Route path="/home-doctor" component={Home} />
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
