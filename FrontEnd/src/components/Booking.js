import React, { Component } from "react";
import "./styles.css";
export default class Booking extends Component {
  render() {
    return (
      <div className="box">
        <h1>View Bookings</h1>
        <table>
          <tr>
            <th>Service</th>
            <th>Job</th>
            <th>Date</th>
            <th>Make Booking</th>
          </tr>
          <tr>
            <td>Service 1</td>
            <td>Job 1</td>
            <td>1/1/2020</td>
            <td>.</td>
          </tr>
          <tr>
            <td>Service 2</td>
            <td>Job 2</td>
            <td>1/1/2020</td>
            <td>.</td>
          </tr>
          <tr>
            <td>Service 3</td>
            <td>Job 3</td>
            <td>1/1/2020</td>
            <td>.</td>
          </tr>
        </table>
      </div>
    );
  }
}
