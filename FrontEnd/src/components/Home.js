import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import "./styles.css"

export default class Home extends Component {
    render() {
        return (
            <div>
                <ul>
                    <li><Link to="/ViewBooking">View All Bookings</Link></li>
                    <li><Link to="/MakeBooking">Make a Booking</Link></li>
                </ul>
            </div>
        )
    }
}
