import React, { Component } from "react";
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
          <div className="container-fluid">
            <div className="col-md-8 m-auto">
              <div className="row">
                <h5 className="display-4 align-middle">Upcoming Bookings</h5>
                <hr/>        

                <table className="table">
                  <thead>
                  <tr>
                    <th className="bg-dark text-white text-center align-middle" scope="col">Booking Number</th>
                    <th className="bg-dark text-white text-center align-middle" scope="col">User ID</th>
                    <th className="bg-dark text-white text-center align-middle" scope="col">Service</th>
                    <th className="bg-dark text-white text-center align-middle" scope="col">Worker</th>
                    <th className="bg-dark text-white text-center align-middle" scope="col">Status</th>
                    <th className="bg-dark text-white text-center align-middle" scope="col">Date</th>
                    <th className="bg-dark text-white text-center align-middle" scope="col">Time</th>
                    <th className="bg-dark text-white text-center align-middle" scope="col">Delete</th>
                  </tr>
                  </thead>
                  <tbody>
          {
              this.state.booking.map(
                  booking =>
                      <tr key={booking.booking_id}>
                          <th scope="row">{booking.booking_id}</th>
                          <td>{booking.user_id}</td>
                          <td>{booking.serviceName}</td>
                          <td>{booking.workerName}</td>
                          <td>{booking.status}</td>
                          <td>{booking.date}</td>
                          <td>{booking.time}</td>
                      </tr>
              )
          }
                  </tbody>
                </table>
              </div>
            <div className="row">
              <a className="btn btn-primary btn-block mt-2" href="/MakeBooking">Make a Booking</a>
            </div>
          </div>
        </div>
      </div>

      
    );
  }
}
