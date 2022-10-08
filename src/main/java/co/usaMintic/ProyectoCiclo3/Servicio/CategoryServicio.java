package co.usaMintic.ProyectoCiclo3.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaMintic.ProyectoCiclo3.Modelo.Category;
import co.usaMintic.ProyectoCiclo3.Repositorio.CategoryRepositorio;

@Service
public class CategoryServicio {
    
    @Autowired
    private CategoryRepositorio categoryRepositorio;
    
     public List<Category> getAll() {
        return categoryRepositorio.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return categoryRepositorio.getCategory(categoryId);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepositorio.save(category);
        } else {
            Optional<Category> aux = categoryRepositorio.getCategory(category.getId());
            if (aux.isEmpty()) {
                return categoryRepositorio.save(category);
            } else {
                return category;
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>aux= categoryRepositorio.getCategory(category.getId());
            if(!aux.isEmpty()){
                if(category.getDescription()!=null){
                    aux.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    aux.get().setName(category.getName());
                }
                return categoryRepositorio.save(aux.get());
            }
        }
        return category;
    }
    
    
    public boolean deleteCategory (int id){
        Boolean d = getCategory(id).map(category -> {
            categoryRepositorio.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
