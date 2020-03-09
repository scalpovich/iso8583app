import React, { Component } from 'react';
import './css/App.css';
import Home from './component/Iso8583Home';

class App extends Component {
  render() {
    return (
        <div className="container">
          <Home />
        </div>
    );
  }
}

export default App;
