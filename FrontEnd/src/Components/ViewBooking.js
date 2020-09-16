import React, { Component } from "react";
import "./styles.css";
import axios from 'axios';
import DataService from './DataService.js';
import { Link } from "react-router-dom";

export default class ViewBooking extends Component {

  state = {
    booking: []

  }
  componentDidMount() {
    axios.get('http://localhost:8080/bookings').then(response => {this.setState({booking: response.data})});
  }

  deleteRow(id,e){
   const url = 'http://localhost:8080/bookings'
   axios.delete(url+id).then(response => {this.setState({booking: response.data})});
   this.props.history.push('/')

  }

  render() {
    return (
      <div>
          <div className="box">
            <div className="col-md-8 m-auto">
              <div className="row">
                <h5 className="display-4 text-center">Upcoming Bookings</h5>
                <hr/>
              </div>
              <div className="row">
                <table>
                  <tr>
                    <th>Booking ID</th>
                    <th>User ID</th>
                    <th>Service</th>
                    <th>Worker</th>
                    <th>Status</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Delete</th>
                  </tr>
                  <tbody>
          {
              this.state.booking.map(
                  booking =>
                      <tr key={booking.id}> {/* booking.booking_id*/}
                          <td>{booking.id}</td>{/* booking.booking_id*/}
                          <td>{booking.personIdentifier}</td>{/* booking.user_id*/}
                          <td>{booking.desc}</td>{/* booking.serviceName*/}
                          <td>{booking.name}</td>{/* booking.workerName*/}
                          <td>{booking.end_date}</td>{/* booking.status*/}
                          <td>{booking.created_At}</td>{/* booking.date*/}
                          <td>12:00</td>{/* booking.time*/}
                      </tr>
              )
          }
                  </tbody>
                </table>
            </div>
            <div className="row">
              <a className="btn btn-success" href="/MakeBooking">Make a Booking</a>
            </div>
          </div>
        </div>
      </div>

      
    );
  }
}
