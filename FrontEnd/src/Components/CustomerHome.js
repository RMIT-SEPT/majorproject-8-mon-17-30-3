import React, { Component } from 'react'
import './CSS/homeStyle.css'
import logo from './CSS/logo.png'

class CustomerHome extends Component {

        render() {
        return (
            <div className="Home">
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
                              <li><a href="/Login">LOGOUT</a></li>
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
            </div>

        )
    }
}
export default CustomerHome
