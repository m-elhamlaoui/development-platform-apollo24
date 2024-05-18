/*
Auto-generated by: https://github.com/pmndrs/gltfjsx
Command: npx gltfjsx@6.2.16 solar_system.gltf 
Author: Samer_Arab_S5 (https://sketchfab.com/Samer_Arab_S5)
License: CC-BY-4.0 (http://creativecommons.org/licenses/by/4.0/)
Source: https://sketchfab.com/3d-models/solar-system-animation-b7c69a6b655b47c99f871d5ec5aee854
Title: Solar System animation
*/

import React, { useRef, useState } from 'react'
import { useGLTF, useAnimations } from '@react-three/drei'
import { useEffect } from 'react'
import {gsap} from 'gsap'
import { useThree, useFrame } from '@react-three/fiber'
import * as THREE from 'three'; // Import THREE
import { OrbitControls } from 'three/examples/jsm/controls/OrbitControls';

export default function Model(props) {
  const group = useRef();
  const { nodes, materials, animations } = useGLTF('./solar_system/solar_system.gltf');
  const { actions, names } = useAnimations(animations, group);
  const [hoveredPlanet, setHoveredPlanet] = useState(null);
  const { camera, gl } = useThree();
  const controls = useRef(new OrbitControls(camera, gl.domElement));

  useEffect(() => {
    controls.current = new OrbitControls(camera, gl.domElement);
    controls.current.enableDamping = true;
    controls.current.dampingFactor = 0.25;
    controls.current.enableZoom = true;

    actions[names[0]].reset().play();

    return () => {
      controls.current.dispose();
    };
  }, [actions, names, camera, gl]);

  useFrame(() => {
    controls.current.update();
  });

  const handlePointerOver = (e, planet) => {
    e.stopPropagation();
    setHoveredPlanet(planet);
  };

  const handlePointerOut = (e) => {
    e.stopPropagation();
    setHoveredPlanet(null);
  };

  const handlePlanetClick = (e, planetName) => {
    if (!controls.current) {
      console.error("OrbitControls not initialized");
      return;
    }

    // Get the clicked planet object
    const planet = e.object.parent;

    // Create a function to update the camera position and target
    const updateCamera = () => {
        const planetPosition = planet.getWorldPosition(new THREE.Vector3());
        const newCameraPosition = planetPosition.clone().add(new THREE.Vector3(0, 0, 50));

        // Log the position of the clicked planet
        console.log(`Position of ${planetName}: `, planetPosition);

        // Update the camera position
        gsap.to(camera.position, {
            x: newCameraPosition.x,
            y: newCameraPosition.y,
            z: newCameraPosition.z,
            duration: 1,
            onUpdate: () => controls.current.update()
        });

        // Update the camera target
        gsap.to(controls.current.target, {
            x: planetPosition.x,
            y: planetPosition.y,
            z: planetPosition.z,
            duration: 1,
            onUpdate: () => controls.current.update()
        });
    };

    // Call the update function immediately
    updateCamera();

    // Call the update function continuously to track the planet's position
    const intervalId = setInterval(updateCamera, 100); // Adjust the interval as needed

    // Stop tracking when the mouse is released
    window.addEventListener("mouseup", () => {
        clearInterval(intervalId);
    }, { once: true });
};


  return (
    <group ref={group} {...props} dispose={null}>
      <group name="Sketchfab_Scene">
        <group name="Sketchfab_model" rotation={[-Math.PI / 2, 0, 0]}>
          <group name="root">
            <group name="GLTF_SceneRootNode" rotation={[Math.PI / 2, 0, 0]}>

              <group
                name="mercury_BezierCircle_4"
                scale={9.695}
                onPointerOver={(e) => handlePointerOver(e, 'mercury')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'mercury')}
              >
                <group name="mercury_2" position={[0, 0, 1]} rotation={[1.739, -0.875, 1.237]} scale={hoveredPlanet === 'mercury' ? 0.05 : 0.038}>
                  <mesh name="Object_5" geometry={nodes.Object_5.geometry} material={materials.mercury} />
                </group>
              </group>

              <group
                name="venus_BezierCircle_7"
                rotation={[0, 0.028, 0]}
                scale={12.235}
                onPointerOver={(e) => handlePointerOver(e, 'venus')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'venus')}
              >
                <group name="venus_5" position={[0, 0, 1]} rotation={[0, 0, Math.PI / 2]} scale={hoveredPlanet === 'venus' ? 0.12 : 0.102}>
                  <mesh name="Object_8" geometry={nodes.Object_8.geometry} material={materials.venus} />
                </group>
              </group>

              <group
                name="erath_BezierCircle_11"
                scale={16.115}
                onPointerOver={(e) => handlePointerOver(e, 'earth')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'earth')}
              >
                <group name="erath_8" position={[0, 0, 1]} rotation={[0.819, 0, 0]} scale={hoveredPlanet === 'earth' ? 0.072 : 0.062}>
                  <mesh name="Object_11" geometry={nodes.Object_11.geometry} material={materials.earth} />
                </group>
              </group>

              <group
                name="mars_BezierCircle_14"
                scale={20.451}
                onPointerOver={(e) => handlePointerOver(e, 'mars')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'mars')}
              >
                <group name="mars_12" position={[0, 0, 1]} rotation={[0, 0, Math.PI / 2]} scale={hoveredPlanet === 'mars' ? 0.035 : 0.025}>
                  <mesh name="Object_14" geometry={nodes.Object_14.geometry} material={materials.mars} />
                </group>
              </group>

              <group
                name="jupiter_BezierCircle_17"
                scale={28.775}
                onPointerOver={(e) => handlePointerOver(e, 'jupiter')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'jupiter')}
              >
                <group name="jupiter_15" position={[0, 0, 1]} scale={hoveredPlanet === 'jupiter' ? 0.105 : 0.095}>
                  <mesh name="Object_17" geometry={nodes.Object_17.geometry} material={materials.jupiter} />
                </group>
              </group>

              <group
                name="saturn_BezierCircle_21"
                scale={36.61}
                onPointerOver={(e) => handlePointerOver(e, 'saturn')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'saturn')}
              >
                <group name="saturn_19" position={[0, 0, 1]} scale={hoveredPlanet === 'saturn' ? 0.069 : 0.059}>
                  <group name="saturn_ring_18" position={[0.01, -0.067, 0]} rotation={[0, 0, 0.351]} scale={1.739}>
                    <mesh name="Object_22" geometry={nodes.Object_22.geometry} material={materials.saturn_ring} />
                  </group>
                  <mesh name="Object_20" geometry={nodes.Object_20.geometry} material={materials.saturn} />
                </group>
              </group>

              <group
                name="uranus_BezierCircle_24"
                scale={44.26}
                onPointerOver={(e) => handlePointerOver(e, 'uranus')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'uranus')}
              >
                <group name="uranus_22" position={[0, 0, 1]} rotation={[0, 0, Math.PI / 2]} scale={hoveredPlanet === 'uranus' ? 0.03 : 0.02}>
                  <mesh name="Object_25" geometry={nodes.Object_25.geometry} material={materials.uranus} />
                </group>
              </group>

              <group
                name="neptune_BezierCircle_27"
                scale={49.927}
                onPointerOver={(e) => handlePointerOver(e, 'neptune')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'neptune')}
              >
                <group name="neptune_25" position={[0, 0, 1]} rotation={[0, 0, Math.PI / 2]} scale={hoveredPlanet === 'neptune' ? 0.034 : 0.024}>
                  <mesh name="Object_28" geometry={nodes.Object_28.geometry} material={materials.neptune} />
                </group>
              </group>

              <group
                name="pluto_BezierCircle_30"
                scale={54.22}
                onPointerOver={(e) => handlePointerOver(e, 'pluto')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'pluto')}
              >
                <group name="pluto_28" position={[0, 0, 1]} rotation={[0, 0, Math.PI / 2]} scale={hoveredPlanet === 'pluto' ? 0.014 : 0.004}>
                  <mesh name="Object_31" geometry={nodes.Object_31.geometry} material={materials.pluto} />
                </group>
              </group>

              <group
                name="moon_BezierCircle_33"
                position={[0, 6.426, 14.778]}
                scale={-1.879}
                onPointerOver={(e) => handlePointerOver(e, 'moon')}
                onPointerOut={handlePointerOut}
                onClick={(e) => handlePlanetClick(e, 'moon')}
              >
                <group name="moon_31" position={[0, 0, 1]} rotation={[-0.023, 0, Math.PI / 2]} scale={hoveredPlanet === 'moon' ? 0.106 : 0.096}>
                  <mesh name="Object_34" geometry={nodes.Object_34.geometry} material={materials.moon} />
                </group>
              </group>
              
              <group name="mercury_BezierCircle001_34" scale={9.695}>
                <mesh name="Object_36" geometry={nodes.Object_36.geometry} material={materials.Material} />
              </group>
              <group name="venus_BezierCircle001_35" rotation={[0, 0.028, 0]} scale={12.235}>
                <mesh name="Object_38" geometry={nodes.Object_38.geometry} material={materials.Material} />
              </group>
              <group name="erath_BezierCircle001_36" scale={16.115}>
                <mesh name="Object_40" geometry={nodes.Object_40.geometry} material={materials.Material} />
              </group>
              <group name="mars_BezierCircle001_37" scale={20.451}>
                <mesh name="Object_42" geometry={nodes.Object_42.geometry} material={materials.Material} />
              </group>
              <group name="jupiter_BezierCircle001_38" scale={28.775}>
                <mesh name="Object_44" geometry={nodes.Object_44.geometry} material={materials.Material} />
              </group>
              <group name="saturn_BezierCircle001_39" scale={36.61}>
                <mesh name="Object_46" geometry={nodes.Object_46.geometry} material={materials.Material} />
              </group>
              <group name="uranus_BezierCircle001_40" scale={44.26}>
                <mesh name="Object_48" geometry={nodes.Object_48.geometry} material={materials.Material} />
              </group>
              <group name="neptune_BezierCircle001_41" scale={49.927}>
                <mesh name="Object_50" geometry={nodes.Object_50.geometry} material={materials.Material} />
              </group>
              <group name="pluto_BezierCircle001_42" scale={54.22}>
                <mesh name="Object_52" geometry={nodes.Object_52.geometry} material={materials.Material} />
              </group>
              <group name="moon_BezierCircle001_43" position={[0, 6.426, 14.778]} scale={-1.879}>
                <mesh name="Object_54" geometry={nodes.Object_54.geometry} material={materials.Material} />
              </group>
              <group name="sun_53" scale={5.997}>
                <mesh name="Object_56" geometry={nodes.Object_56.geometry} material={materials.material} />
              </group>
            </group>
          </group>
        </group>
      </group>
    </group>
  )
}

useGLTF.preload('/solar_system.gltf')
