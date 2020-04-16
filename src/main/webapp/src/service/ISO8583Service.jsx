import axios from 'axios'

const DEFAULT_URL = 'http://localhost:8080'

class ISO8583Service {

    createISO8583(iso8583) {
        return axios.post(`${DEFAULT_URL}/createISO8583`,iso8583);
    }
}

export default new ISO8583Service()