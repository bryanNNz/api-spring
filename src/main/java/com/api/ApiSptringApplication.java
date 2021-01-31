package com.api;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.domain.builder.AlbumBuilder;
import com.api.domain.builder.ArtistBuilder;
import com.api.domain.builder.MusicBuilder;
import com.api.domain.builder.MusicGenreBuilder;
import com.api.domain.model.Album;
import com.api.domain.model.Artist;
import com.api.domain.model.Music;
import com.api.domain.model.MusicGenre;
import com.api.repository.AlbumRepository;
import com.api.repository.ArtistRepository;
import com.api.repository.MusicGenreRepository;
import com.api.repository.MusicRepository;

@SpringBootApplication
public class ApiSptringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSptringApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
			@Autowired ArtistRepository artistRepository,
			@Autowired AlbumRepository albumRepository,
			@Autowired MusicRepository musicRepository,
			@Autowired MusicGenreRepository musicGenreRepository) {
		
		return args -> {
			Artist art1 = ArtistBuilder.builder()
					.name("ARTISTA1")
					.bio("Lorem ipsum dolor sit amet, consectetur adipiscing elit1.")
					.get();
			
			Artist art2 = ArtistBuilder.builder()
					.name("ARTISTA2")
					.bio("Lorem ipsum dolor sit amet, consectetur adipiscing elit2.")
					.get();
			
			art1 = artistRepository.save(art1);
			art2 = artistRepository.save(art2);
			
			Album alb1 = AlbumBuilder.builder()
					.artist(art1)
					.name("ALBUM1")
					.release(new Date())
					.get();
			
			Album alb2 = AlbumBuilder.builder()
					.artist(art2)
					.name("ALBUM2")
					.release(new Date())
					.get();
			
			alb1 = albumRepository.save(alb1);
			alb2 = albumRepository.save(alb2);
			
			MusicGenre mg1 = MusicGenreBuilder.builder()
					.description("BLUES")
					.get();
			
			MusicGenre mg2 = MusicGenreBuilder.builder()
					.description("RAP")
					.get();
			
			mg1 = musicGenreRepository.save(mg1);
			mg2 = musicGenreRepository.save(mg2);
			
			Music msc1 = MusicBuilder.builder()
					.name("MUSICA1")
					.musicTime(new Date())
					.release(new Date())
					.album(alb1)
					.artist(art1)
					.musicGenre(mg1)
					.votes(10L)
					.get();
			
			Music msc2 = MusicBuilder.builder()
					.name("MUSICA2")
					.musicTime(new Date())
					.release(new Date())
					.album(alb1)
					.artist(art1)
					.musicGenre(mg1)
					.votes(12L)
					.get();
			
			Music msc3 = MusicBuilder.builder()
					.name("MUSICA3")
					.musicTime(new Date())
					.release(new Date())
					.album(alb2)
					.artist(art2)
					.musicGenre(mg2)
					.votes(13L)
					.get();
			
			Music msc4 = MusicBuilder.builder()
					.name("MUSICA4")
					.musicTime(new Date())
					.release(new Date())
					.album(alb2)
					.artist(art2)
					.musicGenre(mg2)
					.votes(14L)
					.get();
		
			musicRepository.saveAll(Arrays.asList(msc1, msc2, msc3, msc4));
			
		};
	}
	
}
