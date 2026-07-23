// components/ListofPlayers.js

import React from "react";

function ListofPlayers({ players }) {
  return (
    <div>
      {players.map((item, index) => (
        <li key={index}>
          Mr. {item.name} {item.score}
        </li>
      ))}
    </div>
  );
}

export default ListofPlayers;