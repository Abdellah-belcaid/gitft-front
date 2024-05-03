package ma.fsa.appwebcadeaux.web;

import lombok.AllArgsConstructor;
import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.dtos.CategorieDTO;
import ma.fsa.appwebcadeaux.exceptions.CategorieNotFoundException;
import ma.fsa.appwebcadeaux.services.CategorieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CategorieRestController {

    private CategorieService categorieService;
    @GetMapping("/categories")
    public List<CategorieDTO> categories(){
        return categorieService.listCategories();
    }
    @GetMapping("/categories/search")
    public List<CategorieDTO> searchCategories(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return categorieService.searchCategories("%"+keyword+"%");
    }
    @GetMapping("/categories/{idCategorie}")
    public CategorieDTO getCategorie(@PathVariable(name = "idCategorie") int idCategorie) throws CategorieNotFoundException {
        return categorieService.getCategorie(idCategorie);
    }
    @PostMapping("/categories")
    public CategorieDTO saveCategorie(@RequestBody CategorieDTO categorieDTO){
        return categorieService.saveCategorie(categorieDTO);
    }
    @GetMapping("/categories/{idCategorie}/articles")
    public List<ArticleDTO> getArticles(@PathVariable int idCategorie){
        return categorieService.article_in_categorie(idCategorie);
    }
    @PutMapping("/categories/{idCategorie}")
    public CategorieDTO updateCategorie(@PathVariable int idCategorie, @RequestBody CategorieDTO categorieDTO){
        categorieDTO.setIdCategorie(idCategorie);
        return categorieService.updateCategorie(categorieDTO);
    }
    @DeleteMapping("/categories/{idCategorie}")
    public void deleteCustomer(@PathVariable int idCategorie){
        categorieService.deleteCategorie(idCategorie);
    }
}

