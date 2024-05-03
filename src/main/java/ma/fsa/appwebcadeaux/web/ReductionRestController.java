package ma.fsa.appwebcadeaux.web;

import lombok.AllArgsConstructor;
import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.entities.Reduction;
import ma.fsa.appwebcadeaux.exceptions.ReductionNotFoundException;
import ma.fsa.appwebcadeaux.services.ReductionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ReductionRestController {

    private ReductionService reductionService ;

    @GetMapping("/reductions")
    public List<Reduction> getAllReductions() {
        return reductionService.getAllReductions();
    }

    @GetMapping("/reductions/{id}")
    public Reduction getReductionById(@PathVariable int id) throws ReductionNotFoundException {
        return reductionService.getReductionById(id);
    }

    @PostMapping("/reductions")
    public Reduction addReduction(@RequestBody Reduction reduction) {
        return reductionService.addReduction(reduction);
    }

    @PutMapping("/reductions/{id}")
    public Reduction updateReduction(@PathVariable int id, @RequestBody Reduction reduction) {
        reduction.setIdReduction(id);
        return reductionService.updateReduction(reduction);
    }

    @DeleteMapping("/reductions/{id}")
    public void deleteReduction(@PathVariable int id) {
        reductionService.deleteReduction(id);
    }

    @GetMapping("/reductions/{id}/articles")
    public List<ArticleDTO> getArticlesByReductionId(@PathVariable int id) throws ReductionNotFoundException {
        return reductionService.getArticlesByReductionId(id);
    }
}

