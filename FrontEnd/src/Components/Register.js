import React, { Component } from 'react'
import loginImg from '../Components/avatar.png'
import './CSS/todo.css'
import axios from "axios";


class Register extends Component {

    state = {
        email: "",
        name: "",
        lastName: "",
        password: "",
        companyName: "",
        serviceName: "",
        number: "",
        isRegistered: false,
        show: false
    };

    emailhandler = (event) => {
        this.setState({
            email: event.target.value
        });
    };
    firsthandler = (event) => {
        this.setState({
            name: event.target.value
        });
    };
    lasthandler = (event) => {
        this.setState({
            lastName: event.target.value
        });
    };
    passwordhandler = (event) => {
        this.setState({
            password: event.target.value
        });
    };

    companyNameHandler = (event) => {
        this.setState({
            companyName: event.target.value
        });
    };

    serviceNameHandler = (event) => {
        this.setState({
            serviceName: event.target.value
        });
    };
    
    mobileHandler = (event) => {
        this.setState({
            number: event.target.value
        });
    };

    handleSubmit = e => {
        e.preventDefault();
        const customer = {
            name: this.state.name,
            lastName: this.state.lastName,
            email: this.state.email,
            password: this.state.password,
        };
        
        const admin = {
            name: this.state.name,
            lastName: this.state.lastName,
            email: this.state.email,
            password: this.state.password,
            companyName: this.state.companyName,
            serviceName: this.state.serviceName,
            number: this.state.number,
        };

        if(this.state.companyName == ""){
        axios
            .post("http://localhost:8080/createUser", customer)
            .then(res => console.log(res))
            .catch(err => console.log(err));
        this.props.history.push({
            pathname: '/login',
        });
    }
    else {
        axios
            .post("http://localhost:8080/createUser", admin)
            .then(res => console.log(res))
            .catch(err => console.log(err));
        this.props.history.push({
            pathname: '/login',
        });
    }
    }

    handleField = (event) => {
        this.setState({
            show: this.state.show = false
        });
    };
        
          operation(){
              this.setState({
                  show:!this.state.show
              })
          }

        operationTrue(){
            this.setState({
                show:true
            })
          }

    render() {

        
        return (
            <div className="registerBox">

                <img src={loginImg} class="avatar"></img>
                <form onSubmit={this.handleSubmit}>

                    <h1>CREATE AGME ACCOUNT</h1>

                    <p>FirstName</p>
                    <input type="text" value={this.state.name}
                        onChange={this.firsthandler}
                        placeholder="FirstName" required /><br />

                    <p>LastName</p>
                    <input type="text" value={this.state.lastName}
                        onChange={this.lasthandler} placeholder="LastName" required /><br />

                    <p>Email</p> <input type="text"
                        value={this.state.email}
                        onChange={this.emailhandler}
                        placeholder="Email" required /><br />

                    <p>Password</p>
                    <input type="password"
                        value={this.state.password}
                        onChange={this.passwordhandler}
                        placeholder="Password" required /><br />

                    {this.state.show?
                    <div className="ifYes" >
                        <p>Company Name</p>
                        <input type="text"
                            value={this.state.companyName}
                            onChange={this.companyNameHandler}
                            placeholder="Company name"
                            class="form-control" />
                        
                        <p>Service Name</p>
                        <input type="text"
                            value={this.state.serviceName}
                            onChange={this.serviceNameHandler}
                            placeholder="Service name"
                            class="form-control" />
                        
                        <p>Phone Number</p>                      
                        <input type="text"
                            value={this.state.number}
                            onChange={this.mobileHandler}
                            placeholder="Number"
                            class="form-control" />
               
                    </div>
                    :null
                    }
                    
                    
                    <br /><input type="submit" value="Register Account" />
                    <button onClick={()=>this.operation()} >Click Here to Register Company</button><br/><br/>
                    <a href="Login">Back to Login</a><br></br><br></br>
                    <a href="Home">Home</a>
                </form>

            </div>

        );
    }
}

export default Register;


