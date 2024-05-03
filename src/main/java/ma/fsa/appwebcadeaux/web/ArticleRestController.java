package ma.fsa.appwebcadeaux.web;

import ma.fsa.appwebcadeaux.entities.Theme;
import ma.fsa.appwebcadeaux.exceptions.*;
import ma.fsa.appwebcadeaux.services.ArticleService;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;


    @RestController
    @AllArgsConstructor
    @CrossOrigin("*")
    public class ArticleRestController {

        private ArticleService articleService;

        @GetMapping("articles")
        public List<ArticleDTO> listArticles() {
            return articleService.listArticle();
        }

       /* @GetMapping("/articles/search")
        public List<ArticleDTO> searchArticles(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
            return articleService.searchThemes(keyword);
        }*/
       @GetMapping("/theme/{themeId}")
       public List<ArticleDTO> getArticlesByTheme(@PathVariable int themeId) throws ThemeNotFoundException {
               Theme theme = new Theme();
               theme.setIdTheme(themeId);
               return articleService.getArticlesByTheme(theme);
       }

        @GetMapping("/articles/{idArticle}")
        public ArticleDTO getArticle(@PathVariable int idArticle) throws ArticleNotFoundException {
            return articleService.getArticle(idArticle);
        }
        @PostMapping("/articles")
        public ArticleDTO saveArticle(@RequestParam String nom, @RequestParam double prix,
                                      @RequestParam String lien_image, @RequestParam int q,
                                      @RequestParam int idCategorie) throws CategorieNotFoundException {

                return articleService.saveArticle(nom, prix, lien_image, q, idCategorie);
        }


        @PutMapping("/articles/{idArticle}")
        public ArticleDTO updateArticle(@PathVariable int idArticle, @RequestBody ArticleDTO articleDTO) {
            articleDTO.setIdArticle(idArticle);
            return articleService.updateArticle(articleDTO);
        }

        @DeleteMapping("/articles/{idArticle}")
        public void deleteArticle(@PathVariable int idArticle) {
            articleService.deleteArticle(idArticle);
        }

        @PostMapping("/api/articles/reduce-price")
        public void reducePrice(@RequestParam int idArticle, @RequestParam int idReduction) throws ArticleNotFoundException, ReductionNotFoundException, InvalidReductionException {
                 articleService.redutionPrix(idArticle, idReduction);


        }
    }


