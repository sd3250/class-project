import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import Snackbar from 'material-ui/Snackbar';
import Register from './containers/Register';
import MainTableContainer from './containers/MainTableContainer';
import './css/App.css';

class App extends Component {

  constructor(props){
      super(props);
      this.state={
          registeredSuccessfully: false,
          failedRegistration: false,
          employeesData: []
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

  componentDidMount() {
      this.getEmployeesData()
  }

  getUserRole = () => {
    //return "REGULAR"
    //return "ADMIN"
  }

  getEmployeesData = () => {

      fetch('api/employee', {
          method: 'get',
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          }
      }).then(res=>res.json())
          .then( res => {
              console.log(res)
              this.setState({employeesData: res})
          }).catch(function(err) {
          console.log(err)
      })
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
            {/*{!this.isUserAuthenticated() ? <RaisedButton label="Log In" /> : null}*/}
            {
                this.state.registeredSuccessfully ?
                    <MainTableContainer
                        getEmployees={this.getEmployeesData}
                        employeesData={this.state.employeesData}
                    /> :
                    <div>
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

            }
          {/*<MainTableContainer*/}
              {/*employeesData={this.getEmployeesData()}*/}
          {/*/>*/}


        </div>
    </MuiThemeProvider>
    );
  }
}

export default App;
