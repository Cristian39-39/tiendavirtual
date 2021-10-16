import './App.css';
import React, { useEffect } from "react";
import { BrowserRouter, Route } from "react-router-dom";
import Login from './componets/login/Login.js'
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Route exact path="/" component={Login} />
      </BrowserRouter>
    </div>
  );
}

export default App;
