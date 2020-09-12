import React, { Component } from 'react'
import axios from 'axios';

class MakeBooking extends Component {
    constructor(){
        super();

        this.state= {
        name: "", 
        personIdentifier: "",
        desc: "",
        start_date: "",
        end_date: "" 
    }; 

         {/* should be :
            this.state= {
            user_id: "",
            serviceName: "",
            workerName: "",
            status: "",
            date: "",
            time: ""    
            }
        */}

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    
        }

    onChange(e){
        this.setState({[e.target.name]: e.target.value});
    }
    onSubmit(e){
        e.preventDefault();
        const newPerson = {
            name: this.state.name,
            personIdentifier: this.state.personIdentifier,
            desc: this.state.desc,
            start_date:this.state.start_date,
            end_date: ""
        }

        console.log(newPerson);
        axios.post("http://localhost:8080/api/booking/",newPerson);
        this.props.history.push('/')
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
                            placeholder="UserID" 
                            name="personIdentifier"
                            value= {this.state.personIdentifier}
                            onChange = {this.onChange}
                            />
                            
                            </div>



                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg " 
                                placeholder="Service Name" 
                                name="desc"
                                value= {this.state.desc}
                                onChange = {this.onChange}
                                />
                                
                            </div>
                            <div className="form-group">
                                <input type="text" className="form-control form-control-lg" 
                                placeholder="Worker Name"
                                name="name"
                                value= {this.state.name}
                                onChange = {this.onChange}
                                    />
                            </div>
                          
                            <div className="form-group">
                                <input className="form-control form-control-lg"placeholder="Status"></input> 
                                
                                {/*name = "desc"
                                value= {this.state.desc}
                                onChange = {this.onChange}
                                />*/}
                                

                            </div>
                            <h6>Date</h6>
                            <div className="form-group">
                                <input type="date" className="form-control form-control-lg" 
                                name="start_date"
                                value= {this.state.start_date}
                                onChange = {this.onChange}
                                />
                            </div>
                            <h6>Time</h6>
                            <div className="form-group">
                                <input type="time" className="form-control form-control-lg" ></input>
                                {/*name="end_date"*/} 
                                {/*value= {this.state.end_date}*/}
                                {/*onChange = {this.onChange}*/}
                                {/*/>*/}

                            </div>
    
                            <input type="submit" className="btn btn-primary btn-block mt-4" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        )
    }
}
export default MakeBooking;