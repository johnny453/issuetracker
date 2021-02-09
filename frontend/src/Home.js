import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div class="d-flex justify-content-center">Welcome To Issue Tracker!</div>
                    <div class="d-flex justify-content-center"><Button color="link"><Link to="/issue/all">Click Here For Issues</Link></Button></div>                
                </Container>
            </div>
        );
    }
}
export default Home; 