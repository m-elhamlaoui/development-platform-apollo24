// EarthExploreLayout.jsx
import React from 'react';
import Layout from './Layout';

const EarthExploreLayout = ({ children }) => {
  return (
    <Layout>
      {/* Override the header element */}
      <header className="bg-white shadow">
        <div className="container mx-auto px-6 py-4">
          <h2 className="text-3xl font-bold text-gray-800">
            Earth Explore
          </h2>
        </div>
      </header>

      {/* Render the children elements */}
      {children}

     
      
    </Layout>
  );
};

export default EarthExploreLayout;