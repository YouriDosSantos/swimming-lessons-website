//package com.ecom.swimminglessons.config;
//
//import com.ecom.swimminglessons.model.Category;
//import com.ecom.swimminglessons.model.Lesson;
//import com.ecom.swimminglessons.repository.CategoryRepository;
//import com.ecom.swimminglessons.repository.LessonRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//
//@Component //spring component
//public class DataSeeder implements CommandLineRunner { //used to seed data at website load
//
//    private final LessonRepository lessonRepository;
//    private final CategoryRepository categoryRepository;
//
//    public DataSeeder(LessonRepository lessonRepository, CategoryRepository categoryRepository) {
//        this.lessonRepository = lessonRepository;
//        this.categoryRepository = categoryRepository;
//    }
//
//    //run method will be executed when application starts
//    @Override
//    public void run(String... args) throws Exception {
//
//        //clear all data at app start
//        lessonRepository.deleteAll();
//        categoryRepository.deleteAll();
//
//        //Create Categories
//        Category privateLesson = new Category();
//        privateLesson.setName("Private Lesson");
//
//        Category infantSwimming = new Category();
//        infantSwimming.setName("Infant Swimming");
//
//        Category smallGroup = new Category();
//        smallGroup.setName("Small Group");
//
//        Category collegePrep = new Category();
//        collegePrep.setName("College Prep");
//
//        Category coachingPrep = new Category();
//        coachingPrep.setName("Coaching Prep");
//
//        //We work with database through repositories
//        categoryRepository.saveAll(Arrays.asList(privateLesson, smallGroup, infantSwimming, collegePrep, coachingPrep));
//
//        //for the imageURL, companies normally keep the images somewhere and the URL and plugged in here
//
//        //Create Products/Lessons
//        Lesson privateLesson1 = new Lesson();
//        privateLesson1.setName("Private Lesson");
//        privateLesson1.setDescription("Private Lesson for Kids who Prioritize 1-1 Coaching");
//        privateLesson1.setImageUrl("https://placehold.co/600x400");
//        privateLesson1.setPrice(50);
//        privateLesson1.setCategory(privateLesson);
//        privateLesson1.setDuration(40);
//
//        Lesson adaptiveSwimming1 = new Lesson();
//        adaptiveSwimming1.setName("Adaptive Swimming");
//        adaptiveSwimming1.setDescription("Adaptive Swimming Lessons to Kids");
//        adaptiveSwimming1.setImageUrl("https://placehold.co/600x400");
//        adaptiveSwimming1.setPrice(70);
//        adaptiveSwimming1.setCategory(privateLesson);
//        adaptiveSwimming1.setDuration(30);
//
//        Lesson infantSwimming1 = new Lesson();
//        infantSwimming1.setName("Infant Swimming Resource");
//        infantSwimming1.setDescription("Infant Swimming Resource Class");
//        infantSwimming1.setImageUrl("https://placehold.co/600x400");
//        infantSwimming1.setPrice(50);
//        infantSwimming1.setCategory(infantSwimming);
//        infantSwimming1.setDuration(10);
//
//
//        //set up Packages for multiple classes
//        Lesson smallerGroup3 = new Lesson();
//        smallerGroup3.setName("Smaller Group");
//        smallerGroup3.setDescription("Small Group Lesson for a Small Group of up to 3 Kids");
//        smallerGroup3.setImageUrl("https://placehold.co/600x400");
//        smallerGroup3.setPrice(40);
//        smallerGroup3.setCategory(smallGroup);
//        smallerGroup3.setDuration(30);
//
//        Lesson smallGroup6 = new Lesson();
//        smallGroup6.setName("Small Group");
//        smallGroup6.setDescription("Small Group Lesson for a Small Group of up to 6 Kids");
//        smallGroup6.setImageUrl("https://placehold.co/600x400");
//        smallGroup6.setPrice(30);
//        smallGroup6.setCategory(smallGroup);
//        smallGroup6.setDuration(30);
//
//        //set up packages for College Prep Bundles
//        Lesson collegePrepSwimming1 = new Lesson();
//        collegePrepSwimming1.setName("College Prep");
//        collegePrepSwimming1.setDescription("High Performance College Prep Swimming Lessons for High School Students");
//        collegePrepSwimming1.setImageUrl("https://placehold.co/600x400");
//        collegePrepSwimming1.setPrice(1000);
//        collegePrepSwimming1.setCategory(collegePrep);
//        collegePrepSwimming1.setDuration(60);
//
//        Lesson nutritionProgram1 = new Lesson();
//        nutritionProgram1.setName("Nutrition Program");
//        nutritionProgram1.setDescription("Nutrition Program");
//        nutritionProgram1.setImageUrl("https://placehold.co/600x400");
//        nutritionProgram1.setPrice(500);
//        nutritionProgram1.setCategory(collegePrep);
//        nutritionProgram1.setDuration(30);
//
//        Lesson recruitmentAssistance1 = new Lesson();
//        recruitmentAssistance1.setName("College Recruitment Assistance");
//        recruitmentAssistance1.setDescription("Assistance with the Recruitment Process to Swim in College");
//        recruitmentAssistance1.setImageUrl("https://placehold.co/600x400");
//        recruitmentAssistance1.setPrice(500);
//        recruitmentAssistance1.setCategory(collegePrep);
//        recruitmentAssistance1.setDuration(60);
//
//        Lesson drySwimmingAssistance1 = new Lesson();
//        drySwimmingAssistance1.setName("Dry Swimming Assistance");
//        drySwimmingAssistance1.setDescription("Dry Swimming Assistance is Assistance with Workouts out of the Water");
//        drySwimmingAssistance1.setImageUrl("https://placehold.co/600x400");
//        drySwimmingAssistance1.setPrice(500);
//        drySwimmingAssistance1.setCategory(collegePrep);
//        drySwimmingAssistance1.setDuration(60);
//
//        //set up packages for Coaching Lessons
//        Lesson coachingInfant = new Lesson();
//        coachingInfant.setName("Coaching Infant");
//        coachingInfant.setDescription("Coaching Prep for Infant Swimming Lessons");
//        coachingInfant.setImageUrl("https://placehold.co/600x400");
//        coachingInfant.setPrice(50);
//        coachingInfant.setCategory(coachingPrep);
//        coachingInfant.setDuration(10);
//
//        Lesson coachingKids = new Lesson();
//        coachingKids.setName("Coaching Kids");
//        coachingKids.setDescription("Coaching Prep for Kids Swimming Lessons");
//        coachingKids.setImageUrl("https://placehold.co/600x400");
//        coachingKids.setPrice(30);
//        coachingKids.setCategory(coachingPrep);
//        coachingKids.setDuration(30);
//
//        Lesson coachingHighSchool = new Lesson();
//        coachingHighSchool.setName("Coaching High School Age Kids");
//        coachingHighSchool.setDescription("Coaching Prep for High School Swimming Lessons");
//        coachingHighSchool.setImageUrl("https://placehold.co/600x400");
//        coachingHighSchool.setPrice(50);
//        coachingHighSchool.setCategory(coachingPrep);
//        coachingHighSchool.setDuration(60);
//
//        //save products
//        lessonRepository.saveAll(Arrays.asList(privateLesson1, adaptiveSwimming1, infantSwimming1, smallerGroup3, smallGroup6, collegePrepSwimming1, nutritionProgram1, recruitmentAssistance1, drySwimmingAssistance1, coachingInfant, coachingKids, coachingHighSchool));
//    }
//}
