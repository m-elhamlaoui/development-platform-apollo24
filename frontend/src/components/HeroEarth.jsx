import styles from "../style";
import { discount, robot, astronomy } from "../assets";

import { useState, Suspense } from "react";
import { Canvas } from "@react-three/fiber";
import { Environment, OrbitControls,Stars } from '@react-three/drei';
import Earth from '../../public/earth/Earth';

const HeroEarth = () => {
  return (
    <section id="home" className={`flex md:flex-row flex-col ${styles.paddingY}`} style={{backgroundSize:'cover', backgroundPosition: 'center'}}>
      <>
        <Canvas>
            <color attach='background' args={["black"]}/>
            <ambientLight intensity={0.6}/>
            <OrbitControls enableZoom={false}/>
            <Stars/>
            <Suspense fallback={null}>
                <Earth />
            </Suspense>
            <Environment preset='sunset' />
        </Canvas>
        </>
    </section>
  );
};

export default HeroEarth;