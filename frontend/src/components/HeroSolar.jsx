import styles from "../style";
import { discount, robot, astronomy } from "../assets";

import { useState, Suspense, useEffect } from "react";
import { Canvas } from "@react-three/fiber";
import { Environment, OrbitControls,Stars } from '@react-three/drei';
import Solar_system from '../../public/solar_system/Solar_system';


const HeroSolar = () => {
  const [hovered, hover] = useState(false)

  useEffect(()=>{
    document.body.style.cursor = hovered ? 'pointer' : 'auto'
  }, [hovered])

  return (
    <section id="home" className={`flex md:flex-row flex-col ${styles.paddingY}`} style={{backgroundSize:'cover', backgroundPosition: 'center'}}>
      <>
        <Canvas>
            <color attach='background' args={["black"]}/>
            <ambientLight intensity={0.6}/>
            <OrbitControls enableZoom={true} />
            <Stars/>
            <Suspense fallback={null}>
                <Solar_system/>
            </Suspense>
            <Environment preset='sunset' />
        </Canvas>
        </>
    </section>
  );
};

export default HeroSolar