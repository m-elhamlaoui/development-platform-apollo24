import React from 'react';
import styles from '../style';
import { Hero,Navbar,Footer} from '../components';
import Services from '../components/Services';
import { BrowserRouter, createBrowserRouter, RouterProvider, Link, Route, Routes} from 'react-router-dom';
import Login from '../components/Login';
const News = () => {
  return (
    <div className="bg-primary w-full overflow-scroll">
      <div className={`${styles.paddingX} ${styles.flexCenter}`}>
        <div className={`${styles.boxWidth}`}>
            <Navbar/>
        </div>
      </div>
    <h1 className='text-white text-center font-poppins font-semibold text-5xl mt-10'>LAUNCHES</h1>
      <div className="h-full w-screen">
        <div className='w-full inline-flex flex-nowrap overflow-hidden [mask-image:_linear-gradient(to_right,transparent_0,_black_128px,_black_calc(100%-128px),transparent_100%)]"'>
          <div className='bg-third w-full flex items-center justify-center md:justify-start [&_li]:mx-8 [&_img]:max-w-none animate-infinite-scroll'>

              <div className="border-gray-600 border-[1px] rounded-md h-[500px] w-[250px] md:w-[30%] lg:w-[25%] xl:w-[20%] bg-[#191D27] flex flex-col justify-between relative m-4 animate-infinite-scrol">
                <div className="w-full h-[70%] flex items-center">
                  <img className="w-full h-full object-cover" src="https://images2.pics4learning.com/catalog/2/2011-08-0614.54.07.jpg" alt="" />        
                </div>
                <div className=''>
                  <button className="bg-[#00040f] text-white border-blue-500 border-[2px] rounded-md p-2 bottom-0 right-0 m-4 absolute hover:bg-blue-500 font-bold">Subscribe</button>
                </div>
              </div>
              <div className="border-gray-600 border-[1px] rounded-md h-[500px] w-[250px] md:w-[30%] lg:w-[25%] xl:w-[20%] bg-[#191D27] flex flex-col justify-between relative m-4">
                <div className="w-full h-[70%] flex items-center">
                  <img className="w-full h-full object-cover" src="https://images2.pics4learning.com/catalog/2/2011-08-0614.54.07.jpg" alt="" />        
                </div>
                <div className=''>
                  <button className="bg-[#00040f] text-white border-blue-500 border-[2px] rounded-md p-2 bottom-0 right-0 m-4 absolute hover:bg-blue-500 font-bold">Subscribe</button>
                </div>
              </div>
              <div className="border-gray-600 border-[1px] rounded-md h-[500px] w-[250px] md:w-[30%] lg:w-[25%] xl:w-[20%] bg-[#191D27] flex flex-col justify-between relative m-4">
                <div className="w-full h-[70%] flex items-center">
                  <img className="w-full h-full object-cover" src="https://images2.pics4learning.com/catalog/2/2011-08-0614.54.07.jpg" alt="" />        
                </div>
                <div className=''>
                  <button className="bg-[#00040f] text-white border-blue-500 border-[2px] rounded-md p-2 bottom-0 right-0 m-4 absolute hover:bg-blue-500 font-bold">Subscribe</button>
                </div>
              </div>
              <div className="border-gray-600 border-[1px] rounded-md h-[500px] w-[250px] md:w-[30%] lg:w-[25%] xl:w-[20%] bg-[#191D27] flex flex-col justify-between relative m-4">
                <div className="w-full h-[70%] flex items-center">
                  <img className="w-full h-full object-cover" src="https://images2.pics4learning.com/catalog/2/2011-08-0614.54.07.jpg" alt="" />        
                </div>
                <div className=''>
                  <button className="bg-[#00040f] text-white border-blue-500 border-[2px] rounded-md p-2 bottom-0 right-0 m-4 absolute hover:bg-blue-500 font-bold">Subscribe</button>
                </div>
              </div>
                            <div className="border-gray-600 border-[1px] rounded-md h-[500px] w-[250px] md:w-[30%] lg:w-[25%] xl:w-[20%] bg-[#191D27] flex flex-col justify-between relative m-4">
                <div className="w-full h-[70%] flex items-center">
                  <img className="w-full h-full object-cover" src="https://images2.pics4learning.com/catalog/2/2011-08-0614.54.07.jpg" alt="" />        
                </div>
                <div className=''>
                  <button className="bg-[#00040f] text-white border-blue-500 border-[2px] rounded-md p-2 bottom-0 right-0 m-4 absolute hover:bg-blue-500 font-bold">Subscribe</button>
                </div>
              </div>
              
        </div>
      </div>
      </div>

      <h1 className='text-white text-center font-poppins font-semibold text-5xl mt-10'>NEWS & EVENTS</h1>
        <div className={`bg-primary ${styles.flexStart} h-screen w-screen`}>
          <div className="bg-[#00040f] h-screen w-screen flex flex-wrap justify-around items-center">
            <div className="border-gray-600 border-[1px] rounded-md h-[500px] w-[250px] md:w-[30%] lg:w-[25%] xl:w-[20%] bg-[#191D27] flex flex-col justify-between relative m-4">
              <div className="w-full h-[70%] flex items-center">
                <img className="w-full h-full object-cover" src="https://images2.pics4learning.com/catalog/2/2011-08-0614.54.07.jpg" alt="" />        
              </div>
              <div className=''>
                <button className="bg-[#00040f] text-white border-blue-500 border-[2px] rounded-md p-2 bottom-0 right-0 m-4 absolute hover:bg-blue-500 font-bold">Subscribe</button>
              </div>
            </div>
            <div className="border-gray-600 border-[1px] rounded-md h-[500px] w-[250px] md:w-[30%] lg:w-[25%] xl:w-[20%] bg-[#191D27] flex flex-col justify-between relative m-4">
              <div className="w-full h-[70%] flex items-center">
                <img className="w-full h-full object-cover" src="https://images2.pics4learning.com/catalog/2/2011-08-0614.54.07.jpg" alt="" />        
              </div>
                <button className="bg-[#00040f] text-white border-blue-500 border-[2px] rounded-md p-2 absolute bottom-0 right-0 m-4 hover:bg-blue-500 font-bold">Subscribe</button>
            </div>
            <div className="border-gray-600 border-[1px] rounded-md h-[500px] w-[250px] md:w-[30%] lg:w-[25%] xl:w-[20%] bg-[#191D27] flex flex-col justify-between relative m-4">
              <div className="w-full h-[70%] flex items-center">
                 <img className="w-full h-full object-cover" src="https://images2.pics4learning.com/catalog/2/2011-08-0614.54.07.jpg" alt="" />        
              </div>
                <button className="bg-[#00040f] text-white border-blue-500 border-[2px] rounded-md p-2 absolute bottom-0 right-0 m-4 hover:bg-blue-500 font-bold">Subscribe</button>
            </div>
          </div>
        </div>
      </div>
  )
}

export default News