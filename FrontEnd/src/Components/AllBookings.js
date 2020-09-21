import React,{useEffect,useState} from 'react';

import axios from 'axios';

const AllBookings=()=>{
    const [Data,setData]=useState({
        id:'',
        serviceName:'',
        workerName:'',
        date:'',
        time:''
    })
    
    useEffect(()=>{
        axios.get('http://localhost:8080/bookings')
            .then(res=>{
                let information=res.data;
                setData({id:information.bookingID,serviceName:information.serviceName,workerName:information.workerName,
                date:information.date,time:information.time})
            })
            .catch(err=>{
                console.log(err);
            })
    },[])
    return(
        <>
           <p>id: {Data.id}</p>
           <p>Service Name: {Data.serviceName}</p>
           <p>Worker Name:  {Data.workerName}</p>
           <p>Date :  {Data.date}</p>
           <p>Time :  {Data.time}</p>

        </>
    )
}

export default AllBookings;
