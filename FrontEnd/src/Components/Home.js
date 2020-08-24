import React, { Component } from 'react'
import './CSS/homeStyle.css'
import logo from './CSS/logo.png'

class Home extends Component {

        render() {
        return (
            <div className="Home">
             <head>  
              
                   <title>Welcome to Agme</title>
              
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
                              
                              <li><a href="Home">AGME</a></li>
                              <li><a href="AdminHome">ABOUT US</a></li>
                              <li><a href="/Login">LOGIN</a></li>
                              <li><a href="/Register">REGISTER</a></li>
                              </ul>
                              <div className="welcome-text">
                                  <h1> 
                                      WELCOME TO AGME
                                      </h1>
                                  </div>
                      </header>

              </body>
            </div>

        )
    }
}
export default Home
