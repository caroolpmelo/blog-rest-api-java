package com.blog.blogservice.config;

import com.blog.blogservice.dto.CommentDTO;
import com.blog.blogservice.repository.IUserRepository;
import com.blog.blogservice.domain.Post;
import com.blog.blogservice.domain.User;
import com.blog.blogservice.dto.AuthorDTO;
import com.blog.blogservice.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private IUserRepository IUserRepository;

    @Autowired
    private IPostRepository IPostRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        IUserRepository.deleteAll();
        IPostRepository.deleteAll();

        User steven = new User(null, "Steven", "steven@crystal.gem");
        User connie = new User(null, "Connie", "connie@crystal.gem");
        User pearl = new User(null, "Pearl", "pearl@crystal.gem");

        IUserRepository.saveAll(Arrays.asList(steven, connie, pearl));

        Post post1 = new Post(
                null,
                sdf.parse("21/05/2020"),
                "Meu cristal favorito",
                "Gosto de todos cristais, mas adoro a cor da ametista!",
                new AuthorDTO(steven)
        );
        Post post2 = new Post(
                null,
                sdf.parse("24/05/2020"),
                "O que acho da Pink Diamond",
                "Só digo uma coisa: digo é nada. E digo mais: só digo isso.",
                new AuthorDTO(pearl)
        );

        CommentDTO c1 = new CommentDTO(
                "Quero ver você se transformar numa mulher gigante!",
                sdf.parse("24/05/2020"),
                new AuthorDTO(connie)
        );
        CommentDTO c2 = new CommentDTO(
                "Quais desses cristais seriam mais forte que você? Rs",
                sdf.parse("24/05/2020"),
                new AuthorDTO(pearl)
        );
        CommentDTO c3 = new CommentDTO(
                "Paz e amor cristal <3",
                sdf.parse("24/05/2020"),
                new AuthorDTO(steven)
        );

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        IPostRepository.saveAll(Arrays.asList(post1, post2));

        steven.getPosts().addAll(Arrays.asList(post1));
        pearl.getPosts().addAll(Arrays.asList(post2));
        IUserRepository.save(steven);
        IUserRepository.save(pearl);
    }

}
