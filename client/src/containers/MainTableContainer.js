import React, { Component } from 'react';
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';

class MainTableContainer extends Component {

    // constructor(props) {
    //     super(props)
    // }




    render() {

        const tableData = this.props.employeesData;
        const tableContent = tableData && tableData.map((angajat) => {
            return <TableRow>
                <TableRowColumn>{angajat.id}</TableRowColumn>
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
            <Table>
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
                <TableBody>{tableContent}</TableBody>
            </Table>
        );
    }
}

export default MainTableContainer;
