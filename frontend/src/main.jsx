import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import { BrowserRouter, Route, Router,Routes } from 'react-router-dom'
import Login from './components/Login.jsx'
import Register from './components/Register.jsx'
import EarthExplore from './components/EarthExplore.jsx';
import SolarExplor from './components/SolarExplor.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
    <Routes>
      <Route path='/' element={<App/>}></Route>
      <Route path='/login' element={<Login/>}></Route>
      <Route path='/register' element={<Register/>}></Route>
      <Route path='/EarthExplore' element={<EarthExplore/>}></Route>
      <Route path='/SolarExplore' element={<SolarExplor/>}></Route>
    </Routes>
    </BrowserRouter>
  </React.StrictMode>,

)