import React, { Component } from 'react'
import './styles.css'
import logo from './Images/logo.png'

class Profile extends Component {
    render() {
    return (
        <div className="Profile">
        <div className="container-fluid">
        <div className="jumbotron">
        <div className="col-md-12">
        <h1>Profile</h1>
        <h3>Your Details</h3>
        <h6>Note: This section should draw data from the Users table.</h6>
            <div className="row">
            <div className="col-md-12">
                <table>
                    <tr>
                        <th>Username</th>
                        <th>Phone</th>
                        <th>Email</th>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td>Phone</td>
                        <td>Email</td>
                    </tr>
                </table>
            </div>
            </div>
            <br/>
            <div className="row">
            <div className="col-md-12">
                <h3>Your Upcoming Bookings</h3>
                <h6>Note: This section should draw from the Bookings table.</h6>
                    <table>
                        <tr>
                            <th>Booking ID</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Service</th>
                            <th>Worker</th>
                        </tr>
                        <tr>
                            <td>43</td>
                            <td>10/10/2020</td>
                            <td>12:00</td>
                            <td>Haircut</td>
                            <td>Larry</td>
                        </tr>
                        <tr>
                            <td>55</td>
                            <td>05/12/2020</td>
                            <td>15:00</td>
                            <td>Hair colour</td>
                            <td>Susan</td>
                        </tr>
                        <tr>
                            <td>62</td>
                            <td>11/11/2020</td>
                            <td>14:00</td>
                            <td>Hair style</td>
                            <td>Bob</td>
                        </tr>
                    </table>
            </div>
            </div>
        </div>    
        </div>
        </div>
        </div>
        )
    }
}
export default Profile
