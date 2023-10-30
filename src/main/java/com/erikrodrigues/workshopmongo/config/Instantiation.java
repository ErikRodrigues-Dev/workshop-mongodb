package com.erikrodrigues.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.erikrodrigues.workshopmongo.domain.Post;
import com.erikrodrigues.workshopmongo.domain.User;
import com.erikrodrigues.workshopmongo.dto.AuthorDTO;
import com.erikrodrigues.workshopmongo.repository.PostRepository;
import com.erikrodrigues.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("30/10/2023"), "Partiu viagem", "Vou viajar para Dubai. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("31/10/2023"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

	
	
}
