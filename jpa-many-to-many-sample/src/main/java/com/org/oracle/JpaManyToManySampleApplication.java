package com.org.oracle;

/**
 *	Source of this sample is <link>https://www.callicoder.com/hibernate-spring-boot-jpa-many-to-many-mapping-example/</link>
 *
 * 	Many to Many relation ship in JPA using Spring Boot framework and MySql DB
 */

import com.org.oracle.model.Post;
import com.org.oracle.model.Tag;
import com.org.oracle.repository.PostRepository;
import com.org.oracle.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JpaManyToManySampleApplication  { // implements CommandLineRunner

	public static void main(String[] args) {
		SpringApplication.run(JpaManyToManySampleApplication.class, args);
	}

	/*@Autowired
	private TagRepository tagRepository;

	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaManyToManySampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup the tables
		tagRepository.deleteAllInBatch();
		postRepository.deleteAllInBatch();

		// ========================================


		// Create first Post
		Post post1 = new Post("Hibernate Many to Many Example with Spring Boot",
				"Learn how to map a many to many relationship using hibernate",
				"Entire Post content with Sample code");


		// Create second Post
		Post post2 = new Post("Hibernate many-to-many example with spring boot",
				"Learn how to map a many to many association using hibernate",
				"Entire Tag content with sample code");

		Set<Post> posts = new HashSet<>();
		posts.add(post1);
		posts.add(post2);




		// Create Two tags
		Tag tag1 = new Tag("Spring Boot");
		Tag tag2 = new Tag("Hibernate");

		List<Tag> tags = Arrays.asList(tag1, tag2);

		tag1.setPosts(posts);


		// Add tag references in the post
		//post1.getTags().add(tag1);
		//post1.getTags().add(tag2);

		// Add post reference in the tags
		//tag1.getPosts().add(post1);
		//tag2.getPosts().add(post1);

		//tag1.getPosts().add(post2);

		tagRepository.save(tag1);

		//postRepository.save(post1);

		//postRepository.deleteById(1L);
	}*/
}

