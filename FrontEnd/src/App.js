import React from 'react';
import {BrowserRouter,Route,Switch} from 'react-router-dom'
import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/Layout/Header';
import Booking from './components/Booking';
import Home from './components/Home';

function App() {
  return (
    <div>
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={Home}></Route>
        <Route path="/Booking" exact component={Booking}></Route>
      </Switch>
      
    </BrowserRouter>

    </div>
  );
}

export default App;
