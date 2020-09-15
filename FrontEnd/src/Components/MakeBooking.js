import React, { Component } from 'react'
import BookingService from './services/BookingService'

class MakeBooking extends Component {
    constructor(props){
        super(props);

        this.state= {
            user_id: "",
            servicename: "",
            workerName: "",
            status: "",
            date: "",
            time: ""    
            }; 

    this.onChange = this.onChange.bind(this);
    this.makeBooking = this.makeBooking.bind(this);
        }

    onChange(e){
        this.setState({[e.target.name]: e.target.value});
    }

    makeBooking = (e) => {
        e.preventDefault();
        let booking = {
            user_id: this.state.user_id,
            servicename: this.state.servicename,
            workerName: this.state.workerName,
            status:this.state.status,
            date: this.state.date,
            time: this.state.time,
        };

        console.log('booking => ' + JSON.stringify(booking));

        BookingService.createBooking(booking).then(res =>{
            this.props.history.push('/ViewBooking');
        });
    }

    render() {
        return (
            <div>
            <div className="box">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <h5 className="display-4 text-center">Make a new booking</h5>
                        <hr />
                        <form onSubmit={this.onSubmit}>


                            <div className="form-group">
                            <input type="text" className="form-control form-control-lg " 
                            placeholder="User ID" 
                            name="user_id"
                            value= {this.state.user_id}
                            onChange = {this.onChange}
                            />
                            </div>

                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg " 
                                placeholder="Service Name" 
                                name="servicename"
                                value= {this.state.servicename}
                                onChange = {this.onChange}
                                />  
                            </div>

                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg" 
                                placeholder="Worker Name"
                                name="workerName"
                                value= {this.state.workerName}
                                onChange = {this.onChange}
                                    />
                            </div>
                          
                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg" 
                                placeholder="Status"
                                name="status"
                                value= {this.state.status}
                                onChange = {this.onChange}
                                    />
                            </div>

                            <h6>Date</h6>
                            <div className="form-group">
                                <input type="date" className="form-control form-control-lg" 
                                name="date"
                                value= {this.state.date}
                                onChange = {this.onChange}
                                />
                            </div>

                            <h6>Time</h6>
                            <div className="form-group">
                                <input type="time" className="form-control form-control-lg"
                                name="time"
                                value= {this.state.time}
                                onChange = {this.onChange}
                                />
                            </div>
    
                            <button className="btn btn-primary btn-block mt-4" onClick={this.makeBooking}>Make Booking</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        )
    }
}
export default MakeBooking;