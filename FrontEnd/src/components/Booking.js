import React, { Component } from "react";
import "./styles.css";
import axios from 'axios';
import DataService from './DataService.js';

export default class Booking extends Component {

  state = {
    person: []

  }
  componentDidMount() {
    axios.get('http://localhost:8080/api/person/all').then(response => {this.setState({person: response.data})})
  }


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
            <th>Date</th>
            <th>Make Booking</th>
          </tr>
          <tbody>
          {
              this.state.person.map(
                  person =>
                      <tr key={person.id}>
                          <td>{person.desc}</td>
                          <td>{person.name}</td>
                          <td>{person.personIdentifier}</td>
                          <td></td>
                          <td></td>
                      </tr>
              )
          }
      </tbody>
        </table>
      </div>

      
    );
  }
}
