import React from 'react';
import {BrowserRouter, Route, Link, Switch} from "react-router-dom";
import './App.css';
import Register from './Components/Register'
import Login from './Components/Login';


//import Login from './Components/Login'

function App() {
  return (

    <div className="App">
      <Login/>
      <BrowserRouter>
        <Switch>
            <Route path="/Login" component={Login}></Route>
            <Route path="/Register" component={Register}></Route>
        </Switch>
      </BrowserRouter>

      
    </div>

  );
}

export default App;
