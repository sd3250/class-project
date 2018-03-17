import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import MainTableContainer from './containers/MainTableContainer'
import AngajatiData from './mock_data/angajati.json'
import logo from './img/logo.svg';
import './css/App.css';

class App extends Component {

  isUserAuthenticated = () => {
    return true;
  }

  getUserRole = () => {
    //return "REGULAR"
    //return "ADMIN"
  }

  getEmployeesData = () => {
    //fetch from API
    //test that XHR requests are proxied to back-end server
    fetch('/api/employeesData', {
        accept: 'application/json',
      }).then(function(data) {
            console.log(data)
        })

    return AngajatiData
  }

  render() {

    return (
      <MuiThemeProvider>
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <h1 className="App-title">Employees Management Platform</h1>
          </header>
          <p className="App-intro">
            Built with Java, Spring, React, and Material-UI.
          </p>
            {!this.isUserAuthenticated() ? <RaisedButton label="Log In" /> : null}
          <MainTableContainer
              employeesData={this.getEmployeesData()}
          />
        </div>
    </MuiThemeProvider>
    );
  }
}

export default App;
