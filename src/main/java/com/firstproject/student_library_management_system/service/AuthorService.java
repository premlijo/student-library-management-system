package com.firstproject.student_library_management_system.service;


import com.firstproject.student_library_management_system.converters.AuthorConverter;
import com.firstproject.student_library_management_system.model.Author;
import com.firstproject.student_library_management_system.repository.AuthorRepository;
import com.firstproject.student_library_management_system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String saveAuthor(AuthorRequestDto authorRequestDto){

        Author author = AuthorConverter.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
        authorRepository.save(author);

        return "Author saved successfully";
    }

    public Author findAuthorById(int id){
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if(optionalAuthor.isPresent()){
            return optionalAuthor.get();
        } else{
            throw new RuntimeException("Author not found with id : " +id );
        }

    }

    public List<Author> findAllAuthor(){
        List<Author> authorList = authorRepository.findAll();
        return authorList;
    }

    public String updateAuthorById(int id, AuthorRequestDto authorRequestDto){
        Author author = findAuthorById(id);

        if(author != null){
            author.setName(authorRequestDto.getName());
            author.setEmail(authorRequestDto.getEmail());
            author.setGender(authorRequestDto.getGender());
            author.setCountry(authorRequestDto.getCountry());
            author.setRating(authorRequestDto.getRating());

            authorRepository.save(author);
            return "Author updated successfully";
        } else {
            return "Author cannot be updated";
        }
    }

    public String deleteAuthorById(int id){
        authorRepository.deleteById(id);
        return "Author deleted successfully";
    }
}
