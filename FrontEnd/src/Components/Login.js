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

<<<<<<< Updated upstream
=======
    handleSubmit = e => {
        e.preventDefault();
        let information
        const customer = {
            email: this.state.email,
            password: this.state.password,
           
        };
        axios.post('http://localhost:8080/loginUser',customer)
        .then(res=>{
            console.log('Response from main API: ',res)
            console.log('Home Data: ',res.data.userType)
            information=res.data;
             this.state.userType=information.userType;
            if(information.userType == 'ADMIN_USER'){
                this.props.history.push({
                    pathname: '/AdminHome',
                });
            }
            else if(information.userType == 'SITE_USER'){
                this.props.history.push({
                    pathname: '/CustomerHome',
                });
            }
            else{
                
            }
>>>>>>> Stashed changes

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
