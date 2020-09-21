import React,{useEffect,useState} from 'react';
import axios from 'axios';
import AllBookings from '../Components/AllBookings'

const Bookings=()=>{
    // const [Data,setData]=useState({
    //     Company:'',
    //     Description:''
    // })
    const [bookingsData,setbookingsData]=useState([])
    useEffect(()=>{
        axios.get('http://localhost:8080/bookings')
            .then(res=>{
                // console.log('Response from main API: ',res)
                // console.log('Home Data: ',res.data.ad)
                // let companyData=res.data.ad;
                // setData({Company:companyData.company,Description:companyData.text})
                // console.log('Colors Data: ',res.data.data)
                
                setbookingsData(res.data.data)
            })
            .catch(err=>{
                console.log(err);
            })
    },[])
    return(
        <>
            {/* <h1>{Data.Company}</h1>
            <p>{Data.Description}</p> */}
            <AllBookings data={bookingsData}/>
        </>
    )
}

export default Bookings;
