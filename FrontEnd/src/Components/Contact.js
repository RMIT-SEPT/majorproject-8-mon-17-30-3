import React, { Component } from 'react'
import './styles.css'

class Contact extends Component {
    render() {
    return (
        <div className="Contact">
        <div className="container-fluid">
        <div className="jumbotron">
        <h1>Contact Us</h1>
        <h4>Note: This page should draw data from the Users table where a User is an Admin.</h4>
                <table>
                    <tr>
                        <th>Site Administrator</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
                    <tr>
                    <td>Admin Name</td>
                    <td>admin@contact.com</td>
                    <td>0494938443</td>
                    </tr>
                </table>
        </div>    
        </div>
        </div>
        )
    }
}
export default Contact
