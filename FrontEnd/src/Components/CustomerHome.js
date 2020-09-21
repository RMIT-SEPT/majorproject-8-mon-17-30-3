import React, { Component } from 'react'
import './CSS/homeStyle.css'
import logo from './CSS/logo.png'
import axios from 'axios'

class CustomerHome extends Component {

    handleSubmit = e => {
        e.preventDefault();
        axios
        .get("http://localhost:8080/logout")
        .then(res => console.log(res))
        .catch(err => console.log(err));
        this.props.history.push({
        pathname: '/login',
    });
        

    }
        render() {
        return (
            <div className="Home">
            <form onSubmit={this.handleSubmit}>

             <head>  
              
                   <title>View Bookings</title>
              
                   </head> 
              <body>
                  <header>
                      <div className="wrapper">
                          <div className="logo">
                          <img src={logo} alt="">
                          </img>
                              </div>
                             
                          </div>
                          <ul className="nav-area">
                              {/* <li><a href="/Login">LOGOUT</a></li> */}
                              <input type="submit" value="Logout" /> 
                              </ul>
                              <div className="welcome-text">
                                  <h1> 
                                  <a href="#">View Past Bookings</a><br></br>
                                  <a href="CreateBooking">Create a Booking</a><br></br>
                                  <a href="Profile">View Details</a><br></br>
                                      </h1>
                                  </div>
                      </header>

              </body>
              </form>
            </div>

        )
    }
}
export default CustomerHome
