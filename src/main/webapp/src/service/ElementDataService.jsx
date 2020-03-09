import axios from 'axios'

const DEFAULT_URL = 'http://localhost:8080'

class ElementDataService {

    retrieveAllElements(name) {
        return axios.get(`${DEFAULT_URL}/iso8583`);
    }
}

export default new ElementDataService()