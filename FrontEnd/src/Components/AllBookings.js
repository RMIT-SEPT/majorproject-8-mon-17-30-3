import React from 'react';
import { Table } from 'reactstrap';

const AllBookings=({data})=>{
    return(
        <>
        <div className="container-fluid">
        <div className="col-md-8 m-auto">
        <table className="table">
          <th>Booking ID</th>
          <th>Service Name</th>
          <th>Worker Name</th>
          <th>Date </th>
          <th>Time</th>
            </table>
             <div> {
            data && data.map((d)=>{
               return(
                    <div>
                    <table>         
                      <tbody>
                        <td>{d.bookingID}</td>
                        <td>{d.serviceName}</td>
                        <td>{d.workerName}</td>
                        <td>{d.date}</td>
                        <td>{d.time}</td>
                      </tbody>          
                    </table>  
                  </div>
                
               )
           })
          } 
        
          <br/>
        </div>
        </div>
        </div>
        </>
    )
}

export default AllBookings;