import React from "react";

import office1 from "./office1.jpg";
import office2 from "./office2.jpg";

function App() {

  const officeList = [

    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      Image: office2
    },

    {
      Name: "Regus",
      Rent: 75000,
      Address: "Bangalore",
      Image: office1
    },

    {
      Name: "WeWork",
      Rent: 65000,
      Address: "Hyderabad",
      Image: office2
    }

  ];

  return (

    <div style={{ marginLeft: "50px" }}>

      <h1>Office Space, at Affordable Range</h1>

      {officeList.map((office, index) => (

        <div key={index}>

          <img
            src={office.Image}
            alt={office.Name}
            width="250"
            height="250"
          />

          <h2>Name: {office.Name}</h2>

          <h3
            style={{
              color:
                office.Rent <= 60000
                  ? "red"
                  : "green"
            }}
          >
            Rent Rs. {office.Rent}
          </h3>

          <h3>Address: {office.Address}</h3>

          <hr />

        </div>

      ))}

    </div>

  );

}

export default App;