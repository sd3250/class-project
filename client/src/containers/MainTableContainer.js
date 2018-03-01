import React, { Component } from 'react';
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';

class MainTableContainer extends Component {

    // constructor(props) {
    //     super(props)
    // }




    render() {

        const tableData = this.props.employeesData;
        const tableContent = tableData.map((angajat) => {
            return <TableRow>
                <TableRowColumn>{angajat.id}</TableRowColumn>
                <TableRowColumn>{angajat.nume}</TableRowColumn>
                <TableRowColumn>{angajat.rol}</TableRowColumn>
                <TableRowColumn>{angajat.salar}</TableRowColumn>
            </TableRow>
        });

        return (
            <Table>
                <TableHeader>
                    <TableRow>
                        <TableHeaderColumn>ID</TableHeaderColumn>
                        <TableHeaderColumn>Nume</TableHeaderColumn>
                        <TableHeaderColumn>Rol</TableHeaderColumn>
                        <TableHeaderColumn>Salar</TableHeaderColumn>
                    </TableRow>
                </TableHeader>
                <TableBody>{tableContent}</TableBody>
            </Table>
        );
    }
}

export default MainTableContainer;
