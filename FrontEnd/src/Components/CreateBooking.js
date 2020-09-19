import React,{Component,useEffect,useState} from 'react';
import './CSS/booking.css'
import loginImg from '../Components/avatar.png'
import axios from 'axios';

class CreateBooking extends Component {
    
    state = {
            serviceName: "",
            workerName: "",
            date:"",
            time:""
        }

    servicehandler = (event) => {
        this.setState({
            serviceName: event.target.value
        })
    }
    workerhandler = (event) => {
        this.setState({
            workerName: event.target.value
        })
    }
    datehandler = (event) => {
        this.setState({
            date: event.target.value
        })
    }
    timehandler = (event) => {
        this.setState({
            time: event.target.value
        })
    }

    handleSubmit = e => {
        e.preventDefault();
        let information
        const bookingDetails = {
            serviceName: this.state.serviceName,
            workerName: this.state.workerName,
            date: this.state.date,
            time: this.state.time,
        };
        axios
        .post("http://localhost:8080/createBooking", bookingDetails)
        .then(res => console.log(res))
        .catch(err => console.log(err));
        this.props.history.push({
        pathname: '/CustomerHome',
    });
        

    }

    render() {
        return (
            <div className="bookingbox">
                <img src={loginImg} class="avatar"></img>
                <form onSubmit={this.handleSubmit}>
               <h1>AGME Booking</h1>
                    <p>Service Name </p> <input type="text" value={this.state.serviceName} onChange={this.servicehandler} placeholder="serviceName" required /><br />
                    <p>Worker Name</p> <input type="text" value={this.state.workerName} onChange={this.workerhandler} placeholder="workerName" required /><br />
                    <p>Date</p> <input type="text" value={this.state.date} onChange={this.datehandler} placeholder="date" required /><br />
                    <p>Time</p> <input type="text" value={this.state.time} onChange={this.timehandler} placeholder="time" required /><br />
                    <br/><input type="submit" value="Create Booking" /> 
                    <a href="/CustomerHome"> Back to DashBoard</a>
            </form>        
            </div>

        )
    }
}
export default CreateBooking;
