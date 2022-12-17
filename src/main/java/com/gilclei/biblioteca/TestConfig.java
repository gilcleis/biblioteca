package com.gilclei.biblioteca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gilclei.biblioteca.entities.Jogo;
import com.gilclei.biblioteca.entities.Livro;
import com.gilclei.biblioteca.entities.Media;
import com.gilclei.biblioteca.entities.Revista;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		List<Media> listMedias = new ArrayList<Media>();

		listMedias.add(new Livro("O iluminado"));
		listMedias.add(new Livro("O apanhador de sonhos"));
		listMedias.add(new Livro("A zona morta"));

		listMedias.add(new Revista("Turma da mônica"));

		listMedias.add(new Jogo("Call of Duty"));
		listMedias.add(new Jogo("Cult of Lamb"));

		listMedias.add(new Livro("Hannibal"));
		listMedias.add(new Livro("Dragão vermelho"));
		listMedias.add(new Livro("O silencio dos inocentes"));

	}

}