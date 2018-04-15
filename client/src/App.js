import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import Snackbar from 'material-ui/Snackbar';
import Register from './components/Register';
// import MainTableContainer from './containers/MainTableContainer';
// import AngajatiData from './mock_data/angajati.json';
import './css/App.css';

class App extends Component {

  constructor(props){
      super(props);
      this.state={
          registeredSuccessfully: false,
          failedRegistration: false
      }
  }

  isUserAuthenticated = () => {
    return true;
  }

  addUser = (userName, password, role, employeeId) => {
    const user = {
        userName,
        password,
        isAdmin: role.toUpperCase() === 'ADMIN',
        employeeId
    }

    fetch('api/users/add', {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(res=>res.json())
        .then( res => {
          console.log(res)
            if (res === true) {
                this.setState({registeredSuccessfully: true})
                this.setState({failedRegistration: false})
            } else {
                this.setState({registeredSuccessfully: false})
                this.setState({failedRegistration: true})
            }

        }).catch(function(err) {
        console.log(err)
    });
  }

  getUserRole = () => {
    //return "REGULAR"
    //return "ADMIN"
  }

  getEmployeesData = () => {
    //fetch from API
    //test that XHR requests are proxied to back-end server
    // fetch('/api/employeesData', {
    //     accept: 'application/json',
    //   }).then(function(data) {
    //         console.log(data)
    //     })

      fetch('/api/users', {
          accept: 'application/json',
      }).then(function(data) {
          console.log('users: ', data)
      })

    // return AngajatiData
  }

  render() {

    return (
      <MuiThemeProvider>
        <div className="App">
          <header className="App-header">
            <h1 className="App-title">Employees Management Platform</h1>
          </header>
          <p className="App-intro">
            Built with Java, Spring, React, and Material-UI.
          </p>
            {!this.isUserAuthenticated() ? <RaisedButton label="Log In" /> : null}
          {/*<MainTableContainer*/}
              {/*employeesData={this.getEmployeesData()}*/}
          {/*/>*/}
            <Register
                addUser = {this.addUser}
            />
            <Snackbar
                bodyStyle={{backgroundColor: 'green'}}
                autoHideDuration={5000}
                message={'Succesfully Registered!'}
                open={this.state.registeredSuccessfully}
              />
            <Snackbar
                bodyStyle={{backgroundColor: 'red'}}
                autoHideDuration={5000}
                message={'An error occured when trying to register!'}
                open={this.state.failedRegistration}
            />

        </div>
    </MuiThemeProvider>
    );
  }
}

export default App;
