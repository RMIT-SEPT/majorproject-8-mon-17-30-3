import React, { Component } from 'react'
import Persons from './Persons/Persons'
import "bootstrap/dist/css/bootstrap.min.css"
class Dashboard extends Component {
    render() {
        return (
            <div>
            
            <h1 className="alert alert-warning">Welcome to Dashboard</h1>
            <Persons/>
            </div>
        )
    }
}
export default Dashboard;
