import "./App.css";
import CohortDetails from "./components/CohortDetails";

function App() {

  const cohorts = [

    {
      name: "INTADMDF10 - .NET FSD",
      startedOn: "22-Feb-2022",
      status: "Scheduled",
      coach: "Ashwin",
      trainer: "Jojo Jose"
    },

    {
      name: "ADM21JF014 - Java FSD",
      startedOn: "10-Sep-2021",
      status: "Ongoing",
      coach: "Apoorv",
      trainer: "Elisa Smith"
    },

    {
      name: "CDBJF21035 - Java FSD",
      startedOn: "24-Dec-2021",
      status: "Ongoing",
      coach: "Aarthna",
      trainer: "John Doe"
    }

  ];

  return (

    <div className="App">

      <h1>Cohorts Details</h1>

      {
        cohorts.map((cohort, index) => (

          <CohortDetails

            key={index}

            name={cohort.name}
            startedOn={cohort.startedOn}
            status={cohort.status}
            coach={cohort.coach}
            trainer={cohort.trainer}

          />

        ))
      }

    </div>

  );

}

export default App;