
import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './Home';
import IssueList from './IssueList';
import IssueAdd from './IssueAdd';
import IssueEdit from './IssueEdit';


class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/issue/all' exact={true} component={IssueList}/>
          <Route path='/issue/add' component={IssueAdd}/>
          <Route path='/issue/update/:id' component={IssueEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;
