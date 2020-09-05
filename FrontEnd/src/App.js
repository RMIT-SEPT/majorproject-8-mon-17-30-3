import React from 'react';
import {BrowserRouter,Route,Switch} from 'react-router-dom'
import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/Layout/Header';
import ViewBooking from './components/ViewBooking';
import MakeBooking from './components/MakeBooking';
import Home from './components/Home';

function App() {
  return (
    <div>
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={Home}></Route>
        <Route path="/ViewBooking" exact component={ViewBooking}></Route>
        <Route path="/MakeBooking" exact component={MakeBooking}></Route>
      </Switch>
      
    </BrowserRouter>

    </div>
  );
}

export default App;
