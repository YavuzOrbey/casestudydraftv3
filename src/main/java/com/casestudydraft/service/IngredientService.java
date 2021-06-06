package com.casestudydraft.service;

import com.casestudydraft.dao.IngredientDAO;
import com.casestudydraft.dao.IngredientDAOImpl;
import com.casestudydraft.dao.MeasurementDAOImpl;
import com.casestudydraft.model.Ingredient;
import com.casestudydraft.model.Measurement;
import com.casestudydraft.model.Nutrient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
@Service
public class IngredientService extends GenericService<Ingredient, IngredientDAOImpl> {
    @Autowired NutrientService nutrientService;
    public Ingredient findById(int id) {
        return dao.findById(id);
    }


    public List<Ingredient> findAll() {
        return dao.findAll();
    }

    public Ingredient findByName(String name) {
        return dao.findByName(name);
    }
    @Transactional
    public void mapNutrientsToIngredient(Ingredient ingredient, List<Nutrient> nutrients) throws NoResultException {

//        Query q = DatabaseDAO.entityManager.createQuery("SELECT c from Course c WHERE c.cId=:id");
//        q.setParameter("id", cId);
//        Course course = (Course) q.getSingleResult();
//        Student student = getStudentByEmail(sEmail);
        System.out.println(ingredient);
            //ingredient.setNutrients(nutrientService.findAll());

        /* I want to say here that even though I'm not using JPQL to access the join table the getsCourses method is
         accessing a List<Courses> that is a many to many relationship which IS accessing that join table */
//        List<Nutrient> currentNutrients= ingredient.getNutrients();
//        System.out.println("currentnutrients: " + currentNutrients);
//        for(int i=0; i<nutrients.size(); i++){
//            if (!currentNutrients.contains(nutrients.get(i))) {
//                currentNutrients.add(nutrients.get(i));
//                //saves the changes to the student's courses
//                System.out.println("Registered for the course!");
//            }
//            else{
//                System.out.println("Student is already registered in that course!");
//            }
//        }
//        System.out.println("currentnutrients after map method: " + currentNutrients);
    }

//    public void registerStudentToCourse(String sEmail, int cId) throws NoResultException {
//
//        Query q = DatabaseDAO.entityManager.createQuery("SELECT c from Course c WHERE c.cId=:id");
//        q.setParameter("id", cId);
//        Course course = (Course) q.getSingleResult();
//        Student student = getStudentByEmail(sEmail);
//
//        /* I want to say here that even though I'm not using JPQL to access the join table the getsCourses method is
//         accessing a List<Courses> that is a many to many relationship which IS accessing that join table */
//        if (!student.getsCourses().contains(course)) {
//            List<Course> studentCourses = student.getsCourses();
//            studentCourses.add(course);
//            //saves the changes to the student's courses
//            System.out.println("Registered for the course!");
//        }
//        else{
//            System.out.println("Student is already registered in that course!");
//        }
//    }
}
