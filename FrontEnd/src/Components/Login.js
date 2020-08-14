import React, { Component } from 'react'
import './CSS/style.css'
import loginImg from '../Components/avatar.png'
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
        alert(`${this.state.firstName} ${this.state.lastName}  Registered Successfully !!!!`)
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
            <div className="loginbox">
                <img src={loginImg} class="avatar"></img>
                <form onSubmit={this.handleSubmit}>
               <h1>Login</h1>
                    <p>UserName </p> <input type="text" value={this.state.username} onChange={this.userNamehandler} placeholder="Username..." /><br />
                    <p>Password</p> <input type="password" value={this.state.password} onChange={this.passwordhandler} placeholder="Password..." /><br />
                    <br/><input type="submit" value="Register Account" /> 
            </form>        
            </div>

        )
    }
}
export default Login
