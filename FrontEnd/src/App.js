import React from 'react';
import {BrowserRouter,Route,Switch} from 'react-router-dom'
import './App.css';
import './Components/CSS/global.css';
import Dashboard from './Components/Dashboard';
import Header from './Components/Layout/Header';
import Footer from './Components/Layout/Footer';
import ViewBooking from './Components/ViewBooking';
import CreateBooking from './Components/CreateBooking';
import Home from './Components/Home';
import Contact from './Components/Contact';
import Login from './Components/Login';
import AdminHome from './Components/AdminHome'
import CustomerHome from './Components/CustomerHome' 
import Profile from './Components/Profile'
import BookingComponent from './Components/BookingComponent'
import AllBookings from './Components/AllBookings'
import Bookings from './Components/Bookings'
import Register from './Components/Register'


function App() {
  
  return (

    <div className="App">
      <Header/>
      <BrowserRouter>
         <Switch>
         <Route exact path="/" component={Login}></Route>
            <Route path="/Home" component={Home}></Route>
             <Route path="/Login" component={Login}></Route>
             <Route path="/Dashboard" component={Dashboard}></Route>
             <Route path="/Register" component={Register}></Route>
             <Route path="/AdminHome" component={AdminHome}></Route>
             <Route path="/CustomerHome" component={CustomerHome}></Route>
             <Route path="/CreateBooking" component={CreateBooking}></Route>
             <Route path="/Profile" component={Profile}></Route>
             <Route path="/Bookings" component={Bookings}></Route>
         </Switch>
      </BrowserRouter> 
<Footer/>
    </div>
  );
}
export default App;
