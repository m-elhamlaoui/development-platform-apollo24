import React from 'react'
import HeroSolar from './HeroSolar';
import { Hero, Navbar, Footer } from "../components";
import styles from "../style"; 

const SolarExplor = () => {
  return (
    <div className="bg-primary w-full overflow-hidden">
      <div className={`${styles.paddingX} ${styles.flexCenter}`}>
        <div className={styles.boxWidth}>
          <Navbar />
        </div>
      </div>
      <div className={`bg-primary ${styles.flexStart}`}>
        <div className={styles.boxWidth}>
          <HeroSolar />
        </div>
      </div>

    </div>
  );
}

export default SolarExplor