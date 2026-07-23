import React from "react";

import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";

function App(){

let show=true;

return(

<div
style={{
display:"flex",
justifyContent:"space-around"
}}
>

{

show ?

<>

<CourseDetails/>

<BookDetails/>

<BlogDetails/>

</>

:

<h1>No Data Available</h1>

}

</div>

);

}

export default App;