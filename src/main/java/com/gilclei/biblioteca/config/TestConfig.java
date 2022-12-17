package com.gilclei.biblioteca.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gilclei.biblioteca.entities.Autor;
import com.gilclei.biblioteca.entities.Desenvolvedora;
import com.gilclei.biblioteca.entities.Editora;
import com.gilclei.biblioteca.entities.Jogo;
import com.gilclei.biblioteca.entities.Livro;
import com.gilclei.biblioteca.entities.Revista;
import com.gilclei.biblioteca.entities.repositories.AutorRepository;
import com.gilclei.biblioteca.entities.repositories.DesenvolvedoraRepository;
import com.gilclei.biblioteca.entities.repositories.EditoraRepository;
import com.gilclei.biblioteca.entities.repositories.JogoRepository;
import com.gilclei.biblioteca.entities.repositories.LivroRepository;
import com.gilclei.biblioteca.entities.repositories.RevistaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private DesenvolvedoraRepository desenvolvedoraRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private RevistaRepository revistaRepository;
	
	@Autowired
	private JogoRepository jogoRepository;

	@Override
	public void run(String... args) throws Exception {	

		List<Autor> autors = new ArrayList<Autor>();
		autors.add(new Autor(null, "O iluminado"));
		autors.add(new Autor(1L, "Andre Vianco"));
		autors.add(new Autor(2L, "Stephen King"));
		autors.add(new Autor(3L, "Edgar Allan Poe"));
		autors.add(new Autor(4L, "José Saramago"));
		autors.add(new Autor(5L, "Gabriel García Márquez "));
		autors.add(new Autor(6L, "H. P. Lovecraft"));
		autors.add(new Autor(7L, "J. R. R. Tolkien"));
		autors.add(new Autor(8L, "George R. R. Martin"));
		autors.add(new Autor(9L, "Machado de Assis"));
		autors.add(new Autor(10L, "José de Alencar"));
		autors.add(new Autor(11L, "Thomas Harris"));
		autors.add(new Autor(12L, "Fiódor Dostoiévski"));
		autors.add(new Autor(13L, "Carlos Drummond de Andrade"));
		autors.add(new Autor(14L, "George Orwell"));
		autors.add(new Autor(15L, "Dan Brown"));
		autors.stream().forEach(x -> System.out.println(x));
		
		autorRepository.saveAll(autors);

		List<Desenvolvedora> desenvolvedoras = new ArrayList<Desenvolvedora>();
		desenvolvedoras.add(new Desenvolvedora(1L, "Tencent"));
		desenvolvedoras.add(new Desenvolvedora(2L, "Sony"));
		desenvolvedoras.add(new Desenvolvedora(3L, "Electronic Arts"));
		desenvolvedoras.add(new Desenvolvedora(4L, "Nintendo"));
		desenvolvedoras.add(new Desenvolvedora(5L, "Microsoft"));
		desenvolvedoras.add(new Desenvolvedora(6L, "Square Enix"));
		desenvolvedoras.add(new Desenvolvedora(7L, "Ubisoft"));
		desenvolvedoras.add(new Desenvolvedora(8L, "Devolver Digital"));
		desenvolvedoras.add(new Desenvolvedora(9L, "Rockstar Games"));
		desenvolvedoras.add(new Desenvolvedora(10L, "Lucasfilm Games"));
		desenvolvedoras.add(new Desenvolvedora(11L, "Activision"));
		desenvolvedoras.stream().forEach(x -> System.out.println(x));		
		desenvolvedoraRepository.saveAll(desenvolvedoras);

		List<Editora> editoras = new ArrayList<Editora>();
		editoras.add(new Editora(1L, "Editora Jambo"));
		editoras.add(new Editora(2L, "Editora Moderna"));
		editoras.add(new Editora(3L, "New Order"));
		editoras.add(new Editora(4L, "Editora Rocco"));
		editoras.add(new Editora(5L, "Grupo Companhia das Letras"));
		editoras.add(new Editora(6L, "Editora Abril"));
		editoras.stream().forEach(x -> System.out.println(x));
		editoraRepository.saveAll(editoras);

		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro(1L, "A Hora do Vampiro", "Terror", 1, autors.get(1), 23.50, false));
		livros.add(new Livro(2L, "Os Setes", "Terror", 1, autors.get(0), 55.50, true));
		livros.add(new Livro(3L, "O Chamado de Cthulhu", "Terror", 1, autors.get(5), 45.50, false));
		livros.add(new Livro(4L, "Bento", "Terror", 1, autors.get(0), 25.50, false));
		livros.add(new Livro(6L, "Setimo", "Terror", 1, autors.get(0), 15.50, false));
		livros.stream().forEach(x -> System.out.println(x));		
		livroRepository.saveAll(livros);

		List<Jogo> jogos = new ArrayList<Jogo>();
		jogos.add(new Jogo(1L, "Call of Duty", "Tiro", "Single", true, desenvolvedoras.get(10), 255.50, true));
		jogos.add(new Jogo(2L, "GTA V", "Tiro", "Deluxe", false, desenvolvedoras.get(10), 235.50, true));
		jogos.add(new Jogo(3L, "FIFA 21", "Esport", "Deluxe", true, desenvolvedoras.get(2), 155.50, true));
		jogos.add(new Jogo(4L, "God of War", "Aventura", "Deluxe", true, desenvolvedoras.get(1), 200.50, true));
		jogos.stream().forEach(x -> System.out.println(x));
		jogoRepository.saveAll(jogos);

		List<Revista> revistas = new ArrayList<Revista>();
		revistas.add(new Revista(1L, "Veja", "Noticias", 2838, editoras.get(5), 5.50, false));
		revistas.add(new Revista(2L, "Globo Rural", "Agro", 3442, editoras.get(1), 4.50, false));
		revistas.add(new Revista(3L, "Autoesporte", "Auto", 3442, editoras.get(1), 6.50, false));
		revistas.stream().forEach(x -> System.out.println(x));
		revistaRepository.saveAll(revistas);
		
		System.out.println(editoras.get(2));

	}

}