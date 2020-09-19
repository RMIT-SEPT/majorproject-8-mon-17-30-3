import React from 'react';
import {BrowserRouter, Route, Link, Switch} from "react-router-dom";
import './App.css';
import Register from './Components/Register'
import Login from './Components/Login';
import Home from './Components/Home'
import AdminHome from './Components/AdminHome'
//import Login from './Components/Login'
<<<<<<< Updated upstream

=======
import CustomerHome from './Components/CustomerHome' 
import CreateBooking from './Components/CreateBooking'
>>>>>>> Stashed changes
function App() {
  return (

    <div className="App">
     {/* <AdminHome/> */}
     {/* <Home/> */}
     <Login/>
      <BrowserRouter>
<<<<<<< Updated upstream
        <Switch>
            <Route path="/Home" component={Home}></Route>
            <Route path="/Login" component={Login}></Route>
            <Route path="/Register" component={Register}></Route>
            <Route path="/AdminHome" component={AdminHome}></Route>
        </Switch>
      </BrowserRouter>

=======
         <Switch>
             <Route path="/Home" component={Home}></Route>
             <Route path="/Login" component={Login}></Route>
             <Route path="/Register" component={Register}></Route>
             <Route path="/AdminHome" component={AdminHome}></Route>
             <Route path="/CustomerHome" component={CustomerHome}></Route>
             <Route path="/CreateBooking" component={CreateBooking}></Route>
         </Switch>
      </BrowserRouter> 
     {/* <BookingComponent2/>  */}
>>>>>>> Stashed changes
      
    </div>

  );
}

export default App;
