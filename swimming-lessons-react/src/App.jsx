//Initial Code
// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import { useEffect, useState} from 'react'
import './App.css'
import LessonList from './LessonList';
import CategoryFilter from './CategoryFilter';


function App() {
  //Initial Counter for Vite APP
  // const [count, setCount] = useState(0)
  
  //used to fetch data -> "Create a lessons state variable (initially empty) and a way to update it using setLessons."
  const [lessons, setLessons] = useState([]);

  const [categories, setCategories] = useState([]);

  const[selectedCategory, setSelectedCategory] = useState(null);

  const [searchTerm, setSearchTerm] = useState("");

  const [sortOrder, setSortOrder] = useState("asc");


  //Fetch API -> Transform the response in JSON -> Transform it to Data and applied to the lessons above in the const
  useEffect(() => {
    fetch('http://localhost:8080/api/lessons')
    .then(response => response.json())
    .then(data => setLessons(data));
   
    fetch('http://localhost:8080/api/categories')
    .then(response => response.json())
    .then(data => setCategories(data));
  }, []);


  // Search bar function
  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  }

  // Sort Dropdown
  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  }

  // Category Dropdown
  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  }

  // Filter and Sort Lessons
  const filteredLessons = lessons
    .filter(lesson => {
      return (
        (selectedCategory ? lesson.categoryId === selectedCategory : true) 
        &&
        lesson.name.toLowerCase().includes(searchTerm.toLowerCase())
      )
    })
    .sort((a, b) => {
      if(sortOrder === "asc") {
        return a.price - b.price;
      } else {
        return b.price - a.price;
      }
    });





  return (
    
    <div className='container'>
      {/* Website Title */}
      <h1 className='my-4'>Dos Santos Swimming School</h1>

      {/* functionality for filtering and sorting */}
      <div className='row align-items-center mb-4'>

        {/* Category Filter. It refes to the CategoryFilter.jsx file*/}
        <div className='col-md-3 col-sm-12 mb-2'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
        </div>

        {/* Seach Change */}
        <div className='col-md-5 col-sm-12 mb-2'>
          <input type='text' className='form-control' placeholder='Search for lessons' onChange={handleSearchChange}/>
        </div>

        {/* Sorting Dropdown */}
        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option value="asc">Sort by Price: Low to High</option>
            <option value="desc">Sort by Price: High to Low</option>
          </select>
        </div>

      </div>


      <div>
        
        {filteredLessons.length ? (
          //Display Lessons
          <LessonList lessons={filteredLessons}/>
        ) : (
          <p>No products found</p>
        )}

      </div>
    </div>
  )
};

export default App