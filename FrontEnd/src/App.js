import React from 'react';
import {BrowserRouter, Route, Link, Switch} from "react-router-dom";
import './App.css';
import Register from './Components/Register'
import Login from './Components/Login';
import Home from './Components/Home'
import AdminHome from './Components/AdminHome'
//import Login from './Components/Login'

function App() {
  return (

    <div className="App">
     {/* <AdminHome/> */}
     {/* <Home/> */}
     <Login/>
      <BrowserRouter>
        <Switch>
            <Route path="/Home" component={Home}></Route>
            <Route path="/Login" component={Login}></Route>
            <Route path="/Register" component={Register}></Route>
            <Route path="/AdminHome" component={AdminHome}></Route>
        </Switch>
      </BrowserRouter>

      
    </div>

  );
}

export default App;
