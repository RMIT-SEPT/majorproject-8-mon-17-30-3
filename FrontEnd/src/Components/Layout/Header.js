import React, { Component } from 'react'
import logo from '../Images/logo.png'

 class Header extends Component {
    render() {
        return (
        <div>
            <nav className="navbar navbar-expand-sm navbar-dark bg-dark mb-4">
                <div className="container">
                    <a className="navbar-brand" href="/Home"><img className="logo" src={logo} alt=""/></a>
                        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
                            <span className="navbar-toggler-icon" />
                        </button>
                    <div className="collapse navbar-collapse" id="mobile-nav">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <a className="nav-link" href="/Dashboard">Dashboard</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/MakeBooking">Book</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/ViewBooking">Bookings</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/Profile">Profile</a>
                            </li>
                        </ul>
                        <ul className="navbar-nav ml-auto">
                            <li className="nav-item">
                                    <a className="nav-link" href="Login">Login</a>
                            </li>
                            <li className="nav-item">
                                    <a className="nav-link " href="Register">Register</a>
                            </li>    
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        )
    }
}
export default Header;