import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';
import IssueService from './IssueService'; 

class IssueEdit extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id, 
            title: '',
            summary: '',
            reporter: '',
            status: '',
            severity: ''  
        }

        this.title = this.title.bind(this); 
        this.summary = this.summary.bind(this); 
        this.reporter = this.reporter.bind(this); 
        this.status = this.status.bind(this); 
        this.severity = this.severity.bind(this); 
    }

    componentDidMount() {

        IssueService.updateIssue(this.state).then((Response) => {
            let issue = Response.data; 
            this.setState({title: issue.title, 
                summary: issue.summary,
                reporter: issue.reporter,
                status: issue.status, 
                severity: issue.severity})
        })
    }

    updateIssue = (event) => {
        event.preventDefault(); 
        let issue = {title: this.state.title, 
            summary: this.state.summary, 
            reporter: this.state.reporter, 
            status: this.state.status,
            severity: this.state.severity
        }; 
        console.log('issue => ' + JSON.stringify(issue))

        IssueService.updateIssue(issue, this.state.id).then(Response => {
            this.props.history.push('/issue/all'); 
        })
    }

    title= (event) => {
        this.setState({title: event.target.value});
    }

    summary= (event) => {
        this.setState({summary: event.target.value});
    }
    reporter= (event) => {
        this.setState({reporter: event.target.value});
    }
    status= (event) => {
        this.setState({status: event.target.value});
    }
    severity= (event) => {
        this.setState({severity: event.target.value});
    }
    render() {

        return <div>
            <AppNavbar/>
            <Container>
            <h2>{'Edit Issues'}</h2>
                <Form onSubmit={this.updateIssue}>
                    <FormGroup>
                        <Label for="title">Title</Label>
                        <input type="text" name="title" id="title" value={this.state.title}
                                onChange={this.title} autoComplete="title"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="summary">Summary</Label>
                        <input type="text" name="summary" id="summary" value={this.state.summary}
                                onChange={this.summary} autoComplete="summary"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="reporter">Reporter</Label>
                        <input type="text" name="reporter" id="reporter" value={this.state.reporter}
                                onChange={this.reporter} autoComplete="reporter"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="status">Status</Label>
                        <input type="text" name="status" id="status" value={this.state.status}
                                onChange={this.status} autoComplete="status"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="severity">Severity</Label>
                        <input type="text" name="severity" id="severity" value={this.state.severity}
                                onChange={this.severity} autoComplete="severity"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/issue/all">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
    
}

export default withRouter(IssueEdit); 