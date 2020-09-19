import React,{useEffect,useState} from 'react';
import Colors from './Color';
import axios from 'axios';

const Authenticate=()=>{
    const [Data,setData]=useState({
        email:'',
        userType:''
    });
    
    const customer = {
       
       email:'li@li.com',
       password:'password' 
      
    };

    // const [colorsData,setColorsData]=useState([])
    useEffect(()=>{
        axios.post('http://localhost:8080/loginUser',customer)
            .then(res=>{
                console.log('Response from main API: ',res)
                console.log('Home Data: ',res.data.userType)
                let information=res.data;
                setData({userType:information.userType})
                console.log('Colors Data: ',res.data.data)
                // setColorsData(res.data.data)
            })
            .catch(err=>{
                console.log(err);
            })
    },[])
    return(
        <>
           
            <p>{Data.userType}</p>
            {/* <Colors data={colorsData}/> */}
        </>
    )
}

export default Home;
