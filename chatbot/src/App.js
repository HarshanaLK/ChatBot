import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Chat from '../Pages/chat';


function App() {
  return (
    <div className="App">
        <Router>
          <Routes>
            <Route path="/" element= {<Chat/>} ></Route>
          </Routes>
          
        </Router>
    </div>
  );
}

export default App;
