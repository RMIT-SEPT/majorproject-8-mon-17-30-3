import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import "./styles.css"

export default class Home extends Component {
    render() {
        return (
            <div>
                <Link to="/Booking">Booking</Link>
            </div>
        )
    }
}
