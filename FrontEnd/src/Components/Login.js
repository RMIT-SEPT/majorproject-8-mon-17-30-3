import React, { Component } from 'react'
import './CSS/global.css'
import loginImg from './Images/avatar.png'

class Login extends Component {
    constructor(props) {
        super(props)

        this.state = {
            username: "",
            email: "",
            password: "",
        }
        this.handleSubmit=this.handleSubmit.bind(this)
    }
    userNamehandler = (event) => {
        this.setState({
            username: event.target.value
        })
    }
    emailhandler = (event) => {
        this.setState({
            email: event.target.value
        })
    }
    passwordhandler = (event) => {
        this.setState({
            password: event.target.value
        })
    }

    handleSubmit = (event) => {
        alert(`${this.state.firstName} ${this.state.lastName}  Login successful!`)
        console.log(this.state);
        this.setState({
            email: "",
            firstName: "",
            lastName: "",
            password: '',
            gender: "",
        })
     event.preventDefault()
        
    }

    render() {
        return (
            <div className="registerBox col-md-5 align-items-center">
             <div className="container-fluid">
                <img src={loginImg} class="avatar"></img>
                    <form onSubmit={this.handleSubmit}>
                        <h1>Login</h1>
                            <p>Username</p> 
                                <input type="text" 
                                value={this.state.username} 
                                onChange={this.userNamehandler} 
                                placeholder="Username" required/>

                            <p>Password</p> 
                                <input type="password" 
                                value={this.state.password} 
                                onChange={this.passwordhandler} 
                                placeholder="Password" required/>
                                
                        <input className="btn-success" type="submit" value="Sign in" />
                        <div class="btn-toolbar col-lg-12">
                            <button href="Register" class="btn btn-success mx-auto" role="button">Register</button>
                            <button href="Home" class="btn btn-success mx-auto" role="button">Home</button>
                        </div>
                    </form>        
                </div>
            </div>
        )
    }
}
export default Login
