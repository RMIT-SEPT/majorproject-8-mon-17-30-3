import React,{Component,useEffect,useState} from 'react';
import axios from 'axios';
import './CSS/Profile.css'
const Profile=()=>{
    const [Data,setData]=useState({
        email:'',
        firstName:'',
        lastName:''
    });
    
    useEffect(()=>{
        axios.get('http://localhost:8080/profile')
            .then(res=>{
                let information=res.data;
                setData({email:information.email,firstName:information.firstName,lastName:information.lastName})
            })
            .catch(err=>{
                console.log(err);
            })
    },[])
    return(
        <div className="container-fluid">
                <div className="row">
                    <div className="content-box col-md-8 m-auto">
                        <h5 className="pageTitle display-4 text-center">Your Profile</h5>
                        <hr />
                            <p>Email: {Data.email}</p><br/>
                            <p>Firt Name: {Data.firstName}</p><br/>
                            <p>Last Name:  {Data.lastName}</p><br/>
                            <button href="/"> Back to Dashboard</button>
                </div>
           </div>
        </div>
    )
}

export default Profile;
