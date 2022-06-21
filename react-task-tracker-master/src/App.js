import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
/*
<header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
*/
function App() {
  const name = 'bepbop'

  return (
    <div className="App">
      
      <h1>Hello from the other side</h1>
      <h2>ADELE {name+' '}{2+3}</h2>
      <Header title='buenas '/>
    </div>
  );
}

export default App;
