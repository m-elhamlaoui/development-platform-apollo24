import React from 'react'
import { features } from "../constants";
import styles, { layout } from "../style";
import Button from "./Button";

const FeatureCard = ({ icon, title, content, index }) => (
  <div className={`flex flex-row p-6 rounded-[20px] ${index !== features.length - 1 ? "mb-6" : "mb-0"} feature-card`}>
    <div className="flex-1 flex flex-col">
      <h4 className="font-poppins font-semibold text-white text-[18px] leading-[23.4px] mb-1">
        {title}
      </h4>
      <p className="font-poppins font-normal text-dimWhite text-[16px] leading-[24px]">
        {content}
      </p>
    </div>
  </div>
);

const Services = () =>  (
  <section id="features" className={`${layout.section} h-screen w-screen`}>
    <div className="flex flex-col justify-around items-center">
      <div className={`${layout.sectionInfo} text-center`}>
        <h2 className={styles.heading2}>
          Check our Servises
        </h2>
      </div>

      <div className={`${layout.sectionImg} flex-row`}>
        {features.map((feature, index) => (
          <a href={feature.link} key={feature.id}>
            <FeatureCard {...feature} index={index} />
          </a>
        ))}
      </div>
    </div>
  </section>
);
export default Services;