import React from 'react';
import {BrowserRouter, Route, Link, Switch} from "react-router-dom";
import './App.css';
import Register from './Components/Register'
import Login from './Components/Login';
import Home from './Components/Home'
import AdminHome from './Components/AdminHome'
import CustomerHome from './Components/CustomerHome' 
import CreateBooking from './Components/CreateBooking'
import Profile from './Components/Profile'
import AllBookings from './Components/AllBookings'

function App() {
  
  return (

    <div className="App">
      <BrowserRouter>
         <Switch>
             <Route path="/Home" component={Home}></Route>
             <Route path="/Login" component={Login}></Route>
             <Route path="/Register" component={Register}></Route>
             <Route path="/AdminHome" component={AdminHome}></Route>
             <Route path="/CustomerHome" component={CustomerHome}></Route>
             <Route path="/CreateBooking" component={CreateBooking}></Route>
             <Route path="/Profile" component={Profile}></Route>
             <Route path="/AllBookings" component={AllBookings}></Route>
         </Switch>
      </BrowserRouter> 
      </div>

  
);
}
export default App;
