// EarthExplore.jsx
import React from 'react';
import styles from "../style"; 
import { Hero, Navbar, Footer } from "../components";
import Services from "../components/Services";
import HeroEarth from './HeroEarth';

const EarthExplore = () => {
  return (
    <div className="bg-primary w-full overflow-hidden">
      <div className={`${styles.paddingX} ${styles.flexCenter}`}>
        <div className={styles.boxWidth}>
          <Navbar />
        </div>
      </div>
      <div className={`bg-primary ${styles.flexStart}`}>
        <div className={styles.boxWidth}>
          <HeroEarth />
        </div>
      </div>
    </div>
  );
}

export default EarthExplore;
