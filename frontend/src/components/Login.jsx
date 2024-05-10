import React, {useState} from 'react'
import Button from './Button'
import { logo1 } from '../assets'


const Login = () => {
  return (
    <div class="bg-primary w-screen h-screen flex justify-center items-center overflow-scroll">
      <div class="flex-col justify-center">
        <div>
          <img src={logo1} alt="hoobank"/>
          <h1 class="text-white text-lg text-center mb-5 font-poppins font-bold">Sign in to SpaceExp</h1>
        </div>
      <div class="bg-third rounded-md border-[1px] border-gray-600 w-[300px]">
        <div class="p-5">
          <label class="text-white font-poppins">Email</label><br></br>
          <input type="text" class="bg-primary rounded-md mt-2 border-gray-600 border-[1px] w-full text-white"></input>
        </div>
        <div class="p-5">
          <label class="text-white font-poppins">Password</label><br></br>
          <input type="password" class="bg-primary rounded-md border-gray-600 border-[1px] mt-2 w-full text-white"></input>
        </div>
        <div class="p-5 flex justify-center items-center w-full">
          <Button text="Sign in"></Button>
        </div>
        </div>
      <div>
        <div class="rounded-md border-gray-600 border-[1px] mt-5 p-5">
            <span className='text-white'>New to the app? <a className='text-white hover:text-blue-500' href="/register">Create an account</a></span>
        </div>
      </div>
      </div>
    </div>
  )
}

export default Login