package ma.fsa.appwebcadeaux.web;

import lombok.AllArgsConstructor;
import ma.fsa.appwebcadeaux.dtos.ThemeDTO;
import ma.fsa.appwebcadeaux.exceptions.ThemeNotFoundException;
import ma.fsa.appwebcadeaux.services.ThemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ThemeRestController {

        private ThemeService themeService;
        @GetMapping("/themes")
        public List<ThemeDTO> themes(){
            return themeService.listThemes();
        }
        @GetMapping("/themes/search")
        public List<ThemeDTO> searchThemes(@RequestParam(name = "keyword",defaultValue = "") String keyword){
            return themeService.searchThemes("%"+keyword+"%");
        }
        @GetMapping("/themes/{idTheme}")
        public ThemeDTO getTheme(@PathVariable(name = "idTheme") int idTheme) throws ThemeNotFoundException {
            return themeService.getTheme(idTheme);
        }
        @PostMapping("/Themes")
        public ThemeDTO saveTheme(@RequestBody ThemeDTO themeDTO){
            return themeService.saveTheme(themeDTO);
        }
        @PutMapping("/themes/{idTheme}")
        public ThemeDTO updateTheme(@PathVariable int idTheme, @RequestBody ThemeDTO themeDTO){
            themeDTO.setIdTheme(idTheme);
            return themeService.updateTheme(themeDTO);
        }
        @DeleteMapping("/themes/{idTheme}")
        public void deleteTheme(@PathVariable int idTheme){
            themeService.deleteTheme(idTheme);
        }
    }



