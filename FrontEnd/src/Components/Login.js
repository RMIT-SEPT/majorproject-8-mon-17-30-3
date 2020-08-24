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
        alert(`${this.state.firstName} ${this.state.lastName}  Login Successfully !`)
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
               <h1>AGME LOGIN</h1>
                    <p>UserName </p> <input type="text" value={this.state.username} onChange={this.userNamehandler} placeholder="Username" required /><br />
                    <p>Password</p> <input type="password" value={this.state.password} onChange={this.passwordhandler} placeholder="Password" required /><br />
                    <br/><input type="submit" value="Sign in" /> 
                    <a href="/Register">Create Account</a><br></br><br></br>
                    <a href="/Home"> Home</a>
            </form>        
            </div>

        )
    }
}
export default Login
