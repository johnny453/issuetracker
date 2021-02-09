import React, { Component } from 'react'; 
import {Button, ButtonGroup, Container, Table} from 'reactstrap'; 
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import IssueService from './IssueService';

class IssueList extends Component {
    
    constructor(props) {
        super(props); 
        this.state = {issues: []}; 

        this.addIssue = this.addIssue.bind(this); 
        this.updateIssue = this.updateIssue.bind(this); 
        this.deleteIssue = this.deleteIssue.bind(this); 
    }

    addIssue() {
        this.props.history.push('/issue/add')
    }


    updateIssue(id) {

        this.props.history.push(`/issue/update/${id}`); 
    }


    deleteIssue(id) {
        IssueService.deleteIssue(id).then( Response => {
            this.setState({issues: this.state.issues.filter(issues => issues.id !== id)}); 
        }); 
    }

    componentDidMount() {
        IssueService.getAllIssues().then((Response) => {
            this.setState({ issues: Response.data}); 
        })
    }


    render() {

        const{issues, isLoading} = this.state; 

        if(isLoading) {
            return <p>Loading...</p>
        }

        const issueList = issues.map(issues => {
            const id = `${issues.id || ''}`; 
            const title = `${issues.title || ''}`; 
            const summary = `${issues.summary || ''}`; 
            const reporter = `${issues.reporter || ''}`; 
            const status = `${issues.status || ''}`; 
            const severity = `${issues.severity || ''}`; 

            return <tr key={issues.id}>
                <td>{id}</td>
                <td>{title}</td>
                <td>{summary}</td>
                <td>{reporter}</td>
                <td>{status}</td>
                <td>{severity}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" onClick={ () => this.updateIssue(issues.id)}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.deleteIssue(issues.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                    <div className="float-right">
                        <Button color = "success" tag={Link} to="/issue/add">Add Issue</Button>
                    </div>
                    <h3>Issues</h3>
                    <Table striped bordered hover same-col-widths>
                        <thread>
                            <tr>
                                <th class="col-sm-1">Id</th>
                                <th class="col-sm-2">Title</th>
                                <th class="col-sm-3">Summary</th>
                                <th class="col-sm-4">Reporter</th>
                                <th class="col-sm-5">Status</th>
                                <th class="col-sm-6">Severity</th>
                            </tr>
                        </thread>
                        <tbody>
                            {issueList}
                        </tbody>
                    </Table>
            </div>
        );
    }
}

export default IssueList; 