// components/Scorebelow70.js

import React from "react";

function Scorebelow70({ players }) {

  const players70 = players.filter(
    player => player.score <= 70
  );

  return (
    <div>
      {players70.map((item, index) => (
        <li key={index}>
          Mr. {item.name} {item.score}
        </li>
      ))}
    </div>
  );
}

export default Scorebelow70;