package ma.fsa.appwebcadeaux;

import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.dtos.CategorieDTO;
import ma.fsa.appwebcadeaux.entities.Article;
import ma.fsa.appwebcadeaux.entities.Categorie;
import ma.fsa.appwebcadeaux.entities.Theme;
import ma.fsa.appwebcadeaux.repositories.ArticleRepository;
import ma.fsa.appwebcadeaux.repositories.CategorieRepository;
import ma.fsa.appwebcadeaux.repositories.ThemeRepository;
import ma.fsa.appwebcadeaux.services.CategorieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class AppWebCadeauxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWebCadeauxApplication.class, args);
	}



	@Bean
	CommandLineRunner start(CategorieRepository categorieRepository,
							ArticleRepository articleRepository){
		return args -> {
			Stream.of("gruadt","marriage","annive").forEach(name->{
				Categorie categorie=new Categorie();
				categorie.setNomCategorie(name);
				categorieRepository.save(categorie);

			});

			categorieRepository.findAll().forEach(categorie-> {
				Stream.of("Article1", "Article2", "Article3").forEach(name -> {
					Article article = new Article();
					article.setIdArticle((int)(Math.random() * 10));
					article.setNom(name);
					article.setLien_image(UUID.randomUUID().toString());
					article.setDescription(UUID.randomUUID().toString());
					article.setCategorie(categorie);
					article.setPrix(Math.random() * 10);
					articleRepository.save(article);


				});
			});








		};

	}
		};

