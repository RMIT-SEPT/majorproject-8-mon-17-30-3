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
        isRegistered: false,
        show: true
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
    
    handleSubmit = e => {
        e.preventDefault();
        const customer = {
            name: this.state.name,
            lastName: this.state.lastName,
            email: this.state.email,
            password: this.state.password,
        };
        axios
            .post("http://localhost:8080/createUser", customer)
            .then(res => console.log(res))
            .catch(err => console.log(err));
        this.props.history.push({
            pathname: '/login',
        });
    }

    handleField = (event) => {
        this.setState({
            show: this.state.show = false
        });
    };
        
          operation(){
              this.setState({
                  show:false
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

                    <p>Do You Want To Register as a company</p><br />
                    <p>Yes</p><input type="radio" onclick={()=>this.operationTrue()} name="yesCheck" id="yesCheck" />
                    <p>No</p><input type="radio" onclick={this.handleField} name="yesCheck" id="yesCheck" />
                   
                   {this.state.show?
                    <div className="ifYes" >

                        <input type="text"
                            field="*{companyName}"
                            placeholder="Company name"
                            class="form-control" />

                        <input type="text"
                            field="*{serviceName}"
                            placeholder="Service name"
                            class="form-control" />

                        <input type="text"
                            field="*{number}"
                            placeholder="Number"
                            class="form-control" />
               
                    </div>
                    :null
                    }
                    
                    <br /><input type="submit" value="Register Account" />

                    <a href="Login">Back to Login</a><br></br><br></br>
                    <a href="Home">Home</a>
                </form>

            </div>

        );
    }
}

export default Register;


