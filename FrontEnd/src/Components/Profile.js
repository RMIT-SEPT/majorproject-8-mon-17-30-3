import React, { Component } from 'react'

class Profile extends Component {
    render() {
    return (
        <div>
        <div className="container-fluid">
          <div className="col-md-8 m-auto">
            <div className="row">
              <h5 className="display-4 text-center">Profile</h5>
              <hr/>        
            
              <table className="table">
                <thead>
                <tr>
                    <th className="bg-dark text-white" scope="col">Your ID</th>
                    <th className="bg-dark text-white" scope="col">Username</th>
                    <th className="bg-dark text-white" scope="col">First Name</th>
                    <th className="bg-dark text-white" scope="col">Surname</th>
                </tr>
                </thead>
                <tbody>
                    <td className="bg-light text-dark" >1</td>
                    <td className="bg-light text-dark">Markj47</td>
                    <td className="bg-light text-dark">Mark</td>
                    <td className="bg-light text-dark">Johnson</td>
                </tbody>
              </table>
            </div>
          <div className="row">
            <a className="btn btn-primary btn-block mt-2" href="/">Edit Profile</a>
          </div>
        </div>
      </div>
    </div>

    
      )
    }
}
export default Profile
