//lessons is a prop: This means LessonList expects to receive an array of lesson objects from its parent component (like App)
const LessonList = ({lessons}) => {
   
    //Bootstrap Class (row): This sets up a responsive grid layout (assuming you're using Bootstrap).
    return (
        <div className="row">
            {/* What it does: Loops through the lessons array and renders a "card" for each lesson. */}
            {lessons.map(lesson => (
                // number of cards per row based on size of the screen
                <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={lesson.id}>
                    {/* h-100: Makes all cards the same height, which improves UI consistency. */}
                    <div className="card h-100">
                        {/* gets image from lesson / Data Seeder but if it does not, it has a fallback image. alt tag for accessibility */}
                        <img src={lesson.imageUrl || 'https://placehold.com/600x400'} className="card-img-top" alt={lesson.name}/>

                            <div className="card-body">
                                <h5 className="card-title">{lesson.name}</h5>
                                <p className="card-text">{lesson.description}</p>
                                <p className="card-text"><strong>${lesson.price}</strong></p>
                                
                            </div>
                    </div>

                </div>
            ))}

        </div>
    )
}
//allows other files (Like app.jsx) to import and use LessonList
export default LessonList;