import React, { Component } from 'react';
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';
import EmployeeModal from '../components/EmployeeModal';

class MainTableContainer extends Component {

    constructor(props) {
        super(props)
        this.state = {
            modalOpened: false,
            employeeId: null
        }
    }

    onCellClicked = (row, col, event) => {
        console.log(event.target.innerHTML)
        this.openEditModal(event.target.innerHTML)
    }

    openEditModal = (employeeId) => {
        this.setState({
            modalOpened: true,
            employeeId
        })
    }

    removeEmployee = () => {
        console.log('REMOVING EMPLOYEE', this.state.employeeId)
        let { employeeId } = this.state

        fetch(`api/employee/delete/${employeeId}`, {
            method: 'delete',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(res=>res.json())
            .then( res => {
                console.log(res)
                this.setState({
                    modalOpened: false
                })
                this.props.getEmployees()
            }).catch(function(err) {
            console.log(err)
        });
    }


    render() {

        const tableData = this.props.employeesData;
        const tableContent = tableData && tableData.map((angajat) => {
            return <TableRow key={angajat.id}
                             style={{paddingLeft: 20}}>
                <TableRowColumn style={{cursor: 'pointer'}}>{angajat.id}</TableRowColumn>
                <TableRowColumn>{angajat.firstName}</TableRowColumn>
                <TableRowColumn>{angajat.lastName}</TableRowColumn>
                <TableRowColumn>{angajat.birthDate}</TableRowColumn>
                <TableRowColumn>{angajat.gender}</TableRowColumn>
                <TableRowColumn>{angajat.employmentDate}</TableRowColumn>
                <TableRowColumn>{angajat.jobTitle}</TableRowColumn>
                <TableRowColumn>{angajat.salary}</TableRowColumn>
            </TableRow>
        })

        return (
            <div>
                    <EmployeeModal
                        isOpen={this.state.modalOpened}
                        removeEmployee={this.removeEmployee}
                    />
                <Table onCellClick={this.onCellClicked}
                        >
                    <TableHeader>
                        <TableRow>
                            <TableHeaderColumn>ID</TableHeaderColumn>
                            <TableHeaderColumn>firstName</TableHeaderColumn>
                            <TableHeaderColumn>lastName</TableHeaderColumn>
                            <TableHeaderColumn>birthDate</TableHeaderColumn>
                            <TableHeaderColumn>gender</TableHeaderColumn>
                            <TableHeaderColumn>employmentDate</TableHeaderColumn>
                            <TableHeaderColumn>jobTitle</TableHeaderColumn>
                            <TableHeaderColumn>salary</TableHeaderColumn>
                        </TableRow>
                    </TableHeader>
                    <TableBody displayRowCheckbox={false}>{tableContent}</TableBody>
                </Table>
            </div>
        );
    }
}

export default MainTableContainer;
