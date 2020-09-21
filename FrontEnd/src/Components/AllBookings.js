import React from 'react';
import { Table } from 'reactstrap';

const AllBookings=({data})=>{
    return(
        <>
        <Table>
            <th>Booking ID</th>
            <th>Service Name</th>
            <th>Worker Name</th>
            <th>Date </th>
            <th>Time</th>
            </Table>
             <div> {
            data && data.map((d)=>{
               return(
                    <div>
                    
                    <br></br><br></br>
                    
                    <Table>
                      <thead>
                        <tr>
                          
                        </tr>
                      </thead>          
                      <tbody>
               <td>{d.bookingID}</td>
               <td>{d.serviceName}</td>
               <td>{d.workerName}</td>
               <td>{d.date}</td>
               <td>{d.time}</td>
                </tbody>          
                    </Table>  
                  </div>
                
               )
           })
          } 
        
          <br/>
        </div>

        </>
    )
}

export default AllBookings;