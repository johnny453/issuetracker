import axios from 'axios'; 

const base_url = 'http://localhost:8080/issue'

class IssueService {

    getAllIssues() {
        return axios.get(base_url + '/all'); 
    }

    addIssue(issue){
        return axios.post(base_url + '/add', issue);
    }

    updateIssue(issue, id){
        return axios.put(base_url + '/update/' + id, issue);
    }

    deleteIssue(id){
        return axios.delete(base_url + '/delete/' + id);
    }
}

export default new IssueService() 