package ma.fsa.appwebcadeaux.services;

import lombok.AllArgsConstructor;
import ma.fsa.appwebcadeaux.dtos.ThemeDTO;
import ma.fsa.appwebcadeaux.entities.Theme;
import ma.fsa.appwebcadeaux.exceptions.ThemeNotFoundException;
import ma.fsa.appwebcadeaux.mappers.MapperImpl;
import ma.fsa.appwebcadeaux.repositories.CategorieRepository;
import ma.fsa.appwebcadeaux.repositories.ThemeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ThemeServiceImpl implements ThemeService{

    private ThemeRepository themeRepository;
    private MapperImpl dtoMapper;



    @Override
    public ThemeDTO saveTheme(ThemeDTO themeDTO) {
       Theme theme=dtoMapper.fromThemeDTO(themeDTO);
        Theme savedTheme = themeRepository.save(theme);
        return dtoMapper.fromTheme(savedTheme);
    }

    @Override
    public ThemeDTO getTheme(int idTheme) throws ThemeNotFoundException {
        Theme theme=themeRepository.findById(idTheme)
                .orElseThrow(() -> new ThemeNotFoundException("Theme not found"));

        return dtoMapper.fromTheme(theme);
    }
    @Override
    public ThemeDTO updateTheme(ThemeDTO themeDTO) {
        Theme theme=dtoMapper.fromThemeDTO(themeDTO);
        Theme savedTheme = themeRepository.save(theme);
        return dtoMapper.fromTheme(savedTheme);
    }
    @Override
    public void deleteTheme(int idTheme) {
        themeRepository.deleteById(idTheme);
    }

    @Override
    public List<ThemeDTO> listThemes() {
        List<Theme> themes = themeRepository.findAll();
        List<ThemeDTO> themeDTOS = themes.stream()
                .map(theme -> dtoMapper.fromTheme(theme))
                .collect(Collectors.toList());

        return themeDTOS;
    }

    @Override
    public List<ThemeDTO> searchThemes(String keyword) {
        List<Theme> themes=themeRepository.searchTheme(keyword);
        List<ThemeDTO> themeDTOS = themes.stream().map(theme -> dtoMapper.fromTheme(theme)).collect(Collectors.toList());
        return themeDTOS;
    }

}
