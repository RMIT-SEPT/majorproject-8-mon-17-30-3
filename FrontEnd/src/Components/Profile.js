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
        <>
        <div className="Profilebox">
           <p>Email: {Data.email}</p><br/>
           <p>Firt Name: {Data.firstName}</p><br/>
           <p>Last Name:  {Data.lastName}</p><br/>
           <a href="/CustomerHome"> Back to DashBoard</a>

           </div>
        </>
    )
}

export default Profile;
