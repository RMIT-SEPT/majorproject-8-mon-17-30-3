import React from 'react';
import {BrowserRouter,Route,Switch} from 'react-router-dom'
import './App.css';
import './Components/CSS/global.css';
import Dashboard from './Components/Dashboard';
import Header from './Components/Layout/Header';
import Footer from './Components/Layout/Footer';
import ViewBooking from './Components/ViewBooking';
import MakeBooking from './Components/MakeBooking';
import Home from './Components/Home';
import Contact from './Components/Contact';
import Profile from './Components/Profile';
import Login from './Components/Login';
import Register from './Components/Register';

function App() {
  return (
    <div className="page-container">
    <Header/>
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={Home}></Route>
        <Route path="/Home" exact component={Home}></Route>
        <Route path="/ViewBooking" exact component={ViewBooking}></Route>
        <Route path="/MakeBooking" exact component={MakeBooking}></Route>
        <Route path="/Contact" exact component={Contact}></Route>
        <Route path="/Profile" exact component={Profile}></Route>
        <Route path="/Login" exact component={Login}></Route>
        <Route path="/Register" exact component={Register}></Route>
        <Route path="/MakeBooking" exact component={MakeBooking}></Route>
      </Switch>
    </BrowserRouter>
    <Footer/>
    </div>
  );
}

export default App;
