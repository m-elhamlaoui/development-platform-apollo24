import React from 'react'
import Button from './Button'
import { facebook, logo1,google,github } from '../assets'


const Register = () => {
    return (
    <div class="bg-primary w-screen h-screen flex justify-center items-center overflow-scroll">
      <div class="flex-col justify-center">
        <div>
          <img src={logo1} alt="hoobank"/>
          <h1 class="text-white text-lg text-center mb-5 font-poppins font-bold">Register</h1>
        </div>
      <div class="bg-third rounded-md border-[1px] border-gray-600 w-[300px]">
        <div class="p-5">
          <label class="text-white font-poppins">Email</label><br></br>
          <input type="text" class="bg-primary rounded-md mt-2 border-gray-600 border-[1px] w-full text-white"></input>
        </div>
        <div class="p-5">
          <label class="text-white font-poppins">Password</label><br></br>
          <input type="text" class="bg-primary rounded-md border-gray-600 border-[1px] mt-2 w-full text-white"></input>
        </div>
        <div class="p-5 flex justify-center items-center w-full">
          <Button text="Register"></Button>
        </div>
        </div>
      <div>
      <div class="icon-container rounded-md border-gray-600 border-[1px] mt-5 p-5 flex justify-around">
        <a href="#">
          <img src={facebook} alt="Facebook icon"/>
        </a>
        <a href="#">
          <img src={google} alt="Google icon"/>
        </a>
        <a href="#">
          <img src={github} alt="GitHub icon"/>
        </a>
      </div>
      </div>
      </div>
    </div>
  )
}

export default Register