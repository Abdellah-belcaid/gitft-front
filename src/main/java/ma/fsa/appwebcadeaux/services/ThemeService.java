package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.CategorieDTO;
import ma.fsa.appwebcadeaux.dtos.ThemeDTO;
import ma.fsa.appwebcadeaux.exceptions.CategorieNotFoundException;
import ma.fsa.appwebcadeaux.exceptions.ThemeNotFoundException;

import java.util.List;

public interface ThemeService {

    ThemeDTO saveTheme(ThemeDTO themeDTO);

    ThemeDTO getTheme(int idTheme) throws ThemeNotFoundException;

    ThemeDTO updateTheme(ThemeDTO themeDTO);

    void deleteTheme(int idTheme);

    List<ThemeDTO> listThemes();

    List<ThemeDTO> searchThemes(String keyword);
}
